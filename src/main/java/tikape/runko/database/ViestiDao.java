package tikape.runko.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tikape.runko.domain.Alue;
import tikape.runko.domain.Avaus;
import tikape.runko.domain.Viesti;

public class ViestiDao implements Dao<Alue, Integer> {

    private Database database;

    public ViestiDao(Database database) {
        this.database = database;
    }

    @Override
    public Alue findOne(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Alue> findAll() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Integer key) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Viesti> etsiOikeat(Integer key) throws SQLException {

        Connection connection = database.getConnection();
        PreparedStatement stmt = connection.prepareStatement("SELECT * FROM Viesti WHERE avaus = ?");
        stmt.setObject(1, key);

        ResultSet rs = stmt.executeQuery();
        List<Viesti> viesti = new ArrayList<>();
        while (rs.next()) {
            Integer id = rs.getInt("id");
            Integer avaus = rs.getInt("avaus");
            //timestamp
            String nimimerkki = rs.getString("nimimerkki");
            String viestin_sisalto = rs.getString("viestin_sisalto");

            viesti.add(new Viesti(id, avaus, nimimerkki, viestin_sisalto));
        }

        rs.close();
        stmt.close();
        connection.close();

        return viesti;
    }

}
