package Summa.io.StockWallet.Controller;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SummaController {

	@RequestMapping("/index")
	public String test() {
		return "index";
	}

	final String url = "https://www.investing.com/indices/iseq-overall-components";

	@GetMapping("/fetch")
	public String FetchIseq() {
		String stockName = "";
		try {
			final Document result = Jsoup.connect(url).get();

//			System.out.println(result.outerHtml());

			for (Element row : result.select("table.genTbl.closedTbl.crossRatesTbl.elpTbl.elp25 tr")) {
				if (row.select("td.bold.left.noWrap.elp.plusIconTd").text().equals("")) {
					continue;
				} else {
					final String stock = row.select("td.bold.left.noWrap.elp.plusIconTd").text();
					System.out.println(stock);
					stockName = stock;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return stockName;
	}

}
