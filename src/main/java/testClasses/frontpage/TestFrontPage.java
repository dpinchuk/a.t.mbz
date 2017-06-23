package testClasses.frontpage;

import controllers.BrowserController;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Pinchuk Dmitry - QA Departament of Mobizon GMBH
 */

public class TestFrontPage {

    private static WebDriver webDriver;
    private String site;
    private long delay;
    private String testNumberTest;
    private String testNameTest;
    private String scroll;
    //private WebElement webElement;

    public TestFrontPage(String site, long delay, String testNumberTest, String testNameTest, String scroll) {
        this.site = site;
        this.delay = delay;
        this.testNumberTest = testNumberTest;
        this.testNameTest = testNameTest;
        this.scroll = scroll;
    }

    @Test
    public void testFrontPage() throws Exception {
        // инициализация web-драйвера
        webDriver = new BrowserController(site, delay).initBrowser();
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;

// Скролл страницы down/up
        //javascriptExecutor.executeScript("window.scrollBy(0, " + scroll + ")", "");
        //Thread.sleep(delay);
        //javascriptExecutor.executeScript("window.scrollBy(0, -" + scroll + ")", "");
        //Thread.sleep(delay);


// Элемент верхнего 'SMS Рассылка'--------------------------------------------------------------------------------------
        // навести указатель мыши на элемент верхнего меню 'SMS Рассылка'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/bulk-sms']")));
        Thread.sleep(delay);

        // клик на элемент верхнего меню 'SMS Рассылка'
        webDriver.findElement(By.cssSelector("a[href='/bulk-sms']")).click();
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'SMS Рассылка'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/bulk-sms']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'СМС рассылка с нашего сайта'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/bulk-sms/online']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'СМС шлюз для сайта и ПО'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/bulk-sms/gateway']")));
        Thread.sleep(delay);
        // навести указатель мыши на элемент верхнего меню 'СМС шлюз для сайта и ПО' -> Подключение к SMS API
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/bulk-sms/gateway/api']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'СМС реклама'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/sms-advertising']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'Коммерческое предложение'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/bulk-sms/sms-offer']")));
        Thread.sleep(delay);


// Элемент верхнего меню 'QR Коды'--------------------------------------------------------------------------------------
        // навести указатель мыши на элемент верхнего меню 'QR Коды'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/qr-codes']")));
        Thread.sleep(delay);
        // клик на элемент верхнего меню 'QR Коды'
        webDriver.findElement(By.cssSelector("a[href='/qr-codes']")).click();
        Thread.sleep(delay);


// Элемент верхнего меню 'Инфоцентр'------------------------------------------------------------------------------------
        // навести указатель мыши на элемент верхнего меню 'Инфоцентр'
        setMousePointer(webDriver.findElement(By.cssSelector("a[class='not-clickable sf-with-ul']")));
        Thread.sleep(delay);

        // клик на элемент верхнего меню 'Инфоцентр'
        webDriver.findElement(By.cssSelector("a[class='not-clickable sf-with-ul']")).click();
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'Инфоцентр'
        setMousePointer(webDriver.findElement(By.cssSelector("a[class='not-clickable sf-with-ul']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'Видео уроки'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/bulk-sms/video']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'Вопросы и ответы'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/faq']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'Правила пользования'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/rules']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'Статьи'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/articles']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'Новости'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/news']")));
        Thread.sleep(delay);

        // навести указатель мыши на элемент верхнего меню 'Документы'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/docs']")));
        Thread.sleep(delay);


// Элемент верхнего меню 'Цены'-----------------------------------------------------------------------------------------
        // навести указатель мыши на элемент верхнего меню 'Цены'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/prices']")));
        Thread.sleep(delay);
        // клик на элемент верхнего меню 'Цены'
        webDriver.findElement(By.cssSelector("a[href='/prices']")).click();
        Thread.sleep(delay);


 // Элемент верхнего меню 'Контакты'------------------------------------------------------------------------------------
        // навести указатель мыши на элемент верхнего меню 'Контакты'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='/contacts']")));
        Thread.sleep(delay);
        // клик на элемент верхнего меню 'Контакты'
        webDriver.findElement(By.cssSelector("a[href='/contacts']")).click();
        Thread.sleep(delay);


// Кнопка верхнего меню [mobizon]---------------------------------------------------------------------------------------
        // навести указатель мыши на кнопку [mobizon]
        setMousePointer(webDriver.findElement(By.cssSelector("a[class='logo-container default']")));
        Thread.sleep(delay);
        // клик на кнопку [mobizon]
        webDriver.findElement(By.cssSelector("a[class='logo-container default']")).click();
        Thread.sleep(delay);


//// Клик на видео--------------------------------------------------------------------------------------------------------
        // навести указатель мыши на видео на сайте
        //setMousePointer(webDriver.findElement(By.cssSelector("a[class='html5-video-player unstarted-mode ytp-hide-controls ytp-hide-info-bar ytp-small-mode']")));
        //setMousePointer(webDriver.findElement(By.className("ytp-thumbnail-overlay-image")));
        //Thread.sleep(delay);
        // клик на кнопку [mobizon]
        //webDriver.findElement(By.cssSelector("a[class='html5-video-player unstarted-mode ytp-hide-controls ytp-hide-info-bar ytp-small-mode']")).click();
        //webDriver.findElement(By.cssSelector("ytp-thumbnail-overlay-image")).click();
        //Thread.sleep(delay);


// Блок 'Основные услуги'-----------------------------------------------------------------------------------------------
        // навести указатель мыши на блок 'СМС рассылка'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='https://mobizon.kz/bulk-sms']")));
        Thread.sleep(delay);
        // навести указатель мыши на блок 'СМС реклама'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='https://mobizon.kz/sms-advertising']")));
        Thread.sleep(delay);
        // навести указатель мыши на блок 'SMS API'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='https://mobizon.kz/bulk-sms/gateway']")));
        Thread.sleep(delay);
        // навести указатель мыши на блок 'QR-коды'
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='https://mobizon.kz/qr-codes']")));
        Thread.sleep(delay);


// Отправка тестового СМС-----------------------------------------------------------------------------------------------
        // установить курсор в поле ввода номера телефона
        webDriver.findElement(By.className("phone-field")).click();
        Thread.sleep(delay);

        // очистить поле ввода номера телефона
        webDriver.findElement(By.className("phone-field")).clear();
        Thread.sleep(delay);

        // ввести в поле тестовый номер
        webDriver.findElement(By.className("phone-field")).sendKeys(testNumberTest);
        Thread.sleep(delay);

// !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        //Thread.sleep(delay);
        // клик на reCaptcha
        //webDriver.findElement(By.xpath("//label[@id='recaptcha-anchor-label']")).click();
        //webDriver.findElement(By.cssSelector("div.recaptcha-checkbox-checkmark")).click();
        //Thread.sleep(delay);

        // клик на кнопку [Отправить]
        //webDriver.findElement(By.cssSelector("button[id='ts-form-button']")).click();
        //Thread.sleep(delay);

        // навести указатель мыши на recaptcha
        //setMousePointer(webDriver.findElement(By.cssSelector("div[class='rc-anchor-pt']")));
        Thread.sleep(delay);


// Виджет обратной связи 'трубка телефона'------------------------------------------------------------------------------
        // Навести указатель мыши на виджет 'трубка телефона'
        setMousePointer(webDriver.findElement(By.cssSelector("i[class='fa fa-phone buzz']")));
        Thread.sleep(delay);

        // Клик на виджет 'трубка телефона'
        webDriver.findElement(By.cssSelector("i[class='fa fa-phone buzz']")).click();
        Thread.sleep(delay);

        // Навести указатель мыши на иконку-крестик закрытия формы 'трубка телефона'
        setMousePointer(webDriver.findElement(By.cssSelector("a[class='fancybox-item fancybox-close']")));
        Thread.sleep(delay);

        // Клик на иконку-крестик закрытия формы 'трубка телефона'
        webDriver.findElement(By.cssSelector("a[class='fancybox-item fancybox-close']")).click();
        Thread.sleep(delay);

        // Клик на виджет 'трубка телефона'
        webDriver.findElement(By.cssSelector("i[class='fa fa-phone buzz']")).click();
        Thread.sleep(delay);

        // Установить курсор в поле ввода номера
        setMousePointer(webDriver.findElement(By.cssSelector("input[id='cb-form-phone']")));
        Thread.sleep(delay);

        // Очистить поле ввода номера
        webDriver.findElement(By.cssSelector("input[id='cb-form-phone']")).clear();
        Thread.sleep(delay);

        // Ввести тестовый номер телефона в поле ввода номера
        webDriver.findElement(By.cssSelector("input[id='cb-form-phone']")).sendKeys(testNumberTest);
        Thread.sleep(delay);

        // Установить курсор в поле ввода имени
        setMousePointer(webDriver.findElement(By.cssSelector("input[id='cb-form-name']")));
        Thread.sleep(delay);

        // Очистить поле ввода имени
        webDriver.findElement(By.cssSelector("input[id='cb-form-name']")).clear();
        Thread.sleep(delay);

        // Ввести тестовое имя
        webDriver.findElement(By.cssSelector("input[id='cb-form-name']")).sendKeys(testNameTest);
        Thread.sleep(delay);

        // Навести указатель мыши на кнопку [Отправить]
        setMousePointer(webDriver.findElement(By.cssSelector("button[id='cb-form-button']")));
        Thread.sleep(delay);

        // Клик на кнопку [Отправить]
        webDriver.findElement(By.cssSelector("button[id='cb-form-button']")).click();
        Thread.sleep(delay);

        // Клик на виджет 'трубка телефона'
        webDriver.findElement(By.cssSelector("i[class='fa fa-phone buzz']")).click();
        Thread.sleep(3 * delay);

        // Установить курсор в поле ввода номера
        setMousePointer(webDriver.findElement(By.cssSelector("input[id='cb-form-phone']")));
        Thread.sleep(delay);

        // Очистить поле ввода номера
        webDriver.findElement(By.cssSelector("input[id='cb-form-phone']")).clear();
        Thread.sleep(delay);

        // Ввести тестовый номер телефона в поле ввода номера
        webDriver.findElement(By.cssSelector("input[id='cb-form-phone']")).sendKeys(testNumberTest);
        Thread.sleep(delay);

        // Установить курсор в поле ввода имени
        setMousePointer(webDriver.findElement(By.cssSelector("input[id='cb-form-name']")));
        Thread.sleep(delay);

        // Очистить поле ввода имени
        webDriver.findElement(By.cssSelector("input[id='cb-form-name']")).clear();
        Thread.sleep(delay);

        // Ввести тестовое имя
        webDriver.findElement(By.cssSelector("input[id='cb-form-name']")).sendKeys(testNameTest);
        Thread.sleep(delay);

        // Клик на radiobutton 'В указанное время'
        webDriver.findElement(By.cssSelector("a[class='toggle-radio']")).click();
        Thread.sleep(delay);

        // Клик на dropbox времени начала
        setMousePointer(webDriver.findElement(By.cssSelector("a[href='javascript:void(0)']")));
        Thread.sleep(delay);
        webDriver.findElement(By.cssSelector("a[href='javascript:void(0)']")).click();
        WebElement webElement = webDriver.findElement(By.cssSelector("div[id='s2id_cb-form-time-from"));
        Thread.sleep(delay);

        javascriptExecutor.executeScript("javascript:void(0)", webElement);
        Thread.sleep(delay);
        javascriptExecutor.executeScript("javascript:void(0)", webElement);
        Thread.sleep(delay);

        //javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");


        //webDriver.switchTo().window("javascript:void(0)");




// Выход из теста-------------------------------------------------------------------------------------------------------
        Thread.sleep(2 * delay);
        // закрыть браузер
        webDriver.quit();
    }

    private static void setMousePointer(WebElement webElement) {
        Actions actions = new Actions(webDriver);
        actions.moveToElement(webElement).build().perform();
    }

}