import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * Клас для сортування слів, що починаються з голосних, за другою літерою.
 */
public class VowelWordSorter {

    /**
     * Головний метод для виконання програми.
     *
     * @param args Аргументи командного рядка.
     */
    public static void main(String[] args) {
        // Оголошення змінних
        Scanner scanner = null;
        String inputText = "";
        List<String> vowelWords = new ArrayList<>();
        String vowels = "АЕЄИІЇОУЮЯаеєиіїоуюя";

        try {
            scanner = new Scanner(System.in);

            // Введення тексту користувачем
            System.out.println("Введіть текст українською мовою:");
            inputText = scanner.nextLine();

            // Отримання слів із тексту
            String[] words = inputText.split("\\s+");

            // Відбір слів, що починаються з голосних і мають мінімум дві літери
            for (String word : words) {
                if (word.length() > 1 && vowels.indexOf(word.charAt(0)) != -1) {
                    vowelWords.add(word);
                }
            }

            // Сортування слів за другою літерою
            Collections.sort(vowelWords, new Comparator<String>() {
                @Override
                public int compare(String word1, String word2) {
                    char secondLetter1 = word1.charAt(1); // Друга літера
                    char secondLetter2 = word2.charAt(1); // Друга літера
                    return Character.compare(secondLetter1, secondLetter2);
                }
            });

            // Виведення результату
            if (vowelWords.isEmpty()) {
                System.out.println("У введеному тексті немає слів, які починаються з голосної та мають другу літеру.");
            } else {
                System.out.println("Слова, що починаються з голосних і мають другу літеру, відсортовані за другою літерою:");
                for (String word : vowelWords) {
                    System.out.println(word);
                }
            }

        } catch (NullPointerException e) {
            System.err.println("Сталася помилка: об'єкт не існує. " + e.getMessage());
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Сталася помилка: вихід за межі масиву. " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Сталася помилка: " + e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }
}
