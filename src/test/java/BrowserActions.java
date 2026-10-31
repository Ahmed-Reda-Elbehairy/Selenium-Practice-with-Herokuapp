import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class BrowserActions {
    WebDriver driver;

    @Test
    public void testCase() {
        driver = new EdgeDriver();
        maximizeWindow();
        navigateTo("https://the-internet.herokuapp.com/login");
        //driver.switchTo().newWindow(org.openqa.selenium.WindowType.TAB);
        close();
        quit();
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driver.get(url);

    }

    public void closeBrowser() {
        driver.close();
    }

    public void close() {
        driver.close();
    }

    public void quit() {
        driver.quit();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public void navigateForward() {
        driver.navigate().forward();
    }

    public void refreshPage() {
        driver.navigate().refresh();
    }

    public void minimizeWindow() {

        driver.manage().window().minimize();
    }

    public void positionWindow(int x, int y) {
        driver.manage().window().setPosition(new Point(x, y));
    }

    public void sizeWindow(int w, int h) {
        driver.manage().window().setSize(new Dimension(w, h));
    }

    public void getSizeWindow() {
        System.out.println(driver.manage().window().getSize().width);
        System.out.println(driver.manage().window().getSize().height);
    }

    public void fullScreen() {
        driver.manage().window().fullscreen();
    }

    public void getURL() {
        System.out.println("Current URL : " + driver.getCurrentUrl());
    }

    public void getTitle() {
        System.out.println("Title : " + driver.getTitle());
    }

    public void getCode() {
        System.out.println("Page Source : " + driver.getPageSource());
    }

    public void getWindowID() {
        System.out.println("Window Handle : " + driver.getWindowHandle());
    }
}
