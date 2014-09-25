package br.com.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.model.ServiceUsuario;
import br.com.model.Usuario;

@Transactional
@Controller
public class UsuarioController {

	private ServiceUsuario funcao;

	@Autowired
	public UsuarioController(ServiceUsuario funcao) {
		this.funcao = funcao;
	}

	@RequestMapping("/formCadastro")
	public String formularioDeCadastro() {
		return "formCadastro";
	}

	@RequestMapping("/cadastro")
	public String cadastrar(Usuario usuario) {
		funcao.cadastrarUsuario(usuario);
		return "loginForm";
	}

	@RequestMapping("/loginForm")
	public String formularioDeLogin() {
		return "loginForm";
	}

	@RequestMapping("/login")
	public String logar(Usuario usuario, HttpSession session) {

		if (funcao.logar(usuario) != null) {
			session.setAttribute("usuarioLogado", usuario);
			return "home";
		} else {
			return "redirect:loginForm";
		}
	}

	@RequestMapping("/listaUsuario")
	public ModelAndView listaDeUsuarios() {

		List<Usuario> usuarios = funcao.listaDeUsuarios();

		ModelAndView mv = new ModelAndView("lista");
		mv.addObject("todosOsUsuarios", usuarios);
		return mv;
	}
}
