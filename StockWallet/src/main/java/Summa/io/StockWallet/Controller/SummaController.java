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

	 private String stockCd = "";
	 private String stockNm = "";
	 private String stockMk = "";

	
	 private Double stockPr = 0.00;

	 

	 private Double finalStockChange = 0.00;

	
	 private Double stockCp = 0.00;

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
	public Set<Stock> FetchIseq(Stock stock) {

		try {
			final Document result = Jsoup.connect(url).get();

//			System.out.println(result.outerHtml());

			for (Element row : result.select("table.full-width.ftse-index-table-table tr")) {
				
				 String textPrice = "";
				 String transitionPrice = "";
				 String textChange = "";
				 String transitionChange = "";
				 Double stockCh = 0.00;

				 String textChangeN = "";
				 String transitionChangeN = "";
				 Double stockChN = 0.00;
				 String textChPer = "";
				 String transitionChPer = "";
				 
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
					
					
					System.out.println("test A "+stockMk);
					transitionPrice = row.select("td.instrument-lastprice").text();
					System.out.println("oiiiii "+transitionPrice);
					textPrice = transitionPrice.replace(",", "");
					System.out.println(textPrice);
					stockPr = Double.parseDouble(textPrice);
					System.out.println("test B "+stockPr);
//					
				
//					
					transitionChPer = row.select("td.instrument-percentualchange.hide-on-landscape.gtm-trackable")
							.text();
					System.out.println("kkkkk "+transitionChPer);
					textChPer = transitionChPer.replace(",", "");
					String a =textChPer.replace("%","");
					System.out.println("textChPerrgfg "+ a);
					stockCp = Double.parseDouble(a);
					System.out.println("ggg"+stockCp);
					
				}
				
				Stock stockTeste = new Stock(stockCd, stockNm, stockMk, stockPr, stockCp);
				System.out.println("STOCK TESTE: " + stockTeste);
				FTSE100.add(stockTeste);
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		System.out.println("test E "+stockCp);
		for (Stock st : FTSE100) {
			System.out.println(st);
		}
		return FTSE100;
	}

}
