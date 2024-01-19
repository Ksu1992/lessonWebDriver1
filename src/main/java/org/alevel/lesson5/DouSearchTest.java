package org.alevel.lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;





public class DouSearchTest {
    private WebDriver driver;




    @BeforeMethod
    public void setUp() {
        System.setProperty("webdriver.firefox.driver", "path/to/firefoxdriver");
        driver = new FirefoxDriver();
        driver.get("https://dou.ua");
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @DataProvider(name = "searchQueries")
    public Object[][] createSearchQueries() {
        return new Object[][]{
                {"Selenium"},
                {"Java"}
        };
    }

    @Test(dataProvider = "searchQueries")
    public void testSearch(String query) {
        // Сохраняем текущий URL до выполнения поиска
        String originalUrl = driver.getCurrentUrl();

       //Пошук
        driver.findElement(By.name("q")).sendKeys(query);
        driver.findElement(By.xpath("//input[@id='txtGlobalSearch']")).click();


        // Получение нового URL
        String newUrl = driver.getCurrentUrl();

        // Проверка,что URL остался прежним
        Assert.assertEquals(newUrl, originalUrl, "URL изменился после выполнения поиска.");
    }

}






