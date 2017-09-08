package br.com.ibfc.geracao.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.ibfc.geracao.daos.ProfessorDao;
import br.com.ibfc.geracao.model.Greeting;
import br.com.ibfc.geracao.model.Professor;

@RestController
public class GreetingController {
	
	@Autowired
	private ProfessorDao professorDao;

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	
	
	@RequestMapping("/prof")
	public Professor professor(@RequestParam(value = "id", defaultValue = "1") String id) {
		return professorDao.findById(new Integer(id));
	}
}
