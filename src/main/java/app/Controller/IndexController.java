package app.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {

	@GetMapping
	@RequestMapping(value = "/")
	public String Index() {
		
		return "Servidor online";
	}
	
	
	
}
