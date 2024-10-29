package com.ecommerce.microcommerce.model;

import jakarta.persistence.*;

//@JsonFilter("monFiltreDynamique")
@Entity
public class User {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)

    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private int dateNaissance;

    @Column(nullable = false)
    private int numeroPermis;

    //CONSTRUCTOR*******************************************************************************************************

    public User(Long id, String nom, String prenom, int dateNaissance, int numeroPermis) {

        this.id = id;

        this.nom = nom;

        this.prenom = prenom;

        this.dateNaissance = dateNaissance;

        this.numeroPermis = numeroPermis;

    }

    public User() {

    }

    //GETTER SETTER*****************************************************************************************************

    public long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getDateNaissance() {
        return dateNaissance;
    }

    public void setDateNaissance(int dateNaissance) {
        this.dateNaissance = dateNaissance;
    }
    public int getNumeroPermis() {
        return numeroPermis;
    }

    public void setNumeroPermis(int numeroPermis) {
        this.numeroPermis = numeroPermis;
    }

}


