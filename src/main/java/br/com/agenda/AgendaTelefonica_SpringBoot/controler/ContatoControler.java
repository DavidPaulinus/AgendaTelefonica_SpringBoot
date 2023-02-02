package br.com.agenda.AgendaTelefonica_SpringBoot.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoAtualizarDTO;
import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoDTO;
import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoListaDTO;
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
	
	@GetMapping
	public List<ContatoListaDTO> listar() {
		System.out.println("\\Listando");
		System.out.println("/Listado");
		return cRep.findAll().stream().map(ContatoListaDTO::new).toList();
	}
	
	@GetMapping("/favorito")
	public List<ContatoListaDTO> listarFavorito() {
		System.out.println("\\Listando");
		System.out.println("/Listado");
		return cRep.findAllByFavoritoTrue().stream().map(ContatoListaDTO::new).toList();
	}
		
	@DeleteMapping("/{id}")
	public void deletar(@PathVariable Long id) {
		System.out.println("\\Deletando");
		cRep.deleteById(id);
		System.out.println("/Deletado");
	}
	
}
