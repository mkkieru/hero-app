import junit.framework.TestCase;
import model.Hero;
import model.SQUAD;
import org.junit.Test;
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
    public void newSquad_CreateDuplicateHeroInstance_True(){
        Hero newHero = new Hero("testHero",20,"Flying","Kryptonite","Avengers");
        Hero newHero1 = new Hero("testHero",20,"Speed","Kryptonite","Avengers");
        //Assert.assertEquals(true,newSquad instanceof Hero);
        assertFalse(Hero.getAll().contains(newHero1));
    }

}