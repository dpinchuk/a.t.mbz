package controllers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * Created by Pinchuk Dmitry - QA Departament of Mobizon GMBH on 28.04.2017
 */

public class BrowserController {

    private String site;
    private long delay;

    public BrowserController(String site, long delay) {
        this.site = site;
        this.delay = delay;
    }

    public WebDriver initBrowser() throws Exception {
        // игнициализируем web-драйвер
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        capability.setBrowserName("chrome");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("window-size=1920, 1080");
        DesiredCapabilities cap = DesiredCapabilities.chrome();
        cap.setCapability(ChromeOptions.CAPABILITY, options);

        WebDriver webDriver = new ChromeDriver();
        // удаляем все cookie в браузере
        webDriver.manage().deleteAllCookies();
        Thread.sleep(delay);
        webDriver.get(site);
        Thread.sleep(delay);

        // делаем окно браузера максимального размера
        webDriver.manage().window().maximize();
        //webDriver.manage().window().setSize(new Dimension(1920, 1080));

        // в консоле выводит заголовок сайта
        System.out.println(webDriver.getTitle());
        Thread.sleep(delay);

        // клик на кнопку установки cookie на сайте
        webDriver.findElement(By.cssSelector("button[class='confirm-cookie-button btn default h-40 fl-left']")).click();
        Thread.sleep(delay);
        return webDriver;
    }

}