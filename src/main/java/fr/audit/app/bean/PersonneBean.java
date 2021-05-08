package fr.audit.app.bean;

import fr.audit.app.client.service.PersonneService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "personneBean")
@ViewScoped
public class PersonneBean implements Serializable {

    @Autowired
    private PersonneService personneService;

    public PersonneService getPersonneService() {
        return personneService;
    }

    public void setPersonneService(PersonneService personneService) {
        this.personneService = personneService;
    }

    public String test(){ return personneService.test();}
}
