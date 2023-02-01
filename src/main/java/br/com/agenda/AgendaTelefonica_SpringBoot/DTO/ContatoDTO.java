package br.com.agenda.AgendaTelefonica_SpringBoot.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContatoDTO(
		@NotBlank
		String nome,
		
		@NotBlank
		String numero,
		
		@NotBlank
		String tipo,
		
		@NotNull
		String email,
		
		@NotNull
		Boolean favorito) {

}
