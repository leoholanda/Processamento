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
import br.com.hemocentro.repository.IBolsaRepository;
import br.com.hemocentro.repository.ISetorRepository;

@Controller
@RequestMapping("/processamento")
public class IndexController {
	
	@Autowired
	private ISetorRepository setorRepository;
	
	@Autowired
	private IBolsaRepository bolsaRepository;
		
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView("index");
		
		return mv;
	}
	
	@RequestMapping("/index")
	public ModelAndView allTipoSanguineo(TipoSanguineo tipoSanguineo) {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("estoque", bolsaRepository.countEstoqueBolsas());
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
	
	@ModelAttribute("totalAPositivo")
	public Long totalAPositivo() {
		Long total = bolsaRepository.countByTipoSanguineo(TipoSanguineo.A_POSITIVO);
		return total;
	}
	
	@ModelAttribute("totalANegativo")
	public Long totalANegativo() {
		Long total = bolsaRepository.countByTipoSanguineo(TipoSanguineo.A_NEGATIVO);
		return total;
	}
	
	@ModelAttribute("totalBPositivo")
	public Long totalBPositivo() {
		Long total = bolsaRepository.countByTipoSanguineo(TipoSanguineo.B_POSITIVO);
		return total;
	}
	
	@ModelAttribute("totalBNegativo")
	public Long totalBNegativo() {
		Long total = bolsaRepository.countByTipoSanguineo(TipoSanguineo.B_NEGATIVO);
		return total;
	}
	
	@ModelAttribute("totalABPositivo")
	public Long totalABPositivo() {
		Long total = bolsaRepository.countByTipoSanguineo(TipoSanguineo.AB_POSITIVO);
		return total;
	}
	
	@ModelAttribute("totalABNegativo")
	public Long totalABNegativo() {
		Long total = bolsaRepository.countByTipoSanguineo(TipoSanguineo.AB_NEGATIVO);
		return total;
	}
	
	@ModelAttribute("totalOPositivo")
	public Long totalOPositivo() {
		Long total = bolsaRepository.countByTipoSanguineo(TipoSanguineo.O_POSITIVO);
		return total;
	}
	
	@ModelAttribute("totalONegativo")
	public Long totalONegativo() {
		Long total = bolsaRepository.countByTipoSanguineo(TipoSanguineo.O_NEGATIVO);
		return total;
	}
	
	@ModelAttribute("sangueTotal")
	public Long sangueTotal() {
		Long total = bolsaRepository.countByBolsa();
		return total;
	}
}
