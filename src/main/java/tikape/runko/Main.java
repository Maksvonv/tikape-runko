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
import tikape.runko.database.OpiskelijaDao;
import tikape.runko.database.ViestiDao;

public class Main {

    public static void main(String[] args) throws Exception {
        //Database database = new Database("jdbc:sqlite:opiskelijat.db");
        //database.init();

        Database databaseU = new Database("jdbc:sqlite:foorumi.db");
        databaseU.init();
        String a = "66KES88";

        int id = 100004; // pitää vaihtaa joka viestin jälkeen

       
        //OpiskelijaDao opiskelijaDao = new OpiskelijaDao(database);

        AvausDao avausDao = new AvausDao(databaseU);
        AlueDao alueDao = new AlueDao(databaseU);
        ViestiDao viestiDao = new ViestiDao(databaseU);

        //Connection connection = DriverManager.getConnection("jdbc:sqlite:foorumi.db");

        get("/", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alueet", alueDao.findAll());
            map.put("paska", alueDao.viestien_maara());

            return new ModelAndView(map, "index");
        }, new ThymeleafTemplateEngine());

        get("/alue/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("alue", alueDao.findOne(Integer.parseInt(req.params("id"))));
            map.put("avaukset", avausDao.etsiOikeat(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "alue");
        }, new ThymeleafTemplateEngine());

        get("/avaus/:id", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("avaus", avausDao.findOne(Integer.parseInt(req.params("id"))));
            //map.put("avaukset", avausDao.etsiOikeat(Integer.parseInt(req.params("id"))));
            map.put("viestit", viestiDao.etsiOikeat(Integer.parseInt(req.params("id"))));

            return new ModelAndView(map, "avaus");
        }, new ThymeleafTemplateEngine());

        post("/avaus/:id", (req, res) -> {
            String viesti = req.queryParams("viesti");
            
            String nimimerkki = req.queryParams("nimimerkki");
            System.out.println(nimimerkki);
            System.out.println(viesti);
            
            viestiDao.lisaa(avausDao.findOne(Integer.parseInt(req.params("id"))).getId(), nimimerkki, viesti );
            System.out.println(avausDao.findOne(Integer.parseInt(req.params("id"))).getId());
            res.redirect("/avaus/" + req.params("id"));

            return "";
        });

        get("/opiskelijat", (req, res) -> {
            HashMap map = new HashMap<>();
            map.put("opiskelijat", avausDao.findAll());

            return new ModelAndView(map, "opiskelijat");
        }, new ThymeleafTemplateEngine());

//        get("/opiskelijat/:id", (req, res) -> {
//            HashMap map = new HashMap<>();
//            map.put("opiskelija", opiskelijaDao.findOne(Integer.parseInt(req.params("id"))));
//
//            return new ModelAndView(map, "opiskelija");
//        }, new ThymeleafTemplateEngine());

    }
}
