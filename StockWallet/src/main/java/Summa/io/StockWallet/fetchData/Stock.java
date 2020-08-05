package Summa.io.StockWallet.fetchData;

import java.time.LocalDateTime;

public class Stock {
	
	private String name = "";
	private Double lastPrice = 0.00;
	private Double highPrice = 0.00;
	private Double lowPrice = 0.00;
	LocalDateTime dTime = LocalDateTime.now();

	public Stock(String name, Double lastPrice, Double highPrice, Double lowPrice, LocalDateTime dTime) {
		this.name = name;
		this.lastPrice = lastPrice;
		this.highPrice = highPrice;
		this.lowPrice = lowPrice;
		this.dTime = dTime;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Double getLastPrice() {
		return lastPrice;
	}

	public void setLastPrice(Double lastPrice) {
		this.lastPrice = lastPrice;
	}

	public Double getHighPrice() {
		return highPrice;
	}

	public void setHighPrice(Double highPrice) {
		this.highPrice = highPrice;
	}

	public Double getLowPrice() {
		return lowPrice;
	}

	public void setLowPrice(Double lowPrice) {
		this.lowPrice = lowPrice;
	}
	
	
	
}
