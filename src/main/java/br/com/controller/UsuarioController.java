package br.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.model.Usuario;
import br.com.persistence.UsuarioDAO;

@Transactional
@Controller
public class UsuarioController {

	private UsuarioDAO dao;

	@Autowired
	public UsuarioController(UsuarioDAO dao) {
		this.dao = dao;
	}

	@RequestMapping("/formCadastro")
	public String formularioDeCadastro() {
		return "formCadastro";
	}

	@RequestMapping("/cadastro")
	public String cadastrarUsuario(Usuario usuario) {

		dao.create(usuario);
		return "loginForm";
	}

	@RequestMapping("/loginForm")
	public String formularioDeLogin() {
		return "loginForm";
	}

	@RequestMapping("/login")
	public String logar(Usuario usuario, HttpSession session) {

		if (dao.buscaPorLoginESenha(usuario) != null) {
			session.setAttribute("usuarioLogado", usuario);
			return "home";
		} else {
			return "redirect:loginForm";
		}
	}

	@RequestMapping("/listaUsuario")
	public ModelAndView listaDeUsuarios() {

		List<Usuario> usuarios = dao.findAll();

		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("todosOsUsuarios", usuarios);
		return mv;
	}
}
