package com.leandro.villela.entity;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "cliente")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;
	@NotBlank(message = "Nome é obrigatório")
	@Size(min = 2, max = 100, message = "Nome deve ter entre 2 e 100 caracteres")
	private String nome;

	@NotBlank(message = "Gênero é obrigatório")
	@Pattern(regexp = "^(MASCULINO|FEMININO|OUTRO|PREFIRO_NAO_DIZER)$",message = "Gênero deve ser uma das opções válidas")
	private String genero;

	@NotNull(message = "Data de nascimento é obrigatória")
	@Past(message = "Data de nascimento não pode ser futura")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;

	@NotBlank(message = "E-mail é obrigatório")
	@Email(message = "E-mail deve ser válido")
	@Column(unique=true)
	@Size(max = 150, message = "E-mail deve ter no máximo 150 caracteres")
	private String email;

	@NotBlank(message = "Confirmação de e-mail é obrigatória")
	private String confirmaEmail;

	@NotBlank(message = "Senha é obrigatória")
	@Size(min = 6, max = 20, message = "Senha deve ter entre 6 e 20 caracteres")
	private String senha;

	@OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<Endereco> enderecos;

	public Cliente() {
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idCliente, String nome, String genero, LocalDate dataNascimento, String email,
			String confirmaEmail, String senha, List<Endereco> enderecos) {
		super();
		this.idCliente = idCliente;
		this.nome = nome;
		this.genero = genero;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.confirmaEmail = confirmaEmail;
		this.senha = senha;
		this.enderecos = enderecos;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nome=" + nome + ", genero=" + genero + ", dataNascimento="
				+ dataNascimento + ", email=" + email + ", confirmaEmail=" + confirmaEmail + ", senha=" + senha
				+ ", enderecos=" + enderecos + "]";
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getConfirmaEmail() {
		return confirmaEmail;
	}

	public void setConfirmaEmail(String confirmaEmail) {
		this.confirmaEmail = confirmaEmail;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public List<Endereco> getEnderecos() {
		return enderecos;
	}

	public void setEnderecos(List<Endereco> enderecos) {
		this.enderecos = enderecos;
	}

}
