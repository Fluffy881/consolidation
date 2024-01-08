package fr.dawan.reflexion;

public class Employe {
    private String nom;
    private String prenom;

    public Employe() {
        this.nom = "John";
        this.prenom = "Doe";
    }

    public Employe(String nom, String prenom) {
        this.nom = nom;
        this.prenom = prenom;
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

    public  void identite(){
        System.out.println(nom + " " + prenom);
    }
}
