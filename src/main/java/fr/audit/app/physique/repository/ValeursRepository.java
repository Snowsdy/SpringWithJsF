package fr.audit.app.physique.repository;

import fr.audit.app.metier.entity.Valeurs;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("valeursRepository")
public interface ValeursRepository extends CrudRepository<Valeurs, Long> {
}
