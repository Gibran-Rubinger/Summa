package Summa.io.StockWallet.fetchData;

import java.time.LocalDateTime;

public class Stock {

	private String code = "";
	private String name = "";
	private Double marketCap = 0.00;
	private Double price = 0.00;
	private Double priceChangePer = 0.00;
	LocalDateTime dTime = LocalDateTime.now();

	public Stock(String code, String name, Double marketCap, Double price, Double priceChangePer) {
		this.code = code;
		this.name = name;
		this.marketCap = marketCap;
		this.price = price;
		this.priceChangePer = priceChangePer;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(Double marketCap) {
		this.marketCap = marketCap;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPriceChangePer() {
		return priceChangePer;
	}

	public void setPriceChangePer(Double priceChangePer) {
		this.priceChangePer = priceChangePer;
	}

	public LocalDateTime getdTime() {
		return dTime;
	}

	public void setdTime(LocalDateTime dTime) {
		this.dTime = dTime;
	}

//	creating a toString to Override it.
	@Override
	public String toString() {
		return "      CODE: " + code + "       STOCK NAME: " + name + "        MARKET CAP:  " + marketCap
				+ " (m).        PRICE:  £" + price + "       CHANGE %:" + priceChangePer + "         DATE: " + dTime
				+ "\n\n\n___________________________________________________________________________________________________________________________________________________________________________\n";
	}
}
