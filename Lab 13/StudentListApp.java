public class StudentListApp {
    public static void main(String[] args) {
        
        StudentList studentList = new StudentList();
        studentList.addStudentToHead(new Student("Harry Stanley", "1234", "Doodling"));
        studentList.addStudentToHead(new Student("Luke Skywalker", "9876", "Fortnite"));
        studentList.addStudentToHead(new Student("Bob Ross", "5555", "Art"));
        //studentList.addStudentToTail(new Student("jimbo Ross", "2345", "poop"));
        //studentList.addStudentToHead(new Student("Bob Ross", "5555", "Art"));
        
        studentList.displayStudent();
    }
}