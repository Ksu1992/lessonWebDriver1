package org.alevel.lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestGoogleForm {
    public static void main(String[] args) {

        System.setProperty("webdriver.firefox.driver", "path_to_firefoxdriver");

        WebDriver driver = new FirefoxDriver();

        try {
            driver.get("https://accounts.google.com/AccountChooser/identifier?service=mail&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&flowName=GlifWebSignIn&flowEntry=AccountChooser&ec=asw-gmail-globalnav-signin&theme=glif");

            // Использование XPath для поиска элемента с определенным атрибутом name
            WebElement inputBox = driver.findElement(By.xpath("//input[@name='identifier']"));

            // Проверка, найден ли элемент и его placeholder
            if (inputBox != null) {
                String placeholderValue = inputBox.getAttribute("placeholder");
                if ("Електронна адреса або номер телефону".equals(placeholderValue)) {
                    System.out.println("Элемент с правильным placeholder найден");
                } else {
                    System.out.println("Найден элемент, но с другим placeholder");
                }
            }
        } catch (NoSuchElementException e) {
            System.out.println("Элемент не найден");
        } finally {
            // Закрытие браузера
            driver.quit();
        }
    }
}
