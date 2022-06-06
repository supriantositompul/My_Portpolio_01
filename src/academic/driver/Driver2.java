package academic.driver;

import java.util.Arrays;
import java.util.Scanner;

import academic.model.*;

/**
 * @author 12S20020_Suprianto Dharma Sitompul
 */

public class Driver2 {
    public static Course[] courses = new Course[0];
    public static Student[] students = new Student[0];
    public static Enrollment[] enrollments = new Enrollment[0];
    public static Lecturer[] lecturers = new Lecturer[0];
    public static String dataRename = "";
    public static int i;
    static AcademicDetails[] academicDetails = new AcademicDetails[0];

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
                Lecturer lecturer= checkDuplicateCorLecturer(argument[0],argument[2],argument[3]);
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
                                    // k = k+1
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
                        dataRename="";
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
                        if (enrollment.getId().equals(argument[1]) && enrollment.getCode().equals(argument[0])){
                            enrollment.setGrade(argument[4]);
                        }
                    }
                    break;
                case "student-details":
                    int totalcredit =0;
                    AcademicDetails academicDetail;
                    for(Enrollment enrollment : enrollments){
                        if (enrollment.getId().equals(argument[0])){
                            for(Course course1 : courses){
                                if (course1.getCode().equals(enrollment.getCode())){
                                    totalcredit = totalcredit + course1.getCredit();
                                }
                            }
                        }
                    }
                    for (Student student1 : students){
                        if (student1.getId().equals(argument[0])){
                            academicDetail = new AcademicDetails(student1.getId(),student1.getName(),student1.getYear(),student1.getStudyProgram(), totalcredit);
                            addAcademicDetail(academicDetail);
                            countGpa(academicDetail);
                        }
                    }

                    break;    
            }
        }
        printAll();

        sc.close();
    }
    
      public static Course checkDuplicateCorCourse(String CODECourse){
        for (Course course : courses){
            if (course.getCode().equals(CODECourse)){
                return course;
            }
        }
        return null;
    }

    private static void printAll() {
        printAllAcademicDetails();
        printAllLecturers();
        printAllCourses();
        printAllStudents();
        printAllEnrollments();
        
    }


    // Lecturers

    public static Lecturer checkDuplicateCorLecturer(String idOfLecturer,String initialOfLecturer,String emailOfLecturer){
        for (Lecturer lecturer : lecturers){
            if (lecturer.getId().equals(idOfLecturer) && lecturer.getInitial().equals(initialOfLecturer) && lecturer.getEmail().equals(emailOfLecturer)){
                return lecturer;
            }
        }
        return null;
    }
    
    private static void printAllLecturers() {
        for (Lecturer Lecturer : lecturers) {
            System.out.println(Lecturer);
        }
    }

    private static void addLecturer(Lecturer lecturer) {
        lecturers = Arrays.copyOf(lecturers, lecturers.length + 1);
        lecturers[lecturers.length - 1] = lecturer;
    }

    private static Lecturer arrayToLecturer(String[] argument) {
        Lecturer Lecturer = new Lecturer(argument[0],argument[1],argument[2], argument[3], argument[4]);

        return Lecturer;
    }

    // Courses
    private static void printAllCourses() {
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
    
    private static void printAllStudents() {
        for (Student student : students) {
            System.out.println(student);
        }
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
    public static Enrollment checkDuplicateEnrollment(String CODEEnrollment){
        for (Enrollment enrollment : enrollments){
            // System.out.println(enrollment);
            if (enrollment.getCode().equals(CODEEnrollment)){
                return enrollment;
            }
        }
        return null;
    }

    private static void printAllEnrollments() {
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

    //Academic Details
    private static void printAllAcademicDetails() {
        for (AcademicDetails academicDetail : academicDetails) {
            System.out.println(academicDetail);
        }
    }

    private static void addAcademicDetail(AcademicDetails academicDetail) {
        academicDetails = Arrays.copyOf(academicDetails, academicDetails.length + 1);
        academicDetails[academicDetails.length - 1] = academicDetail;
    }


    // Counting gpa, change the grade to gpa and than count the gpa
    private static void countGpa(AcademicDetails academicDetail) {
        int totalcredit = academicDetail.getTotalCredit();
        double totalgpa = 0;
        for (Enrollment enrollment : enrollments){
            if (enrollment.getId().equals(academicDetail.getId())){
                for (Course course : courses){
                    if (course.getCode().equals(enrollment.getCode())){
                        if (enrollment.getGrade().equals("A")){
                            totalgpa = totalgpa + (4 * course.getCredit());
                        }
                        if(enrollment.getGrade().equals("AB")){
                            totalgpa = totalgpa + (3.5 * course.getCredit());
                        }
                        else if (enrollment.getGrade().equals("B")){
                            totalgpa = totalgpa + (3 * course.getCredit());
                        }
                        else if(enrollment.getGrade().equals("BC")){
                            totalgpa = totalgpa + (2.5 * course.getCredit());
                        }
                        else if (enrollment.getGrade().equals("C")){
                            totalgpa = totalgpa + (2 * course.getCredit());
                        }
                        else if (enrollment.getGrade().equals("D")){
                            totalgpa = totalgpa + (1 * course.getCredit());
                        }
                        else if (enrollment.getGrade().equals("E")){
                            totalgpa = totalgpa + (0 * course.getCredit());
                        }
                    }
                }
            }
        }

        double gpa = totalgpa / totalcredit;
        academicDetail.setGpa(gpa);
    }
}