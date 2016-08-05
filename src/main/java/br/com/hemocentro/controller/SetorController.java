package br.com.hemocentro.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.hemocentro.model.Setor;
import br.com.hemocentro.model.Unidade;
import br.com.hemocentro.repository.ISetorRepository;

@Controller
@RequestMapping("/setor")
public class SetorController {
	
	private static final String NEW_SETOR = "setor/novo-setor";
	private static final String SEARCH_SETOR = "setor/pesquisa-setor";
	
	@Autowired
	private ISetorRepository setorRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(NEW_SETOR);
		mv.addObject(new Setor());
		return mv;
	}
	
	@RequestMapping("/setores")
	public ModelAndView allSetores(Setor setor) {
		// TODO: Lista de setores
		List<Setor> setores = setorRepository.orderByNome();
		ModelAndView mv = new ModelAndView(SEARCH_SETOR);
		mv.addObject("setores", setores);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Validated Setor setor, Errors errors, RedirectAttributes attributes) {
		// TODO: Salva setor no banco de dados
		
		if(errors.hasErrors()) {
			return NEW_SETOR;
		}
		
		try {
			setorRepository.save(setor);
			attributes.addFlashAttribute("mensagem", "Setor cadastrado com sucesso!");
			return "redirect:/setor/novo";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return NEW_SETOR;
		}
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Setor setor) {
		// TODO: Edita setor
		ModelAndView mv = new ModelAndView(NEW_SETOR);
		mv.addObject(setor);
		return mv;
	}
	
	@ModelAttribute("unidades")
	public List<Unidade> todasUnidades() {
		return Arrays.asList(Unidade.values());
	}
}
