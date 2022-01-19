package com.luxoft.steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.bs.A;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
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

    @Before(value = "@web")
    public void startUpDriver(){
        if(Auxillary.driver==null){
            WebDriverManager.chromedriver().setup();
            Auxillary.driver = new ChromeDriver();
            Auxillary.driver.navigate().to("https://the-internet.herokuapp.com/login");
        }
    }

    @After(value = "@web")
    public void tearDown(Scenario scenario) throws InterruptedException {
        Thread.sleep((3000));
        if (scenario.isFailed()){
            // Take screenshot
            final byte[] screenshot = ((TakesScreenshot) Auxillary.driver).getScreenshotAs(OutputType.BYTES);
//            final byte[] screenshot = ((TakesScreenshot) auxillary.getWebdriver().get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png",scenario.getName());  //...and embed it in the report
        }
        Auxillary.driver.navigate().to("https://the-internet.herokuapp.com/login");
//        Auxillary.driver.close();
    }

    @After
    public void afterHook() {
        System.out.println("the end");
    }
}
