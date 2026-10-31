import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Windows {
    WebDriver driver;
    By btnClick = By.cssSelector("[href='/windows/new']");
    By Text = By.cssSelector("body > .example > h3");

    @Test
    public void windows() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/windows");
        String parent = driver.getWindowHandle();
        driver.findElement(btnClick).click();
        String child = driver.getWindowHandles().toArray()[1].toString();
        driver.switchTo().window(child);
        System.out.println(driver.findElement(Text).getText());
        driver.close();
        driver.switchTo().window(parent);
        //driver.switchTo().newWindow(WindowType.TAB).navigate().to("https://www.google.com/");
    }
}
