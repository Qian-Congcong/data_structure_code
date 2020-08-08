package com.demo3;

import java.util.HashSet;
import java.util.Scanner;

/**
 * program: 20200526
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-28 19
 * Time:06
 */
public class TestDemo {
    public int numJewelsInStones(String J, String S) {
        int count = 0;
        for (int i = 0; i < J.length(); i++) {
            for (int j = 0; j < S.length(); j++) {
                if(J.charAt(i) == S.charAt(j)) {
                    count++;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expected = scanner.nextLine();//7_This_is_a_test
        String actual = scanner.nextLine();//_hs_s_a_es

        //1、把实际的字符转换为大写存放到集合当中
        HashSet<Character> setActual = new HashSet<>();
        for (char s : actual.toUpperCase().toCharArray()) {
            setActual.add(s);
        }

        HashSet<Character> setBroken = new HashSet<>();
        for (char t : expected.toUpperCase().toCharArray()) {
            if (!setActual.contains(t) && !setBroken.contains(t)) {
                System.out.print(t);
                setBroken.add(t);
            }
        }
    }
}
