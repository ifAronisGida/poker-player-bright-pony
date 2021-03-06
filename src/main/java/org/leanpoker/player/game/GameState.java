package org.leanpoker.player.game;

import com.google.gson.Gson;
import com.google.gson.JsonElement;

import java.util.ArrayList;
import java.util.List;

public class GameState {

    private String tournament_id;
    private String game_id;
    private int round;
    private int bet_index;
    private int small_blind;
    private int current_buy_in;
    private int pot;
    private int minimum_raise;
    private int dealer;
    private int orbits;
    private int in_action;
    private List<Bot> players = new ArrayList<>();
    private List<Card> community_cards = new ArrayList<>();

    public int getValueOfCombination() {
        int value = 0;
        int straightValue = 0;
        int matches = 0;

        List<Card> allCards = new ArrayList<>();

        allCards.addAll(community_cards);
        allCards.addAll(getPlayerByName("Bright Pony").getHole_cards());

        for (Card card: getPlayerByName("Bright Pony").getHole_cards()) {
            value -= card.getValue();
            for (Card card1: allCards) {
                if (card.getValue() == card1.getValue()) {
                    value += card.getValue() * 2;
                    matches++;
                }
            }
        }


        if (matches > 2) value += 100;
        if (matches > 3) value += 100;
        if (matches > 4) value += 100;
        return value;
    }

    public String getTournament_id() {
        return tournament_id;
    }

    public String getGame_id() {
        return game_id;
    }

    public int getRound() {
        return round;
    }

    public int getBet_index() {
        return bet_index;
    }

    public int getSmall_blind() {
        return small_blind;
    }

    public int getCurrent_buy_in() {
        return current_buy_in;
    }

    public int getPot() {
        return pot;
    }

    public int getMinimum_raise() {
        return minimum_raise;
    }

    public int getDealer() {
        return dealer;
    }

    public int getOrbits() {
        return orbits;
    }

    public int getIn_action() {
        return in_action;
    }

    public List<Bot> getPlayers() {
        return players;
    }

    public List<Card> getCommunity_cards() {
        return community_cards;
    }

    public Bot getPlayerByName(String name) {
        for (Bot player : players) {
            if (player.getName().equals(name)) {
                return player;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "GameState{" +
                "tournament_id='" + tournament_id + '\'' +
                ", game_id='" + game_id + '\'' +
                ", round=" + round +
                ", bet_index=" + bet_index +
                ", small_blind=" + small_blind +
                ", current_buy_in=" + current_buy_in +
                ", pot=" + pot +
                ", minimum_raise=" + minimum_raise +
                ", dealer=" + dealer +
                ", orbits=" + orbits +
                ", in_action=" + in_action +
                ", players=" + players +
                '}';
    }

    public boolean haveStrongPairInHand() {
        Bot our_player = this.getPlayerByName("Bright Pony");
        String rankOfFirstCard = our_player.getHole_cards().get(0).getRank();
        String rankOfSecondCard = our_player.getHole_cards().get(1).getRank();
        int valueOfCard = our_player.getHole_cards().get(0).getValue();
            if (rankOfFirstCard.equals(rankOfSecondCard)) {
                return true;
            }
        return false;
    }


    public int checkPairs() {
        int pairCounter = 0;
        Bot ourPlayer = getPlayerByName("Bright Pony");
        String rankOfFirstCard = ourPlayer.getHole_cards().get(0).getRank();
        String rankOfSecondCard = ourPlayer.getHole_cards().get(1).getRank();
        if (rankOfFirstCard.equals(rankOfSecondCard)) {
            pairCounter++;
        }
        if (!community_cards.isEmpty()) {
            for (Card card : community_cards) {
                if (rankOfFirstCard.equals(card.getRank())) {
                    pairCounter++;
                }
                if (rankOfSecondCard.equals(card.getRank())) {
                    pairCounter++;
                }
            }
        }
        return pairCounter;
    }
}

