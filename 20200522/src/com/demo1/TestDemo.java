package com.demo1;

import java.util.Objects;

/**
 * program: 20200522
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-25 19
 * Time:58
 */
class Card{
    public int rank;//数值
    public String suit;//花色

    public Card(int rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof Card)) {
            return false;
        }
        Card tmp = (Card)obj;
        if (this.rank == tmp.rank && this.suit.equals(tmp.suit)) {
            return true;
        }
        return false;
    }
}
public class TestDemo {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        System.out.println(a > b);//false
        System.out.println(a < b);//true
        System.out.println(a == b);//false
        char c1 = 'A';
        char c2 = 'B';
        System.out.println(c1 > c2);//false
        System.out.println(c1 < c2);//true
        System.out.println(c1 == c2);//false
        boolean b1 = true;
        boolean b2 = false;
        System.out.println(b1 == b2);//false
        System.out.println(b1 != b2);//true
    }

    public static void main1(String[] args) {
        Card card1 = new Card(5,"♥");
        Card card2 = new Card(5,"♥");
        System.out.println(card1 == card2);
        System.out.println(card1.equals(card2));
    }
}
