package com.spring.sporty.controller;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Marque;
import com.spring.sporty.model.Produit;
import com.spring.sporty.service.CategorieService;
import com.spring.sporty.service.MarqueService;
import com.spring.sporty.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public class ProduitMVC {
    @Autowired
    ProduitService agentprd;

    @Autowired
    CategorieService agentcat;

    @Autowired
    MarqueService agentmar;
    @RequestMapping(value = "/produits/add", method = RequestMethod.GET)
    public ModelAndView display_form() {
        Produit produits = new Produit();
       // List<Categorie> categories = agentcat.findAll();
      //  List<Marque> marques = (List<Marque>) agentmar.findAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("produits");
        mv.addObject("Formproduit", produits);
     //   mv.addObject("categories", categories);
     //   mv.addObject("marques", marques);
        return mv;
    }
    @RequestMapping(value = "produits/save", method = RequestMethod.POST)
    public ModelAndView save(@ModelAttribute("Formproduit")Produit produits){

        agentprd.add_produit(produits);
        return new ModelAndView("redirect:/produits/list");
    }
    @RequestMapping(value = "/produits/list", method = RequestMethod.GET)
    public ModelAndView display_produit() {
        ModelAndView mv = new ModelAndView();
        List<Produit> produits = agentprd.findAll();
        mv.addObject("produits", produits);
        mv.setViewName("produits");
        return mv;
    }
    @RequestMapping(value ="/produits/delete/{id}",method =RequestMethod.GET)
    public ModelAndView delete_rdv(@PathVariable("id")long id){
        agentprd.delete_produit(id);
        return new ModelAndView("redirect:/produits/list");
    }
    @RequestMapping(value = "/produits/update/{id}",method = RequestMethod.GET)
    public ModelAndView display_form_update(@PathVariable("id")long id) {
        Produit produits = agentprd.find_produit(id).get();
       // List<Categorie> categories = agentcat.findAll();
       // List<Marque> marques = (List<Marque>) agentmar.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editproduit");
        mv.addObject("Formproduit", produits);
       // mv.addObject("categoris", categories);
      //  mv.addObject("marques", marques);
        return mv;
    }
}
