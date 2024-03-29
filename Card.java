package com.company;

import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class Card{
    private String faceName, suit;
    //private Image image;
    public Card(String faceName, String suit) {
        setFaceName(faceName);
        setSuit(suit);
    }

    public void setFaceName(String faceName) {
        List<String> validFaceNames = getValidFaceNames();
        faceName = faceName.toLowerCase();

        if(validFaceNames.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException("Valid Faces Are: "+ validFaceNames);
    }

    public void setSuit(String suit) {
        List<String> validSuits = geValidSuits();
        suit = suit.toLowerCase();
        if(validSuits.contains(suit)){
            this.suit = suit;
        }
        else
            throw new IllegalArgumentException("Valid Suits Are: "+ validSuits);

    }

    public String getFaceName() {
        return faceName;
        //2,3,4,5,6,7,8,9,10,j,q,k
    }

    public String getSuit() {
        return suit;
    }
    public static List<String> getValidFaceNames(){
        return Arrays.asList("2","3","4","5","6","7","8","9","10","jack","queen","king","ace");
    }
    public static List<String> geValidSuits(){
        return Arrays.asList("hearts","diamonds","spades","clubs");
    }

    @Override
    public String toString() {
        return String.format("%s of %s", faceName, suit);
    }
}