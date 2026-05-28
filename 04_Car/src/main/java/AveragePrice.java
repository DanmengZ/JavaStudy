public class AveragePrice {
    public static double getAveragePrice(Car[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            Car c = arr[i];
            sum += c.getPrice();
        }

        return sum * 1.0 / arr.length;
    }
}
