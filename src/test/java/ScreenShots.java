import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class ScreenShots {
    WebDriver driver;

    @Test
    public void screenshots() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File dest = new File("src/test/resources/ScreenShot.png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    @Test
    public void screenshotForAnElement() {
        driver = new EdgeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");
        File src = driver.findElement(By.id("content")).getScreenshotAs(OutputType.FILE);
        File dest = new File("src/test/resources/ScreenShotElement.png");
        try {
            FileUtils.copyFile(src, dest);
        } catch (IOException e) {
            System.out.println("error: " + e.getMessage());
        }
    }
}

