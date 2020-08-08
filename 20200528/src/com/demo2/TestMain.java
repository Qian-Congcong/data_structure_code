package com.demo2;

import java.util.*;
import java.util.stream.Collectors;

/**
 * program: 20200528
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-29 10
 * Time:07
 */

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;

    public Employee(int id, int importance, List<Integer> subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = subordinates;
    }
}
public class TestMain {

    public static boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA.length == 0 || popA.length == 0 || popA.length != pushA.length) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i = 0; i < pushA.length; i++) {
            stack.push(pushA[i]);

            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        int[] array1 = {1,2,3,4,5};
        int[] array2 = {4,5,3,2,1};
        System.out.println(IsPopOrder(array1, array2));
    }

    Map<Integer, Employee> emap;

    public int getImportance(List<Employee> employees, int id) {
        emap = new HashMap<>();
        for (Employee e : employees) {
            emap.put(e.id, e);
        }
        return func(id);
    }

    public int func(int eid) {
        Employee employee = emap.get(eid);
        int ans = employee.importance;
        for (Integer subid : employee.subordinates) {
            ans += func(subid);
        }
        return ans;
    }


    public void main7(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(3);
        Employee array1 = new Employee(1,5,list);
        Employee array2 = new Employee(2,3,null);
        Employee array3 = new Employee(3,3,null);
        List<Employee> employees = new ArrayList<>();
        employees.add(array1);
        employees.add(array2);
        employees.add(array3);
        System.out.println(getImportance(employees, 1));
    }

    public static int firstUniqChar(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main6(String[] args) {
        String str = "leetcode";
        System.out.println(firstUniqChar(str));
    }

    public static int[] intersection1(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet<>();
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                set.add(nums1[i]);
                i++;
                j++;
            }else if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            }
        }
        int[] ret = new int[set.size()];
        int index = 0;
        for (int n : set) {
            ret[index++] = n;
        }
        return ret;
    }

    public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();
        for (Integer n : nums1) {
            set1.add(n);
        }
        HashSet<Integer> set2 = new HashSet<>();
        for (Integer n : nums2) {
            set2.add(n);
        }
        //仅保留该集合中包含在指定集合中的元素（可选操作）。
        set1.retainAll(set2);

        int[] ret = new int[set1.size()];
        int index = 0;
        for (int s : set1) {
            ret[index++] = s;
        }
        return ret;
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2,nums1);
        }
        Map<Integer,Integer> map = new HashMap<>();
        for (int n : nums1) {
            map.put(n, map.getOrDefault(n,0) + 1);
        }
        int k = 0;
        for (int n : nums2) {
            int cnt = map.getOrDefault(n,0);
            if (cnt > 0) {
                nums1[k++] = n;
                map.put(n, cnt-1);
            }
        }
        //将指定数组的指定范围复制到新数组中。
        return Arrays.copyOfRange(nums1,0,k);
    }

    public int[] intersect1(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0, j = 0, k = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                ++i;
            } else if (nums1[i] > nums2[j]) {
                ++j;
            } else {
                nums1[k++] = nums1[i++];
                ++j;
            }
        }
        return Arrays.copyOfRange(nums1, 0, k);
    }

    public static void main5(String[] args) {
        int[] array1 = {1, 2, 2, 1};
        int[] array2 = {2, 2};
        int[] ret = intersection(array1, array2);
        for (int s: ret) {
            System.out.print(s + " ");
        }
        System.out.println();
        System.out.println(Arrays.toString(ret));
    }


    public static boolean isIsomorphic(String s, String t) {
        return isIsomorphicHelper(s,t) && isIsomorphicHelper(t,s);
    }

    private static boolean isIsomorphicHelper(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (map.containsKey(c1)) {
                if (map.get(c1) != c2) {
                    return false;
                }
            }else {
                map.put(c1,c2);
            }
        }
        return true;
    }

    public static void main4(String[] args) {
        String s = "egg";
        String t = "add";
        System.out.println(isIsomorphic(s, t));
    }

    public static List<String> topKFrequent1(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: words) {
            map.put(s, map.getOrDefault(s,0) + 1);
        }
        List<String> candidates = new ArrayList<>(map.keySet());
        Collections.sort(candidates,(w1,w2) -> map.get(w1).equals(map.get(w2))
                ? w1.compareTo(w2) : map.get(w2) - map.get(w1));
        return candidates.subList(0,k);
    }

    /**
     * getOrDefault()  返回 key 对应的 value，key 不存在，返回默认值
     * get()    返回 key 对应的 value
     * keySet()     返回所有 key 的不重复集合
     * Collections.reverse()  反转指定列表中元素的顺序。
     */
    public static List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> map = new HashMap<>();
        for (String s: words) {
            map.put(s, map.getOrDefault(s,0) + 1);
        }
        PriorityQueue<String> heap = new PriorityQueue<>(
                (w1,w2) -> map.get(w1).equals(map.get(w2)) ?
                        w2.compareTo(w1) : map.get(w1) -
                        map.get(w2));
        for (String s: map.keySet()) {
            heap.offer(s);
            if (heap.size() > k) {
                heap.poll();
            }
        }

        List<String> ans = new ArrayList<>();
        while (!heap.isEmpty()) {
            ans.add(heap.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
    public static void main3(String[] args) {
        String[] str = {"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(str, 2));
    }

    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        /**
         * stream()  返回顺序IntStream与指定的数组作为源。
         * boxed()  返回一个 Stream组成的这个流的元素，每个盒装到一个 Integer 。
         * collect()  使用 Collector对此流的元素执行 mutable reduction Collector 。
         * Collectors.toList()  返回一个 Collector ，它将输入元素 List到一个新的 List 。
         *
         * Collections.sort()   根据指定的比较器引起的顺序对指定的列表进行排序。
         * Math.abs()  返回值为 int绝对值。
         *
         * subList()  返回此列表中指定的 fromIndex （含）和 toIndex之间的视图。
         */
        List<Integer> ret = Arrays.stream(arr).boxed().collect(
                Collectors.toList());
        Collections.sort(ret,(a,b) -> a == b ? a - b : Math.abs(a-x)
                - Math.abs(b-x));
        ret = ret.subList(0,k);
        Collections.sort(ret);
        return ret;
    }

    public List<Integer> findClosestElements1(int[] arr, int k, int x) {
        List<Integer> ret = Arrays.stream(arr).boxed().collect(Collectors.toList());
        int n = ret.size();
        if (x <= ret.get(0)) {
            return ret.subList(0, k);
        } else if (ret.get(n - 1) <= x) {
            return ret.subList(n - k, n);
        } else {
            int index = Collections.binarySearch(ret, x);
            if (index < 0)
                index = -index - 1;
            int low = Math.max(0, index - k - 1), high = Math.min(ret.size() - 1, index + k - 1);

            while (high - low > k - 1) {
                if ((x - ret.get(low)) <= (ret.get(high) - x))
                    high--;
                else if ((x - ret.get(low)) > (ret.get(high) - x))
                    low++;
                else
                    System.out.println("unhandled case: " + low + " " + high);
            }
            return ret.subList(low, high + 1);
        }
    }

    public static void main2(String[] args) {
        int[] array = {1, 2, 3, 4, 5};
        List<Integer> ret = findClosestElements(array,4,3);
        System.out.println(ret);
    }

    public static int compareVersion(String version1, String version2) {
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");

        // compare versions
        for (int i = 0; i < Math.max(nums1.length, nums2.length); ++i) {
            int i1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            int i2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        // the versions are equal
        return 0;
    }

    public static void main1(String[] args) {
        String str1 = "1";
        String str2 = "0";

        System.out.println(compareVersion(str1, str2));
    }
}
