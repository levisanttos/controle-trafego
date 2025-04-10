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

import br.com.fiap.controletrafego.dtos.SemafaroDto;
import br.com.fiap.controletrafego.dtos.SemafaroUpdateDto;
import br.com.fiap.controletrafego.service.SemafaroService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/semafaros")
@RequiredArgsConstructor
public class SemafaroController {

	private final SemafaroService semafaroService;
	
	@PostMapping
	public ResponseEntity<SemafaroDto> save(@RequestBody  @Valid  SemafaroDto semafaroDto) {
		return new ResponseEntity<>(this.semafaroService.save(semafaroDto), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<SemafaroDto>> listarSemafaros() {
		return new ResponseEntity<List<SemafaroDto>>(this.semafaroService.getSemafaros(),HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<SemafaroDto> getSemafaro(@PathVariable Long id) {
		return new ResponseEntity<SemafaroDto>(this.semafaroService.getById(id), HttpStatus.OK);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<SemafaroDto> update(@PathVariable Long id, @RequestBody @Valid SemafaroUpdateDto semafaroUpdateDto) {
		return new ResponseEntity<SemafaroDto>(this.semafaroService.update(id, semafaroUpdateDto), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.semafaroService.delete(id);
		
		return ResponseEntity.noContent().build();
	}
}
