import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import model.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;

public class App {
    public static void main(String[] args) { //type “psvm + tab” to autocreate this
        staticFileLocation("/public");

        //get: show all tasks
        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heros = Hero.getAll();
            model.put("heros", heros);
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
            String specialPower = req.queryParams("name");
            String weakness = req.queryParams("name");
            Hero newHero = new Hero(name,age,specialPower,weakness);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

    }
}
