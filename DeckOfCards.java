package com.company;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;
    //private Image backOfCardImage;

    public DeckOfCards(ArrayList<Card> deck) {
        this.deck = deck;
    }
    public DeckOfCards(){
        List<String> suits = Card.geValidSuits();
        List<String> faceNames = Card.getValidFaceNames();
        deck = new ArrayList<>();
        for(String suit: suits) {
            for(String faceName: faceNames){
                deck.add(new Card(faceName,suit));
            }
        }
    }

    @Override
    public String toString() {
        return "DeckOfCards = "+ deck;

    }
}