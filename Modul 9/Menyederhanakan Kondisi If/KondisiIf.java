public class KondisiIf {
    public static void accept() {
        System.out.println("Kondisi diterima");
    }
    public static void reject() {
        System.out.println("Kondisi ditolak");
    }
    public static void main(String[] args) {
        int score = 650;
        int income = 75000;
        boolean authorized = true;

        if (score > 700) {
            accept();
        } else if ((income >= 40000) && (income <= 100000) && authorized && (score > 500)) {
            accept();
        } else if (income > 100000) {
            accept();
        } else {
            reject();
        }
    }
}
