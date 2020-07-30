package Summa.io.StockWallet.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SummaController {
	
	@RequestMapping("/index")
	public String test() {
		return "index";
	}

}
