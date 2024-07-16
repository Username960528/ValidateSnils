package org.example;

public class SnilsValidator {
    public static boolean validateSnils(String snils) {

        if (snils == null) {
            return false;
        }
        // Удаляем все символы кроме чисел
        snils = snils.replaceAll("\\D", "");

        // Обрезаем до 11
        if (snils.length() > 11) {
            snils = snils.substring(0, 11);
        }

        // Проверяем что длина символов 11
        if (snils.length() != 11) {
            return false;
        }

        // Считаем некорректными числа меньше "00100199901"
        if (snils.compareTo("00100199901") < 0) {
            return false;
        }

        // Контрольная сумму по первым 9 цифрам
        int checksum = 0;
        for (int i = 0; i < 9; i++) {
            checksum += Character.getNumericValue(snils.charAt(i)) * (9 - i);
        }

        // Считаем контрольное число на основании контрольной суммы
        int controlNumber;
        if (checksum < 100) {
            controlNumber = checksum;
        } else if (checksum == 100 || checksum == 101) {
            controlNumber = 0;
        } else {
            controlNumber = checksum % 101;
        }

        // Валидация контрольного числа с двумя последними цифрами
        int lastTwoDigits = Integer.parseInt(snils.substring(9));
        return controlNumber == lastTwoDigits;
    }
}