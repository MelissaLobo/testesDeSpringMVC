package br.com.persistence;

import java.util.List;

import br.com.model.Usuario;

public interface ServiceUsuarioImpl {

	void cadastrarUsuario(Usuario usuario);

	Usuario logar(Usuario usuario);

	List<Usuario> listaDeUsuarios();

}
