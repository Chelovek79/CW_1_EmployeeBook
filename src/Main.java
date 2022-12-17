import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.SocketHandler;

public class Main {

    public static void returnMenu (int a) {
        System.out.println("Желаете продолжить: 1 - 'Да'; Любое число - 'Нет'");
        Scanner in = new Scanner(System.in);
        int y_n = in.nextInt();
        if (y_n == 1) {
            a = 0;
        } else {
            System.exit(0);
        }
    }
    public static void printAllWorkers (Employee[] employees, String nameOffice) {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment().equals(nameOffice)) {
                System.out.println(employees[i].getFio() + " - заработная плата " + employees[i].getSalary() + " руб.");
            }
        }
        System.out.println("");
    }
    public static void calculateSalaryFund_Average (Employee[] employees, String nameOffice, int f_a) {
        int salaryFund = 0;
        int sumWorkers = 0;
        double averageSalary = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment().equals(nameOffice)) {
                salaryFund = (int) (salaryFund + employees[i].getSalary());
                sumWorkers++;
            }
        }
        averageSalary = (double) Math.round((salaryFund / sumWorkers) *100.0)/100.0;
        if (f_a == 0) {
            System.out.println("Фонд заработной платы отдела '" + nameOffice + "' - " + salaryFund + " руб.");
        }
        if (f_a == 1) {
            System.out.println("Среднемесячная заработная плата отдела '" + nameOffice  + "' - " + averageSalary + " руб.");
        }
        System.out.println("");
    }
    public static void getofficeMinMax (Employee[] employees, String nameOffice, int min_max) {
        int minId = 0;
        int maxId = 0;
        double beginSalaryMax = 0;
        double beginSalaryMin = 1_000_000;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment().equals(nameOffice)){
                if (employees[i].getSalary() > beginSalaryMax) {
                    beginSalaryMax = employees[i].getSalary();
                    maxId = i;
                }
                if (employees[i].getSalary() < beginSalaryMin) {
                    beginSalaryMin = employees[i].getSalary();
                    minId = i;
                }
            }
        }
        if (min_max == 0) {
            System.out.println(employees[minId].getFio() + " - заработная плата: " + beginSalaryMin + " руб.");
        }
        if (min_max == 1) {
            System.out.println(employees[maxId].getFio() + " - заработная плата: " + beginSalaryMax + " руб.");
        }
        System.out.println("");
    }
    public static void indexationOfWagesOffice (Employee[] employees, String nameOffice, double index) {
        NumberFormat divider = NumberFormat.getInstance(new Locale("ru", "RU")); // Разделяем на 1000;
        System.out.println("Зарплата после индексации на " + index + " % :");
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getDepartment().equals(nameOffice)) {
                double salary = Math.round(((employees[i].getSalary() * index / 100) * 100.0) / 100.0);
                employees[i].setSalary(employees[i].getSalary() + salary);
                System.out.println("    " + employees[i].getFio() + " " + divider.format(employees[i].getSalary()) + " руб.");
            }
        }
        System.out.println("");
    }
    public static void getMinSalary (Employee[] employees, double idMinSalary) {
        int outemployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() < idMinSalary) {
                System.out.println("   " + (i+1) + ". " + employees[i].getFio() + " " + " - заработная плата " + employees[i].getSalary()+ " руб.");
            outemployees ++;
            }
        }
        if (outemployees == 0) {
            System.out.println("Сотрудников с заработной платой менее " + idMinSalary + " руб. - 'НЕТ'.");
        }
        System.out.println("");
    }
    public static void getMaxSalary (Employee[] employees, double idMaxSalary) {
        int outemployees = 0;
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getSalary() > idMaxSalary) {
                System.out.println("   " + (i+1) + ". " + employees[i].getFio() + " " + " - заработная плата " + employees[i].getSalary()+ " руб.");
            outemployees ++;
            }
        }
        if (outemployees == 0) {
            System.out.println("Сотрудников с заработной платой более " + idMaxSalary + " руб. - 'НЕТ'.");
        }
        System.out.println("");
    }
    public static void indexationOfWages (Employee[] employees, double index) {
        NumberFormat divider = NumberFormat.getInstance(new Locale("ru", "RU")); // Разделяем на 1000;
        System.out.println("Зарплата после индексации на " + index + " % :");
        for (int i = 0; i < employees.length; i++) {
            double salary = Math.round(((employees[i].getSalary() * index / 100)*100.0)/100.0);
            employees[i].setSalary(employees[i].getSalary() + salary);
            System.out.println("    " + employees[i].getFio() + " " + divider.format(employees[i].getSalary()) + " руб.");
        }
    }
    public static void main(String[] args) {

        double wageIndexation = 0;          // Индексация заработной платы предприятия в "%".
        double wageIndexationOffice = 0;    // Индексация заработной платы отдела в "%"
        double idMinSalary = 0;             // Верхняя граница минимальной заработной платы.
        double idMaxSalary = 0;             // Нижняя граница максимальной заработной платы.
        int a = 0;                          // Критерий продолжения работы с меню.
        boolean b = true;                   // Критерий продолжения работы при ошибочно введённых данных.
        String nameOffice = "";             // Имя отдела.

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
        employees[Employee.id] = new Employee("Степанов Иван Аркадьевич", "Логистика", 65_000);

        Scanner in = new Scanner(System.in);

        System.out.println("Справочник по сотрудникам предприятия 'Сувениры Магадана'.");

        do {
            System.out.println("Что Вас интересует:\n   " +
                    "1. Проиндексировать зарплату наших сотрудников\n      " +
                    "(после индексации Вы будете работать с новыми данными по заработной плате).\n   " +
                    "2. Найти сотрудников с зарплатой менее ___руб.\n   " +
                    "3. Найти сотрудников с зарплатой более ___ руб.\n   " +
                    "4. Работа с конкретным отделом нашего предприятия.");

            int key = in.nextInt();
            if (key < 1 || key > 4) {
                System.out.println("Некорректный ввод...");
            }
            switch (key) {
                case 1:
                    System.out.print("Введите значение индексации (%): ");
                    wageIndexation = in.nextDouble();
                    if (wageIndexation < 0) {
                        throw new RuntimeException("Вы издеваетесь ... ;)))");
                    }
                    indexationOfWages(employees, wageIndexation);
                    System.out.println("-----------------------------");
                    break;

                case 2:
                    b = true;
                    while (b) {
                        System.out.print("Введите интересующую Вас зарплату (руб.): ");
                        idMinSalary = in.nextDouble();
                        if (idMinSalary < 0) {
                            System.out.println("Ошибочка... Ещё разок ;)))");
                        } else {
                            b = false;
                        }
                    }
                    getMinSalary(employees, idMinSalary);
                    break;

                case 3:
                    b = true;
                    while (b) {
                        System.out.print("Введите интересующую Вас зарплату (руб.): ");
                        idMaxSalary = in.nextDouble();
                        if (idMaxSalary < 0) {
                            System.out.println("Ошибочка... Ещё разок ;)))");
                        } else {
                            b = false;
                        }
                    }
                    getMaxSalary(employees, idMaxSalary);
                    break;

                case 4:
                    b = true;
                    while (b) {
                        System.out.println("Укажите номер интересующего Вас отдела:\n   " +
                                "1. 'Управление'.\n   " +
                                "2. 'Бухгалтерия'.\n   " +
                                "3. 'Логистика'.\n   " +
                                "4. 'Склад'.\n   " +
                                "5. 'Доставка'.");
                        int office = in.nextInt();
                        if (office < 1 || office > 5) {
                            System.out.println("Ошибочка... Ещё разок ;)))");
                        } else {
                            b = false;
                            switch (office) {
                                case 1:
                                    nameOffice = "Управление";
                                    break;
                                case 2:
                                    nameOffice = "Бухгалтерия";
                                    break;
                                case 3:
                                    nameOffice = "Логистика";
                                    break;
                                case 4:
                                    nameOffice = "Склад";
                                    break;
                                case 5:
                                    nameOffice = "Доставка";
                                    break;
                            }
                            b = true;
                            while (b) {
                                System.out.println("Отдел - '" + nameOffice + "'.");
                                System.out.println("   1. Узнать сотрудника с минимальной зарплатой.\n   " +
                                        "2. Узнать сотрудника с максимальной зарплатой.\n   " +
                                        "3. Узнать фонд заработной платы отдела.\n   " +
                                        "4. Среднемесячную зарплату отдела.\n   " +
                                        "5. Проиндексировать заработную плату сотрудников отдела.\n   " +
                                        "6. Список сотрудников отдела.   ");
                                int menuOffice = in.nextInt();
                                if (menuOffice < 1 || menuOffice > 6) {
                                    System.out.println("Ошибочка... Ещё разок ;)))");
                                } else {
                                    b = false;
                                    switch (menuOffice) {
                                        case 1:
                                            int min_max = 0;
                                            getofficeMinMax (employees, nameOffice, min_max);
                                            break;
                                        case 2:
                                            min_max = 1;
                                            getofficeMinMax (employees, nameOffice, min_max);
                                            break;
                                        case 3:
                                            int f_a = 0;
                                            calculateSalaryFund_Average(employees, nameOffice, f_a);
                                            break;
                                        case 4:
                                            f_a = 1;
                                            calculateSalaryFund_Average(employees, nameOffice, f_a);
                                            break;
                                        case 5:
                                            System.out.print("Введите значение индексации (%): ");
                                            wageIndexationOffice = in.nextDouble();
                                            indexationOfWagesOffice (employees, nameOffice, wageIndexationOffice);
                                            break;
                                        case 6:
                                            printAllWorkers(employees, nameOffice);
                                            break;
                                    }
                                }
                            }
                        }
                    }
                    break;
            }
            returnMenu (a);
        } while (a == 0);
    }
}