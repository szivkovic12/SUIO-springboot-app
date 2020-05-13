package hr.tvz.suio.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("employee")
public class EmployeeRestController {

	@GetMapping("/bok")
	public String helloWorld() {
		return "Hello World";
	}

}
