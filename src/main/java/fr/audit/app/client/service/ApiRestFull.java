package fr.audit.app.client.service;

import fr.audit.app.metier.entity.Audit;
import fr.audit.app.metier.entity.Personne;
import fr.audit.app.metier.modele.AuditM;
import fr.audit.app.physique.AuditServiceImpl;
import fr.audit.app.physique.PersonneServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;
import java.util.List;

@Service
@RestController
public class ApiRestFull implements Serializable {

    @Autowired
    PersonneServiceImpl persServiceImpl;

    // Je tente de faire un seul RestController pour le CRUD de Personne & Audit :
    @Autowired
    AuditServiceImpl auditServiceImpl;
    // C'est un succès ;)

    public ApiRestFull() {
    }

    /// Api Personne :

    @GetMapping("/Personne/getAll")
    public Iterable<Personne> getAllPersonne(){ return persServiceImpl.getAll();}

    @GetMapping("/Personne/testPersonne")
    public String test(){ return persServiceImpl.test();}

    @GetMapping("/Personne/getByLogin")
    public Iterable<Personne> getByLogin(@RequestParam(value = "login") String login){ return persServiceImpl.getByLogin(login);}

    /// Api Audit :

    @GetMapping("/Audit/testAudit")
    public String testAudit(){ return auditServiceImpl.test();}

    @GetMapping("/Audit/getAll")
    public Iterable<Audit> getAllAudit(){ return auditServiceImpl.getAll();}


    @GetMapping("Audit/testJava")
    public void testJava(){
        Iterable<Audit> audits = getAllAudit();
        for (Audit a : audits) {
            AuditM auditM = new AuditM(a);
            System.out.println(auditM);
        }
    }
}
