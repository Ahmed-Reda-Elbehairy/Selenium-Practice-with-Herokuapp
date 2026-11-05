import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.annotations.Test;

public class BrowserOptions {
    WebDriver driver;

    @Test
    public void options() {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--headless");
        //options.setBrowserVersion("latest");
        options.setAcceptInsecureCerts(true);
        driver = new EdgeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        System.out.println(options.getBrowserName());
    }
}
