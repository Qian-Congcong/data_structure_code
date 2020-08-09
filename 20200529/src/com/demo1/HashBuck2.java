package com.demo1;

import java.util.Objects;

/**
 * program: 20200529
 * Created with IntelliJ IDEA.
 * Description:
 * User: YouName
 * Date:2020-05-29 20
 * Time:40
 */
class Person {
    public int id;

    public Person(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
public class HashBuck2<K, V> {

    static class Node<K,V> {
        public K key;
        public V val;
        public Node<K,V> next;

        public Node(K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    public Node<K,V>[] array = (Node<K, V>[]) new Node[10];
    public int usedSize;

    public void put(K key, V val) {
        int hash = key.hashCode();
        int index = hash % array.length;

        for (Node<K,V> cur = array[index]; cur != null; cur = cur.next) {
            if (cur.key.equals(key)) {
                //key相同 更新val值
                cur.val = val;
                return;
            }
        }

        Node<K,V> node = new Node<>(key, val);
        node.next = array[index];
        array[index] = node;
        this.usedSize++;
    }

    public V get(K key) {
        //1、找位置
        //2、遍历单链表开始找  找到返回val值
        int hash = key.hashCode();
        int index = hash % array.length;
        Node<K,V> cur = array[index];

        while (cur != null) {
            if (cur.key == key) {
                return cur.val;
            }
            cur = cur.next;
        }
        return null;
    }

    public static void main(String[] args) {
        HashBuck2<Integer,Integer> hashBuck2 = new HashBuck2<>();
        for (int i = 1; i < 8; i++) {
            hashBuck2.put(i, i);
        }
        System.out.println(hashBuck2.get(2));
    }

    public static void main1(String[] args) {
        Person person1 = new Person(12);
        Person person2 = new Person(12);
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());
        System.out.println(person1.equals(person2));
    }
}
