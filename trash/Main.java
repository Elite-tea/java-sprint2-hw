package trash;

import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        csvName csvName;

        while(true){ // Зацикливаем меню
            Menu.printMenu();// Выводим меню
            String command = scanner.nextLine(); // Считываем команды

            switch (command) {// Аналог else if конструкции с условием command.equals("")
                case "1": csvName = new csvName();
                csvName.File(command);
                    //System.out.println(reportfull);// Считать все месячные отчёты

                    break;
                case "2": // Считать годовой отчёт
                    //csvName.nameFileCSV("2");// Вызов 1 и 2 комманды одинаковые, в медоте решение от переменной command зависит исполнение того или иного события.
                    break;
                case "3": // Сверить отчёты
                    break;
                case "4": // Вывести информацию о всех месячных отчётах
                    break;
                case "5": // Вывести информацию о годовом отчёте
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





