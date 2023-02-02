package br.com.agenda.AgendaTelefonica_SpringBoot.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoAtualizarDTO;
import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoDTO;
import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoDetalhamentoDTO;
import br.com.agenda.AgendaTelefonica_SpringBoot.DTO.ContatoListaDTO;
import br.com.agenda.AgendaTelefonica_SpringBoot.model.Contato;
import br.com.agenda.AgendaTelefonica_SpringBoot.util.ContatoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/entrada")
public class ContatoControler {
	@Autowired
	private ContatoRepository cRep;

	@PostMapping
	@Transactional
	public ResponseEntity cadastrar(@RequestBody @Valid ContatoDTO dto, UriComponentsBuilder uriBuilder) {
		System.out.println("\\Cadatrando");
		
		var contt = new Contato(dto); 

		cRep.save(contt);

		System.out.println("/Cadatrado");
		
		return ResponseEntity.created(
				uriBuilder.path("/cadContato/{id}")
				.buildAndExpand(contt.getId()).toUri()
				)
				.body(new ContatoDetalhamentoDTO(contt));
	}

	@GetMapping
	public ResponseEntity<Page<ContatoListaDTO>> listar(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
		System.out.println("**Listando**");

		return ResponseEntity.ok(cRep.findAll(page).map(ContatoListaDTO::new));
	}
	@GetMapping("/favorito")
	public ResponseEntity<Page<ContatoListaDTO>> listarFavorito(@PageableDefault(size = 10, sort = {"nome"}) Pageable page) {
		System.out.println("**Listando Favorito**");

		return ResponseEntity.ok(cRep.findAllByFavoritoTrue(page).map(ContatoListaDTO::new));
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ContatoDetalhamentoDTO> detalharContato(@PathVariable Long id){
		return ResponseEntity.ok(new ContatoDetalhamentoDTO(cRep.getReferenceById(id)));
	}

	@PutMapping
	@Transactional
	public ResponseEntity<ContatoDetalhamentoDTO> atualizar(@RequestBody @Valid ContatoAtualizarDTO contt) {
		System.out.println("\\Atualizando");

		var contato = cRep.getReferenceById(contt.id());
		contato.atualizar(contt);

		System.out.println("/Atualizado");

		return ResponseEntity.ok(new ContatoDetalhamentoDTO(contato));
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity deletar(@PathVariable Long id) {
		System.out.println("\\Deletando");

		cRep.deleteById(id);

		System.out.println("/Deletado");

		return ResponseEntity.noContent().build();
	}

}
