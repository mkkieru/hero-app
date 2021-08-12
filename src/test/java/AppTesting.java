import junit.framework.TestCase;
import model.Hero;
import model.SQUAD;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

import static junit.framework.TestCase.assertTrue;
public class AppTesting{
    @Test
    public void newHero_CreateNewHeroInstance_true(){
        Hero newHero = new Hero("testHero",20,"Flying","Kryptonite","Avengers");
        //Assert.assertEquals(true,newHero instanceof Hero);
        assertEquals(true, newHero instanceof Hero);
    }

    @Test
    public void newSquad_CreateNewSQUADInstance_true(){
        Hero newHero = new Hero("testHero",20,"Flying","Kryptonite","Avengers");
        SQUAD newSquad = new SQUAD("Avengers",newHero);
        //Assert.assertEquals(true,newSquad instanceof Hero);
        assertTrue(newSquad instanceof SQUAD);
    }
    @Test
    public void duplicateHeroInstance_CreateDuplicateHeroInstance_False(){
        Hero newHero = new Hero("testHero",20,"Flying","Kryptonite","Avengers");
        Hero newHero1 = new Hero("testHero",20,"Speed","Kryptonite","Avengers");
        assertFalse(Hero.getAll().contains(newHero1));
    }
    @Test
    public void duplicateSquadInstance_CreateSquadInstanceWithSameSquadName_False(){
        Hero newHero = new Hero("testHero",20,"Flying","Kryptonite","Avengers");
        SQUAD newSqaud = new SQUAD("Avengers",newHero);
        SQUAD newSqaud1 = new SQUAD("Avengers",newHero);
        assertFalse(SQUAD.getAll().contains(newSqaud1));
    }
    @Test
    public void addHeros_addMultipleHerosToTheSameSquad_True(){
        Hero newHero = new Hero("testHero",20,"Flying","Kryptonite","Avengers");
        SQUAD newSquad = new SQUAD("Avengers",newHero);

        Hero newHero1 = new Hero("testHero1",20,"Flying","Kryptonite","Avengers");
        SQUAD newSquad1 = new SQUAD("Avengers",newHero1);

        assertTrue(newSquad.getHeros().contains(newHero));
        assertTrue(newSquad.getHeros().contains(newHero1));

    }

    @Test
    public void getSquadName_displaySquadName_True(){
        Hero newHero = new Hero("testHero",20,"Flying","Kryptonite","Avengers");
        SQUAD newSquad = new SQUAD("Avengers",newHero);

        Hero newHero1 = new Hero("testHero1",20,"Flying","Kryptonite","Avengers");
        SQUAD newSquad1 = new SQUAD("Avengers",newHero1);

        assertFalse("Avengers".equals(newSquad.getSquadName()));
    }

}