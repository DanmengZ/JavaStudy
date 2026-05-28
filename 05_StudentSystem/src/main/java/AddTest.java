import java.util.Scanner;

public class AddTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] student = new Student[3];

        for (int i = 0; i < student.length; i++) {
            Student s = new Student();

            System.out.println("输入学生名字：");
            s.setName(sc.next());

            while (true) {
                System.out.println("输入学生学号：");
                String id = sc.next();

                if (contains(student, id)) {
                    System.out.println("当前学号已存在，请重新输入");
                } else {
                    s.setID(id);
                    break;
                }
            }

            System.out.println("输入学生性别：");
            s.setAge(sc.next());

            student[i] = s;
        }
    }

    public static boolean contains(Student[] student, String id) {
        for (int i = 0; i < student.length; i++) {
            Student s = student[i];

            if (s != null && s.getID().equals(id)) {
                return true;
            }
        }

        return false;
    }
}
