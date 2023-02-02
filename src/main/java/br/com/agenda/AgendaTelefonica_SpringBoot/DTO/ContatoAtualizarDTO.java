package br.com.agenda.AgendaTelefonica_SpringBoot.DTO;

import jakarta.validation.constraints.NotNull;

public record ContatoAtualizarDTO(
		@NotNull Long id, 
		String nome, 
		String numero, 
		String tipo, 
		String email, 
		Boolean favorito) {

}
