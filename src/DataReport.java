import java.util.ArrayList;
import java.util.HashMap;

public class DataReport {
    static ArrayList<SaveReport> saveReportYear = new ArrayList<>();
    static ArrayList<SaveReport> saveReportMonth = new ArrayList<>();

    static public void printReportMonth(){ // Печатаем отчет за месяцы
        for (String monthy : FileReader.Month.keySet()) {
            saveReportMonth = FileReader.Month.get(monthy);
            allReportMonth(monthy);
        }
    }

    public static void allReportMonth(String monthy){ // Рассчет месячных отчетов.
        HashMap<String, Integer> topProduct = new HashMap<>();// Тут будет название и сумма*количество
        HashMap<String, Integer> MaxExpense = new HashMap<>(); //Тут тоже самое, только для траты

        String nameTopProduct = null;
        String nameExpenseProduct = null;
        int maxCost = 0;
        int maxExpense = 0;

        String[] name = monthy.split("2021"); // Получаем год для выведения в консоль
        for (SaveReport saveReport : saveReportMonth) { // Разбиваем на информацию
            if(!saveReport.expense){
                topProduct.put(saveReport.name, (saveReport.summa * saveReport.quantity)); // Собираем топовый товар
            } else {
                MaxExpense.put(saveReport.name, (saveReport.summa * saveReport.quantity)); // Собираем максимальную трату
            }
        }

        for (String product : topProduct.keySet()){ // Высчитываем топовый товар
       if (topProduct.get(product) > maxCost){
           maxCost = topProduct.get(product);
           nameTopProduct = product;
       }
        }
        for (String expense : MaxExpense.keySet()){ // Рассчет максимальной траты
            if (MaxExpense.get(expense) > maxExpense) {
                maxExpense = MaxExpense.get(expense);
                nameExpenseProduct = expense;
            }
        }

        System.out.println("Месяц: " + name[1] + "\n Самый продаваемый товар: " + nameTopProduct + " на сумму " + topProduct.get(nameTopProduct) +
                            "\n Самая большая трата: " + nameExpenseProduct + " на сумму " + MaxExpense.get(nameExpenseProduct));
    }
    static public void printReportYear(){ // Печатаем отчет за год
        for (String years : FileReader.Year.keySet()) {
            saveReportYear = FileReader.Year.get(years);
            incomeMonthToYear(Integer.parseInt(years));
        }
    }

    public static void incomeMonthToYear(Integer year){ //Рассчет годового отчета.
    HashMap<Integer, Integer> expense = new HashMap<>();
    HashMap<Integer, Integer> income = new HashMap<>();
        int expens = 0;
        int incom = 0;
        System.out.println("Год " + year);
        for (SaveReport report : saveReportYear) { // Разбиваем отчет на траты и доходы
            if (report.expense) {
                expense.put(Integer.parseInt(report.month), report.summa);
            } else {
                income.put(Integer.parseInt(report.month), report.summa);
            }
        }
            for (int i = 1; i <= expense.size(); i++){ // Печать отчета за каждый месяц

                System.out.println("Месяц " + i + "\nПрибыль :" + (income.get(i) - expense.get(i)) + "\n");

                expens += expense.get(i);
                incom += income.get(i);
            }
            System.out.println("Средний расход: " + (expens / expense.size() + "\nСредний доход: " + (incom / income.size() + "\n")));
        }
    }