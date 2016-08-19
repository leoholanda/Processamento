package br.com.hemocentro.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.hemocentro.model.Solicitacao;
import br.com.hemocentro.repository.ISolicitacaoRepository;

@Controller
@RequestMapping("/solicitacao")
public class SolicitacaoController {

	private static final String NEW_SOLICITACAO = "solicitacao/nova-solicitacao";
	private static final String SEARCH_SOLICITACAO = "solicitacao/listagem-solicitacao";

	@Autowired
	private ISolicitacaoRepository solicitacaoRepository;

	@RequestMapping("/novo")
	public ModelAndView novo() {
		ModelAndView mv = new ModelAndView(NEW_SOLICITACAO);
		mv.addObject(new Solicitacao());
		return mv;
	}

	@RequestMapping
	public ModelAndView allSolicitacoes(Solicitacao solicitacao) {
		// TODO: Lista de solicitacoes
		List<Solicitacao> solicitacoes = solicitacaoRepository.findAll();
		ModelAndView mv = new ModelAndView(SEARCH_SOLICITACAO);
		mv.addObject("solicitacoes", solicitacoes);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public String salvar(@Valid Solicitacao solicitacao, Errors errors, RedirectAttributes attributes) {
		// TODO: Salva solicitacao no banco de dados

		if (errors.hasErrors()) {
			return NEW_SOLICITACAO;
		}

		try {
			solicitacaoRepository.save(solicitacao);
			attributes.addFlashAttribute("mensagem", "Solicitação enviada com sucesso! O Processamento entrará em contato.");
			System.out.println(">>" + LocalDateTime.now());
			return "redirect:/solicitacao/novo";
		} catch (IllegalArgumentException e) {
			return NEW_SOLICITACAO;
		}
	}

	// @RequestMapping("{codigo}")
	// public ModelAndView editar(@PathVariable("codigo") Solicitacao setor) {
	// // TODO: Edita setor
	// ModelAndView mv = new ModelAndView(NEW_SOLICITACAO);
	// mv.addObject(setor);
	// return mv;
	// }
	//
	// @ModelAttribute("unidades")
	// public List<Unidade> todasUnidades() {
	// return Arrays.asList(Unidade.values());
	// }
}
