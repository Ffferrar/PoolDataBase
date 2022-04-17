package logic.user;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.UUID;

@Entity

public abstract  class User {
    @Id
    private String id;
    private String name;
    private String surname;
    private String login;
    private String password;
    private GregorianCalendar birthDate;
    private String email;

    public String getId() {
        return id;
    }
    public void setId() {
        this.id = UUID.randomUUID().toString();;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getLogin() {
        return login;
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

    public GregorianCalendar getBirthDate() {
        return birthDate;
    }
    public void setBirthDate(GregorianCalendar birthDate) {
        this.birthDate = birthDate;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
}
