package com.spring.sporty.controller;
import com.spring.sporty.model.Categorie;
import com.spring.sporty.model.Marque;
import com.spring.sporty.service.CategorieService;
import com.spring.sporty.service.MarqueService;
import com.spring.sporty.service.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@RestController
public class MarqueMvc {
    @Autowired
    MarqueService agent;
    private Marque m;
    private BindingResult result;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("index");
        return mv;
    }

    @RequestMapping(value = "/marques/add", method = RequestMethod.GET)
    public ModelAndView form_add(){
        ModelAndView mv = new ModelAndView();
        Marque marque = new Marque();
        mv.addObject("Formmarque", marque);
        mv.setViewName("marque");
        return mv;

    }
    @RequestMapping(value = "/marques/save", method = RequestMethod.POST)
    public ModelAndView save(@Validated @ModelAttribute("Formmarques") Marque m, BindingResult result) {
        if(result.hasErrors()){
            return(new ModelAndView("categorie"))  ;
        }else{
            agent.add_marque(m);
            return new ModelAndView("redirect:/marques/list");
        }
    }
    @RequestMapping(value = "/marques/list", method = RequestMethod.GET)
    public ModelAndView display_marques() {
        ModelAndView mv = new ModelAndView();
        List<Marque> marques = agent.findAll();
        mv.addObject("marques", marques);
        mv.setViewName("marques");
        return mv;

    }

    @RequestMapping(value = "/marques/delete/{id}", method = RequestMethod.GET)
    public ModelAndView delete_marques(@PathVariable("id") long id) {
        agent.delete_marque(id);
        return new ModelAndView("redirect:/marques/list");
    }

    @RequestMapping(value = "/marques/update/{id}", method = RequestMethod.GET)
    public ModelAndView display_form_update(@PathVariable("id") long id) {

        Marque marque = agent.find_marque(id).get();
        ModelAndView mv = new ModelAndView();
        mv.setViewName("editmarque");
        mv.addObject("Formmarque", marque);
        return mv;
    }
    
}
