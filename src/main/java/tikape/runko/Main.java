package tikape.runko;

import static java.lang.Math.random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import spark.ModelAndView;
import spark.Request;
import spark.Response;
import spark.Route;
import static spark.Spark.*;
import spark.template.thymeleaf.ThymeleafTemplateEngine;
import tikape.runko.database.AlueDao;
import tikape.runko.database.AvausDao;
import tikape.runko.database.Database;
import tikape.runko.database.ViestiDao;

public class Main {

    public static void main(String[] args) throws Exception {

        Database databaseU = new Database("jdbc:sqlite:foorumi.db");
        databaseU.init();

        AvausDao avausDao = new AvausDao(databaseU);
        AlueDao alueDao = new AlueDao(databaseU);
        ViestiDao viestiDao = new ViestiDao(databaseU);

        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alueet", alueDao.findAll());
            map.put("paska", alueDao.viestien_maara());

            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

        post("/", (req, res) -> {
            String viesti = req.queryParams("uusi_alue");
            
            alueDao.lisaa(viesti);
            
            System.out.println(viesti);
            
            res.redirect("/");

            return "";
        });

        get("/alue/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alue", alueDao.findOne(Integer.parseInt(req.params("id"))));
            map.put("avaukset", avausDao.etsiOikeat(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "alue");
        }, new ThymeleafTemplateEngine());
        
         post("/alue/:id", (req, res) -> {
            String viesti = req.queryParams("uusi_avaus");
            
 
            avausDao.lisaa(alueDao.findOne(Integer.parseInt(req.params("id"))).getId(), viesti);
            
            
            
            res.redirect("/alue/" + req.params("id"));

            return "";
        });

        get("/avaus/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("avaus", avausDao.findOne(Integer.parseInt(req.params("id"))));
            map.put("viestit", viestiDao.etsiOikeat(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "avaus");
        }, new ThymeleafTemplateEngine());
        
//         get("/avaus/:id/:sivu", (req, res) -> {
//            HashMap map = new HashMap<>();
//            //map.put("avaus", avausDao.findOne(Integer.parseInt(req.params("id"))));
//            //map.put("viestit", viestiDao.etsiOikeat(Integer.parseInt(req.params("id"))));
//            map.put("viestit", viestiDao.etsiOikeatsivu(Integer.parseInt(req.params("id")), Integer.parseInt(req.params("sivu"))));
//            
//            
//            return new ModelAndView(map, "avaus");
//        }, new ThymeleafTemplateEngine());

        post("/avaus/:id", (req, res) -> {
            String viesti = req.queryParams("viesti");

            String nimimerkki = req.queryParams("nimimerkki");

            viestiDao.lisaa(avausDao.findOne(Integer.parseInt(req.params("id"))).getId(), nimimerkki, viesti);
            res.redirect("/avaus/" + req.params("id"));

            return "";
        });

        get("/opiskelijat", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("opiskelijat", avausDao.findAll());

            return new ModelAndView(map, "opiskelijat");
        }, new ThymeleafTemplateEngine());

    }
}
