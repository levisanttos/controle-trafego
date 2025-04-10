package br.com.fiap.controletrafego.dtos;

import br.com.fiap.controletrafego.model.Usuario;
import br.com.fiap.controletrafego.model.UsuarioRole;

public record UsuarioExbicaoDTO(
		Long id,
		String nome,
		String email,
		UsuarioRole role) {
	
	public UsuarioExbicaoDTO(Usuario usuario) {
		this(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getRole());
	}

}
