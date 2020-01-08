package lt.dr;

import java.util.Scanner;

public class Main {
    // aCof - A koeficientas, bCof - B koeficientas,
    private static int division = 2147483647, aCof = 16807, bCof = 48271;
    private static int repeat = 1000000;
    private static int match = 0;

    public static void main(String[] args) {
        int a, b;

        System.out.print("Input A: ");
        java.util.Scanner sc = new Scanner(System.in).useDelimiter("\\s");
        a = sc.nextInt();

        System.out.print("Input B: ");
        b = sc.nextInt();

        genOnRepeat(a, b, repeat - 1);
        System.out.println("Match " + match);
    }

    static void genOnRepeat(int a, int b, int count) {
        long tempA = a;
        long tempB = b;
        while (count > 0) {
            tempA = tempA * aCof % division;
            tempB = tempB * bCof % division;
            checking((int) tempA, (int) tempB);
            count--;
        }
    }

    private static void checking(int tempA, int tempB) {
        String strA = toBinary(tempA, 32);
        String strB = toBinary(tempB, 32);
        //Tikrina ar paskutiniai 8 skaiciai vienodi
        if (strA.substring(strA.length() - 8).equals(strB.substring(strB.length() - 8))) {
            match++;
        }
    }
    //Grazina is skaiciau i dvejetaine 32 skaiciau ilgio
    public static String toBinary(int x, int len) {
        if (len > 0) {
            return String.format("%" + len + "s",
                    Integer.toBinaryString(x)).replaceAll(" ", "0");
        }
        return null;
    }
}
