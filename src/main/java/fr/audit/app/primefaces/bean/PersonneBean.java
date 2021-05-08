package fr.audit.app.primefaces.bean;

import fr.audit.app.client.service.ApiRestFull;
import org.springframework.beans.factory.annotation.Autowired;

import javax.faces.bean.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;

@Named(value = "personneBean")
@ViewScoped
public class PersonneBean implements Serializable {

    @Autowired
    private ApiRestFull apiRestFull;

    public ApiRestFull getPersonneService() {
        return apiRestFull;
    }

    public void setPersonneService(ApiRestFull apiRestFull) {
        this.apiRestFull = apiRestFull;
    }

    public String test(){ return apiRestFull.test();}
}
