package fr.audit.app.client.service;

import fr.audit.app.metier.entity.Audit;
import fr.audit.app.metier.modele.AuditM;
import fr.audit.app.physique.repository.AuditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/Audit")
public class AuditControleur {

    @Autowired
    AuditRepository auditRepository;

    @GetMapping("/{id}")
    public ResponseEntity<AuditM> getTutorialById(@PathVariable("id") long id){
        Optional<Audit> audit = auditRepository.findById(id);
        AuditM a = new AuditM(audit.get());
        Optional<AuditM> auditData = Optional.of(a);
        if(auditData.isPresent()){
            return new ResponseEntity<>(auditData.get(), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/")
    public ResponseEntity<List<AuditM>> getAllAudit(){
        try{
            Iterable<Audit> audits = auditRepository.findAll();
            List<AuditM> auditMs = new ArrayList<>();
            audits.forEach((audit) -> {
                AuditM aM = new AuditM(audit);
                auditMs.add(aM);
            });

        if (auditMs.isEmpty()){
                return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
            return new ResponseEntity<>(auditMs, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @PostMapping("/")
    public ResponseEntity<AuditM> createAudit(@RequestBody AuditM audit){
        try {
            Audit a = auditRepository.save(audit.toAudit());
            AuditM aud = new AuditM(a);
            return new ResponseEntity<>(aud, HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
