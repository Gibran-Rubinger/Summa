package Summa.io.StockWallet.Controller;

import java.util.HashSet;
//import java.util.List;
import java.util.Set;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//import Summa.io.StockWallet.Entity.User;
//import Summa.io.StockWallet.Service.UserService;
import Summa.io.StockWallet.fetchData.Stock;

@RestController
public class SummaController {

	private String stockCd = "";
	private String stockNm = "";
	private String stockMk = "";

	private Double stockPr = 0.00;

	private Double stockCp = 0.00;

	Set<Stock> FTSE100;
	
	public void Refresh() {
		FTSE100.clear();
	}
	
	public SummaController() {
		FTSE100 = new HashSet<Stock>();
	}

	@RequestMapping("/index")
	public String test() {
		return "index";
	}

	final String url = "https://www.londonstockexchange.com/indices/ftse-100/constituents/table";
	final String url2 = "https://www.londonstockexchange.com/indices/ftse-100/constituents/table?page=2";
	final String url3 = "https://www.londonstockexchange.com/indices/ftse-100/constituents/table?page=3";
	final String url4 = "https://www.londonstockexchange.com/indices/ftse-100/constituents/table?page=4";
	final String url5 = "https://www.londonstockexchange.com/indices/ftse-100/constituents/table?page=5";
	final String url6 = "https://www.londonstockexchange.com/indices/ftse-100/constituents/table?page=6";
	
	@GetMapping("/fetch")
	
	public Set<Stock> FetchIseq(Stock stock) {
		Refresh();

		try {
			final Document result = Jsoup.connect(url).get();
			final Document result2 = Jsoup.connect(url2).get();
			final Document result3 = Jsoup.connect(url3).get();
			final Document result4 = Jsoup.connect(url4).get();
			final Document result5 = Jsoup.connect(url5).get();
			final Document result6 = Jsoup.connect(url6).get();
//			System.out.println(result.outerHtml());

			for (Element row : result.select("table.full-width.ftse-index-table-table tr")) {

				String textPrice = "";
				String transitionPrice = "";
				String textChPer = "";
				String transitionChPer = "";

				if (row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link").text()
						.equals("")) {
					continue;
				} else {
					stockCd = row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link")
							.text();
					stockNm = row.select("td.clickable.instrument-name.gtm-trackable.td-with-link").text();
					stockMk = row.select("td.instrument-marketcapitalization.hide-on-landscape").text();
					transitionPrice = row.select("td.instrument-lastprice").text();
					textPrice = transitionPrice.replace(",", "");
					stockPr = Double.parseDouble(textPrice);
					transitionChPer = row.select("td.instrument-percentualchange.hide-on-landscape.gtm-trackable")
							.text();
					if (transitionChPer.length() == 1) {
						stockCp = 0.00;
					} else {
						textChPer = transitionChPer.replace(",", "");
						String percent = textChPer.replace("%", "");
						stockCp = Double.parseDouble(percent);
					}
				}
				FTSE100.add(new Stock(stockCd, stockNm, stockMk, stockPr, stockCp));
			}
			
			for (Element row : result2.select("table.full-width.ftse-index-table-table tr")) {

				String textPrice = "";
				String transitionPrice = "";
				String textChPer = "";
				String transitionChPer = "";

				if (row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link").text()
						.equals("")) {
					continue;
				} else {
					stockCd = row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link")
							.text();
					stockNm = row.select("td.clickable.instrument-name.gtm-trackable.td-with-link").text();
					stockMk = row.select("td.instrument-marketcapitalization.hide-on-landscape").text();
					transitionPrice = row.select("td.instrument-lastprice").text();
					textPrice = transitionPrice.replace(",", "");
					stockPr = Double.parseDouble(textPrice);
					transitionChPer = row.select("td.instrument-percentualchange.hide-on-landscape.gtm-trackable")
							.text();
					if (transitionChPer.length() == 1) {
						stockCp = 0.00;
					} else {
						textChPer = transitionChPer.replace(",", "");
						String percent = textChPer.replace("%", "");
						stockCp = Double.parseDouble(percent);
					}
				}
				FTSE100.add(new Stock(stockCd, stockNm, stockMk, stockPr, stockCp));
			}
			
			for (Element row : result3.select("table.full-width.ftse-index-table-table tr")) {

				String textPrice = "";
				String transitionPrice = "";
				String textChPer = "";
				String transitionChPer = "";

				if (row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link").text()
						.equals("")) {
					continue;
				} else {
					stockCd = row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link")
							.text();
					stockNm = row.select("td.clickable.instrument-name.gtm-trackable.td-with-link").text();
					stockMk = row.select("td.instrument-marketcapitalization.hide-on-landscape").text();
					transitionPrice = row.select("td.instrument-lastprice").text();
					textPrice = transitionPrice.replace(",", "");
					stockPr = Double.parseDouble(textPrice);
					transitionChPer = row.select("td.instrument-percentualchange.hide-on-landscape.gtm-trackable")
							.text();
					if (transitionChPer.length() == 1) {
						stockCp = 0.00;
					} else {
						textChPer = transitionChPer.replace(",", "");
						String percent = textChPer.replace("%", "");
						stockCp = Double.parseDouble(percent);
					}
				}
				FTSE100.add(new Stock(stockCd, stockNm, stockMk, stockPr, stockCp));
			}
			
			for (Element row : result4.select("table.full-width.ftse-index-table-table tr")) {

				String textPrice = "";
				String transitionPrice = "";
				String textChPer = "";
				String transitionChPer = "";

				if (row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link").text()
						.equals("")) {
					continue;
				} else {
					stockCd = row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link")
							.text();
					stockNm = row.select("td.clickable.instrument-name.gtm-trackable.td-with-link").text();
					stockMk = row.select("td.instrument-marketcapitalization.hide-on-landscape").text();
					transitionPrice = row.select("td.instrument-lastprice").text();
					textPrice = transitionPrice.replace(",", "");
					stockPr = Double.parseDouble(textPrice);
					transitionChPer = row.select("td.instrument-percentualchange.hide-on-landscape.gtm-trackable")
							.text();
					if (transitionChPer.length() == 1) {
						stockCp = 0.00;
					} else {
						textChPer = transitionChPer.replace(",", "");
						String percent = textChPer.replace("%", "");
						stockCp = Double.parseDouble(percent);
					}
				}
				FTSE100.add(new Stock(stockCd, stockNm, stockMk, stockPr, stockCp));
			}
			
			for (Element row : result5.select("table.full-width.ftse-index-table-table tr")) {

				String textPrice = "";
				String transitionPrice = "";
				String textChPer = "";
				String transitionChPer = "";

				if (row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link").text()
						.equals("")) {
					continue;
				} else {
					stockCd = row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link")
							.text();
					stockNm = row.select("td.clickable.instrument-name.gtm-trackable.td-with-link").text();
					stockMk = row.select("td.instrument-marketcapitalization.hide-on-landscape").text();
					transitionPrice = row.select("td.instrument-lastprice").text();
					textPrice = transitionPrice.replace(",", "");
					stockPr = Double.parseDouble(textPrice);
					transitionChPer = row.select("td.instrument-percentualchange.hide-on-landscape.gtm-trackable")
							.text();
					if (transitionChPer.length() == 1) {
						stockCp = 0.00;
					} else {
						textChPer = transitionChPer.replace(",", "");
						String percent = textChPer.replace("%", "");
						stockCp = Double.parseDouble(percent);
					}
				}
				FTSE100.add(new Stock(stockCd, stockNm, stockMk, stockPr, stockCp));
			}
			
			for (Element row : result6.select("table.full-width.ftse-index-table-table tr")) {

				String textPrice = "";
				String transitionPrice = "";
				String textChPer = "";
				String transitionChPer = "";

				if (row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link").text()
						.equals("")) {
					continue;
				} else {
					stockCd = row.select("td.clickable.bold-font-weight.instrument-tidm.gtm-trackable.td-with-link")
							.text();
					stockNm = row.select("td.clickable.instrument-name.gtm-trackable.td-with-link").text();
					stockMk = row.select("td.instrument-marketcapitalization.hide-on-landscape").text();
					transitionPrice = row.select("td.instrument-lastprice").text();
					textPrice = transitionPrice.replace(",", "");
					stockPr = Double.parseDouble(textPrice);
					transitionChPer = row.select("td.instrument-percentualchange.hide-on-landscape.gtm-trackable")
							.text();
					if (transitionChPer.length() == 1) {
						stockCp = 0.00;
					} else {
						textChPer = transitionChPer.replace(",", "");
						String percent = textChPer.replace("%", "");
						stockCp = Double.parseDouble(percent);
					}
				}
				FTSE100.add(new Stock(stockCd, stockNm, stockMk, stockPr, stockCp));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}

		for (Stock st : FTSE100) {
			System.out.println(st);
		}
		System.out.println("total of stocks: " + FTSE100.size());
		return FTSE100;
	}
	
//	@Autowired
//	private UserService service;
//
//	@GetMapping("test2")
//	public String test2() {
//		return "that is ok";
//	}
//	
//	@PostMapping("/addUser")
//	public User addUser(@RequestBody User user) {
//		return service.saveUser(user);
//	}
////	add user
//	@PostMapping("/users")
//	public List<User> addUser(@RequestBody List<User>user){
//		return service.saveUser(user);
//	}
//	
////	search id
//	@PostMapping("/userById/{id}")
//	public User findUserById(@PathVariable Long id) {
//		return service.getUserById(id);
//	}
//	
////	search name
//	@PostMapping("/userByName/{name}")
//	public User findUserByName(@PathVariable String name) {
//		return service.getUserByName(name);
//	}
//	
////	update
//	@PutMapping("/userUpdate")
//	public User updateUser(@RequestBody User user) {
//		return service.updateUser(user);
//	}
//	
////	delete
//	@DeleteMapping("/delete/{id}")
//	public String deleteUser(@PathVariable Long id) {
//		return service.deleteUser(id);
//	}

}
