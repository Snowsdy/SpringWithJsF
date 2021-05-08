package fr.audit.app.physique;

import fr.audit.app.metier.entity.Section;
import fr.audit.app.physique.repository.SectionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("sectionServiceImpl")
public class SectionServiceImpl {

    @Autowired
    SectionRepository sectionRepository;

    public Iterable<Section> getAll(){ return sectionRepository.findAll();}
}
