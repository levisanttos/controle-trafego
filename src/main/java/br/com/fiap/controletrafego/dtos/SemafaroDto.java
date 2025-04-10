package br.com.fiap.controletrafego.dtos;

import br.com.fiap.controletrafego.model.EstadoEnum;
import br.com.fiap.controletrafego.model.Semafaro;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SemafaroDto(
		Long id,
		
		@NotBlank(message = "A localizacao do semafaro é obrigatorio!")
		@Size(min = 4, message = "A localizacao do semafaro deve ter no minimo 4 caracteres!")
		String localizacao, 
		
		@NotBlank(message = "O estado do semafaro é obrigatorio!")
		@Size(min = 4, message = "O estado do semafaro deve ter no minimo 4 caracteres!")
		EstadoEnum estado, 
		
		@NotBlank(message = "A condicao climatica  é obrigatorio!")
		@Size(min = 4, message = "A condicao climatica deve ter no minimo 4 caracteres!")
		String condicaoClimatica) {
	public SemafaroDto(Semafaro semafaro) {
		this(semafaro.getId(), semafaro.getLocalizacao(), semafaro.getEstado(), semafaro.getCondicaoClimatica());
	}

}
