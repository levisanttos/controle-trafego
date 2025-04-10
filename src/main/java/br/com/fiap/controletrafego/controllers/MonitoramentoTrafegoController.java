package br.com.fiap.controletrafego.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.controletrafego.dtos.MonitoramentoTrafegoDTO;
import br.com.fiap.controletrafego.service.MonitoramentoTrafegoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/semafaros/{idSemafaro}/monitoramentoTrafegos")
@RequiredArgsConstructor
public class MonitoramentoTrafegoController {
	
	
	private final MonitoramentoTrafegoService monitoramentoTrafegoService;
	
	@PostMapping
	public ResponseEntity<MonitoramentoTrafegoDTO> save(@PathVariable Long idSemafaro, @RequestBody @Valid MonitoramentoTrafegoDTO monitoramentoTrafegoDTO) {
		return new ResponseEntity<MonitoramentoTrafegoDTO>(this.monitoramentoTrafegoService.save(idSemafaro, monitoramentoTrafegoDTO), HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<MonitoramentoTrafegoDTO>> getMonitoramentoBySemafaro(@PathVariable Long idSemafaro) {
		return new ResponseEntity<List<MonitoramentoTrafegoDTO>>(this.monitoramentoTrafegoService.getMonitoramentoBySemafaro(idSemafaro), HttpStatus.OK);
	}

}
