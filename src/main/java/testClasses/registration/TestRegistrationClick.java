package testClasses.registration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Pinchuk Dmitry - QA Departament of Mobizon GMBH
 */

public class TestRegistrationClick {

    public void testRegistranion() throws Exception {
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        capability.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920, 1080");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver webDriver = new ChromeDriver();
        webDriver.manage().deleteAllCookies(); // удаляем все cookie в браузере
        Thread.sleep(1000);
        webDriver.get("https://mobizon.kz");
        Thread.sleep(1000);

        webDriver.manage().window().maximize(); // делаем окно браузера максимального размера
        //webDriver.manage().window().setSize(new Dimension(1920, 1080));

        // в консоле выводит заголовок сайта
        System.out.println(webDriver.getTitle());
        Thread.sleep(1000);

        // клик на кнопку установки cookie на сайте
        webDriver.findElement(By.cssSelector("button[class='confirm-cookie-button btn default h-40 fl-left']")).click();
        Thread.sleep(1000);

        webDriver.findElement(By.id("btn-reg")).click();
        Thread.sleep(5000);

        // очистить поле вода имени
        webDriver.findElement(By.cssSelector("input[id='registration_name']")).clear();
        Thread.sleep(1000);
        // заполнить поле вода имени
        webDriver.findElement(By.cssSelector("input[id='registration_name']")).sendKeys("TestName");
        Thread.sleep(1000);

        // очистить поле вода фамилии
        webDriver.findElement(By.cssSelector("input[id='registration_surname']")).clear();
        Thread.sleep(1000);
        // заполнить поле вода фамилии
        webDriver.findElement(By.cssSelector("input[id='registration_surname']")).sendKeys("TestSurname");
        Thread.sleep(1000);

        // очистить поле вода email
        webDriver.findElement(By.cssSelector("input[id='registration_email']")).clear();
        Thread.sleep(1000);
        // заполнить поле вода email
        webDriver.findElement(By.cssSelector("input[id='registration_email']")).sendKeys("test@test.test");
        Thread.sleep(1000);

        // очистить поле вода номера телефона
        webDriver.findElement(By.cssSelector("input[id='registration_number']")).clear();
        Thread.sleep(1000);
        // заполнить поле вода номера телефона
        webDriver.findElement(By.cssSelector("input[id='registration_number']")).sendKeys("12345678901");
        Thread.sleep(1000);

        // очистить поле вода пароля
        webDriver.findElement(By.cssSelector("input[id='registration_passwd']")).clear();
        Thread.sleep(1000);
        // заполнить поле вода пароля
        webDriver.findElement(By.cssSelector("input[id='registration_passwd']")).sendKeys("123456");
        Thread.sleep(1000);

        // очистить поле вода подтверждения пароля
        webDriver.findElement(By.cssSelector("input[id='registration_passwdConfirm']")).clear();
        Thread.sleep(1000);
        // заполнить поле вода подтверждения пароля
        webDriver.findElement(By.cssSelector("input[id='registration_passwdConfirm']")).sendKeys("123456");
        Thread.sleep(1000);

        // клик на чекбокс согласия с правилами
        webDriver.findElement(By.className("toggle-checkbox")).click();
        Thread.sleep(1000);

        // клик на кнопку-крестик закрытия окна
        webDriver.findElement(By.className("fancybox-close")).click();
        Thread.sleep(5000);

        // закрыть браузер
        webDriver.quit();
    }

}
