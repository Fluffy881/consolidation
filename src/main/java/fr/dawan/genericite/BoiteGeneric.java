package fr.dawan.genericite;

public class BoiteGeneric<T> {
    private T contenu;

    public BoiteGeneric(T contenu) {
        this.contenu = contenu;
    }

    public T getContenu() {
        return contenu;
    }

    public void setContenu(T contenu) {
        this.contenu = contenu;
    }

    //exemple methode generique
    // le ou les types peut / peuvent
    public <U> void afficherContenue(U prefix){
        System.out.println(prefix.toString() + contenu);
    }
}
