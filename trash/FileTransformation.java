//import java.io.IOException;
//import java.nio.file.Files;
//import java.nio.file.Path;
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashMap;
//import java.util.List;
//
//public class FileTransformation {
//    public ArrayList<SaveReport> report = new ArrayList<>();
//    public HashMap<String, ArrayList<SaveReport>> reportfull = new HashMap<>();
//
//
//    public FileTransformation(String path){
//
//        //Указал жесткие константы под шаблон файлов, что бы при изменении шаблона можно было отредактировать константы и не искать переменные в коде.
//            int tovar = 0;
//            int isExpense = 1;
//            int quan = 2;
//            int summ = 3;
//
//                for (int i = 1; i < readFileContents(path).size(); i++) {   // Передаем в переменной path имя файла из класса ReadCSV, создаем список из файла построчно.
//                    String[] content = (readFileContents(path).get(i)).split(","); // Делим на строки(в массив) и сразу разбиваем на переменные.
//
//                    // Получаем сконфигурированные данные из массива content
//                String name = content[tovar];
//                boolean expense = Boolean.parseBoolean(content[isExpense]);
//                int quantity = Integer.parseInt(content[quan]);
//                int summa = Integer.parseInt(content[summ]);
//
//                SaveReport saveReport = new SaveReport(name, expense, quantity, summa);
//                report.add(saveReport);
//        }
//                String[] name = path.split("[.]");
//                reportfull.put(name[1], report);
//    }
//
//
//    List<String> readFileContents(String path) {
//        try {
//            System.out.println("Тепленькая пошла");
//            return Files.readAllLines(Path.of(path));
//        } catch (IOException e) {
//            System.out.println("Невозможно прочитать файл с месячным отчётом. Возможно файл не находится в нужной директории, или имеет не верное название.");
//            return Collections.emptyList();
//        }
//    }
//
//
//}
