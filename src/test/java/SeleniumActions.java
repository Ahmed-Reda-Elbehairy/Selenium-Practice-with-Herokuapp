import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.testng.annotations.Test;

public class SeleniumActions {
    WebDriver driver;
    By rightElement = By.id("hot-spot");
    By frame = By.xpath("//div[contains(@class,'demo')]//iframe");
    By clickBox = RelativeLocator.with(By.xpath("/html/body/div"))
            .above(By.xpath("//span[contains(text(),'Double click')]"));
    By avatar1 = By.xpath("//*[@id=\"content\"]/div/div[1]");

    By avatar2 = By.xpath("//*[@id=\"content\"]/div/div[2]");

    By avatar3 = By.xpath("//*[@id=\"content\"]/div/div[3]");
    By source = By.id("column-a");
    By Destination = By.id("column-b");


    @Test
    public void rightClick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions action = new Actions(driver);
        action.contextClick(driver.findElement(rightElement)).perform();

    }

    @Test
    public void hovers() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/hovers");
        Actions action = new Actions(driver);
        action.moveToElement(driver.findElement(avatar1)).perform();
        action.moveToElement(driver.findElement(avatar2)).perform();
        action.moveToElement(driver.findElement(avatar3)).perform();

    }

    @Test
    public void doubleClick() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://api.jquery.com/dblclick/");
        driver.switchTo().frame(driver.findElement(frame));
        Actions action = new Actions(driver);
        action.doubleClick(driver.findElement(clickBox)).perform();


    }

    @Test
    public void dragAndDrop() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions action = new Actions(driver);
        action.dragAndDrop(driver.findElement(source), driver.findElement(Destination)).perform();
    }

    @Test
    public void clickAndHold() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/drag_and_drop");
        Actions action = new Actions(driver);
        action.clickAndHold(driver.findElement(source))
                .moveToElement(driver.findElement(Destination))
                .release()
                .perform();

    }

    @Test
    public void keyPresses() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/key_presses");
        Actions action = new Actions(driver);
        action.keyDown(Keys.SHIFT).sendKeys(driver.findElement(By.id("target")), "ahmed").perform();
        ((RemoteWebDriver) driver).resetInputState();

    }

    @Test
    public void scrollToElement() {
        //not working due to website speed issue
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/infinite_scroll");
        Actions action = new Actions(driver);
        action.scrollToElement(driver.findElement((By.xpath("//*[@id=\"content\"]/div/div/div/div/div[1]/br")))).perform();

    }

}
