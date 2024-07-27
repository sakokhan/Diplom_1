import org.junit.Assert;
import org.junit.Test;
import praktikum.Ingredient;

import static praktikum.IngredientType.FILLING;

public class IngredientTest {
    Ingredient ingredient = new Ingredient(FILLING, "cutlet", 100);

    @Test
    public void getPrice() {
        Assert.assertEquals(100, ingredient.getPrice(), 0.1);
    }

    @Test
    public void getName() {
        Assert.assertEquals("cutlet", ingredient.getName());
    }

    @Test
    public void getType() {
        Assert.assertEquals(FILLING, ingredient.getType());
    }
}
