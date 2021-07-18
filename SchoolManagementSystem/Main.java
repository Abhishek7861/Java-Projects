import SchoolPkg.School;
import SchoolPkg.Teacher;
import SchoolPkg.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter School Name: ");
        String schoolName =sc.nextLine();
        List<Teacher> teacherList = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();
        School sch = new School(teacherList,studentList);
        while(true) {
            System.out.println("1: Add Student");
            System.out.println("2: Add Teacher");
            System.out.println("3: Student Fees");
            System.out.println("4:Teacher Slary");
            System.out.println("5:School expense");
            System.out.println("6:School earnings");
            System.out.println("7:Exit");
            String choice = sc.nextLine();
            switch(choice){
                case "1":{
                    break;
                }
                case "2":{
                    break;
                }
                case "7":{
                    return;
                }
                default:
                {

                }
            }
        }
    }
}
