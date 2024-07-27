import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;

@RunWith(Parameterized.class)
public class BurgerGetPriceParamTest {
    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient = Mockito.mock(Ingredient.class);
    Burger burger;

    @Parameterized.Parameter
    public float bunPrice;
    @Parameterized.Parameter(1)
    public float ingredientPrice;
    @Parameterized.Parameter(2)
    public float burgerPrice;
    @Parameterized.Parameters
    public static Object[][] data(){
        return new Object[][]{
                {100, 200, 600},
                {200, 300, 1000},
                {300, 300, 1200}
        };
    }
    @Test
    public void getPriceTest() {
        burger=new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getPrice()).thenReturn(bunPrice);
        Mockito.when(ingredient.getPrice()).thenReturn(ingredientPrice);
        Assert.assertEquals("Цена бургера, полученная методом getPrice отличается от ожидаемой", burgerPrice, burger.getPrice(), 0.1);
    }
}
