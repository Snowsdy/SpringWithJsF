package fr.audit.app.client.service;

import fr.audit.app.metier.entity.Personne;
import fr.audit.app.physique.PersonneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

@Service
@RestController
public class PersonneService implements Serializable {

    @Autowired
    PersonneServiceImpl persServiceImpl;

    public static final String template = "Personne %s";
    public static final String springMessage = "Spring Service";

    public PersonneService() {
    }

    public String sayHello() {
        return springMessage;
    }

    @GetMapping("/getAll")
    public Iterable<Personne> getAll(){ return persServiceImpl.getAll();}

    @GetMapping("/testPersonne")
    public String test(){ return persServiceImpl.test();}
}
