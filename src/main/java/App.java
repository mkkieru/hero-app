import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Hero;
import model.SQUAD;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
    public static void main(String[] args) {

        port(getHerokuAssignedPort());
        staticFileLocation("/public");
        //SQUAD squad1 = new SQUAD();

        //get: show all tasks
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heros = Hero.getAll();
            model.put("heros", heros);

            ArrayList<SQUAD> squads= SQUAD.getAll();
            model.put("squads", squads);

            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new Hero form
        get("/form", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "heroForm.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process new Hero form
        post("/tasks", (req, res) -> { //URL to make new task on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String stringAge = req.queryParams("age");
            Integer age = Integer.parseInt(stringAge);
            String specialPower = req.queryParams("specialPower");
            String weakness = req.queryParams("weakness");
            String yourSquad = req.queryParams("squadName");

            Hero newHero = new Hero(name,age,specialPower,weakness,yourSquad);

            String squadName = req.queryParams("squadName");
            SQUAD newSquad = new SQUAD(squadName,newHero);

            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }
}
