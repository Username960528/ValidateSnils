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

        // Проверяем номера СНИЛС меньше "00100199900", которые считаются некорректными
        if (snils.compareTo("00100199900") <= 0) {
            return false;
        }

        // Рассчитываем контрольную сумму по первым 9 цифрам
        int checksum = 0;
        for (int i = 0; i < 9; i++) {
            checksum += Character.getNumericValue(snils.charAt(i)) * (9 - i);
        }

        // Определяем контрольное число на основе контрольной суммы
        int controlNumber = checksum < 100 ? checksum : (checksum == 100 || checksum == 101 ? 0 : checksum % 101);

        // Проверяем совпадение контрольного числа с двумя последними цифрами СНИЛС
        return controlNumber == Integer.parseInt(snils.substring(9));
    }
}