package br.com.fiap.controletrafego.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.controletrafego.dtos.CameraDTO;
import br.com.fiap.controletrafego.service.CameraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/semafaros/{idSemafaro}/cameras")
@RequiredArgsConstructor
public class CameraController {
	
	private final CameraService cameraService;
	
	@PostMapping
	public ResponseEntity<CameraDTO> save(@PathVariable Long idSemafaro,@RequestBody @Valid CameraDTO cameraDTO) {
		return new ResponseEntity<CameraDTO>(this.cameraService.save(idSemafaro, cameraDTO), HttpStatus.CREATED);
	}

}
