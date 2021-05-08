package fr.audit.app.physique.repository;

import fr.audit.app.metier.entity.Poste;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("posteRepository")
public interface PosteRepository extends CrudRepository<Poste, Long> {
}
