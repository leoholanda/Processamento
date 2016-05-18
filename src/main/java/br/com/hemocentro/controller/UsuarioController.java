package br.com.hemocentro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.hemocentro.model.Usuario;
import br.com.hemocentro.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuario")
public class UsuarioController {

	private static final String CADASTRO_VIEW = "novo-usuario";

	@Autowired
	private UsuarioRepository usuarioRepository;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("novo-usuario");

		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Usuario usuario, Errors errors, RedirectAttributes attributes) {
		// TODO: Salva usuario no banco de dados

		if (errors.hasErrors()) {
			return CADASTRO_VIEW;
		}

		usuarioRepository.save(usuario);
		attributes.addFlashAttribute("mensagem", "Usuário cadastrado com sucesso!");
		return "redirect:/usuario/novo";
	}

	@RequestMapping
	public ModelAndView pesquisar() {
		// TODO: Pesquisa usuarios
		
		List<Usuario> todos = usuarioRepository.findAll();
		ModelAndView mv = new ModelAndView("pesquisa-usuario");
		mv.addObject("usuarios", todos);
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView edicao(@PathVariable("matricula") Usuario usuario) {
		// TODO: Edita usuario
		
		ModelAndView mv = new ModelAndView(CADASTRO_VIEW);
		mv.addObject(usuario);
		return mv;
	}

}
