package fr.audit.app.physique;

import fr.audit.app.metier.entity.Champ;
import fr.audit.app.physique.repository.ChampRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("champServiceImpl")
public class ChampServiceImpl {

    @Autowired
    ChampRepository champRepository;

    public Iterable<Champ> getAll(){ return champRepository.findAll();}
}
