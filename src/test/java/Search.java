import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Search {
    private WebDriver driver;

    @BeforeAll
    public static void setup(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    public void startDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("headless");
        driver = new ChromeDriver(options);
    }

    @Test
    public void search(){
        driver.get("https://duckduckgo.com");
        WebElement searchBar = driver.findElement(By.cssSelector(".searchbox_input__bEGm3"));
        searchBar.clear();
        searchBar.sendKeys("ОТУС");
        WebElement searchButton = driver.findElement(By.cssSelector(".searchbox_searchButton__F5Bwq.iconButton_button__6x_9C"));
        searchButton.click();
        WebElement firstResult = driver.findElement(By.xpath("//span[contains(text(),'Онлайн‑курсы для профессионалов, дистанционное обучение современным ...')]"));
        String actualTitle = firstResult.getText();
        String expectedTitle = "Онлайн‑курсы для профессионалов, дистанционное обучение современным ...";
        Assertions.assertEquals(expectedTitle,actualTitle);
    }

    @AfterEach
    public void downDriver(){
        if (driver != null){
            driver.quit();
        }
    }
}