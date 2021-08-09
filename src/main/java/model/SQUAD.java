package model;
import static javax.swing.JOptionPane.showMessageDialog;
import java.util.ArrayList;

public class SQUAD {

    private static ArrayList<SQUAD> instances =new ArrayList<>();
    private ArrayList<Hero> heros = new ArrayList<>();
    private String squadName;
    private Hero hero;
    private Integer id;
    private boolean check = false;

    public String getSquadName() {
        return squadName;
    }

    public SQUAD(String squadName, Hero hero) {
        this.squadName = squadName;
        this.hero = hero;
        this.id = instances.size();

        for (int i = 0; i < instances.size(); i++) {

            //if squad entered is existent in instances
            if (instances.get(i).squadName.equals(squadName)) {//squad1

                //if the entered hero exists in any squad
                if (instances.get(i).hero.getName().equals(hero.getName())){
                    showMessageDialog(null, "This Hero is in another squad");
                    check = true;


                }else {
                    instances.get(i).heros.add(hero);
                    showMessageDialog(null, "The Hero has been added");
                    check = true;
                }
                break;
            }
        }
        if (!check){
            instances.add(this);
            showMessageDialog(null, "The Hero has been added to the new squad");

        }
    }

    public static ArrayList<SQUAD> getAll() {
        return instances;
    }

}
