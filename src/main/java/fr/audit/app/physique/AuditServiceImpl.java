package fr.audit.app.physique;

import fr.audit.app.metier.entity.Audit;
import fr.audit.app.physique.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service("auditServiceImpl")
public class AuditServiceImpl {

    @Autowired
    AuditRepository auditRepository;

    public Iterable<Audit> getAll(){ return auditRepository.findAll();}

    public Optional<Audit> getById(long id){ return auditRepository.findById(id);}

    public String test(){ return auditRepository.test();}
}
