package br.com.fiap.controletrafego.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.controletrafego.dtos.UsuarioCadastroDTO;
import br.com.fiap.controletrafego.dtos.UsuarioExbicaoDTO;
import br.com.fiap.controletrafego.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {
	
	private final UsuarioService usuarioService;
	
	@PostMapping
	public ResponseEntity<UsuarioExbicaoDTO> cadastrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO) {
		return new ResponseEntity<>(this.usuarioService.cadastrar(usuarioCadastroDTO), HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<UsuarioExbicaoDTO> atualizar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO) {
		return new ResponseEntity<>(this.usuarioService.atualizar(usuarioCadastroDTO), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<UsuarioExbicaoDTO> buscaUsuarioPorId(@PathVariable Long id) {
		return new ResponseEntity<>(this.usuarioService.buscaPorId(id), HttpStatus.OK);
	}
	
	@GetMapping
	public ResponseEntity<List<UsuarioExbicaoDTO>> listaTodos() {
		return new ResponseEntity<>(this.usuarioService.listaTodos(), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id) {
		this.usuarioService.remover(id);
		return ResponseEntity.noContent().build();
	}

}
