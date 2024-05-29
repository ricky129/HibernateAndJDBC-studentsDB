package it.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://192.168.1.17:3306/StudentiDB", "username",
                    "password");
            System.out.println("Connessione stabilita.");

            IUtenteDAO utenteDAO = new UtenteDAOImpl();

            // Creazione di un nuovo utente
            Utente nuovoUtente = new Utente(0, "Giovanni", "Bianchi", 0, "username1", "pswd1");
            utenteDAO.save(nuovoUtente, con);

            // Recupero di un utente
            Utente utente = utenteDAO.findById(1, con);
            if (utente != null)
                System.out.println("Utente trovato: " + utente.getNome() + " " + utente.getCognome());

            // Aggiornamento di un utente
            if (utente != null) {
                utente.setCognome("Verdi");
                utenteDAO.update(utente, con);
            }

            // Eliminazione di un utente
            if (utente != null)
                utenteDAO.delete(utente, con);

            // Trovare tutti gli utenti
            System.out.println("Lista degli utenti:");
            utenteDAO.findAll(con).forEach(u -> System.out.println(u.getNome() + " " + u.getCognome()));

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (con != null)
                    con.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
