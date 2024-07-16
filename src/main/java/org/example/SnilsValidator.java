package org.example;

public class SnilsValidator {
    public static boolean validateSnils(String snils) {
        if (snils == null) {
            return false;
        }
        // Удаляем все символы, кроме цифр
        snils = snils.replaceAll("\\D", "");

        // Проверяем, что длина строго 11 цифр (9 цифр + 2 контрольные)
        if (snils.length() != 11) {
            return false;
        }

        // Проверяем номера СНИЛС меньше "00100199901", которые считаются некорректными
        if (snils.compareTo("00100199901") < 0) {
            return false;
        }

        // Особый случай: все девятки
        if (snils.equals("99999999999")) {
            return true;
        }

        // Рассчитываем контрольную сумму по первым 9 цифрам
        int checksum = 0;
        for (int i = 0; i < 9; i++) {
            checksum += Character.getNumericValue(snils.charAt(i)) * (9 - i);
        }

        // Определяем контрольное число на основе контрольной суммы
        int controlNumber;
        if (checksum < 100) {
            controlNumber = checksum;
        } else if (checksum == 100 || checksum == 101) {
            controlNumber = 0;
        } else {
            controlNumber = checksum % 101;
        }

        // Проверяем совпадение контрольного числа с двумя последними цифрами СНИЛС
        return controlNumber == Integer.parseInt(snils.substring(9));
    }
}