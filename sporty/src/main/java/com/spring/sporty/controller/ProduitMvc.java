package com.spring.sporty.controller;

import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Marque;
import com.spring.sporty.model.Produit;
import com.spring.sporty.model.Search;
import com.spring.sporty.service.CategorieService;
import com.spring.sporty.service.MarqueService;
import com.spring.sporty.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@RestController
public class ProduitMvc {
    @Autowired
    ProduitService agentprd;

    @Autowired
    CategorieService agentcat;

    @Autowired
    MarqueService agentmar;


    @RequestMapping(value = "/produits/add", method = RequestMethod.GET)
    public ModelAndView display_form() {
        Produit produit = new Produit();
        List<Categorie> categories = agentcat.findAll();
        List<Marque> marques = (List<Marque>) agentmar.findAll();

        ModelAndView mv = new ModelAndView();
        mv.setViewName("produit");
        mv.addObject("Formproduit", produit);
        mv.addObject("categories", categories);
       mv.addObject("marques", marques);
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
        List<Produit> produit = agentprd.findAll();
        mv.addObject("produits", produit);
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
        Produit produit = agentprd.find_produit(id).get();
       List<Categorie> categories = agentcat.findAll();
        List<Marque> marques = (List<Marque>) agentmar.findAll();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editproduit");
        mv.addObject("Formproduit", produit);
        mv.addObject("categories", categories);
       mv.addObject("marques", marques);
        return mv;
    }
    @RequestMapping(value = "/produits/recherche", method = RequestMethod.GET)
    public ModelAndView display_search() {
        ModelAndView mv = new ModelAndView();
        Search search = new Search();
        mv.addObject("search", search);
        mv.setViewName("search");
        return mv;

    }



}
