package com.luxoft.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class Hooks {

    @Before(value = "@Shout", order = 10)
    public void firstHook(){
        System.out.println("333333");
    }

    @Before(order = 3)
    public void secondHook(){
        System.out.println("55555555");
    }

    @Before
    public void startUpDriver(){
        if(Auxillary.driver==null){
            WebDriverManager.chromedriver().setup();
            Auxillary.driver = new ChromeDriver();
            Auxillary.driver.navigate().to("https://the-internet.herokuapp.com/login");
        }
    }

    @After
    public void afterHook() {
        System.out.println("the end");
    }
}
