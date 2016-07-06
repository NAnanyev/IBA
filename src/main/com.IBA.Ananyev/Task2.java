package com.IBA.Ananyev;

import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * Created by Ananyeu_NA on 05.07.2016.
 */

/*You are given three nonnegative integers a, b, c. You have to arrange them in some order and put +, − or × signs between them to minimize the outcome of the resulting expression. You are not allowed to use unary minus and parentheses in the expression. There must be exactly one sign between every pair of neighbouring numbers. You should use standard order for performing operations (multiplication first, addition and subtraction then).
Input
        There are three lines with one integer in each line. The numbers are arranged in non-decreasing order (0 ≤ a ≤ b ≤ c ≤ 100).
        Output
        Print one number — the minimal outcome.

        Sample: input
        1
        2
        3
        output
        -4
        */

public class Task2 {

    static int a;
    static int b;
    static int c;
    static int endResult;
    static Scanner scanner;

    public static void main(String[] args) {
        initialize();
        processing();

    }

    public static void initialize() {
        scanner = new Scanner(System.in);
        a = scanner.nextInt();
        b = scanner.nextInt();
        c = scanner.nextInt();
        scanner.close();
    }

    public static void processing() {
        int result1 = -b - c;
        int result2 = -b * c;
        if (result2 < result1) {
            print("a - b * c =", result1);
        } else {
            print("a - b - c = ", result2);
        }
    }

    public static void print(String string, Integer result) {
        endResult = result;
        System.out.println(string + endResult);
    }
}

