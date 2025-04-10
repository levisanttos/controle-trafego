package br.com.fiap.controletrafego.service.impl;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import br.com.fiap.controletrafego.dtos.SemafaroDto;
import br.com.fiap.controletrafego.dtos.SemafaroUpdateDto;
import br.com.fiap.controletrafego.exception.ObjetoNotFoundException;
import br.com.fiap.controletrafego.model.Semafaro;
import br.com.fiap.controletrafego.repository.SemafaroRepository;
import br.com.fiap.controletrafego.service.SemafaroService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SemafaroServiceImpl implements SemafaroService {

	private final SemafaroRepository trafegoRepository;
	private final ModelMapper modelMapper;
	
	@Override
	public SemafaroDto save(SemafaroDto trafegoDto) {
		
		Semafaro trafego = new Semafaro();
		BeanUtils.copyProperties(trafegoDto, trafego);
		trafego = this.trafegoRepository.save(trafego);
		
		return new SemafaroDto(trafego);
	}

	@Override
	public SemafaroDto getById(Long id) {
		
		Optional<Semafaro> semafaro = this.trafegoRepository.findById(id);
		if (!semafaro.isPresent()) {
			throw new ObjetoNotFoundException("Semafaro não encontrado!");
		}
		
		return new SemafaroDto(semafaro.get());
	}

	@Override
	public void delete(Long id) {
		Optional<Semafaro> semafaro = this.trafegoRepository.findById(id);
		if (!semafaro.isPresent()) {
			throw new ObjetoNotFoundException("Semafaro não encontrado!");
		}
		
		this.trafegoRepository.delete(semafaro.get());
	}

	@Override
	public SemafaroDto update(Long id, SemafaroUpdateDto trafegoUpdateDto) {
		Optional<Semafaro> semafaro = this.trafegoRepository.findById(id);
		if (!semafaro.isPresent()) {
			throw new ObjetoNotFoundException("Semafaro não encontrado!");
		}
		Semafaro semafaroUpdate = semafaro.get();
		semafaroUpdate.setEstado(trafegoUpdateDto.getEstado());
		this.trafegoRepository.saveAndFlush(semafaroUpdate);
		return new SemafaroDto(semafaroUpdate);
	}

	@Override
	public List<SemafaroDto> getSemafaros() {
		return this.trafegoRepository.findAll().stream().map(SemafaroDto::new).toList();
	}

}
