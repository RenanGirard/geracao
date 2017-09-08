package br.com.ibfc.geracao.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.ibfc.geracao.daos.ProfessorDao;
import br.com.ibfc.geracao.model.Professor;

@Controller
@RequestMapping("/professor")
@Transactional
public class ProfessorController {

	@Autowired
	private ProfessorDao professorDao;

	@RequestMapping("/form")
	public ModelAndView form(Professor professor) {
		ModelAndView modelAndView = new ModelAndView("professor/form-addjsp");
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Professor professor, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(professor);
		}
		professorDao.save(professor);
		return new ModelAndView("redirect:/professor");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("professor/form-updatejsp");
		modelAndView.addObject("professor", professorDao.findById(id));
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(Professor professor) {
		ModelAndView modelAndView = new ModelAndView("professor/listth");
		List<Professor> DADOS = professorDao.all();

		List<Professor> lista = DADOS.stream()
				.filter(p -> professor.getId() == null || professor.getId().equals(p.getId()))
				.filter(p -> StringUtils.isEmpty(professor.getNome()) || p.getNome().contains(professor.getNome()))
				.collect(Collectors.toList());

		modelAndView.addObject("professores", lista);
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Professor professor = professorDao.findById(id);
		professorDao.remove(professor);
		return "redirect:/professor";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Professor professor,
			BindingResult bindingResult) {
		professor.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("professor/form-updatejsp");
		}
		professorDao.update(professor);
		return new ModelAndView("redirect:/professor");
	}
}
