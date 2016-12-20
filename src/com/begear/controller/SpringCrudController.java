package com.begear.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.begear.dao.DaoH;
import com.begear.model.StudenteH;

@Controller
public class SpringCrudController {
	@Autowired
	DaoH dao;
	
	@Autowired
	StudenteH stu;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String Index(){
		return "index";
	}
	
	
	@RequestMapping(value = "/studenteIns", method = RequestMethod.GET)
    public ModelAndView studenteIns() {
       return new ModelAndView("studenteIns", "formStudente", stu);
       // qui creo l'associazione tra il pojo (Studente.java) e il form nella pagina studenteIns.jsp (che a sua volta è settato con modelAttribute="formStudente")
       // nota bene, se avessi scritto "comand" (nome comando di default) al posto di "formStudente", non avrei avuto bisogno di settarlo (modelAttribute="formStudente" oppure(equivalente) commandName="formStudente")  
    }
	
	@RequestMapping(value = "/insStudente", method = RequestMethod.POST)
    public String insStudente(@ModelAttribute("formStudente")StudenteH stuIns) {
		try {
			dao.insertStudente(stuIns);
		} catch (HibernateException e) {
			System.out.println("Rilevato Errore: " + e.getMessage());
			e.printStackTrace();
		}
		return "index";
	
	}

	@RequestMapping(value = "/studenteList", method = RequestMethod.GET)
	public ModelAndView listaStudenti()
	{	
		List<StudenteH> lst=null;
		
		try {
			lst = dao.stampaStudenti();
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("studenteLista","list",lst);
	}
	
	
	//DELETE STUDENTE
	@RequestMapping(value = "/deleteStudente/{matricola}", method = RequestMethod.GET)
	public String deleteStudente(@PathVariable int matricola)
	{	
		try {
			stu.setMatricola(matricola);
			dao.deleteStudente(stu);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "redirect:/studenteList";
		//return "/studenteList"; // KO perchè resta nel path della delete
	}

	
	//UPDATE STUDENTE
	@RequestMapping(value = "/updateStudente/{matricola}", method = RequestMethod.GET)
	public ModelAndView updateStudente(@PathVariable int matricola)
	{	
		try {
			stu.setMatricola(matricola);
			stu=dao.ricercaStudente(stu);
		} catch (HibernateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ModelAndView("studenteUpd", "formStudente", stu);
	}

	@RequestMapping(value = "/updStudente", method = RequestMethod.POST)
    public String updStudente(@ModelAttribute("formStudente")StudenteH stuUpd) {
		try {
			dao.updateStudente(stuUpd);
		} catch (HibernateException e) {
			System.out.println("Rilevato Errore: " + e.getMessage());
			e.printStackTrace();
		}
		return "redirect:/studenteList";
	
	}
}
