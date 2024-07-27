import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

import java.util.ArrayList;
import java.util.List;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(MockitoJUnitRunner.class)
public class BurgerTest {
    Burger burger;
    @Mock
    Bun bun;
    @Mock
    Ingredient ingredient;

    @Before
    public void createBurger() {burger = new Burger();}

    @Test
    public void setBuns() {
        List<Bun> buns = new ArrayList<>();
        buns.add(new Bun("black bun", 100));
        burger.setBuns(buns.get(0));
        Assert.assertEquals(buns.get(0), burger.bun);
    }
    @Test
    public void addIngredient() {
        burger.addIngredient(ingredient);
        Assert.assertFalse("Ингредиент не добавлен методом addIngredient", burger.ingredients.isEmpty());
    }
    @Test
    public void removeIngredient() {
        burger.addIngredient(ingredient);
        burger.removeIngredient(0);
        Assert.assertTrue("Ингредиент не удален метоодом removeIngredient", burger.ingredients.isEmpty());
    }
    @Test
    public void moveIngredient() {
        burger.addIngredient(new Ingredient(SAUCE, "hot sauce", 100));
        burger.addIngredient(new Ingredient(FILLING, "cutlet", 100));
        List<Ingredient> expected = new ArrayList<>();
        expected.add(burger.ingredients.get(1));
        expected.add(burger.ingredients.get(0));
        burger.moveIngredient(1, 0);
        Assert.assertEquals("Метод moveIngredient не отработал", expected, burger.ingredients);
    }
    @Test
    public void testBunGetNameInGetReceipt() {
        burger.setBuns(bun);
        burger.getReceipt();
        Mockito.verify(bun, Mockito.times(2)).getName();
    }
    @Test
    public void testIngredientGetTypeAndNameInGetReceipt(){
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(ingredient.getType()).thenReturn(SAUCE);
        Mockito.when(ingredient.getName()).thenReturn("sour cream");
        String receipt = burger.getReceipt();
        Assert.assertTrue(receipt.contains("sauce") && receipt.contains("sour cream"));
    }
    @Test
    public void  testGetPriceInGetReceipt(){
        burger.setBuns(bun);
        String receipt = burger.getReceipt();
        Assert.assertTrue(receipt.contains("Price:") && receipt.contains("0"));
    }

}
