package fr.audit.app.physique.repository;

import fr.audit.app.metier.entity.Audit;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("auditRepository")
public interface AuditRepository extends CrudRepository<Audit, Long> {

    default String test(){ return "Test Audit";}
}
