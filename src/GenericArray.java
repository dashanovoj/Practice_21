/* Написать класс, который умеет хранить в себе массив любых
типов данных (int, long etc.). */

import java.util.Arrays;

public class GenericArray<T> {
    // Поля данных
    private Object[] array; // Массив для хранения элементов типа Object
    private int size; // Текущий размер массива

    // Конструктор для инициализации массива заданного размера
    public GenericArray(int capacity) {
        array = new Object[capacity]; // Создаём массив объектов
        size = 0; // Изначальный размер массива
    }

    // Метод для добавления элемента в массив
    public void add(T element) {
        if (size >= array.length) {
            // Если массив заполнен, увеличиваем его размер вдвое
            array = Arrays.copyOf(array, array.length * 2);
        }
        // Добавляем элемент и увеличиваем размер
        array[size++] = element;
    }

    // Метод для получения элемента по индексу
    public T get(int index) {
        // Обработка исключения
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        return (T) array[index]; // Возвращаем элемент, приводя его к типу T
    }

    // Метод для получения текущего размера массива
    public int size() {
        return size;
    }

    // Метод для получения массива как стандартного массива объектов
    public Object[] toArray() {
        // метод Arrays.copyOf создаёт новый массив и копирует в него элементы старого массива
        return Arrays.copyOf(array, size);
    }

    public static void main(String[] args) {
        // Создаем массив для целых чисел
        GenericArray<Integer> intArray = new GenericArray<>(5);

        intArray.add(1);
        intArray.add(2);
        intArray.add(3);

        System.out.println("Элемент по индексу 1: " + intArray.get(1));
        System.out.println("Размер массива: " + intArray.size());

        // Создаем массив для строк
        GenericArray<String> stringArray = new GenericArray<>(5);

        stringArray.add("Hello");
        stringArray.add("World");

        System.out.println("Элемент по индексу 0: " + stringArray.get(0)); // Вывод: Hello
        System.out.println("Размер массива: " + stringArray.size());
    }
}
