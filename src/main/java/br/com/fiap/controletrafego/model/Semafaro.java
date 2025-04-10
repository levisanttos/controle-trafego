package br.com.fiap.controletrafego.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "T_GT_SEMAFARO")
@Entity
@SequenceGenerator(name = "SEQ_SEMAFARO", sequenceName = "SEQ_SEMAFARO", allocationSize = 10, initialValue = 1)
public class Semafaro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_SEMAFARO")
	@Column(name = "id_semaforo")
	private Long id;
	
	@Column(name = "localizacao")
	private String localizacao;
	
	@Column(name = "estado")
	@Enumerated(EnumType.STRING)
	private EstadoEnum estado;
	
	@Column(name = "condicao_climatica")
	private String condicaoClimatica;
	
	@OneToMany(mappedBy = "semafaro")
	private List<Camera> cameras;
	
	@OneToMany(mappedBy = "semafaro")
	private List<MonitoramentoTrafego> monitoramentoTrafegos;

}
