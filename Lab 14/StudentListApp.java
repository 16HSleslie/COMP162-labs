public class StudentListApp {
    public static void main(String[] args) {
        
        StudentList studentList = new StudentList();
        studentList.addStudentToHead(new Student("Harry Stanley", "1234", "Doodling"));
        studentList.addStudentToHead(new Student("Luke Skywalker", "9876", "Fortnite"));
        studentList.addStudentToHead(new Student("Bob Ross", "5555", "Art"));
        studentList.addStudentToTail(new Student("jimbo Ross", "2345", "java"));
        studentList.addStudentToHead(new Student("idk", "345", "lel"));
        studentList.addStudentToTail(new Student("test Ross", "23451", "OOP"));
        studentList.addStudentToHead(new Student("headster", "678", "magic"));
        studentList.addStudentToTail(new Student("laster", "9999", "arts"));
        
        studentList.displayStudent();
        
        //System.out.println(studentList.toString());
        
        System.out.println("\n" + studentList.getStudentById("5555"));
        
        studentList.removeStudentById("23451");
        System.out.println("");
        studentList.displayStudent();
        System.out.println("");
        studentList.displayStudentReverse();
        
        
    }
}