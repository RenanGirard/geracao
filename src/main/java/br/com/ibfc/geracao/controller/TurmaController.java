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

import br.com.ibfc.geracao.daos.TurmaDao;
import br.com.ibfc.geracao.model.Turma;

@Controller
@RequestMapping("/turma")
@Transactional
public class TurmaController {

	@Autowired
	private TurmaDao turmaDao;

	@RequestMapping("/form")
	public ModelAndView form(Turma turma) {
		ModelAndView modelAndView = new ModelAndView("turma/form-add");
		return loadFormDependencies(modelAndView);

	}

	private ModelAndView loadFormDependencies(ModelAndView modelAndView) {
		modelAndView.addObject("turmaList", turmaDao.all());
		return modelAndView;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView save(@Valid Turma turma, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return form(turma);
		}
		turmaDao.save(turma);
		return new ModelAndView("redirect:/turma");
	}

	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public ModelAndView load(@PathVariable("id") Integer id) {
		ModelAndView modelAndView = new ModelAndView("turma/form-update");
		modelAndView.addObject("turma", turmaDao.findById(id));
		loadFormDependencies(modelAndView);
		return modelAndView;
	}
	
	
	
	
	@RequestMapping(method = RequestMethod.GET)
	   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
	   {
	      ModelAndView modelAndView = new ModelAndView("turma/list");
	      modelAndView.addObject("paginatedList", turmaDao.paginated(page, 10));
	      return modelAndView;
	   }

	   //just because get is easier here. Be my guest if you want to change.
	   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	   public String remove(@PathVariable("id") Integer id)
	   {
	      Turma turma = turmaDao.findById(id);
	      turmaDao.remove(turma);
	      return "redirect:/turma";
	   }

	   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
	   public ModelAndView update(@PathVariable("id") Integer id, @Valid Turma turma, BindingResult bindingResult)
	   {
	      turma.setId(id);
	      if (bindingResult.hasErrors())
	      {
	         return loadFormDependencies(new ModelAndView("turma/form-update"));
	      }
	      turmaDao.update(turma);
	      return new ModelAndView("redirect:/turma");
	   }

}
