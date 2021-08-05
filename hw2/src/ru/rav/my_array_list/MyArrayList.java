package ru.rav.my_array_list;

import java.util.Arrays;

public class MyArrayList<T extends Comparable<T>> {
    private T[] list;
    private int size;
    private int capacity;
    private final int DEFAULT_CAPACITY = 10;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity <= 0 " + capacity);
        }
        this.capacity = capacity;
        list = (T[]) new Comparable[capacity];
    }

    public MyArrayList() {
        this.capacity = DEFAULT_CAPACITY;
        list = (T[]) new Comparable[capacity];
    }

    public void add(T item) {
        sizeCheck();
        list[size] = item;
        size++;
    }

    public void add(int index, T item) {
        sizeCheck();
        if (indexCheck(index)) {
            for (int i = size; i > index; i--) {
                list[i] = list[i - 1];
            }
            list[index] = item;
            size++;
        } else System.out.println("Bad index");

    }

    public final T remove(int index) {
        if (indexCheck(index)) {
            T temp = list[index];
            for (int i = index; i < size; i++) {
                list[i] = list[i + 1];
            }
            size--;
            list[size] = null;
            return temp;
        }
        return null;
    }

    public boolean remove(T item) {
        int i = indexOf(item);
        if (i == -1) {
            return false;
        }
        remove(i);
        return true;
    }

    public int indexOf(T item) {
        for (int i = 0; i < size; i++) {
            if (list[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    public T get(int index) {
        if (indexCheck(index)) {
            return list[index];
        } return null;
    }

    public void set(int index, T item) {
        if (indexCheck(index)) {
            list[index] = item;
        } else System.out.println("Bad index");

    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(list[i]).append(", ");
        }
        if (size > 0) {
            sb.setLength(sb.length() - 2);
        }

        sb.append(" ]");
        return sb.toString();
    }


    private boolean less(T item1, T item2) {
        return item1.compareTo(item2) < 0;
    }

    private void swap(int index1, int index2) {
        T temp = list[index1];
        list[index1] = list[index2];
        list[index2] = temp;
    }

    private boolean indexCheck(int index) {
        if ((index < 0) && (index > size)) {
            return false;
        }
        return true;
    }

    private void sizeCheck() {
        if (size >= (0.75 * capacity)) {
            rebuildArray();
        }
    }

    private void rebuildArray() {
        capacity *= 2;
        T[] newList = (T[]) new Comparable[capacity];
        newList = Arrays.copyOf(list, list.length);
        list = newList;
    }
}