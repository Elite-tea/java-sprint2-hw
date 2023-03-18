import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class FileReader {

static HashMap<String, ArrayList<SaveReport>> Month = new HashMap<>();// Хешмапа для хранения месячных отчетов
static HashMap<String, ArrayList<SaveReport>> Year = new HashMap<>();// Хешмапа для хранения годовых отчетов

  public static void read(String command) {
        int number = 0; // Объявляем счетчик с дефолтным значением 0.
        String patch = null;
        String result;

        // Шаблоны названий файлов для комманд 1(Месяц) и 2(Год)
        if (command.equals("1")) {
            number = 3; // По условию  всего 3 месяца, сравнивать и будем с 3 месяцами.
            patch = "resources/m.20210";
        } else if (command.equals("2")) {
            number = 1; // По условию 1 год, присваиваем 1 в счетчик.
            patch = "resources/y.202";
        }

      // Гинерируем имя файла в зависимости от шаблона
        for (int i = 1; i <= number; i++) {
            result = patch + i + ".csv";
            ArrayList<SaveReport> data = new ArrayList<>();
            // Приводим файл в читаемый вид, разбиваем магический лист на строки
            for (int j = 1; j < readFileContents(result).size(); j++) {   // Передаем в переменной result имя файла и создаем список из файла построчно.
                String[] content = (readFileContents(result).get(j)).split(","); // Делим на строки(в массив) и сразу разбиваем на переменные.

                // Получаем сконфигурированные данные из массива content для месячных отчетов и годовых, а так же сохраняем их в мапы.
                if (command.equals("1")) {
                    String name = content[0];
                    boolean expense = Boolean.parseBoolean(content[1]);
                    int quantity = Integer.parseInt(content[2]);
                    int summa = Integer.parseInt(content[3]);
                    // Создаем SaveReport и добавляем данные в ArrayList
                    SaveReport saveReport = new SaveReport(name, expense, quantity, summa);
                    data.add(saveReport);
                }

                else {// Все тоже самое что и блоком выше, но для годичного отчета
                    String month = content[0];
                    int summa = Integer.parseInt(content[1]);
                    boolean expense = Boolean.parseBoolean(content[2]);

                    SaveReport saveReport = new SaveReport(month, expense, summa);
                    data.add(saveReport);
                }
            }
            String[] name = result.split("[.]"); // Получаем имя для ключа в мапе
            if (command.equals("1")) {// Сохраняем данные в мапу для месяца
                if (data.size() != 0) {
                    Month.put(name[1], data);
                }
            }
            else {// Сохраняем данные в мапу для Года
                if (data.size() != 0) {
                    Year.put(name[1], data);
                }
            }

        }

    }

  static List<String> readFileContents(String path) { //Загадочный интерфейс, который мы конечно же не проходили, go search!
        try {
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            String[] name = path.split("/");
            System.out.println("Ошибка, возможно файл " + name[1] + " не находится в нужной директории " + name[0] + " или имеет не верное название.");
            return Collections.emptyList();
        }
    }



}
