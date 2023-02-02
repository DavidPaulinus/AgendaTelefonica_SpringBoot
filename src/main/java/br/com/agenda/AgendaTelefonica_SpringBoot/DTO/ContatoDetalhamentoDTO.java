package br.com.agenda.AgendaTelefonica_SpringBoot.DTO;

import br.com.agenda.AgendaTelefonica_SpringBoot.model.Contato;

public record ContatoDetalhamentoDTO(String nome, String numero, String tipo, String email, Boolean favorito) {
	public ContatoDetalhamentoDTO(Contato contt) {
		this(contt.getNome(), contt.getNumero(), contt.getTipo(), contt.getEmail(), contt.getFavorito());
	}
}
