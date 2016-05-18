package co.id.jasaraharja.microservices.hello.api;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import co.id.jasaraharja.microservices.hello.dto.Greeting;

@RestController
@RequestMapping("/")
public class HelloController {
	
	private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
	
	@RequestMapping(method = RequestMethod.GET, headers = "Accept=application/json")
	public Greeting sayHello(OAuth2Authentication authentication) {
		// get user from request
		String user = (String) authentication.getPrincipal();
		
		return new Greeting(counter.incrementAndGet(),
                String.format(template, user));
	}
}
