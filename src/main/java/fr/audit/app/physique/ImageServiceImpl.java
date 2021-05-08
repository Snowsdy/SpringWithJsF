package fr.audit.app.physique;

import fr.audit.app.metier.entity.Image;
import fr.audit.app.physique.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("imageServiceImpl")
public class ImageServiceImpl {

    @Autowired
    ImageRepository imageRepository;

    public Iterable<Image> getAll(){ return imageRepository.findAll();}
}
