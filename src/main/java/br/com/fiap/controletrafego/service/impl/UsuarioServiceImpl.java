package br.com.fiap.controletrafego.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.fiap.controletrafego.dtos.UsuarioCadastroDTO;
import br.com.fiap.controletrafego.dtos.UsuarioExbicaoDTO;
import br.com.fiap.controletrafego.exception.ObjetoNotFoundException;
import br.com.fiap.controletrafego.model.Usuario;
import br.com.fiap.controletrafego.repository.UsuarioRepository;
import br.com.fiap.controletrafego.service.UsuarioService;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {

	private final UsuarioRepository usuarioRepository;
	
	private final PasswordEncoder passwordEncoder;
	
	@Override
	public UsuarioExbicaoDTO cadastrar(UsuarioCadastroDTO usuarioCadastroDTO) {
		
		Usuario usuario = new Usuario();
		BeanUtils.copyProperties(usuarioCadastroDTO, usuario);
		
		usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
		
		usuario = this.usuarioRepository.save(usuario);
		return new UsuarioExbicaoDTO(usuario);
	}

	@Override
	public UsuarioExbicaoDTO buscaPorId(Long id) {
		Optional<Usuario> usuarioOptional = this.usuarioRepository.findById(id);
		
		if (usuarioOptional.isPresent()) {
			return new UsuarioExbicaoDTO(usuarioOptional.get());
		} else {
			throw new ObjetoNotFoundException("Usuario não encontrado");
		}
	}

	@Override
	public UsuarioExbicaoDTO atualizar(UsuarioCadastroDTO cadastroDTO) {
		return null;
	}

	@Override
	public void remover(Long id) {

	}

	@Override
	public List<UsuarioExbicaoDTO> listaTodos() {
		return null;
	}

}
