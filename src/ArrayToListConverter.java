/* Написать метод для конвертации массива строк/чисел в
список. */

import java.util.ArrayList;
import java.util.List;

public class ArrayToListConverter {

    // Определяем обобщенный метод который принимает массив обобщенного типа и возвращает список обобщенного типа
    public static <T> List<T> convert(T[] array) {
        List <T> list = new ArrayList<>(); // создаём пустой список обобщенного типа
        for (T element: array) { // передаём в него элементы из массива обобщенного типа
            list.add(element);
        }
        return list;
    }

    public static void main(String[] args) {
        // Пример использования с массивом чисел
        Integer[] integerArray = {1, 2, 3, 4, 5};
        List<Integer> integerList = convert(integerArray);
        System.out.println("Список чисел: "+ integerList);

        // Пример использования с массивом строк
        String[] stringArray = {"one", "two", "three", "four", "five"};
        List<String> stringList = convert(stringArray);
        System.out.println("Список строк: "+ stringList);
    }

}