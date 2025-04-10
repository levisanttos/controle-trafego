package br.com.fiap.controletrafego.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Table(name = "T_GT_CAMERAS")
@Entity
@SequenceGenerator(name = "SEQ_CAMERA", sequenceName = "SEQ_CAMERA", allocationSize = 1, initialValue = 1)
public class Camera {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CAMERA")
	@Column(name = "id_camera")
	private Long id;
	
	@Column(name = "localizacao")
	private String localizacao;
	
	@Column(name = "modelo")
	private String modelo;
	
	@Column(name = "status", length = 20)
	@Enumerated(EnumType.STRING)
	private EstadoCamera status;
	
	@Column(name = "data_instalacao")
	private LocalDate dataInstalacao;
	
	@ManyToOne
	@JoinColumn(name = "id_semaforo")
	private Semafaro semafaro;
	
	

}
