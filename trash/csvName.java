package trash;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

class csvName {

    void nameFileCSV(String command) {
//        int number = 0;
//        String patch = null;
//        String result = null;
//        List<String> res = new ArrayList<>();
//
//        if (command.equals("1")) {
//            number = 12; // Взял максимальное число месяцев для проверки.
//            patch = "resources/m.20210";
//            }
//        else if(command.equals("2")){
//            number = 10;// Взял большее количество для проверки на собственных примерах.
//            patch = "y.202";
//            }
//        for (int i = 1; i < number; i++) {
//            result = patch + i + ".csv";
//            res = readFileContents(result);
//        }
    }
    List<String> readFileContents(String path) {
        try {
            System.out.println("Тепленькая пошла");
            return Files.readAllLines(Path.of(path));
        } catch (IOException e) {
            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории, или имеет не верное название.");
            return Collections.emptyList();
        }
    }




    public HashMap<String, ArrayList<SaveReport>> reportfull = new HashMap<>();
    public void File(String path){
        public ArrayList<SaveReport> report = new ArrayList<>();
        int number = 0;
        String patch = null;
        String result = null;
        List<String> res = new ArrayList<>();

        if (path.equals("1")) {
            number = 12; // Взял максимальное число месяцев для проверки.
            patch = "resources/m.20210";
        }
        else if(path.equals("2")){
            number = 10;// Взял большее количество для проверки на собственных примерах.
            patch = "resources/y.202";
        }
        for (int i = 1; i < number; i++) {
            result = patch + i + ".csv";
            res = readFileContents(result);
            for (int j = 1; j < res.size(); j++) {   // Передаем в переменной path имя файла из класса ReadCSV, создаем список из файла построчно.
                String[] content = (res.get(j)).split(","); // Делим на строки(в массив) и сразу разбиваем на переменные.

                // Получаем сконфигурированные данные из массива content
                String name = content[0];
                boolean expense = Boolean.parseBoolean(content[1]);
                int quantity = Integer.parseInt(content[2]);
                int summa = Integer.parseInt(content[3]);

                SaveReport saveReport = new SaveReport(name, expense, quantity, summa);
                report.add(saveReport);
            }
            String[] name = result.split("[.]");
            reportfull.put(name[1], report);
            report.clear();
        }


    }
}
