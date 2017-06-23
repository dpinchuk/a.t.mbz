import testClasses.frontpage.TestFrontPage;

import java.util.Date;

/**
 * Created by Pinchuk Dmitry - QA Departament of Mobizon GMBH
 */

public class Main {
    public static void main(String[] args) throws Exception {
        // минимальное количество цифр в номере
        int minDigitsInNumbers = 11;
        // максимальное количество цифр в номере
        int maxDigitsInNumbers = 15;

        // URL of test site
        //String site = "http://mobizon.kz";
        String site = "http://kz.z.mobizon.net.ua";
        // задержка главного потока исполнения на delay/1000 секунд
        long delay = 2000;
        // Максимальное число для диапазона
        final int max = 10000000;
        // Берем последние 7 цифр из new Date().getTime()
        long time = new Date().getTime() - (new Date().getTime() / 10000000) * 10000000;

        // Login test data----------------------------------------------------------------------------------------------
        String testNameLogin = "TestNameLogin"; // имя
        String testSurnameLogin = "TestSurnameLogin"; // фамилия
        String testEmailLogin = "dmss.dndz.dap@yandex.ru"; // email
        String testNumberLogin = "380968353340"; // номер телефона
        String testPasswordLogin = "01010888"; // пароль
        String testPasswordConfirmLogin = "01010888"; // подтверждение пароля

        // Registration test data---------------------------------------------------------------------------------------
        String testNameRegistration = "TestNameRegistration" + time; // имя
        String testSurnameRegistration = "TestSurnameRegistration" + time; // фамилия
        String testEmailRegistration = "test" + time + "@test.test"; // email
        String testNumberRegistration = getPartOfNumber("7707", max, minDigitsInNumbers); // номер телефона
        String testPasswordRegistration = "01010888"; // пароль
        String testPasswordConfirmRegistration = "01010888"; // подтверждение пароля

        // Test data----------------------------------------------------------------------------------------------------
        String testNumberTest = getPartOfNumber("7707", max, minDigitsInNumbers); // номер телефона
        String testNameTest = "TestNameTest"; // имя
        String scroll = "2600";

        //TestAuthorizationLoginPositive testAuthorizationPositive = new TestAuthorizationLoginPositive(site, delay, testNameLogin, testEmailLogin, testSurnameLogin, testNumberLogin, testPasswordLogin, testPasswordConfirmLogin);
        //testAuthorizationPositive.testAuthorizationPositive();

        //TestAuthorizationPasswordRecoveryPositive testAuthorizationPasswordRecoveryPositive = new TestAuthorizationPasswordRecoveryPositive(site, delay, testNameLogin, testEmailLogin, testSurnameLogin, testNumberLogin, testPasswordLogin, testPasswordConfirmLogin);
        //testAuthorizationPasswordRecoveryPositive.testAuthorizationPasswordRecoveryPositive();

        //TestRegistrationPositive testRegistrationPositive = new TestRegistrationPositive(site, delay, testNameRegistration, testSurnameRegistration, testEmailRegistration, testNumberRegistration, testPasswordRegistration, testPasswordConfirmRegistration);
        //testRegistrationPositive.testRegistrationPositive();

        TestFrontPage testFrontPage = new TestFrontPage(site, delay, testNumberTest, testNameTest, scroll);
        testFrontPage.testFrontPage();
    }

    // метод возвращает номер телефона, начинающийся со 'string' и с количеством цифр равным 'minDigitsInNumbers'
    private static String getPartOfNumber(String string, int max, int minDigitsInNumbers) {
        String testNumberRegistration = "";
        while (testNumberRegistration.length() != minDigitsInNumbers) {
            testNumberRegistration = string + (int) (Math.random() * max);
        }

        return testNumberRegistration;
    }

}