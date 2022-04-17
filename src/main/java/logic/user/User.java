package logic.user;

import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.UUID;

@MappedSuperclass
public abstract  class User {
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "login")
    private String login;

    @Column(name = "pass")
    private String password;

    @Column(name = "birthDate")
    private GregorianCalendar birthDate;

    @Column(name = "email")
    private String email;

    public String getId() {
        return id;
    }
    public void setId() {
        this.id = UUID.randomUUID().toString();
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
