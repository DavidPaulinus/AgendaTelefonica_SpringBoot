package br.com.agenda.AgendaTelefonica_SpringBoot.model;

import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "contatos")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Contato {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nome;
	private String numero;
	private String tipo;
	private String email;
	private Boolean favorito;
	public Contato(ContatoDTO dto) {
		super();
		this.nome = dto.nome();
		this.numero = dto.numero();
		this.tipo = dto.tipo();
		this.email = dto.email();
		this.favorito = dto.favorito();
	}
	
	
}
