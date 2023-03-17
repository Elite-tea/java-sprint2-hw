public class SaveReport { // Обычный конструктор данных под шаблон месячных и годовых файлов.
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
}
