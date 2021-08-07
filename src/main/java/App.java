import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import model.Hero;
import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;
import static spark.Spark.*;


public class App {
    public static void main(String[] args) {
        //showMessageDialog(null,"This is an alert!!");
        staticFileLocation("/public");

        get("/", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> tasks = Hero.getAll();
            model.put("tasks", tasks);
            return new ModelAndView(model, "index.hbs");
        }, new HandlebarsTemplateEngine());

        //get: show new task form
        get("/form", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            return new ModelAndView(model, "heroForm.hbs");
        }, new HandlebarsTemplateEngine());

        //task: process new task form
        post("/tasks", (req, res) -> { //URL to make new task on POST route
            Map<String, Object> model = new HashMap<>();
            String name = req.queryParams("name");
            String ageString = req.queryParams("age");
            Integer age = Integer.parseInt(ageString);
            String specialPower = req.queryParams("specialPower");
            String weakness = req.queryParams("weakness");
            Hero newHero = new Hero(name,age,specialPower,weakness);
            res.redirect("/");
            return null;
        }, new HandlebarsTemplateEngine());

        //get: show all tasks


    }
}

