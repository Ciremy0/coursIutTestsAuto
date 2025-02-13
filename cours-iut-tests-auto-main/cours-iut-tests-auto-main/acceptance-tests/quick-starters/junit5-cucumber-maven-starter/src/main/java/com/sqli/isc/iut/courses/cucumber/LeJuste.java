package com.sqli.isc.iut.courses.cucumber;

public class LeJuste {
    private int nbAvailablePlaces = 10;
    private boolean canEnter;
    private int monthlyCocktailPrice = 0;



	public void setNbAvailablePlaces(int int1) {
		this.nbAvailablePlaces=int1;
	}

    public int getNbAvailablePlaces() {
		return this.nbAvailablePlaces;
    }

    public void setMonthlyCocktailPrice(int price) {
		this.monthlyCocktailPrice=price;
	}

    public int getMonthlyCocktailPrice() {
		return this.monthlyCocktailPrice;
    }

    public boolean makePeopleEnter(int nbPersons) {
        if(this.canEnter){ this.nbAvailablePlaces -= nbPersons;return true;}
        return false;
    }

    public void checkPeopleNb(int nbPersons){
        if(this.nbAvailablePlaces-nbPersons<0) {
            this.canEnter = false;
        }
        else this.canEnter = true;
    }

    public boolean getCanEnter() {
        return this.canEnter;
    }






}
