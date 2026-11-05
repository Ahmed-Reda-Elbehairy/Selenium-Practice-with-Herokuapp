import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class JSExecuter {
    WebDriver driver;
    By text = By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]");

    @Test
    public void test() {
        EdgeOptions opt = new EdgeOptions();
        opt.addArguments("--start-maximized");
        driver = new EdgeDriver(opt);
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView;", driver.findElement(text));

    }
}
