package com.My.Api.service;

import com.My.Api.dao.PersonDao;
import com.My.Api.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;
    @Autowired
    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }



    public int addPerson(@Qualifier("fakeDao") Person person){
        return personDao.insertPerson(person);
    }
    public List<Person> getAllPeople(){return personDao.selectAllPeople();}
    public Optional<Person> getPersonById(UUID id){return personDao.selectPersonById(id);}

    public  int deletePerson(UUID id){return  personDao.deletePerson(id);}

    public int updatePerson(UUID id, Person newperson){return personDao.updatePerson(id, newperson);}


}
