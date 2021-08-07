package model;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class Hero {

    private String name;
    private Integer age;
    private String specialPower;
    private String weakness;
    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String specialPower, String weakness){
        this.name = name;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.age = age;
        instances.add(this);
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
