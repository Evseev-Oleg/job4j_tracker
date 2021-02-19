package ru.job4j.lambda;

import java.util.stream.Stream;

public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(a -> Stream.of(Value.values())
                .map(b -> a + " " + b))
                .forEach(System.out :: println);

    }
}
