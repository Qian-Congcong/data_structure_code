package com.demo2;

/**
 * program: 20200517
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-18 16
 * Time:14
 */
public class TestDemo {

    public static void main1(String[] args) {
        StockSpanner obj = new StockSpanner();
        int param_1 = obj.next(31);
        System.out.println(param_1);
        int param_2 = obj.next(41);
        System.out.println(param_2);
        int param_3 = obj.next(46);
        System.out.println(param_3);
        int param_4 = obj.next(59);
        System.out.println(param_4);
        int param_5 = obj.next(79);
        System.out.println(param_5);

    }


}
