/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Data;

import java.util.LinkedList;

/**
 *
 * @author TAN JIA QIN (WIF180073)
 */
public class Queue<E> {

    LinkedList<E> list;

    public Queue(E[] e) {
        list = new LinkedList<>();
        for (int i = 0; i < e.length; i++) {
            list.addLast(e[i]);
        }
    }

    public Queue() {
        list = new LinkedList<>();
    }

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue() {
        return list.removeFirst();
    }

    public E getElement(int i) {
        return list.get(i);
    }

    public E peek() {
        return list.get(list.size() - 1);
    }

    public int getSize() {
        return list.size();
    }

    public boolean contains(E e) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equals(e)) {
                return true;
            }
        }
        return false;
    }

    public boolean isEmpty() {
        if (list.size() == 0) {
            return true;
        } else {
            return false;
        }
    }

    public String toString() {
        String s = "Queue contains : ";
        for (int i = 0; i < list.size(); i++) {
            if (i == list.size() - 1) {
                s = s + list.get(i) + ".";
            } else {
                s = s + list.get(i) + ",";
            }
        }
        return s;
    }
}
