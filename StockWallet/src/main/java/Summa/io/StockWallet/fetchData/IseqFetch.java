package Summa.io.StockWallet.fetchData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.web.bind.annotation.GetMapping;
public class IseqFetch {

	final String url = "https://www.investing.com/indices/iseq-overall-components";
	
	@GetMapping("/fetch")
	public String FetchIseq() {
		try {
			final Document result= Jsoup.connect(url).get();
			
			System.out.println(result.outerHtml());
			
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return "ok";
	}
}
