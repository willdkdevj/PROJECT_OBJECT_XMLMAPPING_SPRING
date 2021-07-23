package com.example.testJaxb2.controller;

import com.example.testJaxb2.model.Contato;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/contato")
public class ContatoController {

    final Logger log = LoggerFactory.getLogger(ContatoController.class);

    @RequestMapping("/aleatorio")
    @ResponseBody
    public Contato chamadaContato() {
        return Contato.testeDeContato();
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    @ResponseBody
    public Contato mudancaEmContato(@RequestBody Contato contato){
        log.info("Recebendo mudanças em contato: {}", contato);
        contato.setName(contato.getName() + " Derek");
        return contato;
    }
}
