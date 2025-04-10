package br.com.fiap.controletrafego.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

@Data
@Table(name = "T_GT_MONITORAMENTO_TRAFEGO")
@Entity
@SequenceGenerator(name = "SEQ_MONITORAMENTO_TRAFEGO", sequenceName = "SEQ_MONITORAMENTO_TRAFEGO", allocationSize = 1, initialValue = 1)
public class MonitoramentoTrafego {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_MONITORAMENTO_TRAFEGO")
	@Column(name = "id_monitoramento")
	private Long id;

	@Column(name = "data_hora")
	@Temporal(TemporalType.TIMESTAMP)
	private LocalDateTime dataHora;
	
	@Column(name = "patrao_trafego")
	private String padraoTrafego;
	
	@Column(name = "otimizacao_rota")
	private String otimizacaoRota;
	
	@ManyToOne
	@JoinColumn(name = "id_semaforo")
	private Semafaro semafaro;
}
