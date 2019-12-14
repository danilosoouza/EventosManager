package app.Model;

import java.io.Serializable;
import java.util.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Evento")
public class Evento implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nome;
	private String local;
	private String data;
	private String horario;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "evento_pessoa", joinColumns = @JoinColumn(name = "evento_id", 
	referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "pessoa_id",
	referencedColumnName = "id"))
	@JsonIgnoreProperties("eventos")
	private Set<Pessoa> pessoas;
	
	public Evento() {}
	
	public Evento(String nome, String local, String data,
			String horario, Set<Pessoa> pessoas) {
		this.nome = nome;
		this.local = local;
		this.data = data;
		this.horario = horario;
		this.pessoas = pessoas;		
	}

	public int getId() {
		return id;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getLocal() {
		return local;
	}
	
	public void setLocal(String local) {
		this.local = local;
	}
	
	public String getData() {
		return data;
	}
	
	public void setData(String data) {
		this.data = data;
	}
	
	public String getHorario() {
		return horario;
	}
	
	public void setHorario(String horario) {
		this.horario = horario;
	}
	
	public Set<Pessoa> getPessoas() {
		return pessoas;
	}
	
	
	public void addPessoa(Pessoa pessoa) {
		this.pessoas.add(pessoa);
	}
	
	
	public void removePessoa(Pessoa pessoa) {
		this.pessoas.remove(pessoa);
	}
	
	
	

}
