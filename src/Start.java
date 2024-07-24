import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.student.manage.Student;
import com.student.manage.StudentDao;

public class Start {
    public static void main(String[] args) throws NumberFormatException, IOException {
        System.out.println("Welcome to student mangement project");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            System.out.println("Press 1 to Add Student");
            System.out.println("Press 2 to Delete Student");
            System.out.println("Press 3 to Display Student");
            System.out.println("Press 4 to Update the app");
            System.out.println("Press 5 to exit the app");

            int c = Integer.parseInt(br.readLine());

            if (c == 1) {
                System.out.println("Enter user name :");
                String name = br.readLine();

                System.out.println("Enter user phone : ");
                String phone = br.readLine();

                System.out.println("Enter user city :");
                String city = br.readLine();

                Student st = new Student(name, phone, city);
                boolean answer = StudentDao.insertStudentToDB(st);
                if (answer) {
                    System.out.println("Student is added successfully");
                } else {
                    System.out.println("something went wrong");
                }

                System.out.println(st);
            } else if (c == 2) {
                System.out.println("Enter student id to delete");
                int userId = Integer.parseInt(br.readLine());
                boolean f = StudentDao.deleteStudent(userId);
                if (f) {
                    System.out.println("Delete....");
                } else {
                    System.out.println("something went wrong");
                }
            } else if (c == 3) {
                System.out.println("Showing all the students");
                StudentDao.showAllStudent();

            } else if (c == 4) {
                System.out.println("Enter the Student id which you want to update");
                int userId = Integer.parseInt(br.readLine());
                System.out.println("Enter user name :");
                String name = br.readLine();

                System.out.println("Enter user phone : ");
                String phone = br.readLine();

                System.out.println("Enter user city :");
                String city = br.readLine();
                boolean f = StudentDao.updateStudent(userId, name, phone, city);
                if (f) {
                    System.out.println("Updated....");
                } else {
                    System.out.println("something went wrong");
                }
            }

            else if (c == 5) {
                break;
            }
        }
        System.out.println("Thank you using for my application");
        System.out.println("See you soon");
    }
}
