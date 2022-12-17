import java.text.NumberFormat;
import java.util.Locale;

public class Main {

    public static void printAllWorkers (Employee[] employees) {
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }
    public static int calculateSalaryFund (Employee[] employees) {
        int salaryFund = 0;
        for (int i = 0; i < employees.length; i++) {
            salaryFund = (int) (salaryFund + employees[i].getSalary());
        }
        return salaryFund;
    }
    public static void getMinMaxSalary (Employee[] employees) {
        int idMinSalary = 0;
        int idMaxSalary = 0;
        int a = (int) employees[0].getSalary();

        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > a) {
                idMaxSalary = i;
            }
            if (employees[i].getSalary() < a) {
                a = (int) employees[i].getSalary();
                idMinSalary = i;
            }
        }
        System.out.println("Сотрудник с максимальной заработной платой:\n   " + employees[idMaxSalary]);
        System.out.println("Сотрудник с минимальной заработной платой:\n   " + employees[idMinSalary]);
    }
    public static void getFIOWorkers (Employee[] employees) {
        System.out.println("Список работников предприятия: \n");
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i].getFio());
        }
    }
    public static void main(String[] args) {

        int salaryFund;
        double averageSalary;

        NumberFormat divider = NumberFormat.getInstance(new Locale("ru", "RU")); // Разделяем на 1000;

        Employee[] employees = new Employee[10];

        employees[Employee.id] = new Employee("Матвеева Ольга Васильевна", "Управление", 150_000);
        employees[Employee.id] = new Employee("Бояркин Сергей Витальевич", "Управление", 110_000);
        employees[Employee.id] = new Employee("Старикова Инна Степановна", "Бухгалтерия", 75_000);
        employees[Employee.id] = new Employee("Иванова Ирина Евгеньевна", "Бухгалтерия", 55_000);
        employees[Employee.id] = new Employee("Жуков Василий Петрович", "Склад", 50_000);
        employees[Employee.id] = new Employee("Колесникова Алефтина Сергеевна", "Склад", 45_000);
        employees[Employee.id] = new Employee("Антонов Сергей Павлович", "Доставка", 60_000);
        employees[Employee.id] = new Employee("Фролов Геннадий Николаевич", "Доставка", 60_000);
        employees[Employee.id] = new Employee("Афанасьев Артём Павлович", "Логистика", 70_000);
        employees[Employee.id] = new Employee("Степанов Иван Аркадьевич", "Логиститка", 65_000);

        printAllWorkers(employees); // вывод всех Ф.И.О, отдел, зарплата;
        System.out.println("-----------------------------");

        System.out.println("Фонд заработной платы = " + divider.format(calculateSalaryFund(employees)) + " руб.");

        averageSalary = calculateSalaryFund(employees) / Employee.id;
        System.out.println("Средняя зарплата по предприятию за месяц = " + divider.format(averageSalary) + " руб.");
        System.out.println("-----------------------------");

        getMinMaxSalary(employees);

        getFIOWorkers(employees);
    }
}