package testClasses.authorization;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import java.util.Map;

/**
 * Created by Pinchuk Dmitry - QA Departament of Mobizon GMBH on 09.05.2017
 */

public class TestAuthorizationPasswordRecoveryPositive {

    private String site;
    private long delay;
    private String testNameLogin;
    private String testSurnameLogin;
    private String testEmailLogin;
    private String testNumberLogin;
    private String testPasswordLogin;
    private String testPasswordConfirmLogin;

    public TestAuthorizationPasswordRecoveryPositive(String site, long delay, String testNameLogin, String testSurnameLogin, String testEmailLogin, String testNumberLogin, String testPasswordLogin, String testPasswordConfirmLogin) {
        this.site = site;
        this.delay = delay;
        this.testNameLogin = testNameLogin;
        this.testSurnameLogin = testSurnameLogin;
        this.testEmailLogin = testEmailLogin;
        this.testNumberLogin = testNumberLogin;
        this.testPasswordLogin = testPasswordLogin;
        this.testPasswordConfirmLogin = testPasswordConfirmLogin;
    }

    @Test
    public void testAuthorizationPasswordRecoveryPositive() throws Exception {
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
        webDriver.get(this.site);
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

// Тестирование меню авторизации на сайте -> 'Забыли пароль?'-----------------------------------------------------------
        // Открытие формы авторизации -> testNumber---------------------------------------------------------------------
        // клик на конпку [Вход]
        webDriver.findElement(By.id("btn-log")).click();
        Thread.sleep(delay);

        // клик на ссылку 'Забыли пароль?'
        webDriver.findElement(By.id("link-forgot")).click();
        Thread.sleep(delay);

        // очистить поле вода email или номера телефона
        webDriver.findElement(By.cssSelector("input[id='pr-contactValue']")).clear();
        Thread.sleep(delay);

        // в поле вода email или номера телефона ввести номер телефона
        webDriver.findElement(By.cssSelector("input[id='pr-contactValue']")).sendKeys(testNumberLogin);
        Thread.sleep(delay);

        // клик на кнопку [Получить пароль]
        webDriver.findElement(By.id("rp-btn-get-passw")).click();
        Thread.sleep(delay);

        //System.out.println(getResponseHeaderRecoveryCode("http://kz.z.mobizon.net.ua/service/user/getpasswordrecoverycode?contactValue=380968353340"));
        // Ввести в поля формы 'Восстановление пароля' код, пароль и подтверждение пароля
        // код
        webDriver.findElement(By.cssSelector("input[id='pr-code']")).clear();
        webDriver.findElement(By.cssSelector("input[id='pr-code']")).sendKeys(getResponseHeaderRecoveryCode("http://kz.z.mobizon.net.ua/service/user/getpasswordrecoverycode?contactValue=380968353340"));
        Thread.sleep(delay);
        // пароль
        webDriver.findElement(By.cssSelector("input[id='pr-passwd']")).clear();
        webDriver.findElement(By.cssSelector("input[id='pr-passwd']")).sendKeys(testPasswordLogin);
        Thread.sleep(delay);
        // подтверждение пароля
        webDriver.findElement(By.cssSelector("input[id='pr-passwdConfirm']")).clear();
        webDriver.findElement(By.cssSelector("input[id='pr-passwdConfirm']")).sendKeys(testPasswordConfirmLogin);
        Thread.sleep(delay);
        // клик на кнопку [Сохранить]
        webDriver.findElement(By.id("rp-btn-set-passw")).click();
        Thread.sleep(delay);


        // Форма авторизации -> testNumber----------------------------------------------------------------------
        // очистить поле вода email или номера телефона
        webDriver.findElement(By.cssSelector("input[id='email']")).clear();
        Thread.sleep(delay);

        // установить в поле ввода email или номера телефона значение testEmail (valid)
        webDriver.findElement(By.cssSelector("input[id='email']")).sendKeys(testNumberLogin);
        Thread.sleep(delay);

        // очистить поле ввода пароля
        webDriver.findElement(By.cssSelector("input[id='password']")).clear();
        Thread.sleep(delay);

        // установить в поле ввода пароля занчение testPassword (valid)
        webDriver.findElement(By.cssSelector("input[id='password']")).sendKeys(testPasswordLogin);
        Thread.sleep(delay);

        // клик на чекбокс 'Запомнить меня'
        webDriver.findElement(By.className("toggle-checkbox")).click();
        Thread.sleep(delay);

        // клик на кнопку [Войти]
        webDriver.findElement(By.id("btn-login")).click();
        Thread.sleep(5 * delay);


        // Выход из аккаунта пользователя-------------------------------------------------------------------------------
        // клик на кнопку меню пользователя - открыли
        webDriver.findElement(By.className("taskbar-user-name")).click();
        Thread.sleep(delay);

        // клик на кнопку списка [Выход]
        webDriver.findElement(By.cssSelector("span[id='menuitem-1051-textEl']")).click();
        Thread.sleep(delay);

        // клик на кнопку формы выхода из аккаунта [Да]
        webDriver.findElement(By.cssSelector("span[id='button-1014-btnIconEl']")).click();
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

    private static String getResponseHeaderRecoveryCode(String urlString) throws Exception {
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
        return map.get("X-1-Recovery-Code").get(0);
    }

}