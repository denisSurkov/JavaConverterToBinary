package main;

/**
 * Converter class. Converting nums to binary repr.
 * Made with binary operation >> and checking is even
 * <p>
 * Сделано с побитовым шагом вправо (деление на шаг в квадрате).
 * Сурков Д. 2018
 */

public class Converter {
    private static final int BIN_STEP = 1; // Шаг сдвига


    public String convertNumberToBin(int x) {
        return convertNumberToBin((long) x);
    }

    public String convertNumberToBin(long numToConvert) {
        StringBuilder answer = new StringBuilder();

        // TODO: Сделать поддержку отрицательных чисел.
        long x = Math.abs(numToConvert), res = x;

        while (x > 0) {

            if (res % 2 == 0) {
                answer.insert(0, 0);
            } else {
                answer.insert(0, 1);
            }

            res = x >> BIN_STEP; // Деление на 2 (побитовый сдвиг вправа)
            x = res;
        }

        if (numToConvert % 2 == 1){
            answer.replace(answer.length() - 1, answer.length(), "1");
        }

        return answer.toString();
    }

    public static boolean checkCanBeByte(long x){
        return (x <= 127) && (x >= -128);
    }

    public static boolean checkCanBeShort(long x){
        return x >= -32768 && x <= 32767;
    }

    public static boolean checkCanBeInt(long x){
        return x >= -2147483648 && x <= 2147483647;
    }


    public static boolean checkCanBeLong(long x){
        return true;
    }
}
