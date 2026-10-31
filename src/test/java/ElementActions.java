import org.openqa.selenium.*;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.pagefactory.ByChained;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class ElementActions {
    WebDriver driverEdge;
    By username = By.id("username");

    By password = By.cssSelector("[type='password']");

    By loginButton = RelativeLocator.with(By.tagName("button")).below(password);
    By Text = new ByChained(By.className("large-4"), By.linkText("Elemental Selenium"));
    By loginFields = new ByAll(username, password);
    By logoutBtn = By.cssSelector("[id=content] [class~=button]");
    By fileID = By.id("file-upload");
    By btnLoad = By.xpath("//*[@id='start']/button");
    By textWait = By.cssSelector("#finish>h4");
    By dropDownId = By.id("dropdown");
    By check1 = By.xpath("//input[1]");
    By check2 = By.xpath("//input[2]");

    @Test
    public void testCase() throws InterruptedException {
        driverEdge = new EdgeDriver();
        maximizeWindow();
        navigateTo("https://the-internet.herokuapp.com/login");
        type(username, "tomsmith");
        type(password, "SuperSecretPassword!");
        System.out.println(pro(username, "type"));
        System.out.println(attr(username, "id"));
        clicking(loginButton);
        System.out.println(findElement(Text).getText());
        System.out.println(visibility(logoutBtn));
        System.out.println(enabled(logoutBtn));
        Thread.sleep(2000);
        clicking(logoutBtn);
        //findElement(username).clear();
        //findElement(password).clear();
        //driver.findElements(loginFields).get(0).sendKeys("tomsmith");
        close();
        quit();

    }

    @Test
    public void testCaseFileUpload() {
        driverEdge = new EdgeDriver();
        maximizeWindow();
        navigateTo("https://the-internet.herokuapp.com/upload");
        fileUpload(fileID, "src/test/resources/testfile.txt");

    }

    @Test
    public void shadowDom() throws InterruptedException {
        driverEdge = new EdgeDriver();
        maximizeWindow();
        //Thread.sleep(5000);
        navigateTo("https://the-internet.herokuapp.com/shadowdom");
        By shadowHostLocator = By.xpath("//*[@id=\"content\"]/my-paragraph[2]");
        By textLocator = By.cssSelector("[name = 'my-text']");
        //String Text = driverEdge.findElement(shadowHostLocator).getShadowRoot().findElement(textLocator).getText();
        WebElement host = driverEdge.findElement(shadowHostLocator);
        SearchContext Root = host.getShadowRoot();
        String text = Root.findElement(textLocator).getText();

        System.out.println(text);
        quit();
    }

    @Test
    public void implicitWait() {
        driverEdge = new EdgeDriver();
        maximizeWindow();
        driverEdge.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        navigateTo("https://the-internet.herokuapp.com/dynamic_loading/2");
        clicking(btnLoad);
        System.out.println(findElement(textWait).getText());

    }

    @Test
    public void explicitWait() {
        driverEdge = new EdgeDriver();
        maximizeWindow();
        navigateTo("https://the-internet.herokuapp.com/dynamic_loading/1");
        clicking(btnLoad);
        new WebDriverWait(driverEdge, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(textWait));
        //new WebDriverWait(driverEdge, Duration.ofSeconds(10)).until(d -> d.findElement(textWait).isDisplayed());
        System.out.println(findElement(textWait).getText());

    }

    @Test
    public void explicitWaitUsingLambda() {
        driverEdge = new EdgeDriver();
        maximizeWindow();
        navigateTo("https://the-internet.herokuapp.com/dynamic_loading/2");
        clicking(btnLoad);
        //new WebDriverWait(driverEdge, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(textWait));
        new WebDriverWait(driverEdge, Duration.ofSeconds(10)).until(d -> d.findElement(textWait).isDisplayed());
        System.out.println(findElement(textWait).getText());

    }

    @Test
    public void fluentWait() {
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        driverEdge = new EdgeDriver(edgeOptions);
        WebDriverWait wait = new WebDriverWait(driverEdge, Duration.ofSeconds(10));
        maximizeWindow();
        navigateTo("https://the-internet.herokuapp.com/dynamic_loading/1");
        wait.until(ExpectedConditions.elementToBeClickable(btnLoad));
        clicking(btnLoad);
        new FluentWait<>(driverEdge)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofMillis(300))
                .withMessage("Element Is not visible, locator:" + textWait.toString())
                .ignoring(NoSuchElementException.class)
                .until(ExpectedConditions.visibilityOfElementLocated(textWait));
        //.until(d -> d.findElement(textWait).isDisplayed());
        System.out.println(findElement(textWait).getText());

    }

    @Test
    public void dropDown() {
        driverEdge = new EdgeDriver();
        maximizeWindow();
        navigateTo("https://the-internet.herokuapp.com/dropdown");
        Select drop = new Select(driverEdge.findElement(dropDownId));
        drop.selectByIndex(1);
        System.out.println(drop.getFirstSelectedOption().getText());
    }

    @Test
    public void checkboxes() {
        driverEdge = new EdgeDriver();
        maximizeWindow();
        navigateTo("https://the-internet.herokuapp.com/checkboxes");
        findElement(check1).click();
        System.out.println(findElement(check2).isSelected());

    }

    public String pro(By by, String propertyName) {
        return driverEdge.findElement(by).getDomProperty(propertyName);
    }

    public String attr(By by, String attributeName) {
        return driverEdge.findElement(by).getDomAttribute(attributeName);
    }

    public WebElement findElement(By by) {
        return driverEdge.findElement(by);
    }

    public boolean visibility(By by) {
        //return driverEdge.findElement(by).isDisplayed();
        return findElement(by).isDisplayed();
        //return driverEdge.findElement(By.cssSelector("#content .button")).isDisplayed();
    }

    public boolean enabled(By by) {
        return driverEdge.findElement(by).isEnabled();

    }

    public void clicking(By by) {
        driverEdge.findElement(by).click();
    }

    public void type(By by, String text) {
        clear(by);
        driverEdge.findElement(by).sendKeys(text);

    }

    public void clear(By by) {
        driverEdge.findElement(by).clear();
    }

    public void fileUpload(By by, String filePath) {
        clear(by);
        String userDir = System.getProperty("user.dir");
        driverEdge.findElement(by).sendKeys(userDir + File.separator + filePath);
    }

    public void maximizeWindow() {
        driverEdge.manage().window().maximize();
    }

    public void navigateTo(String url) {
        driverEdge.get(url);
    }

    public void close() {
        driverEdge.close();
    }

    public void quit() {
        driverEdge.quit();
    }


}
