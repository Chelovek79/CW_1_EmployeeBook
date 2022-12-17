import java.text.NumberFormat;
import java.util.Locale;

public class Employee {
    NumberFormat divider = NumberFormat.getInstance(new Locale("ru", "RU")); // Разделяем на 1000;

    private String fio;
    private String department;
    private int salary;
    public static int id = 0;

    public Employee (String fio, String department, int salary) {
        this.fio = fio;
        this.department = department;
        this.salary = salary;
        id++;
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

    public void setSalary(int salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Ф.И.О.: " + fio + " / Отдел: " + department + " / Заработная плата: " + divider.format(salary) + " руб.";
    }
}
