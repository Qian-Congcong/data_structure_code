package com.demo2;

import java.util.*;

/**
 * program: 20200515
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-16 17
 * Time:43
 */

/**
 * 员工的重要性
 */
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
public class TestMain {



    /**二维网格迁移
     * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
     * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
     * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
     *
     * @param grid
     * @param k
     * @return
     */
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        while (k > 0) {
            int previous = grid[grid.length - 1][grid[0].length - 1];
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    int tmp = grid[i][j];
                    grid[i][j] = previous;
                    previous = tmp;
                }
            }
            k--;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int[] s: grid) {
            List<Integer> listRow = new ArrayList<>();
            result.add(listRow);
            for (int v: s) {
                listRow.add(v);
            }
        }
        return result;
    }

    /**
     * 将数组分成和相等的三部分
     * @param A
     * @return
     */
    public boolean canThreePartsEqualSum(int[] A) {
        int sum = 0;
        for (int i: A) {
            sum += i;
        }
        if (sum%3 != 0) {
            return false;
        }
        int left = 0;
        int leftSum = A[left];
        int right = A.length - 1;
        int rightSum = A[right];
        while (left + 1 < right) {
            if (leftSum == sum/3 && rightSum == sum/3) {
                return true;
            }
            if (leftSum != sum/3) {
                leftSum += A[++left];
            }
            if (rightSum != sum/3) {
                rightSum += A[--right];
            }
        }
        return false;
    }

    public int findJudge(int N, int[][] trust) {
        /*int inDegree[] = new int[N + 1];
        int outDegree[] = new int[N + 1];
        for (int[] path : trust) {
            int start = path[0];
            int end = path[1];
            inDegree[end]++;
            outDegree[start]++;
        }
        for (int i = 1; i <= N; i++) {
            if(outDegree[i] == 0 && inDegree[i] == N - 1) {
                return i;
            }
        }
        return -1;*/

        int[][] counter = new int[N + 1][N + 1];
        for (int[] ints : trust) {
            counter[ints[0]][0]++; // 出度
            counter[ints[1]][1]++; // 入度
        }
        for (int i = 1; i <= N; i++) {
            // 法官的 出度 - 入度 等于 N - 1
            if (counter[i][1] - counter[i][0] == N - 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {

    }

    Map<Integer,Employee> emap;
    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for (Employee e: employees) {
            emap.put(e.id, e);
        }
        return func(id);
    }

    public int func(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid: employee.subordinates) {
            ans += func(subid);
        }
        return ans;
    }
}
