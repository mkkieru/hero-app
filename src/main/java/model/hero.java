package model;

import java.security.PrivateKey;
import java.util.ArrayList;
import java.util.List;

public class hero {

    private String name;
    private Integer age;
    private String specialPower;
    private String weakness;
    private static List<hero> instances = new ArrayList<>();

    public hero(String name, Integer age, String specialPower, String weakness){
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

    public static List<hero> getInstances() {
        return instances;
    }
}
