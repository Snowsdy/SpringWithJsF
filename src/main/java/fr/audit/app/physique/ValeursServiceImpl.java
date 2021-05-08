package fr.audit.app.physique;

import fr.audit.app.metier.entity.Valeurs;
import fr.audit.app.physique.repository.ValeursRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("valeursServiceImpl")
public class ValeursServiceImpl {

    @Autowired
    ValeursRepository valeursRepository;

    public Iterable<Valeurs> getAll(){ return valeursRepository.findAll();}
}
