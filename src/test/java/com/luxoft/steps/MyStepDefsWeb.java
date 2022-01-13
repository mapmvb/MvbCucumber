package com.luxoft.steps;

import com.luxoft.Calc;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;

import java.util.List;
import java.util.Map;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class MyStepDefsWeb {

    private int distance1;

    @Given("I enter {string} to the field {string}")
    public void iEnterToTheField(String arg0, String arg1) {
    }
}



