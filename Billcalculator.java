public class BillCalculator {
    public static double calculateBill(double units) {
        double amount = 0;
        if (units <= 100) {
            amount = units * 1.5;
        } else if (units <= 200) {
            amount = (100 * 1.5) + (units - 100) * 2.5;
        } else if (units <= 300) {
            amount = (100 * 1.5) + (100 * 2.5) + (units - 200) * 3.5;
        } else {
            amount = (100 * 1.5) + (100 * 2.5) + (100 * 3.5) + (units - 300) * 5.0;
        }
        return amount;
    }
}