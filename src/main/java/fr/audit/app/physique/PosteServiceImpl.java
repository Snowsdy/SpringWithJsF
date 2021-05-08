package fr.audit.app.physique;

import fr.audit.app.metier.entity.Poste;
import fr.audit.app.physique.repository.PosteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("posteServiceImpl")
public class PosteServiceImpl {

    @Autowired
    PosteRepository posteRepository;

    public Iterable<Poste> getAll(){ return posteRepository.findAll();}
}
