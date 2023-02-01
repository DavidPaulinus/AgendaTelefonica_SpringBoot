package br.com.agenda.AgendaTelefonica_SpringBoot.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoDTO;
import br.com.agenda.AgendaTelefonica_SpringBoot.model.Contato;
import br.com.agenda.AgendaTelefonica_SpringBoot.util.ContatoRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/entrada")
public class ContatoControler {
	
	@Autowired
	private ContatoRepository cRep;
	
	@PostMapping
	public void cadastrar(@RequestBody @Valid ContatoDTO dto) {
		System.out.println("\\Cadatrando");
		cRep.save(new Contato(dto));
		System.out.println("/Cadatrado");
	}
	
}
