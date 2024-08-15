package inChromeBrowserTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class ConnectionChrome {
    WebDriver driver;

    //подключение драйвера браузера и установление ожидания в 5 секунд
    @Before
    public void open() {
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    //закрываю браузер
    @After
    public void close() {
        driver.quit();
    }
}
