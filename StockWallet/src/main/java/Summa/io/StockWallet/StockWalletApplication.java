package Summa.io.StockWallet;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan("Summa.io.StockWallet")
public class StockWalletApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockWalletApplication.class, args);
		
	}

}
