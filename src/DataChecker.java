import java.util.ArrayList;
import java.util.HashMap;

public class DataChecker {
    static ArrayList<SaveReport> saveReportYear = new ArrayList<>(); //Данные за год
    static ArrayList<SaveReport> saveReportMonth = new ArrayList<>();// Данные за месяц
    static ArrayList<Boolean> resultExamination = new ArrayList<>(); // Данные о сверке
    static int year;

    public static void printChecker() {

        for (String years : FileReader.Year.keySet()) { // Проходим и получаем информацию по году
            year = Integer.parseInt(years);
            saveReportYear = FileReader.Year.get(years);
            if (!years.equals("2021")) {
                break;// Заглушка, при попытке сравнивания отчетов за другие года, программа остановит исполнение.
                // Реализовал бы, если смог разобраться с регулярными выражениями, но в ТЗ не требуется:)
            }

            for (String month : FileReader.Month.keySet()) { // Проходимся по годам
                HashMap<String, Integer> checkExpense = new HashMap<>();
                HashMap<String, Integer> checkIncome = new HashMap<>();
                String[] name = month.split("2021");
                saveReportMonth = FileReader.Month.get(month);
                checker(checkExpense, checkIncome, name[1]);
            }
        }
            if(resultExamination.size() == saveReportMonth.size()){// Проверка отчетов, если успешных сравнений = количеству месяцев * 2(Траты и прибыль) то говорим что все ок.
                System.out.println("Отчеты за " + year + " успешно сошлись.");
            }

        }


    public static void checker(HashMap<String, Integer> checkExpense, HashMap<String, Integer> checkIncome, String month) { // Рассчет сверки отчетов
        for (SaveReport saveReport : saveReportMonth) { // Разбиваем месяц на доходы и расходы.
            if (!saveReport.expense) {
                checkIncome.put("Income", (checkIncome.getOrDefault("Income", 0) + (saveReport.summa * saveReport.quantity)));
            } else {
                checkExpense.put("Expense", (checkExpense.getOrDefault("Expense", 0) + (saveReport.summa * saveReport.quantity)));
            }
        }

        for (SaveReport saveReport : saveReportYear) {// Сверяем отчеты
            if(saveReport.name.equals(month)) {
                if ((!saveReport.expense && saveReport.summa == checkIncome.get("Income")) || (saveReport.expense && saveReport.summa == checkExpense.get("Expense"))) {
                    resultExamination.add(true);
                } else {
                    System.out.println("Ошибка(false)! В месяце" + month + " не сходятся отчеты.");// Если траты или доходы не сходятся за какой либо месяц, пишем ошибку и номер месяца и завершаем.
                    return;
                }
            }

        }


//    Сверка данных — это проверка, что данные в двух и более разных источниках не противоречат друг другу.
//    В данном случае при сверке данных вам нужно проверить, что информация по месяцу в годовом отчёте не противоречит информации в месячном отчёте.
//    При вызове сверки данных программа должна:
//    Подсчитывать две суммы: общие доходы и общие расходы по каждому из месяцев.
//    Сверять полученные суммы с суммой доходов и расходов в отчёте по году.
//    Если обнаружена ошибка, программа должна выводить месяц, в котором обнаружено несоответствие.
//    Если ошибок не обнаружено, должна выводиться только информация об успешном завершении операции.
    }
}

