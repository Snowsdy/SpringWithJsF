package fr.audit.app.client.service;

import fr.audit.app.metier.entity.Audit;
import fr.audit.app.metier.entity.Modele;
import fr.audit.app.metier.entity.Personne;
import fr.audit.app.metier.modele.AuditM;
import fr.audit.app.physique.AuditServiceImpl;
import fr.audit.app.physique.PersonneServiceImpl;
import fr.audit.app.physique.repository.ModeleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RestController
public class ApiRestFull implements Serializable {

    @Autowired
    ModeleRepository modeleRepository;

    // CRUD & others for Personne :
    @Autowired
    PersonneServiceImpl persServiceImpl;

    // CRUD & others for Audit :
    @Autowired
    AuditServiceImpl auditServiceImpl;

    public ApiRestFull() {
    }

    /// Api Personne :

    @GetMapping("/Personne/getAll")
    public Iterable<Personne> getAllPersonne(){ return persServiceImpl.getAll();}

    @GetMapping("/Personne/testPersonne")
    public String test(){ return persServiceImpl.test();}

    @GetMapping("/Personne/getById/{id}")
    public Optional<Personne> getById(@PathVariable("id") long id){ return persServiceImpl.getById(id);}

    @GetMapping("/Personne/getByLogin")
    public Optional<Personne> getByLogin(@RequestParam(value = "login") String login){ return persServiceImpl.getByLogin(login);}

    /// Api Audit :
    /*
    @GetMapping("/Audit/testAudit")
    public String testAudit(){ return auditServiceImpl.test();}

    @GetMapping("/Audit/getAll")
    public Iterable<AuditM> getAllAudit(){
        List<AuditM> auditMS = new ArrayList<>();
        Iterable<Audit> audits = auditServiceImpl.getAll();
        for (Audit a: audits) {
            auditMS.add(new AuditM(a));
        }
        return auditMS;
    }

    @GetMapping("/Modele/{id}")
    public ResponseEntity<Modele> getTutorialById(@PathVariable("id") long id){
        Optional<Modele> ModeleData = modeleRepository.findById(id);
        if(ModeleData.isPresent()){
            return new ResponseEntity<>(ModeleData.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/Modele/")
    public ResponseEntity<List<Modele>> getAll(){
        try {
            List<Modele> modeles = new ArrayList<>();
            return new ResponseEntity<>(modeles, HttpStatus.OK);
        }catch (Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("Audit/testJava")
    public void testJava(){
        Iterable<AuditM> audits = getAllAudit();
        for (AuditM a : audits) {
            System.out.println(a);
        }
    }*/
}
