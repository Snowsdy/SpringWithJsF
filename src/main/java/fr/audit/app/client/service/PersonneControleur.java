
package fr.audit.app.client.service;

import fr.audit.app.metier.entity.Personne;
import fr.audit.app.physique.repository.PersonneRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Personne")
public class PersonneControleur {
   @Autowired
   PersonneRepository personneRepository;

   @GetMapping("/{id}")
    public ResponseEntity<Personne> getPersonneById(@PathVariable("id") long id){
       Optional <Personne> PersonneData = personneRepository.findById(id);
       if(PersonneData.isPresent()){
           return new ResponseEntity<>(PersonneData.get(), HttpStatus.OK);
       }else {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

   @GetMapping("/")
   public ResponseEntity<List<Personne>> getAllPersonnes() {
       try{
            List<Personne> personnes = new ArrayList<>();
            personneRepository.findAll().forEach(personnes::add);
            return new ResponseEntity<>(personnes, HttpStatus.OK);
        }catch ( Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/Count")
    public ResponseEntity<Integer> getCountPersonne() {
       try {
           Integer count = 0;
           Iterable<Personne> personnes = personneRepository.findAll();
           for (Personne p : personnes) {
               count++;
           }
           return new ResponseEntity<>(count,HttpStatus.OK);
       }catch(Exception e){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }
    }

    @GetMapping("/{login}")
    public ResponseEntity<Personne>getByLogin(@PathVariable String login) {
       Optional<Personne> p = personneRepository.getByLogin(login);
       if(p.isPresent()){
           return new ResponseEntity<>(p.get(), HttpStatus.OK);
       }else {
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



}
