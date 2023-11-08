import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutorizationTest {
    private WebDriver driver;
    private Logger logger = LogManager.getLogger(AutorizationTest.class);


    @BeforeAll
    public static void  setup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver(){
        driver = new ChromeDriver();
    }


    @Test
    public void autorization(){
        driver.get("https://otus.ru");
        driver.manage().window().maximize();
        WebElement loginButton = driver.findElement(By.cssSelector(".sc-mrx253-0.enxKCy.sc-945rct-0.iOoJwQ"));
        loginButton.click();
        WebElement userName = driver.findElement(By.cssSelector("input[name=\"email\"]"));
        userName.sendKeys("snolanaila@mail.ru");
        WebElement userPassword = driver.findElement(By.cssSelector("input[type=\"password\"]"));
        userPassword.sendKeys("y4ct656y1XhA!");
        WebElement submitLogin = driver.findElement(By.cssSelector(".sc-9a4spb-0.gYNtqF.sc-11ptd2v-2-Component.cElCrZ"));
        submitLogin.click();
        logger.info(driver.manage().getCookies());
    }

    @AfterEach
    public void downDriver() {
        if (driver != null){
            driver.quit();
        }
    }
}