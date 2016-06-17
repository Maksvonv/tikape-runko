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
import tikape.runko.domain.Opiskelija;

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
        String avauksen_otsikko = rs.getString("avauksen_otsikko");
        String avauksen_sisalto = rs.getString("avauksen_sisalto");

        Avaus o = new Avaus(id, alue, avauksen_otsikko, avauksen_sisalto);

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
            String avauksen_otsikko = rs.getString("avauksen_otsikko");
            String avauksen_sisalto = rs.getString("avauksen_sisalto");

            avaus.add(new Avaus(id, alue, avauksen_otsikko, avauksen_sisalto));
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

}
