class Menu {// Тут будет только меню и ошибка, отдельный класс что бы в main было максимально читаемо.
    public static void printMenu() {
        System.out.println("Что вы хотите сделать? ");
        System.out.println("1 - Считать все месячные отчёты");
        System.out.println("2 - Считать годовой отчёт");
        System.out.println("3 - Сверить отчёты");
        System.out.println("4 - Вывести информацию о всех месячных отчётах");
        System.out.println("5 - Вывести информацию о годовом отчёте");
        System.out.println("!@# - Выход");

    }
    public static void errormenu(){
        System.out.println("Ошибка! Прежде чем производить рассчеты, пожалуйста, считайте необходимый вид отчетов командой 1 или 2.");
    }
}
