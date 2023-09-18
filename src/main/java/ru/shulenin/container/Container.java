package ru.shulenin.container;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Arrays;
import java.util.Iterator;

/**
 * Класс контейнер, позволяющий хранить произвольное количество объектов.
 * Позволяет добавлять, извлекать и удалять элементы.
 * @param <T>
 * @autor Shulenin Ilya
 */
@ToString
public class Container<T> implements Iterable<T> {
    /** Размер контейнера */
    @Getter
    private int size;
    /** Массив, в котором хранятся элементы контейнера */
    @Getter
    private T[] vault;

    /**
     * Конструктор по умолчанию
     */
    public Container() {
        size = 0;
        vault = (T[]) new Object[10];
    }

    /**
     * Конструктор с параметром
     * @param size размер контейнера
     */
    public Container(int size) {
        this.size = size;
        vault = (T[]) new Object[size];
    }

    /**
     * Добавляет указанный элемент в начало контейнера
     * @param elem добавляемый элемент
     */
    public void pushFront(T elem) {
        T[] newVault = (T[]) new Object[size + 1];
        newVault[0] = elem;

        for (int i = 0; i < size; ++i) {
            newVault[i + 1] = vault[i];
        }

        vault = newVault;
        size++;
    }

    /**
     * Добавляет указанный элемент в конец контейнера
     * @param elem добавляемый элемент
     */
    public void pushBack(T elem) {
        T[] newVault = Arrays.copyOf(vault, size + 1);
        newVault[size] = elem;

        size++;
        vault = newVault;
    }

    /**
     * Вставка элемента на указанную позицию
     * @param elem вставляемый элемент
     * @param position позиция
     * @throws ArrayIndexOutOfBoundsException
     */
    public void insert(T elem, int position) throws ArrayIndexOutOfBoundsException {
        if (position >= 0 && position <= size) {
            T[] newVault = Arrays.copyOf(vault, size + 1);

            for (int i = 0; i < position; ++i) {
                newVault[i] = vault[i];
            }

            newVault[position] = elem;

            for (int i = position; i < size; ++i) {
                newVault[i + 1] = vault[i];
            }

            size++;
            vault = newVault;
        }
        else throw new IndexOutOfBoundsException("Index " + position + " out of range " + size);
    }

    /**
     * Извлечение элемента с указанной позиции
     * @param position позиция
     * @return значение элемента
     * @throws IndexOutOfBoundsException
     */
    public T at(int position) throws IndexOutOfBoundsException {
        if (position >= 0 && position < size) {
            return vault[position];
        }
        else throw new IndexOutOfBoundsException("Index " + position + " out of range " + size);
    }

    /**
     * Удаляет элемент на указанной пизиции
     * @param position позиция
     * @throws IndexOutOfBoundsException
     */
    public void remove(int position) throws IndexOutOfBoundsException {
        if (position >= 0 && position < size) {
            T[] newVault = Arrays.copyOf(vault, size - 1);

            for (int i = 0; i < position; ++i) {
                newVault[i] = vault[i];
            }
            for (int i = position; i < size - 1; ++i) {
                newVault[i] = vault[i + 1];
            }

            size--;
            vault = newVault;
        }
        else throw new IndexOutOfBoundsException("Index " + position + " out of range " + size);
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private int current;

            @Override
            public boolean hasNext() {
                return current < size;
            }

            @Override
            public T next() {
                return vault[current++];
            }
        };
    }
}
