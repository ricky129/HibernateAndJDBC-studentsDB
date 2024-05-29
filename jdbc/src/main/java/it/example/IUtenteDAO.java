package it.example;

import it.example.Utente;
import java.sql.Connection;
import java.util.List;

public interface IUtenteDAO {
    Utente findById(int id, Connection con);
    void save(Utente utente, Connection con);
    void update(Utente utente, Connection con);
    void delete(Utente utente, Connection con);
    List<Utente> findAll(Connection con);
}