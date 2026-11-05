import io.restassured.response.Response;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

import java.net.URI;
import java.net.URL;

public class RestAssured {
    WebDriver driver;
    By hrefLocator = By.xpath("//a[@target='_blank'][1]");
    By img = By.xpath("//div[@class='example']/img[2]");

    @Test
    public void checkLink() {
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        String href = driver.findElement(hrefLocator).getDomProperty("href");
        try {
            URL url = new URI(href).toURL();
            Response res = io.restassured.RestAssured.given().get(url);
            System.out.println(res.getStatusLine());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }

    @Test
    public void checkBrokenImage() {
        driver = new EdgeDriver();
        driver.get("https://the-internet.herokuapp.com/broken_images");
        String link = driver.findElement(img).getDomProperty("src");
        try {
            URL url = new URI(link).toURL();
            Response res = io.restassured.RestAssured.given().get(url);
            System.out.println(res.getStatusLine());
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}
