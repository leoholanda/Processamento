package br.com.hemocentro.controller;

import java.util.Arrays;
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
import br.com.hemocentro.model.TipoSanguineo;
import br.com.hemocentro.repository.IBolsaRepository;
import br.com.hemocentro.repository.ISetorRepository;

@Controller
@RequestMapping("/bolsa")
public class BolsaController {
	
	private static final String NEW_BOLSA = "bolsa/nova-bolsa";
	private static final String SEARCH_BOLSA = "bolsa/pesquisa-bolsa";
	
	@Autowired
	private IBolsaRepository bolsaRepository;
	
	@Autowired
	private ISetorRepository setorRepository;
	
	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(NEW_BOLSA);
		mv.addObject(new Bolsa());
		return mv;
	}
	
	@RequestMapping("/bolsas")
	public ModelAndView allBolsaes(Bolsa bolsa) {
		// TODO: Lista de bolsas
		ModelAndView mv = new ModelAndView(SEARCH_BOLSA);
		mv.addObject("bolsas", bolsaRepository.orderByCodigo());
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid Bolsa bolsa, Errors errors, RedirectAttributes attributes) {
		// TODO: Salva setor no banco de dados
		
		if(errors.hasErrors()) {
			return NEW_BOLSA;
		}
		
		try {
			bolsaRepository.save(bolsa);
			attributes.addFlashAttribute("mensagem", "Bolsa cadastrada com sucesso!");
			return "redirect:/bolsa/novo";
		} catch (IllegalArgumentException e) {
			errors.rejectValue("dataVencimento", null, e.getMessage());
			return NEW_BOLSA;
		}
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Bolsa bolsa) {
		// TODO: Edita setor
		ModelAndView mv = new ModelAndView(NEW_BOLSA);
		mv.addObject(bolsa);
		return mv;
	}
	
	@ModelAttribute("setores")
	public List<Setor> carregaSetores() {
		return setorRepository.findAll();
	}
	
	@ModelAttribute("tiposSanguineos")
	public List<TipoSanguineo> tiposSanguineos() {
		return Arrays.asList(TipoSanguineo.values());
	}
}
