package CleanCode;

public class Employees {
    private int monthlySalary;
    private int commission;
    private int bonus;
    private EmployeeType type;

    public Employees(int monthlySalary, int commission, int bonus, EmployeeType type) {
        this.monthlySalary = monthlySalary;
        this.commission = commission;
        this.bonus = bonus;
        this.type = type;
    }

    public int payAmount() throws Exception {
        switch (type) {
            case ENGINEER:
                return monthlySalary;
            case SALESMAN:
                return monthlySalary + commission;
            case MANAGER:
                return monthlySalary + bonus;
            default:
                throw new Exception("Incorrect Employee");
        }
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

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

    public void setMonthlySalary(int monthlySalary) {
        this.monthlySalary = monthlySalary;
    }

    public void setCommission(int commission) {
        this.commission = commission;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }
}

enum EmployeeType {
    ENGINEER, SALESMAN, MANAGER;
}
