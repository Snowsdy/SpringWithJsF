package fr.snowsdy.app.physique;

import fr.snowsdy.app.metier.entity.Personne;
import fr.snowsdy.app.physique.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("persServiceImpl")
public class PersonneServiceImpl {

    @Autowired
    PersonneRepository personneRepository;

    public Iterable<Personne> getAll(){ return personneRepository.findAll();}

    public String test(){ return personneRepository.test();}
}
