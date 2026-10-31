import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class frames {
    WebDriver driver;
    By leftFrame = By.xpath("//body[contains(text(),'LEFT')]");
    By bottomFrame = By.xpath("//body[contains(text(),'BOTTOM')]");

    @Test
    public void frames() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        driver.switchTo().frame("frame-top").switchTo().frame("frame-left");
        System.out.println(driver.findElement(leftFrame).getText());
        driver.switchTo().defaultContent().switchTo().parentFrame().switchTo().frame("frame-bottom");
        System.out.println(driver.findElement(bottomFrame).getText());


    }
}
