package main.java.com.epam.homework;

import java.util.Scanner;

public class Task1 {

    /**
     * Ввести N строк с консоли.
     * Найти среди них самую короткую и самую длинную.
     * Вывести найденные строки и их длину.
     * Если строк, удовлетворяющих условию, более одной - вывести последнюю из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество доступных для чтения строк
     * Строка_1
     * Строка_2
     * ...
     * Строка_N
     * <p>
     * Формат выходных данных:
     * MIN ($длина_минимальной_строки$): $минимальная_строка$
     * MAX ($длина_максимальной_строки$): $максимальная_строка$
     * <p>
     * -----------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 4
     * Унылая пора! Очей очарованье!
     * Приятна мне твоя прощальная краса —
     * Люблю я пышное природы увяданье,
     * В багрец и в золото одетые леса,
     * <p>
     * Выходные данные:
     * MIN (29): Унылая пора! Очей очарованье!
     * MAX (35): Приятна мне твоя прощальная краса —
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner = new Scanner(System.in);

        String maxString = scanner.nextLine();
        String minString = maxString;

        for (int i = 0; i <= n - 2; i++) {
            String tempString = scanner.nextLine();

            maxString = getMaxString(maxString, tempString);
            minString = getMinString(minString, tempString);
        }

        System.out.println("MIN (" + minString.length() + "): " + minString);
        System.out.println("MAX (" + maxString.length() + "): " + maxString);
    }

    private static String getMinString(String minString, String tempString) {
        if (tempString.length() <= minString.length()) {
            minString = tempString;
        }
        return minString;
    }

    private static String getMaxString(String maxString, String tempString) {
        if (tempString.length() >= maxString.length()) {
            maxString = tempString;
        }
        return maxString;
    }
}
