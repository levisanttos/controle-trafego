package br.com.fiap.controletrafego.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import br.com.fiap.controletrafego.dtos.MonitoramentoTrafegoDTO;
import br.com.fiap.controletrafego.model.MonitoramentoTrafego;
import br.com.fiap.controletrafego.model.Semafaro;
import br.com.fiap.controletrafego.repository.MonitoramentoTrafegoRepository;
import br.com.fiap.controletrafego.repository.SemafaroRepository;
import br.com.fiap.controletrafego.service.MonitoramentoTrafegoService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MonitoramentoTrafegoServiceImpl implements MonitoramentoTrafegoService {
	
	private final MonitoramentoTrafegoRepository monitoramentoTrafegoRepository;
	
	private final SemafaroRepository semafaroRepository;
	
	private final ModelMapper modelMapper;

	@Override
	public MonitoramentoTrafegoDTO save(Long idSemafaro, MonitoramentoTrafegoDTO monitoramentoTrafegoDTO) {
		Semafaro semafaro = this.semafaroRepository.findById(idSemafaro).get();
		MonitoramentoTrafego monitoramentoTrafego = this.modelMapper.map(monitoramentoTrafegoDTO, MonitoramentoTrafego.class);
		monitoramentoTrafego.setSemafaro(semafaro);
		monitoramentoTrafego.setDataHora(LocalDateTime.now());
		monitoramentoTrafego = this.monitoramentoTrafegoRepository.save(monitoramentoTrafego);
		monitoramentoTrafegoDTO.setId(monitoramentoTrafego.getId());
		return monitoramentoTrafegoDTO;
	}

	@Override
	public List<MonitoramentoTrafegoDTO> getMonitoramentoBySemafaro(Long idSemafaro) {
		Semafaro semafaro = this.semafaroRepository.findById(idSemafaro).get();
		return this.monitoramentoTrafegoRepository.findBySemafaro(semafaro)
				.stream()
	            .map(monitoramentoTrafego -> modelMapper.map(monitoramentoTrafego, MonitoramentoTrafegoDTO.class))
	            .collect(Collectors.toList());
	}

	@Override
	public MonitoramentoTrafegoDTO getById(Long idSemafaro, Long idMonitoramento) {
		return null;
	}

	@Override
	public MonitoramentoTrafegoDTO update(Long idSemafaro, Long idMonitoramento,
			MonitoramentoTrafegoDTO monitoramentoTrafegoDTO) {
		return null;
	}

}
