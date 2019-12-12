package app.Controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.Model.Evento;
import app.Model.Pessoa;
import app.Repository.EventoRepository;
import app.Repository.PessoaRepository;

@RestController
@RequestMapping(value = "/api/v1", produces = "application/json")
public class EventoController {

	@Autowired
	EventoRepository eventoRepository;
	
	@Autowired
	PessoaRepository pessoaRepository;
	
	@PostMapping
	@RequestMapping("/cadastrarevento")
	public Evento cadastrarEvento(@Valid @RequestBody Evento evento) {	
		return eventoRepository.save(evento);			
	}
	
	@PutMapping
	@RequestMapping("/cadastrarevento/{evento_id}/cadastrarpessoa/{pessoas_id}")
	public Evento cadastrarPessoasNoEvento(@PathVariable(value = "evento_id") Integer evento_id, 
			@PathVariable(value = "pessoas_id") Integer pessoas_id) {
		
		Optional<Pessoa> optionalPessoa =  pessoaRepository.findById(pessoas_id);
		
		Optional<Evento> optionalEvento = eventoRepository.findById(evento_id);
			
		Pessoa pessoa = optionalPessoa.get();		
		Evento evento = optionalEvento.get();

		evento.addPessoa(pessoa);
		
		System.out.println(pessoa.getEventos());
		
		return eventoRepository.save(evento);
	}
	
	@DeleteMapping
	@RequestMapping("/evento/{evento_id}/excluirpessoa/{pessoas_id}")
	public Evento removerPessoa(@PathVariable(value = "evento_id") Integer evento_id, 
			@PathVariable(value = "pessoas_id") Integer pessoas_id) {
		Optional<Pessoa> optionalPessoa =  pessoaRepository.findById(pessoas_id);
		
		Optional<Evento> optionalEvento = eventoRepository.findById(evento_id);
			
		Pessoa pessoa = optionalPessoa.get();		
		Evento evento = optionalEvento.get();
		
		evento.removePessoa(pessoa);
		
		return eventoRepository.save(evento);
		
	}
	
	@GetMapping
	@RequestMapping("/exibirEventos")
	public List<Evento> exibirEventos(){
		return eventoRepository.findAll();
	}
	
	@PutMapping
	@RequestMapping("/editarEvento/{id}")
	public String editarEvento() {
	
		return "Editar evento";
	}
	
	@GetMapping
	@RequestMapping("/exibirEvento/{id}")
	public ResponseEntity<Evento> exibirEventoId(@PathVariable(value = "id") Integer id) {
		Optional<Evento> evento = eventoRepository.findById(id);
		
		if(evento.isPresent()) {
			return new ResponseEntity<Evento>(evento.get(), HttpStatus.OK);
		}else {
			return new ResponseEntity<Evento>(HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping
	@RequestMapping("/deletarEvento/{id}")
	public String deletarEvento() {
		
		return "Evento excluido";
	}
	
	
}
