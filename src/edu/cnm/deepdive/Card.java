package edu.cnm.deepdive;

public class Card implements Comparable<Card>{

  private final Rank rank; // set these private and final to avoid being changed -- immutable
  private final Suit suit;

  public Card(Rank rank, Suit suit) {
    this.rank = rank;
    this.suit = suit;
  }

  public Rank getRank() { //getters or, accessor method that allows you to access private vars
    return rank;
  }

  public Suit getSuit() {
    return suit;
  }

  @Override
  public String toString() {
    return String.format("%s%s (%s)", rank.abbreviation(), suit.abbreviation(), suit.getColor());
  }

  @Override
  public int compareTo(Card other) {
    int result  = getSuit().getColor().compareTo(other.getSuit().getColor());
    if (result == 0) {
      result = suit.compareTo(other.suit);
      if (result == 0) {
        result = rank.compareTo(other.rank);
      }
    }
    return result;
  }
}
