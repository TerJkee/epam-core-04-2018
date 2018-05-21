package com.epam.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Task8 {

    /**
     * Ввести N слов с консоли.
     * Помимо обычных слов, во входной последовательности могут встречаться целые числа (в том числе большие чем Long.MAX_VALUE).
     * Среди них необходимо найти число-палиндром (одинаково читающееся в обоих направлениях).
     * Число, содержащее одну цифру также является палиндромом.
     * Если палиндромов во входной последовательности больше одного - найти второй уникальный из них.
     * <p>
     * Формат входных данных:
     * N (целое число, 0 < N < 100) - количество слов в строке
     * Строка, содержащая минимум N слов, разделенных пробелами
     * <p>
     * Формат выходных данных:
     * В результате выполнения в выходной поток должно быть выведено найденное число-палиндром.
     * В случае, если не найдено ни одного палиндрома - в поток должно быть выведено "NOT FOUND".
     * <p>
     * ---------------------------------------------------------------------------------------------------
     * Пример выполнения задания:
     * <p>
     * Входные данные:
     * 15
     * Chapter 11 describes exceptions, chapter 13 describes binary compatibility... chapter 22 presents a syntactic grammar
     * <p>
     * Выходные данные:
     * 22
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int numOfWords = sc.nextInt();
        List<String> wordsFromInput = new ArrayList<>(numOfWords);
        StringBuilder answer = new StringBuilder("NOT FOUND");

        for (int i = 0; i < numOfWords; i++) {
            wordsFromInput.add(sc.next().toLowerCase());
        }
        answer = findLastUniquePalindrome(wordsFromInput, answer);

        System.out.println(answer.toString());
    }

    private static StringBuilder findLastUniquePalindrome(List<String> wordsFromInput, StringBuilder answer) {
        for (String current:wordsFromInput) {

            if (hasOnlyDigits(current) && isPalindrome(current) ) {
                answer = answer.replace(0,answer.length(),current);
            }


        }
        return answer;
    }

    private static boolean hasOnlyDigits(String current) {
        return current.matches("[0-9]+");
    }

    private static boolean isPalindrome(String testedString){
        StringBuilder buff=new StringBuilder(testedString);
        return buff == buff.reverse();
    }
}



//s.replaceAll("[^A-Za-zА-Яа-я0-9]", "");
//Chapter 11 describes exceptions chapter 13 describes binary compatibility chapter 22 presents a syntactic grammar