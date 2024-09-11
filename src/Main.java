/*
Напишите программу, которая использует Stream API для обработки списка чисел.
Программа должна вывести на экран среднее значение всех четных чисел в списке.
 */

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args)
    {
        // исходный массив
        int[] source = new int[] {1, 2, 6, 3, 8, 9, 2, 4, 7, 10};

        // вариант 1, через специализированный IntStream
        double av = IntStream.of(source).filter(n -> (n & 1) == 0).mapToDouble(n -> n).average().orElse(0);

        // вариант 2, через обычный список (инициализируем тоже через stream() из обычного массива int[])
        List<Integer> list = Arrays.stream(source).boxed().toList();
        double avg = list.stream().filter(n -> (n & 1) == 0).mapToDouble(n -> n).average().orElse(0);

        System.out.printf("Среднее значение четных чисел массива:\n%s\nравно = %.2f\n\n", Arrays.toString(source), av);
        System.out.printf("Среднее значение четных чисел массива:\n%s\nравно = %.2f\n", list, avg);
    }
}