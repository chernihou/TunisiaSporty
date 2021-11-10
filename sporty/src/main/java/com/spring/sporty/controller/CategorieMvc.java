package com.spring.sporty.controller;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;
@RestController
//@Controller
public class CategorieMvc {
    @Autowired
    CategorieService agent;
    private Categorie c;
    private BindingResult result;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/categories/add", method = RequestMethod.GET)
    public ModelAndView form_add(){
        ModelAndView mv = new ModelAndView();
        Categorie categorie = new Categorie();
        mv.addObject("Formcategorie", categorie);
        mv.setViewName("categorie");
        return mv;

    }
    @RequestMapping(value = "/categories/save", method = RequestMethod.POST)
    public ModelAndView save(@Validated @ModelAttribute("Formcategorie") Categorie c, BindingResult result) {
        if(result.hasErrors()){
            return(new ModelAndView("categorie"))  ;
        }else{
            agent.add_categorie(c);
            return new ModelAndView("redirect:/categories/list");
        }
    }
    @RequestMapping(value = "/categories/list", method = RequestMethod.GET)
    public ModelAndView display_categories() {
        ModelAndView mv = new ModelAndView();
        List<Categorie> categories = agent.findAll();
        mv.addObject("categories", categories);
        mv.setViewName("categories");
        return mv;

    }

    @RequestMapping(value = "/categories/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete_categorie(@PathVariable("id") long id) {
        agent.delete_categorie(id);
        return new ModelAndView("redirect:/categories/list");
    }

    @RequestMapping(value = "/categories/update/{id}", method = RequestMethod.GET)
    public ModelAndView display_form_update(@PathVariable("id") long id) {

        Categorie categorie = agent.find_categorie(id).get();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editcategorie");
        mv.addObject("Formcategorie", categorie);
        return mv;
    }
}
