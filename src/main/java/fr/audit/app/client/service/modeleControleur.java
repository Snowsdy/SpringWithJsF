package fr.audit.app.client.service;

import fr.audit.app.metier.entity.Modele;

import fr.audit.app.physique.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Modele")
public class modeleControleur {

    @Autowired
    ModeleRepository modeleRepository;

    @GetMapping("/{id}")
    public ResponseEntity<Modele> getTutorialById(@PathVariable("id") long id){
        Optional<Modele> ModeleData = modeleRepository.findById(id);
        if(ModeleData.isPresent()){
            return new ResponseEntity<>(ModeleData.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/Count")
    public ResponseEntity<Integer> getCountModele() {
        try {
            Integer count = 0;
            Iterable<Modele> modeles = modeleRepository.findAll();
            for (Modele modele : modeles) {
                count++;
            }
            return new ResponseEntity<>(count, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Modele>> getAllModele(){
        try {
            List<Modele> modeles = new ArrayList<>();
            modeleRepository.findAll().forEach(modeles::add);
            return new ResponseEntity<>(modeles, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
