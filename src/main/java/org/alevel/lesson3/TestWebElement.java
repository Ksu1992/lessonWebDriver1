package org.alevel.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class TestWebElement {
    public static void main(String[] args) {
        //  WebDriver
        System.setProperty("webdriver.firefox.driver", "path_to_chromedriver");

        WebDriver driver = new FirefoxDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        try {
            // Відкриття Google форми
            driver.get("https://accounts.google.com/AccountChooser/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser&ec=asw-gmail-globalnav-signin&theme=glif");

            // Введення некоректного значення
            WebElement inputBox = driver.findElement(By.xpath("//input[@name='identifier']"));
            inputBox.sendKeys("parusna.ksu@gmail");

            // Натискання кнопки "Далі"
            WebElement nextButton = driver.findElement(By.id("identifierNext"));
            nextButton.click();

            // Очікування з'явлення валідаційного повідомлення
            WebElement validationMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(), 'Введіть дійсні електронну адресу або номер телефону')]")));

            // Перевірка тексту повідомлення
            if (validationMessage.getText().contains("Введіть дійсні електронну адресу або номер телефону")) {
                System.out.println("Валідаційне повідомлення відображено коректно.");
            } else {
                System.out.println("Валідаційне повідомлення відсутнє або відрізняється.");
            }

        } catch (Exception e) {
            System.out.println("Помилка при виконанні тесту: " + e.getMessage());
        } finally {
            // Закриття браузера
            driver.quit();
        }
    }
}
