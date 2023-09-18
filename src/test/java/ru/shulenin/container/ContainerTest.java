package ru.shulenin.container;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerTest {

    @Test
    void pushFront() {
        Container<Integer> cont = new Container<>();
        Integer[] arr = new Integer[100];

        for (int i = 0; i < 100; ++i) {
            cont.pushFront(i);
            arr[i] = 99 - i;
        }

        assertArrayEquals(cont.getVault(), arr);
    }

    @Test
    void pushBack() {
        Container<Integer> cont = new Container<>();
        Integer[] arr = new Integer[100];

        for (int i = 0; i < 100; ++i) {
            cont.pushBack(i);
            arr[i] = i;
        }

        assertArrayEquals(cont.getVault(), arr);
    }

    @Test
    void insert() {
        Container<Integer> cont = new Container<>();
        Integer[] a = {1, 11, 12, 12, 0, 13, 14, 9};

        cont.pushBack(11);
        cont.pushBack(12);
        cont.pushBack(13);
        cont.pushBack(14);

        cont.insert(12, 1);
        cont.insert(0, 3);
        cont.insert(1, 0);
        cont.insert(9, 7);

        assertArrayEquals(a, cont.getVault());
    }

    @Test
    void remove() {
        Container<Integer> cont = new Container<>();

        cont.pushBack(11);
        cont.pushBack(12);
        cont.pushBack(13);
        cont.pushBack(14);

        cont.insert(12, 1);
        cont.insert(0, 3);
        cont.insert(1, 0);
        cont.insert(9, 7);

        cont.remove(0);
        cont.remove(0);
        cont.remove(0);
        cont.remove(0);

        Integer[] x = {0, 13, 14, 9};

        for (Integer i : cont) {
            System.out.println(i);
        }

        assertArrayEquals(x, cont.getVault());
    }

    @Test
    void testForEach() {
        Container<Integer> cont = new Container<>();
        Integer[] x = {11, 12, 13, 14};
        Integer[] y = new Integer[4];

        cont.pushBack(11);
        cont.pushBack(12);
        cont.pushBack(13);
        cont.pushBack(14);

        int j = 0;
        for (Integer i : cont) {
            y[j++] = i;
        }

        assertArrayEquals(x, y);
    }
}