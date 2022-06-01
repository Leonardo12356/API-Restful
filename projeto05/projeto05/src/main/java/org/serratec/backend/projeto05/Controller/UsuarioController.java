package org.serratec.backend.projeto05.Controller;

import javax.validation.Valid;

import org.serratec.backend.projeto05.DTO.UsuarioDTO;
import org.serratec.backend.projeto05.security.JwtUtil;
import org.serratec.backend.projeto05.security.UsuarioDetalheService;
import org.serratec.backend.projeto05.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private AuthenticationManager autheticationManager;
	
	@Autowired
	private UsuarioDetalheService usuarioDetalheService;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@PostMapping("/salvar")
	public ResponseEntity<Integer> salvar(@RequestBody @Valid UsuarioDTO usuarioDTO){
		return ResponseEntity.ok(usuarioService.salvar(usuarioDTO));
	}
	
	@GetMapping("/buscar")
	public ResponseEntity<UsuarioDTO> buscar(@RequestParam String login){
		return ResponseEntity.ok(usuarioService.buscarPorLogin(login));
	}
	
}
