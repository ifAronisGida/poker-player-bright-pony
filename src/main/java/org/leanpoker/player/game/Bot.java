package org.leanpoker.player.game;

import java.util.ArrayList;
import java.util.List;

public class Bot {

    private int id;
    private String name;
    private String status;
    private String version;
    private int stack;
    private int bet;
    private List<Card> hole_cards = new ArrayList<>();

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getVersion() {
        return version;
    }

    public int getStack() {
        return stack;
    }

    public int getBet() {
        return bet;
    }

    public List<Card> getHole_cards() {
        return hole_cards;
    }

    @Override
    public String toString() {
        return "Bot{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", status='" + status + '\'' +
                ", version='" + version + '\'' +
                ", stack=" + stack +
                ", bet=" + bet +
                ", hole_cards=" + hole_cards +
                '}';
    }
}
