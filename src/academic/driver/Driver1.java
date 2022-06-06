package academic.driver;

import java.util.Arrays;
import java.util.Scanner;
import academic.model.Course;
import academic.model.Enrollment;
import academic.model.Student;
import academic.model.Lecturer;

/**
 * @author 12S20020_Suprianto Dharma Sitompul
 */

public class Driver1 {  
    public static Course[] courses = new Course[0];
    public static Student[] students = new Student[0];
    public static Enrollment[] enrollments = new Enrollment[0];
    public static Lecturer[] lecturers = new Lecturer[0];
    public static String dataRename = "";
    public static int i;
    public static void main(String[] _args) {
        Scanner sc = new Scanner(System.in);
        String input = null;
        String[] rename;

        while (!(input = sc.nextLine()).equals("---")) {
            String[] argument = input.split("#");
            String command = argument[0];
            argument = Arrays.copyOfRange(argument, 1, argument.length);
            

             if(input.equals("student-add")){
                Lecturer newLecturer = arrayToLecturer(argument);
                addLecturer(newLecturer);
                
             }        
                       
            switch (command) {
                case "lecturer-add":
                Lecturer lecturer= checkDuplicateLecturer(argument[0],argument[2],argument[3]);
                    if(lecturer != null){
                        break;
                    }
                    else{
                        Lecturer newLecturer = arrayToLecturer(argument);
                        addLecturer(newLecturer);
                        break;
                    }
                    
                case "course-add":
                    Course course = checkDuplicateCorCourse(argument[0]);
                    if(course != null){
                        break;
                    }
                    else{
                    rename= argument[4].split(",");                    
                    for( i =0 ; i < rename.length;i++){
                        if(i == rename.length -1){
                            for (Lecturer x : lecturers){
                                if (x.getInitial().equals(rename[i])){
                        dataRename = dataRename.concat(String.format("%s (%s)", rename[i], x.getEmail() ));                                ;
                        }
                     }
                      }
                    else{
                        for (Lecturer x : lecturers){
                        if (x.getInitial().equals(rename[i])){
                            dataRename = dataRename.concat(String.format("%s (%s);", rename[i], x.getEmail() ));                                ;
                                }
                            }
                        }
                        }
                        
                        argument[4] = dataRename ;
                        Course newCourse = arrayToCourse(argument);
                        addCourse(newCourse);
                        break;
                        
                    }


                case "student-add":
                    Student student = checkDuplicateStudent(argument[0]);
                    if(student != null){
                        break;
                    }
                    else{
                    Student newStudent = arrayToStudent(argument);
                    addStudent(newStudent);
                    break;
                    }
                    
                case "enrollment-add":
                    Enrollment newEnrollment = arrayToEnrollment(argument);
                    addEnrollment(newEnrollment);
                    break;
                 
                case "enrollment-grade":
                    for (Enrollment enrollment : enrollments){
                        if (enrollment.getId().equals(argument[1]) && enrollment.getCode().equals(argument[0]) && enrollment.getYear().equals(argument[2]) &&
                        enrollment.getSemester().equals(argument[3])){
                            enrollment.setGrade(argument[4]);
                        }
                    }
                    break;
            }
        }
        cetakSemuaData();
        sc.close();
    }

    public static Course checkDuplicateCorCourse(String idOfCourse){
        for (Course course : courses){
            if (course.getCode().equals(idOfCourse)){
                return course;
            }
        }
        return null;
    }
    private static void cetakSemuaData() {
        cetakSemuaDataLecturers();
        cetakSemuaDataCourses();
        cetakSemuaDataStudents();
        cetakSemuaDataEnrollments();
        
    }
    // Lecturers
    public static Lecturer checkDuplicateLecturer(String idOfLecturer,String initialOfLecturer,String EMAILLecturer){
        for (Lecturer lecturer : lecturers){
            if (lecturer.getId().equals(idOfLecturer) && 
                lecturer.getInitial().equals(initialOfLecturer) && 
                lecturer.getEmail().equals(EMAILLecturer)){
                return lecturer;
            }
        }
        return null;
    }
    
    private static void cetakSemuaDataLecturers() {
        for (Lecturer Lecturer : lecturers) {
            System.out.println(Lecturer);
        }
    }

    private static void addLecturer(Lecturer lecturer) {
        lecturers = Arrays.copyOf(lecturers, lecturers.length + 1);
        lecturers[lecturers.length - 1] = lecturer;
    }

    private static Lecturer arrayToLecturer(String[] argument) {
        Lecturer Lecturer = new Lecturer(argument[0],argument[1],argument[2],argument[3],argument[4]);
        return Lecturer;
    }
    
    // Courses
    private static void cetakSemuaDataCourses() {
        for (Course course : courses) {
            System.out.println(course);
        }
    }

    private static void addCourse(Course course) {
        courses = Arrays.copyOf(courses, courses.length + 1);
        courses[courses.length - 1] = course;
    }

    private static Course arrayToCourse(String[] argument) {
        Course course = new Course(argument[0],argument[1],Integer.parseInt(argument[2]),argument[3],argument[4]);
        return course;
    }

    // Students
    public static Student checkDuplicateStudent(String CODEStudent){
        for (Student student : students){
            if (student.getId().equals(CODEStudent)){
                return student;
            }
        }
        return null;
    }
    
    private static void cetakSemuaDataStudents() {
        for (Student student : students) {System.out.println(student);}
    }

    private static void addStudent(Student student) {
        students = Arrays.copyOf(students, students.length + 1);
        students[students.length - 1] = student;
    }
    private static Student arrayToStudent(String[] argument) {
        Student student = new Student(argument[0],argument[1],argument[2],argument[3]);
        return student;
    }

    //Enrollment
    public static Enrollment checkDuplicateEnrollment(String idOfEnrollment){
        for (Enrollment enrollment : enrollments){
            // System.out.println(enrollment);
            if (enrollment.getCode().equals(idOfEnrollment)){
                return enrollment;
            }
        }
        return null;
    }

    private static void cetakSemuaDataEnrollments() {
        for (Enrollment enrollment : enrollments) {
            System.out.println(enrollment);
        }
    }
    private static void addEnrollment(Enrollment enrollment) {
        enrollments = Arrays.copyOf(enrollments, enrollments.length + 1);
        enrollments[enrollments.length - 1] = enrollment;
    }
    private static Enrollment arrayToEnrollment(String[] argument) {
        Enrollment enrollment = new Enrollment(argument[0],argument[1],argument[2], argument[3]); return enrollment;
    }
}