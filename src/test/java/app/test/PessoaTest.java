package app.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import junit.framework.TestCase;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class PessoaTest extends TestCase{

	@LocalServerPort
	int randomServerPort;
	
	
	@Test
	public void TestGetStatusCode() throws URISyntaxException{
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/v1/exibirEventos";
		
		URI uri = new URI(baseUrl);
		
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
		
		assertEquals(200, result.getStatusCodeValue());	
		
	}
	
	
	
}
