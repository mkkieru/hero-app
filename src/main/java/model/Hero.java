package model;
import java.util.ArrayList;
import static javax.swing.JOptionPane.showMessageDialog;

public class Hero {

    private String name;
    private Integer age;
    private String specialPower;
    private String weakness;
    private String yourSquad;
    private boolean check = false;

    private static ArrayList<Hero> instances = new ArrayList<>();

    public Hero(String name, Integer age, String specialPower, String weakness, String yourSquad){
        this.name = name;
        this.specialPower = specialPower;
        this.weakness = weakness;
        this.age = age;
        this.yourSquad = yourSquad;

        for (int i = 0 ; i < instances.size() ; i++){
            if (instances.get(i).getName().equals(name)){
                showMessageDialog(null, "The Hero exists in one of the Squads");
                check = true;
            }
        }
        if (!check){
            instances.add(this);
        }
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
