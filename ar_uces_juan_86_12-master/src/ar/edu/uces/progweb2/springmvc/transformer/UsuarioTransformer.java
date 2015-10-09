package ar.edu.uces.progweb2.springmvc.transformer;

import ar.edu.uces.progweb2.springmvc.dto.UsuarioFormDTO;
import ar.edu.uces.progweb2.springmvc.model.Usuario;

public class UsuarioTransformer {
	
	public Usuario transformToUsuario(UsuarioFormDTO usuarioForm){
		Usuario usuario = new Usuario();
		usuario.setUser(usuarioForm.getUser());
		usuario.setPass(usuarioForm.getPassword());
		return usuario;
	}
}
