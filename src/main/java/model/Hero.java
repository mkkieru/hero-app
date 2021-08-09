package model;
import java.util.ArrayList;
public class Hero {

    private String name;
    private Integer age;
    private String specialPower;
    private String weakness;
    private String yourSquad;

    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String specialPower, String weakness, String yourSquad){
        this.name = name;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.age = age;
        this.yourSquad = yourSquad;
        instances.add(this);
    }

    public String getYourSquad() {
        return yourSquad;
    }

    public Integer getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public String getSpecialPower() {
        return specialPower;
    }

    public String getWeakness() {
        return weakness;
    }

    public static ArrayList<Hero> getAll() {
        return instances;
    }
}
