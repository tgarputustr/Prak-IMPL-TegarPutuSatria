package CleanCode;
public class Employee {
    private int monthlySalary;
    private int commission;
    private int bonus;
    private EmployeeType type;

    public Employee(int monthlySalary, int commission, int bonus, EmployeeType type) {
        this.monthlySalary = monthlySalary;
        this.commission = commission;
        this.bonus = bonus;
        this.type = type;
    }

    public int payAmount() {
        return type.payAmount(this);
    }

    public int getMonthlySalary() {
        return monthlySalary;
    }

    public int getCommission() {
        return commission;
    }

    public int getBonus() {
        return bonus;
    }
}
abstract class EmployeeType {
    abstract int payAmount(Employee emp);
}

class Salesman extends EmployeeType {
    int payAmount(Employee emp) {
        return emp.getMonthlySalary() + emp.getCommission();
    }
}

class Manager extends EmployeeType {
    int payAmount(Employee emp) {
        return emp.getMonthlySalary() + emp.getBonus();
    }
}
