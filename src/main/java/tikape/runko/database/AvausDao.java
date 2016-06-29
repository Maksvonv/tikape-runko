/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.Avaus;

public class AvausDao implements Dao<Avaus, Integer> {

    private Database database;

    public AvausDao(Database database) {
        this.database = database;
    }

    @Override
    public Avaus findOne(Integer key) throws SQLException {
        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Avaus WHERE id = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        boolean hasOne = rs.next();
        if (!hasOne) {
            return null;
        }

        Integer id = rs.getInt("id");
        Integer alue = rs.getInt("alue");
        
        String avauksen_nimi = rs.getString("avauksen_nimi");
       

        Avaus o = new Avaus(id, alue, avauksen_nimi);

        rs.close();
        stmt.close();
        connection.close();

        return o;
    }

    @Override
    public List<Avaus> findAll() throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Avaus");

        ResultSet rs = stmt.executeQuery();
        List<Avaus> avaus = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            Integer alue = rs.getInt("alue");
            String avauksen_nimi = rs.getString("avauksen_nimi");
     
            avaus.add(new Avaus(id, alue, avauksen_nimi));
        }

        rs.close();
        stmt.close();
        connection.close();

        return avaus;
    }

    public List<Avaus> etsiOikeat(Integer key) throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT Avaus.id, Avaus.avauksen_nimi, COUNT(Viesti.id) AS viesteja, MAX(Viesti.aikaleima) AS viimeisin_viesti FROM Avaus LEFT JOIN Viesti ON Viesti.avaus = Avaus.id WHERE Avaus.alue = ? GROUP BY Avaus.id ORDER BY Viesti.aikaleima DESC");
        stmt.setObject(1, key);
        
        ResultSet rs = stmt.executeQuery();
        List<Avaus> avaus = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            String avauksen_nimi = rs.getString("avauksen_nimi");
            Integer viesteja = rs.getInt("viesteja");
            String viimeisin_viesti = rs.getString("viimeisin_viesti");
   

            avaus.add(new Avaus(id, avauksen_nimi, viesteja, viimeisin_viesti));
        }

        rs.close();
        stmt.close();
        connection.close();

        return avaus;
    }

    @Override
    public void delete(Integer key) throws SQLException {
        // ei toteutettu
    }

       public void lisaa(int alue, String aloitus) throws SQLException {
        Connection connection = database.getConnection();

        PreparedStatement stmt = connection.prepareStatement("INSERT INTO Avaus (alue, avauksen_nimi) VALUES (?,?)");
        
        stmt.setObject(1, alue);
        stmt.setObject(2, aloitus);
        
        
        stmt.executeUpdate();

        stmt.close();
        connection.close();
    }

}
