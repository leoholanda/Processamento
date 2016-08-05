package br.com.hemocentro.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.hemocentro.model.Setor;
import br.com.hemocentro.model.TipoSanguineo;
import br.com.hemocentro.repository.ISetorRepository;

@Controller
@RequestMapping("/processamento")
public class IndexController {
	
	@Autowired
	private ISetorRepository setorRepository;
		
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	
	@RequestMapping("/index")
	public ModelAndView allTipoSanguineo(TipoSanguineo tipoSanguineo) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("tipoSanguineos", todosTipos());
		return mv;
	}
	
	public ModelAndView allSetores(Setor setor) {
		// TODO: Lista de setores
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("setores", setorRepository.findAll());
		return mv;
	}
	
	@RequestMapping("{codigo}")
	public ModelAndView editar(@PathVariable("codigo") Setor setor) {
		// TODO: Edita setor
		ModelAndView mv = new ModelAndView("index");
		mv.addObject(setor);
		return mv;
	}
	
	@ModelAttribute("tiposSanguineos")
	public List<TipoSanguineo> todosTipos() {
		return Arrays.asList(TipoSanguineo.values());
	}

}
