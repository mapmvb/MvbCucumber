package com.luxoft.steps;

import com.luxoft.Calc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyStepdefs {
    Calc calc = new Calc();

    private int distance1;
    @Given("show how background works")
    public void showHowBackgroundWorks() {
        System.out.println("222222222");
    }

    @Given("^Macy is in (\\d+) m from Kean$")
    public void macyIsInMFromKean(int arg0) {
        distance1 = arg0;
    }

    @When("^Kean shouts '([^\"]*)'$")
    public void keanShouts(String arg0) {
        System.out.println(arg0);
    }

    @Then("^.acy \\w+ Kean message$")
    public void macyHearsKeanMessage() { Assertions.assertTrue(distance1<15);
    }

    @Given("numbers are")
    public void numbersAre(List<String> data) {
        for(String value:data) {
            System.out.println(value);
        }

    }

    @Given("x divides y")
    public void xDividesY(List<List<Integer>> data) {
        Calc calc = new Calc();
        for (int i=0; i<data.size(); i++){
//            assertThat(calc.isXdividesY(data.get(i).get(0), data.get(i).get(1)), is(true));
//            assertThat(calc.isXdividesY(data.get(i).get(0),data.get(i).get(1)), is);
            assertThat(calc.isXdividesY(data.get(i).get(0), data.get(i).get(1)), is(true));
        }


    }

    @Given("x divides y map")
    public void xDividesYMap(Map<String,String> data) {
        data.forEach((K,V)->
                assertThat(calc.isXdividesY(Integer.parseInt(K),Integer.parseInt(V)), is(true)));

    }

    @Given("x divides y dt")
    public void xDividesYDt(DataTable dt) {
        for(int i=1;i<dt.height();i++) {
            assertThat(calc.isXdividesY(Integer.parseInt(dt.row(i).get(0)),
                    Integer.parseInt(dt.row(i).get(1))),is(true));
        }

    }
}
