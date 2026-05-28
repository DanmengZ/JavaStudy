import java.util.Scanner;

public class CarTest {
    public static void main(String[] args) {
        Car[] arr = new Car[3];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < arr.length; i++) {
            Car c = new Car();

            System.out.println("输入汽车品牌");
            c.setBrand(sc.next());

            System.out.println("输入汽车颜色");
            c.setColor(sc.next());

            System.out.println("输入汽车价格");
            c.setPrice(sc.nextInt());

            arr[i] = c;
        }

        for (int i = 0; i < arr.length; i++) {
            Car c = arr[i];
            System.out.println("牌子：" + c.getBrand() + "，颜色：" + c.getColor() + "，价格：" + c.getPrice());
        }

        double avg = AveragePrice.getAveragePrice(arr);
        System.out.println("汽车平均价格是：" + avg);
    }
}
