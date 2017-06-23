package testClasses.authorization;

import controllers.BrowserController;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

/**
 * Created by Pinchuk Dmitry - QA Departament of Mobizon GMBH on 28.04.2017
 */

public class TestAuthorizationLoginNegative {

    private BrowserController browserController;
    private String site;
    private long delay;
    private String testEmail;
    private String testNumber;
    private String testPassword;
    private String testPasswordConfirm;

    public TestAuthorizationLoginNegative(String site, long delay, String testEmail, String testNumber, String testPassword, String testPasswordConfirm) {
        this.site = site;
        this.delay = delay;
        this.testEmail = testEmail;
        this.testNumber = testNumber;
        this.testPassword = testPassword;
        this.testPasswordConfirm = testPasswordConfirm;
    }

    public void testAuthorizationNegative() throws Exception {
        // инициализация web-драйвера
        WebDriver webDriver = new BrowserController(site, delay).initBrowser();

// Тестирование меню авторизации на сайте-------------------------------------------------------------------------------
        // Открытие формы авторизации -> testNumber---------------------------------------------------------------------
        // клик на конпку [Вход]
        webDriver.findElement(By.id("btn-log")).click();
        Thread.sleep(delay);

        // очистить поле вода email или номера телефона
        webDriver.findElement(By.cssSelector("input[id='email']")).clear();
        Thread.sleep(delay);

        // установить в поле ввода email или номера телефона значение testNumber (valid)
        webDriver.findElement(By.cssSelector("input[id='email']")).sendKeys(testNumber);
        Thread.sleep(delay);

        // очистить поле ввода пароля
        webDriver.findElement(By.cssSelector("input[id='password']")).clear();
        Thread.sleep(delay);

        // установить в поле ввода пароля занчение testPassword (valid)
        webDriver.findElement(By.cssSelector("input[id='password']")).sendKeys(testPassword);
        Thread.sleep(delay);

        // клик на чекбокс 'Запомнить меня'
        webDriver.findElement(By.className("toggle-checkbox")).click();
        Thread.sleep(delay);

        // клик на кнопку [Войти]
        webDriver.findElement(By.id("btn-login")).click();
        Thread.sleep(5 * delay);


        // Выход из аккаунта пользователя-------------------------------------------------------------------------------
        // клик на кнопку 1 меню пользователя - открыли
        webDriver.findElement(By.cssSelector("span[class='x-btn-wrap x-btn-arrow x-btn-arrow-right']")).click();
        Thread.sleep(delay);

        // клик на кнопку 1 меню пользователя - закрыли
        webDriver.findElement(By.cssSelector("span[class='x-btn-wrap x-btn-arrow x-btn-arrow-right']")).click();
        Thread.sleep(delay);

        // клик на кнопку 2 меню пользователя - открыли
        webDriver.findElement(By.className("taskbar-user-name")).click();
        Thread.sleep(delay);

        // клик на кнопку списка [Выход]
        webDriver.findElement(By.cssSelector("span[id='menuitem-1051-textEl']")).click();
        Thread.sleep(delay);

        // клик на кнопку формы выхода из аккаунта [Да]
        webDriver.findElement(By.cssSelector("span[id='button-1014-btnIconEl']")).click();
        Thread.sleep(delay);


        // Удаление файлов cookies в браузере---------------------------------------------------------------------------
        // удаляем все cookie в браузере
        webDriver.manage().deleteAllCookies();


        // Открытие формы авторизации -> testEmail----------------------------------------------------------------------
        // клик на конпку [Вход]
        webDriver.findElement(By.id("btn-log")).click();
        Thread.sleep(delay);

        // очистить поле вода email или номера телефона
        webDriver.findElement(By.cssSelector("input[id='email']")).clear();
        Thread.sleep(delay);

        // установить в поле ввода email или номера телефона значение testEmail (valid)
        webDriver.findElement(By.cssSelector("input[id='email']")).sendKeys(testEmail);
        Thread.sleep(delay);

        // очистить поле ввода пароля
        webDriver.findElement(By.cssSelector("input[id='password']")).clear();
        Thread.sleep(delay);

        // установить в поле ввода пароля занчение testPassword (valid)
        webDriver.findElement(By.cssSelector("input[id='password']")).sendKeys(testPassword);
        Thread.sleep(delay);

        // клик на чекбокс 'Запомнить меня'
        webDriver.findElement(By.className("toggle-checkbox")).click();
        Thread.sleep(delay);

        // клик на кнопку [Войти]
        webDriver.findElement(By.id("btn-login")).click();
        Thread.sleep(5 * delay);


        // Выход из аккаунта пользователя-------------------------------------------------------------------------------
        // клик на кнопку 1 меню пользователя - открыли
        webDriver.findElement(By.cssSelector("span[class='x-btn-wrap x-btn-arrow x-btn-arrow-right']")).click();
        Thread.sleep(delay);

        // клик на кнопку 1 меню пользователя - закрыли
        webDriver.findElement(By.cssSelector("span[class='x-btn-wrap x-btn-arrow x-btn-arrow-right']")).click();
        Thread.sleep(delay);

        // клик на кнопку 2 меню пользователя - открыли
        webDriver.findElement(By.className("taskbar-user-name")).click();
        Thread.sleep(delay);

        // клик на кнопку списка [Выход]
        webDriver.findElement(By.cssSelector("span[id='menuitem-1051-textEl']")).click();
        Thread.sleep(delay);

        // клик на кнопку формы выхода из аккаунта [Да]
        webDriver.findElement(By.cssSelector("span[id='button-1014-btnIconEl']")).click();
        Thread.sleep(delay);


        // Удаление файлов cookies в браузере---------------------------------------------------------------------------
        // удаляем все cookie в браузере
        webDriver.manage().deleteAllCookies();


        // Открытие формы авторизации-----------------------------------------------------------------------------------
        // клик на конпку [Вход]
        webDriver.findElement(By.id("btn-log")).click();
        Thread.sleep(delay);
        // клик на кнопку [Войти]
        webDriver.findElement(By.id("btn-login")).click();
        Thread.sleep(delay);


        // Содержится ли строка "Личность пользователя неопределена" на ткекущей странице браузера
        boolean isTextInContent = webDriver.findElement(By.xpath("//html")).getText().contains("Личность пользователя неопределена");
        Thread.sleep(delay);
        // if (isTextInContent=true) {} -> Ok!
        Assert.assertTrue(isTextInContent);
        Thread.sleep(delay);


        // клик на сообщение с текстом "Личность пользователя неопределена"
        webDriver.findElement(By.className("message-container")).click();
        Thread.sleep(delay);


        // клик на ссылку 'Зарегистрироваться'
        webDriver.findElement(By.cssSelector("a[class='registration-button']")).click();
        Thread.sleep(delay);
        // клик на кнопку-крестик закрытия окна
        webDriver.findElement(By.className("fancybox-close")).click();
        Thread.sleep(delay);


        // Открытие формы авторизации-----------------------------------------------------------------------------------
        // клик на кнопку [Войти]
        webDriver.findElement(By.id("btn-log")).click();
        Thread.sleep(delay);
        // клик на ссылку 'Забыли пароль?'
        webDriver.findElement(By.id("link-forgot")).click();
        Thread.sleep(delay);
        // клик на кнопку-крестик закрытия окна
        webDriver.findElement(By.cssSelector("a[class='fancybox-item fancybox-close']")).click();
        Thread.sleep(delay);


        // Открытие формы авторизации-----------------------------------------------------------------------------------
        // клик на кнопку [Войти]
        webDriver.findElement(By.id("btn-log")).click();
        Thread.sleep(delay);
        // клик на ссылку 'завершить регистрацию?'
        webDriver.findElement(By.cssSelector("a[class='fancy-log link-activate-number'")).click();
        Thread.sleep(delay);
        // клик на кнопку-крестик закрытия окна
        webDriver.findElement(By.cssSelector("a[class='fancybox-item fancybox-close']")).click();
        Thread.sleep(delay);


        Thread.sleep(2 * delay);
        // закрыть браузер
        webDriver.quit();
    }

}
