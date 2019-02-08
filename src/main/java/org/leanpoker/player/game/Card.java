package org.leanpoker.player.game;

public class Card {

    private String rank;
    private String suit;

    public String getRank() {
        return rank;
    }

    public String getSuit() {
        return suit;
    }

    public int getValue() {
        int toReturn;
        switch (rank) {
            case "2":
                toReturn = 2;
                break;
            case "3":
                toReturn = 3;
                break;
            case "4":
                toReturn = 4;
                break;
            case "5":
                toReturn = 5;
                break;
            case "6":
                toReturn = 6;
                break;
            case "7":
                toReturn = 7;
                break;
            case "8":
                toReturn = 8;
                break;
            case "9":
                toReturn = 9;
                break;
            case "10":
                toReturn = 10;
                break;
            case "J":
                toReturn = 11;
                break;
            case "Q":
                toReturn = 12;
                break;
            case "K":
                toReturn = 13;
                break;
            case "A":
                toReturn = 14;
                break;
            default: toReturn = 0;
        }
        return toReturn;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}

