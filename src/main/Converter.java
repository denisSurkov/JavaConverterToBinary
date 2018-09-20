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
        long x = Math.abs(numToConvert);

        while (x >= 1) {
            long res = x >> BIN_STEP; // Деление на 2 (побитовый сдвиг вправа)

            if (res % 2 == 0) {
                answer.append(0);
            } else {
                answer.append(1);
            }

            x = res;
        }

        return answer.toString();
    }

    public static boolean checkCanBeByte(long x){
        if (x <= 127 && x >= -128){
            return true;
        }
        return false;
    }

    public static boolean checkCanBeShort(long x){
        if (x >= -32768 && x <= 32767){
            return true;
        }
        return false;
    }

    public static boolean checkCanBeInt(long x){
        if (x >= -2147483648 && x <= 2147483647){
            return true;
        }
        return false;
    }


    public static boolean checkCanBeLong(long x){
        return true;
    }
}
