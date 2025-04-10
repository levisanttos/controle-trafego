package br.com.fiap.controletrafego.dtos;

import br.com.fiap.controletrafego.model.EstadoEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SemafaroUpdateDto {
	
	@NotBlank(message = "O estado do semafaro é obrigatorio!")
	@Size(min = 4, message = "O estado do semafaro deve ter no minimo 4 caracteres!")
	private EstadoEnum estado;

}
