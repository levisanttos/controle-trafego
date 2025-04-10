package br.com.fiap.controletrafego.dtos;

import java.time.LocalDate;

import br.com.fiap.controletrafego.model.EstadoCamera;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class CameraDTO {

	private Long id;

	@NotBlank(message = "Localizacao é obrigatorio!")
	@Size(min = 6, message = "A Localizacao deve ter no minimo 6 caracteres!")
	private String localizacao;
	
	@NotBlank(message = "Modelo é obrigatorio!")
	@Size(min = 5, message = "O modelo deve ter no minimo 8 caracteres!")
	private String modelo;

	@NotBlank(message = "Status é obrigatorio!")
	private EstadoCamera status;
	
	private LocalDate dataInstalacao;

}
