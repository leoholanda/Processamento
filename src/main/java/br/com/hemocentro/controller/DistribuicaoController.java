package br.com.hemocentro.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.hemocentro.model.Bolsa;
import br.com.hemocentro.model.Setor;
import br.com.hemocentro.repository.IBolsaRepository;
import br.com.hemocentro.repository.ISetorRepository;

@Controller
@RequestMapping("/distribuicao")
public class DistribuicaoController {

	@Autowired
	private IBolsaRepository bolsaRepository;
	
	@Autowired
	private ISetorRepository setorRepository;
	
	private static final String LIST_DIST = "distribuicao/listagem-distribuicao";
	private static final String NEW_DIST = "distribuicao/nova-distribuicao";
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(NEW_DIST);
		mv.addObject(new Bolsa());
		return mv;
	}
		
	@RequestMapping
	public ModelAndView allBolsas(Bolsa bolsa) {
		// TODO: Lista de bolsas
		ModelAndView mv = new ModelAndView(LIST_DIST);
		mv.addObject("bolsas", bolsaRepository.orderByCodigo());
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Bolsa bolsa) {
		// TODO: Distribuir Sangue
		ModelAndView mv = new ModelAndView(NEW_DIST);
		mv.addObject(bolsa);
		return mv;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid Bolsa bolsa, Errors errors, RedirectAttributes attributes) {
		// TODO: Salva distribuicao
		
		if(errors.hasErrors()) {
			return NEW_DIST;
		}
		
		try {
			bolsaRepository.save(bolsa);
			attributes.addFlashAttribute("mensagem", "Sangue distribuido com sucesso para ");
			return "redirect:/distribuicao";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("codigo", null, e.getMessage());
			return LIST_DIST;
		}
	}
	
	@ModelAttribute("setores")
	public List<Setor> carregaSetores() {
		// TODO: Carrega lista de setors
		return setorRepository.orderByNome();
	}

}
