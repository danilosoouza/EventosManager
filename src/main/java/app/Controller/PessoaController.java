package app.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Model.Pessoa;
import app.Repository.PessoaRepository;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	//Retornar uma lista com todas as pessoas
	@GetMapping("/users")
	public List<Pessoa> getPessoas(){
		
		return pessoaRepository.findAll();
	}
	
	//Retornar uma pessoa pelo id
	
	
	
	//Criar uma pessoa
	@PostMapping("/users")
	public Pessoa createPessoa(@Valid @RequestBody Pessoa pessoa) {
		
		return pessoaRepository.save(pessoa);
		
	}
	
	
	
	//Atualizar uma pessoa
	
	
	
	//Deletar uma pessoa
	
}
