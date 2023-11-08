import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OpenImageTest {
    private WebDriver driver;

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver(){
        driver = new ChromeDriver();
    }

    @Test
    public void openImage() {
        driver = new ChromeDriver();
        driver.get("https://demo.w3layouts.com/demos_new/template_demo/03-10-2020/photoflash-liberty-demo_Free/685659620/web/index.html?_ga=2.181802926.889871791.1632394818-2083132868.1632394818");
        driver.manage().window().fullscreen();
        WebElement pictures = driver.findElement(By.cssSelector(".portfolio-item2.content"));
        pictures.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        WebElement picturesFullScreen = driver.findElement(By.cssSelector(".pp_pic_holder.light_rounded"));
        picturesFullScreen.isDisplayed();
    }

    @AfterEach
    public void downDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}