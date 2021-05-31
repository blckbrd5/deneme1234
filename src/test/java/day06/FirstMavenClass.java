package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FirstMavenClass {

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        driver.get("https://www.amazon.com");

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Samsung headphones" + Keys.ENTER);

     // bulunan sonuc sayisini yazdiralim
        WebElement sonucYazisiWebElement = driver.findElement(By.xpath("(//span[@dir='auto'])[1]"));
        System.out.println(sonucYazisiWebElement.getText());

    // sadece sonuc ADEDINI istersek sonuc yazisini String eatayip string manipulation yapabiliriz

        // ilk urunu tiklayalim

        /* 1.YOL */
      //  WebElement ilkUrun = driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]"));
       //  ilkUrun.click();

        /* 2.YOL */
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//span[@class='a-size-medium a-color-base a-text-normal'])[1]")).click();

        // geri giderek arama sayfasindaki tum basliklari yazdirin
        driver.navigate().back();

        List<WebElement> basliklarListesi = driver.findElements(By.xpath("//span[@class='a-size-base a-color-base']"));

        for (WebElement each : basliklarListesi) {
            System.out.println(each.getText());
        }
      driver.close();
    }



}
