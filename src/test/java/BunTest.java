import org.junit.Assert;
import org.junit.Test;
import praktikum.Bun;

public class BunTest {
    Bun bun = new Bun("white bun", 200);
    @Test
    public void getName() {
        Assert.assertEquals("white bun", bun.getName());
    }
    @Test
    public void getPrice() {
        Assert.assertEquals(200F, bun.getPrice(), 0.1);
    }
}
