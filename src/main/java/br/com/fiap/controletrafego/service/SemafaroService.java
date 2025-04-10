package br.com.fiap.controletrafego.service;

import java.util.List;

import br.com.fiap.controletrafego.dtos.SemafaroDto;
import br.com.fiap.controletrafego.dtos.SemafaroUpdateDto;

public interface SemafaroService {
	
	SemafaroDto save(SemafaroDto trafegoDto);
	
	SemafaroDto getById(Long id);
	
	void delete(Long id);
	
	SemafaroDto update(Long id, SemafaroUpdateDto trafegoUpdateDto);

	List<SemafaroDto> getSemafaros();

}
