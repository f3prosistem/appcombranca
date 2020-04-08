package com.f3pro.appcombranca.controller;


import com.f3pro.appcombranca.model.StatusTitulo;
import com.f3pro.appcombranca.model.Titulo;
import com.f3pro.appcombranca.repository.Titulos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/titulos")
public class TituloController {

    @Autowired
    private Titulos titulos;

    @RequestMapping("/novo")
    public ModelAndView novo() {
        ModelAndView mv = new ModelAndView("CadastrosTitulo");
        return mv;
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView salvar(Titulo titulo) {
        titulos.save(titulo);

        ModelAndView mv = new ModelAndView("CadastrosTitulo");
        mv.addObject("mensagem","Título salvo com sucesso!");
        return mv;

    }
    @RequestMapping
    public String pesquisar(){
        return "PesquisaTitulos";

    }

    @ModelAttribute("todosStatusTitulo")
    public List<StatusTitulo> todosStatusTitulo(){
        return Arrays.asList(StatusTitulo.values());
    }
}