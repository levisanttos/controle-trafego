package br.com.fiap.controletrafego.service;

import java.util.List;

import br.com.fiap.controletrafego.dtos.MonitoramentoTrafegoDTO;

public interface MonitoramentoTrafegoService {
	
	MonitoramentoTrafegoDTO save(Long idSemafaro, MonitoramentoTrafegoDTO monitoramentoTrafegoDTO);
	
	List<MonitoramentoTrafegoDTO> getMonitoramentoBySemafaro(Long idSemafaro);
	
	MonitoramentoTrafegoDTO getById(Long idSemafaro, Long idMonitoramento);
	
	MonitoramentoTrafegoDTO update(Long idSemafaro, Long idMonitoramento, MonitoramentoTrafegoDTO monitoramentoTrafegoDTO);
}
