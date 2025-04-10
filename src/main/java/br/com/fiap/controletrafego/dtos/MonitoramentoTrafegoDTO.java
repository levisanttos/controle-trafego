package br.com.fiap.controletrafego.dtos;

import java.time.LocalDateTime;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class MonitoramentoTrafegoDTO {

	private Long id;

	private LocalDateTime dataHora;
	
	@NotBlank(message = "Padrão do trafego é obrigatorio!")
	@Size(min = 4, message = "O Padrão deve ter no minimo 4 caracteres!")
	private String padraoTrafego;
	
	@NotBlank(message = "A otimizacao da Rota é obrigatorio!")
	@Size(min = 5, message = "A otimizacao da Rota deve ter no minimo 5 caracteres!")
	private String otimizacaoRota;
	
}
