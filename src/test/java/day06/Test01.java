package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test01 {
    /* 1-Test01 isimli bir class olusturun
   2- https://www.walmart.com/ adresine gidin
   3- Browseri tam sayfa yapin
   4-Sayfayi “refresh” yapin
   5- Sayfa basliginin “Save” ifadesi icerdigini control edin
   6-Sayfa basliginin “Walmart.com | Save Money. Live Better.” a esit oldugunu control ediniz
   7- URL in walmart.com icerdigini control edin
   8-”Nutella” icin arama yapiniz
   9- Kac sonuc bulundugunu yaziniz
   10-Sayfayi kapatin */

     public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.walmart.com");

        driver.manage().window().maximize();

        driver.navigate().refresh();

        String sayfaBasligi = driver.getTitle();

        if (sayfaBasligi.contains("Save")) {
             System.out.println(" Sayfa basligi Save iceriyor, test PASS ");
         } else {
             System.out.println(" Sayfa basligi Save icermiyor, test FAILED ");
         }

        if (sayfaBasligi.equals("Walmart.com | Save Money. Live Better")) {
            System.out.println(" pass");

        }else       System.out.println(" failed");
         System.out.println(" gecerli baslik current title :" + sayfaBasligi);
         System.out.println(" Expected Title :" + "Walmart.com | Save Money.Live Better.");


        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("walmart.com")){
            System.out.println("url testi pass");
        } else System.out.println(" url testi failed");

    }
}
