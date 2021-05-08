package fr.audit.app.physique.repository;

import fr.audit.app.metier.entity.Section;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("sectionRepository")
public interface SectionRepository extends CrudRepository<Section, Long> {
}
