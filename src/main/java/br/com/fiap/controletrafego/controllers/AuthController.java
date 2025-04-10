package br.com.fiap.controletrafego.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fiap.controletrafego.configs.security.TokenService;
import br.com.fiap.controletrafego.dtos.LoginDTO;
import br.com.fiap.controletrafego.dtos.TokenDTO;
import br.com.fiap.controletrafego.dtos.UsuarioCadastroDTO;
import br.com.fiap.controletrafego.dtos.UsuarioExbicaoDTO;
import br.com.fiap.controletrafego.model.Usuario;
import br.com.fiap.controletrafego.service.UsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

	private final AuthenticationManager authenticationManager;
	
	private final UsuarioService usuarioService;
	
	private final TokenService tokenService;
	
	@PostMapping("/login")
	public ResponseEntity<TokenDTO> login(@RequestBody @Valid LoginDTO loginDTO) {
		
		UsernamePasswordAuthenticationToken usernamePassword = 
				new UsernamePasswordAuthenticationToken(
						loginDTO.email(), 
						loginDTO.senha());
		
		Authentication authentication = authenticationManager.authenticate(usernamePassword);
		
		String token = this.tokenService.gerarToken( (Usuario) authentication.getPrincipal());
		
		
		return ResponseEntity.ok(new TokenDTO(token));
	}
	
	@PostMapping("/register")
	public ResponseEntity<UsuarioExbicaoDTO> registrar(@RequestBody @Valid UsuarioCadastroDTO usuarioCadastroDTO) {
		
		return new ResponseEntity<UsuarioExbicaoDTO>(this.usuarioService.cadastrar(usuarioCadastroDTO), HttpStatus.CREATED);
	}
}
