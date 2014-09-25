package br.com.model;

import java.util.List;

import br.com.persistence.ServiceUsuarioDAO;
import br.com.persistence.UsuarioDAO;

public class ServiceUsuario implements ServiceUsuarioDAO {

	private UsuarioDAO dao;

	public void cadastrarUsuario(Usuario usuario) {
		dao.create(usuario);
	}

	public Usuario logar(Usuario usuario) {
		dao.buscaPorLoginESenha(usuario);
		return usuario;
	}

	public List<Usuario> listaDeUsuarios() {

		List<Usuario> usuarios = dao.findAll();
		return usuarios;
	}
}
