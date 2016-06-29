
package tikape.runko.domain;

public class Alue {
    
    private Integer id;
    private String alueen_nimi;
    
    private Integer ketjujen_maara;
    private String viimeisin_viesti;

    public Alue(Integer id, String alueen_nimi) {
        this.id = id;
        this.alueen_nimi = alueen_nimi;
    }

    public Alue(Integer id, String alueen_nimi, Integer ketjujen_maara, String viimeisin_viesti) {
       
        this.id = id;
        this.alueen_nimi = alueen_nimi;
        this.ketjujen_maara = ketjujen_maara;
        this.viimeisin_viesti = viimeisin_viesti;
    } //kyselyy varte
    
    

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAlueen_nimi() {
        return alueen_nimi;
    }

    public void setAlueen_nimi(String alueen_nimi) {
        this.alueen_nimi = alueen_nimi;
    }

    public Integer getKetjujen_maara() {
        return ketjujen_maara;
    }

    public void setKetjujen_maara(Integer ketjujen_maara) {
        this.ketjujen_maara = ketjujen_maara;
    }

    public String getViimeisin_viesti() {
        return viimeisin_viesti;
    }

    public void setViimeisin_viesti(String viimeisin_viesti) {
        this.viimeisin_viesti = viimeisin_viesti;
    }

    
   
    
    
    
    
}
