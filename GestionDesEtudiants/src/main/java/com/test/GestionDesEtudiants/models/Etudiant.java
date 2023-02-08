package com.test.GestionDesEtudiants.models;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;
@Entity
public class Etudiant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotEmpty
    private String name;
    @NotEmpty
    private  String cne;
    @NotEmpty
    private String email;
    @NotEmpty
    @DateTimeFormat(pattern = "yyyy-mm-dd")
    private Date dateNaissance;
    private String photo;

    public Etudiant() {
        super();
    }

    public Etudiant( String name, String cne, String email, Date dateNaissance, String photo) {

        this.name = name;
        this.cne = cne;
        this.email = email;
        this.dateNaissance = dateNaissance;
        this.photo = photo;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
