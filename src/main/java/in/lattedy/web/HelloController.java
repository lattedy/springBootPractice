package in.lattedy.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import in.lattedy.web.dto.HelloResponseDto;

@RestController
public class HelloController {
	@GetMapping("/hello")
	public String hello() {
		return "Hello";
	}

	@GetMapping("/hello/dto")
	public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount) {
		return new HelloResponseDto(name, amount);
	}
}
