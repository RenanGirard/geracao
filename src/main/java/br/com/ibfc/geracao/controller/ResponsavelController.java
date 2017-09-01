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

import br.com.ibfc.geracao.daos.ResponsavelDao;
import br.com.ibfc.geracao.model.Responsavel;

@Controller
@RequestMapping("/responsavel")
@Transactional
public class ResponsavelController {
	@Autowired
	   private ResponsavelDao responsavelDao;

	   @RequestMapping("/form")
	   public ModelAndView form(Responsavel responsavel)
	   {
	      ModelAndView modelAndView = new ModelAndView("responsavel/form-add");
	      return modelAndView;

	   }

	   @RequestMapping(method = RequestMethod.POST)
	   public ModelAndView save(@Valid Responsavel responsavel, BindingResult bindingResult)
	   {
	      if (bindingResult.hasErrors())
	      {
	         return form(responsavel);
	      }
	      responsavelDao.save(responsavel);
	      return new ModelAndView("redirect:/responsavel");
	   }

	   @RequestMapping(method = RequestMethod.GET, value = "/{id}")
	   public ModelAndView load(@PathVariable("id") Integer id)
	   {
	      ModelAndView modelAndView = new ModelAndView("responsavel/form-update");
	      modelAndView.addObject("responsavel", responsavelDao.findById(id));
	      return modelAndView;
	   }

	   @RequestMapping(method = RequestMethod.GET)
	   public ModelAndView list(@RequestParam(defaultValue = "0", required = false) int page)
	   {
	      ModelAndView modelAndView = new ModelAndView("responsavel/list");
	      modelAndView.addObject("paginatedList", responsavelDao.paginated(page, 10));
	      return modelAndView;
	   }

	   //just because get is easier here. Be my guest if you want to change.
	   @RequestMapping(method = RequestMethod.GET, value = "/remove/{id}")
	   public String remove(@PathVariable("id") Integer id)
	   {
	      Responsavel responsavel = responsavelDao.findById(id);
	      responsavelDao.remove(responsavel);
	      return "redirect:/responsavel";
	   }

	   @RequestMapping(method = RequestMethod.POST, value = "/{id}")
	   public ModelAndView update(@PathVariable("id") Integer id, @Valid Responsavel responsavel, BindingResult bindingResult)
	   {
	      responsavel.setId(id);
	      if (bindingResult.hasErrors())
	      {
	         return new ModelAndView("responsavel/form-update");
	      }
	      responsavelDao.update(responsavel);
	      return new ModelAndView("redirect:/responsavel");
	   }
}
