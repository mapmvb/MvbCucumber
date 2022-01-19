package com.luxoft.page;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class MainPage extends CommonPage {
//first way
//    @FindBy(id = "username")
//    WebElement username;
//
//    @FindBy(name = "password")
//    WebElement password;

    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getElement(String name){
        WebElement obj = null;
        try {
            switch (name){
                case "username":
                    obj = driver.findElement(By.id("username")); break;
                case "password":
                    obj = driver.findElement(By.name("password")); break;
                case "login":
    //                obj = driver.findElement(By.className("radius")); break;   - my try, it also works
                    obj = driver.findElement(By.xpath("//button")); break;
                case "logout":
                    obj = driver.findElement(By.cssSelector(".icon-signout")); break;
            }
        } catch (NoSuchElementException e) {
//            Assertions.fail("element "+ name + " not found at the page");
            return null;
        }
        return obj;
    }
}
