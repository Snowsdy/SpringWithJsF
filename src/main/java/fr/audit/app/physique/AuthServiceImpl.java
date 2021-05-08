package fr.audit.app.physique;

import fr.audit.app.metier.entity.Personne;
import fr.audit.app.physique.repository.PersonneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("authServiceImpl")
public class AuthServiceImpl {

    @Autowired
    PersonneRepository personneRepository;

    public Personne login(){

    }
}
