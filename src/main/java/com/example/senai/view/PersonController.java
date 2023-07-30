package com.example.senai.view;

import com.example.senai.controller.Controller;
import com.example.senai.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

@RestController
public class PersonController {

    @Autowired
    Controller controller;

    @GetMapping("/person")
    public Person findPerson(@PathParam("name") String name) {
        return controller.findPerson(name);
    }


    @DeleteMapping("/person")
    public String deletePerson(@PathParam("name") String name) {
        controller.deletePerson(name);
        return"Pessoa com o nome de: " + name + ", foi removida";
}
    @PostMapping ("/person")
    public Person addPerson(@RequestParam("name") String  name, @RequestParam("sexo") String sexo){
        return controller.addPerson(name, sexo);
    }

  @PutMapping("/person")
  public String updatePerson(@RequestParam("name") String name, @RequestParam("sexo") String sexo) {
      if (controller.editPerson(name, sexo)) {
          return "A pessoa com o nome " + name + " teve o sexo atualizado para " + sexo;
      } else {
          return "Pessoa com o nome " + name + " não encontrada";
      }
  }
}
