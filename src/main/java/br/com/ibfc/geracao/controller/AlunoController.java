package br.com.ibfc.geracao.controller;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import br.com.ibfc.geracao.daos.AlunoDao;
import br.com.ibfc.geracao.daos.TurmaDao;
import br.com.ibfc.geracao.model.Aluno;

@Controller
@RequestMapping("/aluno")
@Transactional
public class AlunoController {
	
	
	@Autowired
	private AlunoDao alunoDao;
	
	@Autowired
	private TurmaDao turmaDao;

	@RequestMapping("/form")
	public ModelAndView form(Aluno aluno) {
		ModelAndView modelAndView = new ModelAndView("aluno/form-add");
		modelAndView.addObject("turmaList", turmaDao.all());
		return modelAndView;

	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Aluno aluno, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(aluno);
		}
		alunoDao.save(aluno);
		return new ModelAndView("redirect:/aluno");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("aluno/form-update");
		modelAndView.addObject("aluno", alunoDao.findById(id));
		modelAndView.addObject("turmaList", turmaDao.all());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page) {
		ModelAndView modelAndView = new ModelAndView("aluno/list");
		modelAndView.addObject("paginatedList", alunoDao.paginated(page, 10));
		return modelAndView;
	}

	// just because get is easier here. Be my guest if you want to change.
	@RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	public String remove(@PathVariable("id") Integer id) {
		Aluno aluno = alunoDao.findById(id);
		alunoDao.remove(aluno);
		return "redirect:/aluno";
	}

	@RequestMapping(method = RequestMethod.POST, value = "/{id}")
	public ModelAndView update(@PathVariable("id") Integer id, @Valid Aluno aluno,
			BindingResult bindingResult) {
		aluno.setId(id);
		if (bindingResult.hasErrors()) {
			return new ModelAndView("aluno/form-update");
		}
		alunoDao.update(aluno);
		return new ModelAndView("redirect:/aluno");
	}
}
