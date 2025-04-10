package br.com.fiap.controletrafego.model;

import lombok.Getter;

@Getter
public enum UsuarioRole {
	
	ADMIN("admin"), USER("user");

	private String role;
	
	UsuarioRole(String role) {
		this.role = role;
	}

}
