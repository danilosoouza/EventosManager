package app.test;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import app.Model.Pessoa;
import app.Repository.PessoaRepository;
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
	

	@Test
	public void TestGetPessoasSucesso() throws URISyntaxException{
		
		RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/v1/users";
		
		URI uri = new URI(baseUrl);
		
		ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
			
		assertEquals(true,result.getBody().contains("nome"));
	}
		
	@Test
	public void TestAdicionarPessoa() throws URISyntaxException {
	
	RestTemplate restTemplate = new RestTemplate();
		
		final String baseUrl = "http://localhost:" + randomServerPort + "/api/v1/users";
		
		URI uri = new URI(baseUrl);
		
		Pessoa pessoa = new Pessoa("Danilo", 
				"Souza", "10/03/1994", 
				null, false, "6019876");
		
		HttpEntity<Pessoa> request = new HttpEntity<Pessoa>(pessoa);
		
		ResponseEntity<String> result = restTemplate.postForEntity(uri, 
				request ,String.class);
			
		
		System.out.println(result.getBody());
		
	}
	
}
