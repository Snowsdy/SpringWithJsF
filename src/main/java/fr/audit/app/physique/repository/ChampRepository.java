package fr.audit.app.physique.repository;

import fr.audit.app.metier.entity.Champ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("champRepository")
public interface ChampRepository extends CrudRepository<Champ, Long> {
}
