package br.com.fiap.controletrafego.dtos;

import br.com.fiap.controletrafego.model.UsuarioRole;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UsuarioCadastroDTO(
		Long id,
		@NotBlank(message = "nome do usuario é obrigatorio!")
		String nome,
		@NotBlank(message = "Email do usuario é obrigatorio!")
		@Email(message = "Email invalido")
		String email,
		@NotBlank(message = "Senha do usuario é obrigatorio!")
		@Size(min = 6, max = 10, message = "A senha deve ter no minimo 6 caracteres e no maxio 10 caracteres!")
		String senha,
		UsuarioRole role
		) {

}
