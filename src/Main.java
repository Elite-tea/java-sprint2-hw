import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(true){ // Зацикливаем меню
            Menu.printMenu();// Выводим меню
            String command = scanner.nextLine(); // Считываем команды

            switch (command) {// Аналог else if конструкции с условием command.equals("")
                case "1":
                case "2":
                    FileReader.read(command);// Считать все отчёты, в зависимости от команды 1(месяц) 2 (Год)
                    break;

                case "3": if(!FileReader.Month.isEmpty() && !FileReader.Year.isEmpty()){ // Проверка на предварительный счет данных, аналогично в 4 и 5 команде.
                    DataChecker.printChecker();// Сверить отчёты
                } else {
                    Menu.errormenu();
                }
                    break;

                case "4": if(!FileReader.Month.isEmpty()) {
                    DataReport.printReportMonth();// Вывести информацию о всех месячных отчётах
                } else {
                    Menu.errormenu();
                }
                    break;

                case "5":if(!FileReader.Year.isEmpty()){
                    DataReport.printReportYear(); // Вывести информацию о годовом отчёте
                } else {
                    Menu.errormenu();
                }
                    break;

                case "!@#": //!@# - Выход
                    System.out.println("Выход. Всего доброго:)");
                    return;

                default:  // Отрабатываем несуществующие команды.
                    System.out.println("Ошибка, такой команды пока нет. \nВведите от 1 до 5, или команду !@# для выхода ");
                    break;
            }
        }
    }
}