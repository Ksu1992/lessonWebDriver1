package org.alevel.lesson4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test; // Убедитесь, что импортировали аннотацию @Test
public class RozetkaTestActions {

    @Test
    public void contextClick() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://rozetka.com.ua/ua/");
        Thread.sleep(3000); // Лучше использовать WebDriverWait

        WebElement source = driver.findElement(By.xpath("//button[contains(@class, 'button_color_green')]"));
        Actions actions = new Actions(driver);
        actions.contextClick(source).perform();

        driver.quit();
    }
}
