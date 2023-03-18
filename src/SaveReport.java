public class SaveReport { // Обычный конструктор данных под шаблон месячных и годовых файлов.
    String month;

    String name;
    boolean expense;
    int quantity; // не используется при расчете за год.
    int summa;

    public SaveReport(String name, boolean expence, int quantity, int summa){
        this.name = name;
        this.expense = expence;
        this.quantity = quantity;
        this.summa = summa;
    }
    public SaveReport(String month, boolean expence, int summa){ // Конструктор для годового отчета.
        this.month = month;
        this.expense = expence;
        this.summa = summa;
    }
}
