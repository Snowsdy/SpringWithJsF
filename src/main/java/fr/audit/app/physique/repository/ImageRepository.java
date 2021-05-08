package fr.audit.app.physique.repository;

import fr.audit.app.metier.entity.Image;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository("imageRepository")
public interface ImageRepository extends CrudRepository<Image, Long> {
}
