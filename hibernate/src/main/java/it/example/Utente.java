package it.example;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "utenti")  // Specifica il nome della tabella se è diverso dal nome della classe
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "nome", nullable = false, length = 50)
    private String nome;

    @Column(name = "cognome", nullable = false, length = 50)
    private String cognome;
    
    @Column(name = "tel", nullable = false, length = 10)
    private int tel;
    
    @Column(name = "username", nullable = false, length = 10)
    private String username;
    
    @Column(name = "password", nullable = false, length = 64)
    private String pswd;

    // Costruttori
    public Utente(int id, String nome, String cognome, int tel, String username, String pswd) {
        this.id = id;
        this.nome = nome;
        this.cognome = cognome;
        this.tel = tel;
        this.username = username;
        this.pswd = pswd;
    }

    public Utente() {
    }

    // Getter e Setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPwsd() {
        return pswd;
    }

    public void setPwsd(String pswd) {
        this.pswd = hash.getSHA256Hash(pswd);
    }
}
