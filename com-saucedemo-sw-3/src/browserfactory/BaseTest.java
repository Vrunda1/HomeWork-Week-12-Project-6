package browserfactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;

    public void openBrowser(String baseUrl){
       System.setProperty("webdriver.chrome.driver","driver/chromedriver.exe");
       driver =new ChromeDriver();

        // Launch the URL.
        driver.get(baseUrl);

        // Maximise Window
        driver.manage().window().maximize();

        //implicit timeout
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

    }
    public void closeBrowser(){
        driver.quit();
    }
}
