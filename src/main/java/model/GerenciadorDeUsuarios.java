package model;

import java.util.List;

import persistence.UsuarioDAO;

public class GerenciadorDeUsuarios {

	UsuarioDAO usuarioDAO = new UsuarioDAO();

	public List<Usuario> listaDeUsuarios() {
		return usuarioDAO.findAll();
	}
	
	public Usuario tentaLogar(Usuario usuario) {
		return usuarioDAO.buscaPorLoginESenha(usuario);
	}
}
