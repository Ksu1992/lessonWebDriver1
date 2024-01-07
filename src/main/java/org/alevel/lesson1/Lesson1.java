package org.alevel.lesson1;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Lesson1 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://jobs.dou.ua/");
        WebElement input=driver.findElement(By.xpath("//input[@class='job']"));

        WebElement searchButton =driver.findElement(By.xpath("//input[@value='Знайти']"));
input.clear();
input.sendKeys("Team lead");
searchButton.click();

driver.quit();


    }
}