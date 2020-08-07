package Summa.io.StockWallet.Controller;

import java.util.HashSet;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Summa.io.StockWallet.fetchData.Stock;

@RestController
public class SummaController {

	 

	Set<Stock> FTSE100;

	public SummaController() {
		FTSE100 = new HashSet<Stock>();
	}

	@RequestMapping("/index")
	public String test() {
		return "index";
	}

	final String url = "https://www.londonstockexchange.com/indices/ftse-100/constituents/table";

	@GetMapping("/fetch")
	public Stock FetchIseq(Stock stock) {

		try {
			final Document result = Jsoup.connect(url).get();

//			System.out.println(result.outerHtml());

			for (Element row : result.select("table.full-width.ftse-index-table-table")) {
				 String stockCd = "";
				 String stockNm = "";
				 String stockMk = "";

				 String textPrice = "";
				 String transitionPrice = "";
				 Double stockPr = 0.00;

				 String textChange = "";
				 String transitionChange = "";
				 Double stockCh = 0.00;

				 String textChangeN = "";
				 String transitionChangeN = "";
				 Double stockChN = 0.00;

				 Double finalStockChange = 0.00;

				 String textChPer = "";
				 String transitionChPer = "";
				 Double stockCp = 0.00;
				if (row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link").text()
						.equals("")) {
					continue;
				} else {
					stockCd = row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link")
							.text();
//					System.out.println(stockCd);
					stockNm = row.select("td.clickable.instrument-name.gtm-trackable.td-with-link").text();
//					System.out.println(stockNm);
					stockMk = row.select("td.instrument-marketcapitalization.hide-on-landscape").text();
					System.out.println("este é um numero pro Michael"+stockMk);
					transitionPrice = row.select("td.instrument-lastprice").text();
					textPrice = transitionPrice.replace(",", "");
					stockPr = Double.parseDouble(textPrice);
					System.out.println("este é um numero pro Michael"+stockPr);
					
					transitionChange = row.select("td.instrument-netchange.hide-on-landscape.positivechange").text();
					textChange = transitionChange.replace(",", "");
					stockCh = Double.parseDouble(textChange);
					System.out.println("este é um numero pro Michael"+stockCh);
					
					transitionChangeN = row.select("td.instrument-netchange.hide-on-landscape.negativechange").text();
					textChangeN = transitionChangeN.replace(",", "");
					stockChN = Double.parseDouble(textChangeN);
					System.out.println("este é um numero pro Michael"+stockChN);
					
					transitionChPer = row.select("td.instrument-percentualchange.hide-on-landscape.gtm-trackable")
							.text();
					textChPer = transitionChPer.replace(",", "");
					stockCp = Double.parseDouble(textChPer);
					System.out.println(stockCp);
				}
				if (stockCh != 0.00) {
					finalStockChange = stockCh;
				} else {
					finalStockChange = stockChN;
				}
				FTSE100.add(new Stock(stockCd, stockNm, stockMk, stockPr, finalStockChange, stockCp));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		for (Stock st : FTSE100) {
			System.out.println(st);
		}
		return stock;
	}

}
