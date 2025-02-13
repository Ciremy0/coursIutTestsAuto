package com.sqli.isc.iut.courses.cucumber;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.junit.platform.engine.Cucumber;



@Cucumber
public class CucumberTest {

private LeJuste bar;
private int nbPersons;
private Personne pigeon = new Personne("Pignon",1000,0);
private Personne mrWhite = new Personne("leBlanc",1000,0);
private List<Personne> personneList = new ArrayList<>();
private Personne buyer;

@Given("Mr Pignon et Mr Leblanc go to Le Juste bar")
public void mr_pignon_et_mr_leblanc_go_to_le_juste_bar() {
    this.bar = new LeJuste();
}



@Given("they are a group of {int} persons")
public void setGroupSize(int nbPerso) {
    personneList.add(pigeon);
    personneList.add(mrWhite);
    this.nbPersons = nbPerso;
}



@Given("the bar have only {int} available places")
public void setAvailablePlaces(int place) {
    this.bar.setNbAvailablePlaces(place);
    assertEquals(10,this.bar.getNbAvailablePlaces());
}



@Given("{int} available place in the bar")
public void one_available_place_in_the_bar(int nbPlaces) {
    this.bar.setNbAvailablePlaces(nbPlaces);
    assertEquals(1,this.bar.getNbAvailablePlaces());
}



@When("they ask to enter in the bar")
public void they_ask_to_enter_in_the_bar() {
    assertFalse(this.bar.getCanEnter());
}

@Then("they are not accepted in the bar")
public void they_are_not_accepted_in_the_bar() {
    assertFalse(this.bar.makePeopleEnter(this.nbPersons));
}

@Given("{int} available places in the bar")
public void two_available_places_in_the_bar(int place) {
    this.bar.setNbAvailablePlaces(place);
    assertEquals(place,this.bar.getNbAvailablePlaces());
}

@When("they enter into the bar")
public void they_enter_into_the_bar() {
    this.bar.checkPeopleNb(this.nbPersons);
    assertTrue(this.bar.getCanEnter());
    assertTrue(this.bar.makePeopleEnter(this.nbPersons));
}
@Then("the bar shows full")
public void the_bar_shows_full() {
    this.bar.setNbAvailablePlaces(0);
    assertEquals(0,this.bar.getNbAvailablePlaces());
}

@Then("the person behind them cannot enter in the bar")
public void the_person_behind_them_cannot_enter_in_the_bar() {
    this.bar.checkPeopleNb(1);
    assertFalse(this.bar.getCanEnter());
    assertFalse(this.bar.makePeopleEnter(1));
}

@Then("each order one cocktail of the month for {int} dollars")
public void each_order_one_cocktail_of_the_month_for_dollars(int glassPrice) {
    for (Personne p : this.personneList) {
        p.setnbGlasse(p.getnbGlasse()+1);
    }
    
    this.bar.setMonthlyCocktailPrice(glassPrice);
    assertEquals(1,pigeon.getnbGlasse());
    assertEquals(1,mrWhite.getnbGlasse());
    assertEquals(glassPrice,this.bar.getMonthlyCocktailPrice());
}

@Then("Mr Leblanc pays the receipt")
public void mr_leblanc_pays_the_receipt() {
    this.buyer = this.mrWhite;
    assertEquals(this.mrWhite,this.buyer);
}

@Then("after drinking their cocktails, they check the receipt and Mr Leblanc pays")
public void after_drinking_their_cocktails_they_check_the_receipt_and_mr_leblanc_pays() {
    int totalPrice = 0;
    for (Personne p : this.personneList) {
        totalPrice += (p.getnbGlasse() * this.bar.getMonthlyCocktailPrice());
    }
    this.buyer.setMoney(mrWhite.getMoney()-totalPrice);
    assertEquals(20,totalPrice);
    assertEquals(1000,pigeon.getMoney());
    assertEquals(980,mrWhite.getMoney());
}

@Then("Mr Pignon is happy because he drank only one drink \\(liver problem)")
public void mr_pignon_is_happy_because_he_drank_only_one_drink_liver_problem() {
    pigeon.setEmotion(Emotion.Happy);
    assertEquals(Emotion.Happy,this.pigeon.getEmotion());
}

public void resetData() {
    for (Personne p : this.personneList) {
        p.setMoney(1000);
        p.setnbGlasse(0);
    }
    this.bar.setNbAvailablePlaces(10);
}



@Given("{int} persons are in the bar")
public void persons_are_in_the_bar(int place) {
    this.resetData();
    this.bar.setNbAvailablePlaces(this.bar.getNbAvailablePlaces()-place);
    this.bar.checkPeopleNb(this.nbPersons);
    this.bar.makePeopleEnter(this.nbPersons);
    assertEquals(5,this.bar.getNbAvailablePlaces());
    assertTrue(this.bar.getCanEnter());
}


@Given("they each order a cocktail of the month costing {int} dollars")
public void they_each_order_a_cocktail_of_the_month_costing_dollars(int price) {
    for (Personne p : this.personneList) {
        p.setnbGlasse(p.getnbGlasse()+1);
    }
    this.bar.setMonthlyCocktailPrice(price);
    assertEquals(1,pigeon.getnbGlasse());
    assertEquals(1,mrWhite.getnbGlasse());
    assertEquals(price,this.bar.getMonthlyCocktailPrice());
}

@Given("each pays their own drink")
public void each_pays_their_own_drink() {
    this.buyer = new Personne("EveryOne",0,0);
}

@When("they finish their cocktail, each person check they receipt")
public void they_finish_their_cocktail_each_person_check_they_receipt() {
    // Imagine
}

@When("Mr Pignon pays but Mr Leblanc insists to order one more drink of the month")
public void mr_pignon_pays_but_mr_leblanc_insists_to_order_one_more_drink_of_the_month() {
    this.pigeon.setMoney(this.pigeon.getMoney()-this.bar.getMonthlyCocktailPrice());
    this.pigeon.setnbGlasse(0);
    assertEquals(990,this.pigeon.getMoney());
    assertEquals(0,this.pigeon.getnbGlasse());
}

@When("he orders {int} more drinks of the month to his bill")
public void he_orders_more_drinks_of_the_month_to_his_bill(int nbGlass) {
    this.mrWhite.setnbGlasse(this.mrWhite.getnbGlasse() + nbGlass
    );
    assertEquals(3,this.mrWhite.getnbGlasse());

}

@When("when they finished their drinks, Mr Leblanc check his receipt and pays")
public void when_they_finished_their_drinks_Mr_Leblanc_check_his_receipt_and_pays(){
    this.mrWhite.setMoney(this.mrWhite.getMoney()-(this.bar.getMonthlyCocktailPrice()*this.mrWhite.getnbGlasse()));
    this.mrWhite.setnbGlasse(0);
    assertEquals(970,this.mrWhite.getMoney());
    assertEquals(0,this.mrWhite.getnbGlasse());
}
@Then("Mr Pignon is sad because he knows that he will spend a bad night \\(liver problem)")
public void mr_pignon_is_sad_because_he_knows_that_he_will_spend_a_bad_night_liver_problem() {
    this.pigeon.setEmotion(Emotion.Sad);
    assertEquals(Emotion.Sad,this.pigeon.getEmotion());
}
}

