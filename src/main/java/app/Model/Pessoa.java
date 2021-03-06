package app.Model;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "Pessoa")
public class Pessoa implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "sobrenome", nullable = false)
	private String sobreNome;
	
	@Column(name = "rg", nullable = false)
	private String rg;
	
	@Column(name = "datanascimento", nullable = false)
	private String dataNascimento;
	
	@JsonIgnoreProperties("pessoas")
	@ManyToMany(mappedBy = "pessoas")
	private Set<Evento> eventos;
	
	@Column(name = "organizador", columnDefinition = "boolean default false")
	private Boolean organizador;
	
	public Pessoa() {}
	
	public Pessoa(String nome, String sobreNome, 
			String datanascimento, Set<Evento> eventos, 
			Boolean organizador, String rg) {
		
		this.nome = nome;
		this.sobreNome = sobreNome;
		this.dataNascimento = datanascimento;
		this.rg = rg;
		this.organizador = organizador;
		this.eventos = eventos;		
	}
	
	public Boolean getOrganizador() {
		return organizador;
	}

	public void setOrganizador(Boolean organizador) {
		this.organizador = organizador;
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getSobreNome() {
		return sobreNome;
	}
	
	public void setSobreNome(String sobreNome) {
		this.sobreNome = sobreNome;
	}
	
	public String getRg() {
		return rg;
	} 
	
	public void setRg(String rg) {
		this.rg = rg;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	public Set<Evento> getEventos(){
		return eventos;
	}
	
}
