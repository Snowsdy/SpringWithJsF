package fr.audit.app.physique;

import fr.audit.app.metier.entity.Modele;
import fr.audit.app.physique.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("modeleServiceImpl")
public class ModeleServiceImpl {

    @Autowired
    ModeleRepository modeleRepository;

    public Iterable<Modele> getAll(){ return modeleRepository.findAll();}
}
