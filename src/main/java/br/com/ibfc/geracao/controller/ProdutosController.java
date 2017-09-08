package br.com.ibfc.geracao.controller;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import br.com.ibfc.geracao.daos.ProfessorDao;
import br.com.ibfc.geracao.model.Produto;
import br.com.ibfc.geracao.model.Professor;


@Controller
@RequestMapping("/produtos")
public class ProdutosController {
    
	@Autowired
	private ProfessorDao professorDao;
	
  /*  private static final List<Produto> DADOS = new ArrayList<>(Arrays.asList(
            new Produto(1L, "Smartphone Samsung Galaxy On 7", new BigDecimal(849.99)),
            new Produto(2L, "Geladeira Electrolux Frost Free", new BigDecimal(1947.50)),
            new Produto(3L, "Purificador de Água Electrolux", new BigDecimal(533.30)),
            new Produto(4L, "Smart Watch Relogio Bluetooth", new BigDecimal(64.99)),
            new Produto(5L, "Smart TV LED 32\" Samsung", new BigDecimal(1249.00)),
            new Produto(6L, "Kit Pneu Aro 14 Dunlop 175/65r14", new BigDecimal(759.60)))); */
    
    @GetMapping
    public ModelAndView lista(Professor professor) {
        ModelAndView model = new ModelAndView("/produto-listath");
        List<Professor> lista1 = professorDao.all();
        
        
        List<Professor> lista = lista1.stream()
                .filter(p -> professor.getId() == null || professor.getId().equals(p.getId()))
                .filter(p -> StringUtils.isEmpty(professor.getNome()) || p.getNome().startsWith(professor.getNome()))
                .collect(Collectors.toList());
        
        model.addObject("professores", lista);
        
        return model;
    }
}