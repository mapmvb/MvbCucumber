package com.luxoft.steps;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

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
            Auxillary.driver.manage().timeouts().implicitlyWait(Duration.of(5, ChronoUnit.SECONDS));
//            Auxillary.driver.navigate().to("https://the-internet.herokuapp.com/login");
        }
    }

    @AfterAll
    public static void tearDown1(){
        Auxillary.driver.close();
    }

    @After
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep((1000));
        if (scenario.isFailed()){
            // Take screenshot
            System.out.println("Take screenshot!");
            final byte[] screenshot = ((TakesScreenshot) Auxillary.driver).getScreenshotAs(OutputType.BYTES);
//            final byte[] screenshot = ((TakesScreenshot) auxillary.getWebdriver().get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());  //...and embed it in the report
        }
//        Auxillary.driver.navigate().to("https://the-internet.herokuapp.com/login");
//        Auxillary.driver.close();
    }

    @After
    public void afterHook() {
        System.out.println("the end");
    }
}
