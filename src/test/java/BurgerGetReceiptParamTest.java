import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;
import praktikum.Bun;
import praktikum.Burger;
import praktikum.Ingredient;
import praktikum.IngredientType;

import static praktikum.IngredientType.FILLING;
import static praktikum.IngredientType.SAUCE;

@RunWith(Parameterized.class)
public class BurgerGetReceiptParamTest {
    Bun bun = Mockito.mock(Bun.class);
    Ingredient ingredient = Mockito.mock(Ingredient.class);
    Burger burger = Mockito.mock(Burger.class);

    @Parameterized.Parameter
    public String bunName;
    @Parameterized.Parameter(1)
    public IngredientType ingredientType;
    @Parameterized.Parameter(2)
    public String ingredientName;
    @Parameterized.Parameter(3)
    public float burgerPrice;
    @Parameterized.Parameters
    public static Object[][] dataForReceipt(){
        return new Object[][]{
                {"black bun", SAUCE, "hot sauce", 1000},
                {"white bun", FILLING, "cutlet", 1200}
        };
    }
    @Test
    public void getReceiptTest(){
        burger = new Burger();
        burger.setBuns(bun);
        burger.addIngredient(ingredient);
        Mockito.when(bun.getName()).thenReturn(bunName);
        Mockito.when(ingredient.getType()).thenReturn(ingredientType);
        Mockito.when(ingredient.getName()).thenReturn(ingredientName);
        Mockito.when(burger.getPrice()).thenReturn(burgerPrice);
        String receipt = burger.getReceipt();
        Assert.assertTrue(receipt.contains(bunName) && receipt.contains(ingredientName)
                && receipt.contains(String.valueOf(ingredientType.toString().toLowerCase()))
                && receipt.contains(String.format(" %f", burgerPrice)));
    }
}
