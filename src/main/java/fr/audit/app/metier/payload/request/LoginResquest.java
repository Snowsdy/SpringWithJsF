package fr.audit.app.metier.payload.request;

import javax.validation.constraints.NotBlank;

public class LoginResquest {

    @NotBlank
    private String login;

    @NotBlank
    private String password;

    public String getLogin() {
        return this.login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
