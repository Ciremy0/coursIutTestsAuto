package com.sqli.isc.iut.courses.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;

@Cucumber
public class CucumberTest {

private LeJuste bar;
private int nbPersons;

@Given("Mr Pignon et Mr Leblanc go to Le Juste bar")
public void mr_pignon_et_mr_leblanc_go_to_le_juste_bar() {
    bar = new LeJuste();
    throw new io.cucumber.java.PendingException();
}



@Given("they are a group of {int} persons")
public void setGroupSize(Integer int1) {
    this.nbPersons = int1;  
    throw new io.cucumber.java.PendingException();
}



@Given("the bar have only {int} available places")
public void setAvailablePlaces(Integer int1) {
    this.bar.nbAvailablePlaces = int1;
    throw new io.cucumber.java.PendingException();
}



@Given("one available place in the bar")
public void one_available_place_in_the_bar() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}



@When("they ask to enter in the bar")
public void they_ask_to_enter_in_the_bar() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}



@Then("they are not accepted in the bar")
public void they_are_not_accepted_in_the_bar() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}



}
