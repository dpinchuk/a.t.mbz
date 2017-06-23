package testClasses.registration;

import controllers.BrowserController;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Pinchuk Dmitry - QA Departament of Mobizon GMBH
 */

public class TestRegistrationPositive {

    private String site;
    private long delay;
    private String testNameRegistration;
    private String testSurnameRegistration;
    private String testEmailRegistration;
    private String testNumberRegistration;
    private String testPasswordRegistration;
    private String testPasswordConfirmRegistration;

    public TestRegistrationPositive(String site, long delay, String testNameRegistration, String testSurnameRegistration, String testEmailRegistration, String testNumberRegistration, String testPasswordRegistration, String testPasswordConfirmRegistration) {
        this.site = site;
        this.delay = delay;
        this.testNameRegistration = testNameRegistration;
        this.testSurnameRegistration = testSurnameRegistration;
        this.testEmailRegistration = testEmailRegistration;
        this.testNumberRegistration = testNumberRegistration;
        this.testPasswordRegistration = testPasswordRegistration;
        this.testPasswordConfirmRegistration = testPasswordConfirmRegistration;
    }

    @Test
    public void testRegistrationPositive() throws Exception {
        // инициализация web-драйвера
        WebDriver webDriver = new BrowserController(site, delay).initBrowser();
// Тестирование формы регистрации
        // Открыть форму регистрации -> клик на кнопку [Регистрация]
        webDriver.findElement(By.id("btn-reg")).click();
        Thread.sleep(delay);

        // Очистить поле ввода имени и ввести в него тестовое имя
        webDriver.findElement(By.cssSelector("input[id='registration_name']")).clear();
        Thread.sleep(delay);
        webDriver.findElement(By.cssSelector("input[id='registration_name']")).sendKeys(testNameRegistration);
        Thread.sleep(delay);

        // Очистить поле ввода фамилии и ввести в него тестовую фамилию
        webDriver.findElement(By.cssSelector("input[id='registration_surname']")).clear();
        Thread.sleep(delay);
        webDriver.findElement(By.cssSelector("input[id='registration_surname']")).sendKeys(testSurnameRegistration);
        Thread.sleep(delay);

        // Очистить поле ввода имени и ввести в него тестовое имя
        webDriver.findElement(By.cssSelector("input[id='registration_email']")).clear();
        Thread.sleep(delay);
        webDriver.findElement(By.cssSelector("input[id='registration_email']")).sendKeys(testEmailRegistration);
        Thread.sleep(delay);

        // Очистить поле ввода имени и ввести в него тестовое имя
        webDriver.findElement(By.cssSelector("input[id='registration_number']")).clear();
        Thread.sleep(delay);
        webDriver.findElement(By.cssSelector("input[id='registration_number']")).sendKeys(testNumberRegistration);
        Thread.sleep(delay);

        // Очистить поле ввода имени и ввести в него тестовое имя
        webDriver.findElement(By.cssSelector("input[id='registration_passwd']")).clear();
        Thread.sleep(delay);
        webDriver.findElement(By.cssSelector("input[id='registration_passwd']")).sendKeys(testPasswordRegistration);
        Thread.sleep(delay);

        // Очистить поле ввода имени и ввести в него тестовое имя
        webDriver.findElement(By.cssSelector("input[id='registration_passwdConfirm']")).clear();
        Thread.sleep(delay);
        webDriver.findElement(By.cssSelector("input[id='registration_passwdConfirm']")).sendKeys(testPasswordConfirmRegistration);
        Thread.sleep(delay);

        // клик на чекбокс подтверждения правил и условий публ. соглашения
        webDriver.findElement(By.className("toggle-checkbox")).click();
        Thread.sleep(delay);

        // клик на кнопку [Регистрация]
        webDriver.findElement(By.id("btn-register")).click();
        Thread.sleep(delay);

        // ввести код активации из смс
        webDriver.findElement(By.cssSelector("input[id='activation_code']")).clear();
        webDriver.findElement(By.cssSelector("input[id='activation_code']")).sendKeys(getResponseHeaderActivationCode("http://kz.z.mobizon.net.ua/service/user/sendactivationcodenumberpublic?number=" + testNumberRegistration));
        Thread.sleep(delay);
        // клик на кнопку [Завершить регистрацию]
        webDriver.findElement(By.id("btn-confirm-number")).click();
        Thread.sleep(delay);

        // Очистить поле ввода пароля и ввести пароль
        webDriver.findElement(By.id("password")).clear();
        Thread.sleep(delay);
        webDriver.findElement(By.id("password")).sendKeys(testPasswordRegistration);
        Thread.sleep(delay);

        // клик на чекбокс подтверждения правил и условий публ. соглашения
        webDriver.findElement(By.className("toggle-checkbox")).click();
        Thread.sleep(delay);

        // клик на кнопку [Войти]
        webDriver.findElement(By.id("btn-login")).click();
        Thread.sleep(delay);

        Thread.sleep(2 * delay);
        // закрыть браузер
        webDriver.quit();
    }

    private static int getResponseCode(String urlString) throws Exception {
        URL url = new URL(urlString);
        HttpURLConnection huc = (HttpURLConnection)url.openConnection();
        huc.setRequestMethod("GET");
        huc.connect();
        return huc.getResponseCode();
    }

    private static String getResponseHeaderActivationCode(String urlString) throws Exception {
        URL url = new URL(urlString);
        URLConnection urlConnection = url.openConnection();
        //get all headers
        Map<String, List<String>> map = urlConnection.getHeaderFields();
        //for (Map.Entry<String, List<String>> entry : map.entrySet()) {
        //System.out.println("Key : " + entry.getKey() + " ,Value : " + entry.getValue());
        //}
        //get header by 'key'
        //String server = urlConnection.getHeaderField("Server");
        //int code = Integer.parseInt(map.get("X-1-Recovery-Code").get(0));
        return map.get("X-1-Activation-Code").get(0);
    }

}