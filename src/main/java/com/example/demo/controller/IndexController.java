package com.example.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Usuario;

/**
*
* @author Arthur Barbosa
*/
@RestController
public class IndexController {

   @RequestMapping(value = "/{nome}", method = RequestMethod.GET)
   public com.example.demo.entity.Usuario getUsuario(@PathVariable String nome) {

       Usuario usuario = new Usuario();

       usuario.setNome(nome);
       usuario.setIdade(26);
       usuario.setEmail("arthur@gmail.com");

       return usuario;
   }

}
