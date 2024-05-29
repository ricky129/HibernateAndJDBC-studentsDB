package it.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.util.List;

public class UtenteDAOImpl implements IUtenteDAO {

    @Override
    public Utente findById(int id, Connection con) {
        try {
            String sql = "SELECT * FROM Studenti WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int tel = result.getInt("tel"); // Assumendo che il telefono sia unico per ogni utente
                String nome = result.getString("nome");
                String cognome = result.getString("cognome");
                String username = result.getString("username");
                String pswd = result.getString("pswd");
                return new Utente(id, nome, cognome, tel, username, pswd);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void save(Utente utente, Connection con) {
        try {
            String sql = "INSERT INTO Studenti (id, nome, cognome, tel, username, pswd) VALUES (?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, utente.getId());
            statement.setString(2, utente.getNome());
            statement.setString(3, utente.getCognome());
            statement.setInt(4, utente.getTel());
            statement.setString(5, utente.getUsername());
            statement.setString(6, utente.getPswd());
            statement.executeUpdate();
            System.out.println("Record created.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Utente utente, Connection con) {
        try {
            String sql = "UPDATE Studenti SET nome = ?, cognome = ?, tel = ?, username = ?, pswd = ? WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setString(1, utente.getNome());
            statement.setString(2, utente.getCognome());
            statement.setInt(3, utente.getTel());
            statement.setString(4, utente.getUsername());
            statement.setString(5, utente.getPswd());
            statement.setInt(6, utente.getId());
            statement.executeUpdate();
            System.out.println("Record updated.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Utente utente, Connection con) {
        try {
            String sql = "DELETE FROM Studenti WHERE id = ?";
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, utente.getId());
            statement.executeUpdate();
            System.out.println("User deleted.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<Utente> findAll(Connection con) {
        List<Utente> utenti = new ArrayList<>();
        try {
            String sql = "SELECT * FROM Studenti";
            PreparedStatement statement = con.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            while (result.next()) {
                int id = result.getInt("id");
                String nome = result.getString("nome");
                String cognome = result.getString("cognome");
                int tel = result.getInt("tel");
                String username = result.getString("username");
                String pswd = result.getString("pswd");
                Utente utente = new Utente(id, nome, cognome, tel, username, pswd);
                utenti.add(utente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utenti;
    }
}
