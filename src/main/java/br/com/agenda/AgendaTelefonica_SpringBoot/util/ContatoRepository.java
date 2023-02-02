package br.com.agenda.AgendaTelefonica_SpringBoot.util;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.agenda.AgendaTelefonica_SpringBoot.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long>{

	 List<Contato>findAllByFavoritoTrue();

}
