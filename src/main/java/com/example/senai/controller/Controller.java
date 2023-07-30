package com.example.senai.controller;

import com.example.senai.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Controller {

    private List<Person> persons = new ArrayList<>();
    private int id = 0;

    public Person findPerson(String name) {
        for (Person p : persons) {
            if (p.getName().equals(name)) {
                return p;
            }
        }
        return null;
    }

    public Person addPerson(String name, String sexo){
    Person person = new Person();
    person.setName(name);
    person.setSexo(sexo);
    id++;
    person.setId(id);
    persons.add(person);
    return person;
    }

    public void deletePerson(String name) {
        Person personToRemove = null;
            for (Person p : persons) {
                if (p.getName().equals(name)) {
                    personToRemove = p;
                    break;
                }
            }

            if (personToRemove != null) {
                persons.remove(personToRemove);
            }
        }

        public boolean editPerson(String name, String newSexo) {
            for (Person p : persons) {
                if (p.getName().equals(name)) {
                    p.setSexo(newSexo);
                    return true;
                }
            }
            return false; // Se não encontrar a pessoa com o nome, retorna false indicando que a pessoa não foi encontrada.
        }
    }



