import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 4.1 Подсчет вхождений подстроки
        System.out.println("Введите строку:");
        String inputString = scanner.nextLine();

        System.out.println("Введите подстроку:");
        String substring = scanner.nextLine();

        int count = countOccurrences(inputString, substring);
        System.out.println("Подстрока '" + substring + "' встречается " + count + " раз");

        // 4.2 Замена слов
        System.out.println("Введите строку:");
        String replaceString = scanner.nextLine();
//
        String censoredString = replaceWords(replaceString);
        System.out.println(censoredString);
//
        // 4.3 Преобразование даты
        System.out.println("Введите дату в формате 'дд.мм.гггг':");
        try {
            String dateInput = scanner.nextLine();

            String formattedDate = convertDateFormat(dateInput);
            System.out.println(formattedDate);

            // 4.4 Преобразование даты с использованием Date и SimpleDateFormat

            String formattedDateUsingDate = convertDateWithDateAPI(dateInput);
            System.out.println(formattedDateUsingDate);
        } catch (Exception e) {
            System.out.println("Ошибка: неверный формат даты.");
        }
    }

    private static int countOccurrences(String str, String subStr) {
        int count = 0;
        int index = 0;

        while ((index = str.indexOf(subStr, index)) != -1) {
            count++;
            index += subStr.length();
        }

        return count;
    }

    // Метод для замены слов "кака" и "бяка"
    private static String replaceWords(String str) {
        return str.replace("кака", "вырезано цензурой")
                .replace("бяка", "вырезано цензурой");
    }

    // Метод для преобразования даты в нужный формат
    private static String convertDateFormat(String date) {
        return date.replace(".", "-");
    }

    // Метод для преобразования даты с использованием Date и SimpleDateFormat
    private static String convertDateWithDateAPI(String date) throws Exception {
        SimpleDateFormat inputFormat = new SimpleDateFormat("dd.MM.yyyy");
        SimpleDateFormat outputFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date parsedDate = inputFormat.parse(date);
        return outputFormat.format(parsedDate);
    }
}
