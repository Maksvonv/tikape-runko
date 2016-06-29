
package tikape.runko.domain;


public class Avaus {
    
    private Integer id;
    private Integer alue;
    private String avauksen_nimi;
    
    private Integer viesteja;
    private String viimeisin_viesti;

    public Avaus(Integer id, Integer alue,String avauksen_nimi) {
        this.id = id;
        this.alue = alue;
        
        this.avauksen_nimi = avauksen_nimi;
        
    }

    public Avaus(Integer id, String avauksen_nimi, Integer viesteja, String viimeisin_viesti) {
       this.id = id;
        this.avauksen_nimi = avauksen_nimi;
       this.viesteja = viesteja;
       this.viimeisin_viesti = viimeisin_viesti;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAlue() {
        return alue;
    }

    public void setAlue(Integer alue) {
        this.alue = alue;
    }

    public String getAvauksen_nimi() {
        return avauksen_nimi;
    }

    public void setAvauksen_nimi(String avauksen_nimi) {
        this.avauksen_nimi = avauksen_nimi;
    }

    public Integer getViesteja() {
        return viesteja;
    }

    public void setViesteja(Integer viesteja) {
        this.viesteja = viesteja;
    }

    public String getViimeisin_viesti() {
        return viimeisin_viesti;
    }

    public void setViimeisin_viesti(String viimeisin_viesti) {
        this.viimeisin_viesti = viimeisin_viesti;
    }

    
   
    
    
    
    
    
    
}
