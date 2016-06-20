
package tikape.runko.domain;

public class Viesti {
    
    private Integer id;
    private Integer avaus;
    //private timestamp 
    private String nimimerkki;
    private String viestin_sisältö; //ö?
     private Integer vastaus_viestiin;



public Viesti(Integer id, Integer avaus, String nimimerkki, String viestin_sisaltö, Integer vastaus_viestiin) {
        this.id = id;
        this.avaus = avaus;
        this.nimimerkki = nimimerkki;
        this.viestin_sisältö = viestin_sisältö;
        this.vastaus_viestiin = vastaus_viestiin;
    }

 

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getAvaus() {
        return avaus;
    }

    public void setAvaus(Integer avaus) {
        this.avaus = avaus;
    }

    public String getNimimerkki() {
        return nimimerkki;
    }

    public void setNimimerkki(String nimimerkki) {
        this.nimimerkki = nimimerkki;
    }

    public String getViestin_sisalto() {
        return viestin_sisältö;
    }

    public void setViestin_sisältö(String viestin_sisalto) {
        this.viestin_sisältö = viestin_sisalto;
    }

    
    
    
    



    
    

    
}
