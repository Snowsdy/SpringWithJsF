package fr.audit.app.physique.repository;

import fr.audit.app.metier.entity.Modele;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("modeleRepository")
public interface ModeleRepository extends CrudRepository<Modele, Long> {
}
