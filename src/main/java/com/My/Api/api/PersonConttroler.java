package com.My.Api.api;

import com.My.Api.model.Person;
import com.My.Api.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RequestMapping("api/v1/person")
@RestController
public class PersonConttroler {
    private final PersonService personService;

    @Autowired
    public PersonConttroler(PersonService personService){
        this.personService = personService;
    }

    @PostMapping
    public void addPerson(@RequestBody Person person){
        personService.addPerson(person);
    }
    @GetMapping
    public List<Person> getAllPeope(){return personService.getAllPeople();}
    @GetMapping(path ="{id}")
    public  Person getPersonById(@PathVariable("id") UUID id){
        return personService.getPersonById(id).orElse(null);
    }
    @DeleteMapping(path="{id}")
    public void  deletePersonByid(@PathVariable("id") UUID id){
        personService.deletePerson(id);
    }
    @PutMapping(path="{id}")
    public void updatePerson(@PathVariable("id")UUID id,@RequestBody  Person personToUpdate){
        personService.updatePerson(id,personToUpdate);
    }
}