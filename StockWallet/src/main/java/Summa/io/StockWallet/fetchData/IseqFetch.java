package Summa.io.StockWallet.fetchData;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class IseqFetch {

	final String url = "https://www.investing.com/indices/iseq-overall-components";

	public void Fetch() {
		try {
			final Document result= Jsoup.connect(url).get();
			
			System.out.println(result.outerHtml());
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
