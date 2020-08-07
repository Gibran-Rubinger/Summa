package Summa.io.StockWallet.fetchData;

import java.time.LocalDateTime;

public class Stock {

	private String code = "";
	private String name = "";
	private String marketCap = "";
	private Double price = 0.00;
	private Double priceChange = 0.00;
	private Double priceChangePer = 0.00;
	LocalDateTime dTime = LocalDateTime.now();

	public Stock(String code, String name, String marketCap, Double price, Double priceChange, Double priceChangePer) {
		this.code = code;
		this.name = name;
		this.marketCap = marketCap;
		this.price = price;
		this.priceChange = priceChange;
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

	public String getMarketCap() {
		return marketCap;
	}

	public void setMarketCap(String marketCap) {
		this.marketCap = marketCap;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Double getPriceChange() {
		return priceChange;
	}

	public void setPriceChange(Double priceChange) {
		this.priceChange = priceChange;
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
				+ " (m).        PRICE:  £" + price + "         CHANGE: " + priceChange + "       CHANGE %:"
				+ priceChangePer + "         DATE: " + dTime
				+ "\n\n\n___________________________________________________________________________________________________________________________________________\n";
	}
}
