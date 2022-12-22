import java.text.NumberFormat;
import java.util.Locale;

public class Employee {
    NumberFormat divider = NumberFormat.getInstance(new Locale("ru", "RU")); // Разделяем на 1000;

    private String fio;
    private String department;
    private double salary;
    private int id;
    public static int counter = 0;

    public Employee (String fio, String department, double salary) {
        this.fio = fio;
        this.department = department;
        this.salary = salary;
        this.id = counter+1;
        counter ++;
    }

    public String getFio() {
        return fio;
    }

    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
    public int getId(){
        return id;
    }

    @Override
    public String toString() {
        return id + ". Ф.И.О.: " + fio + " / Отдел: " + department + " / Заработная плата: " + divider.format(salary) + " руб.";
    }
}
