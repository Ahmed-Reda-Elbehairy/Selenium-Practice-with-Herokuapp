import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class Alerts {
    WebDriver driver;
    By jsAlert = By.xpath("//ul/li[1]/button");
    By jsConfirm = By.xpath("//ul/li[2]/button");
    By jsPrompt = By.xpath("//ul/li[3]/button");


    @Test
    public void jsAlert() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsAlert).click();
        driver.switchTo().alert().accept();
    }

    @Test
    public void jsConfirm() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsConfirm).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

    }

    @Test
    public void jsPrompt() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
        driver.findElement(jsPrompt).click();
        driver.switchTo().alert().sendKeys("Ahmed");
        driver.switchTo().alert().accept();
    }
}
