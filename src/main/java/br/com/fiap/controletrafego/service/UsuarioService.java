package br.com.fiap.controletrafego.service;

import java.util.List;

import br.com.fiap.controletrafego.dtos.UsuarioCadastroDTO;
import br.com.fiap.controletrafego.dtos.UsuarioExbicaoDTO;

public interface UsuarioService {
	
	UsuarioExbicaoDTO cadastrar(UsuarioCadastroDTO usuarioCadastroDTO);
	
	UsuarioExbicaoDTO buscaPorId(Long id);
	
	UsuarioExbicaoDTO atualizar(UsuarioCadastroDTO cadastroDTO);
	
	void remover(Long id);

	List<UsuarioExbicaoDTO> listaTodos();

}
