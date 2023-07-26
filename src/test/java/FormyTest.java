import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;



import static java.lang.Thread.sleep;

public class FormyTest {

    public WebDriver driver;

    public void setUp(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.setExperimentalOption("excludeSwitches", ImmutableList.of("disable-popup-blocking"));
        driver = new ChromeDriver(options);
        driver.get("https://formy-project.herokuapp.com/form");
        driver.findElement(By.id("first-name")).sendKeys("Cevdet");
        driver.findElement(By.id("last-name")).sendKeys("Ayaz");
        driver.findElement(By.id("job-title")).sendKeys("Software Tester");
        driver.findElement(By.id("radio-button-2")).click();
        driver.findElement(By.id("checkbox-1")).click();
        driver.findElement(By.cssSelector("option[value='1']")).click();
        driver.findElement(By.id("datepicker")).sendKeys("07/26/2023");
        driver.findElement(By.linkText("Submit")).click();







    }

    public void tearDown(){

        try {
            sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        driver.quit();
    }

    public static void main(String[] args) {
        FormyTest formyTest = new FormyTest();
        formyTest.setUp();

    }

}
