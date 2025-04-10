package br.com.fiap.controletrafego.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.fiap.controletrafego.model.MonitoramentoTrafego;
import br.com.fiap.controletrafego.model.Semafaro;

public interface MonitoramentoTrafegoRepository extends JpaRepository<MonitoramentoTrafego, Long> {
	
	List<MonitoramentoTrafego> findBySemafaro(Semafaro semafaro);

}
