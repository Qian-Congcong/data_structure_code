package com.demo1;

import java.util.Arrays;

/**
 * program: 20200522
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-25 15
 * Time:47
 */
class Car{
    public int position;
    public double time;

    public Car(int p, double t) {
        this.position = p;
        this.time = t;
    }

}
public class TestMain {
    public int carFleet(int target, int[] position, int[] speed) {
        int N = position.length;
        Car[] cars = new Car[N];
        for (int i = 0; i < N; i++) {
            cars[i] = new Car(position[i], (double)(target - position[i])
                    /speed[i]);
        }
        Arrays.sort(cars, (a,b) -> Integer.compare(a.position, b.position));
        int ans = 0;
        int t = N;
        while (--t > 0) {
            if (cars[t].time < cars[t-1].time) {
                ans++;
            }else {
                cars[t-1] = cars[t];
            }
        }
        return ans + (t == 0 ? 1 : 0);
    }

    public static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = 0; j < nums.length - 1 - i; j++) {
                if (nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {2,0,2,1,1,0};
        System.out.println(Arrays.toString(array));
        sortColors(array);
        System.out.println(Arrays.toString(array));
    }
}
