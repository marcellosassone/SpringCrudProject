package com.begear.controller.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.begear.dao.DaoH;
import com.begear.model.StudenteH;

@RestController
@RequestMapping("/rest/studenti")
public class StudentRestController {

	@Autowired
	DaoH dao;

	@RequestMapping(method = RequestMethod.POST)
	public void insertStudente(@RequestBody StudenteH s) {
		dao.insertStudente(s);
	}

	@RequestMapping(value="/studente/{matricola}", method=RequestMethod.DELETE)
	public void deleteStudente(@PathVariable int matricola) {
		StudenteH s = new StudenteH();
		s.setMatricola(matricola);
		dao.deleteStudente(s);
	}

	@RequestMapping(method = RequestMethod.PUT)
	public void updateStudente(@RequestBody StudenteH s) {
		dao.updateStudente(s);
	}
	
	@RequestMapping(value="/studente/{matricola}", method=RequestMethod.GET)
	public @ResponseBody StudenteH getStudente(@PathVariable int matricola) {
		StudenteH s = new StudenteH();
		s.setMatricola(matricola);
		return dao.ricercaStudente(s);
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public @ResponseBody List<StudenteH> getStudenti() {
		return dao.stampaStudenti();
	}

}
