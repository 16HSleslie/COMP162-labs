public class Student {
    private String name;
    private String id;
    private String major;
    
    public Student(String name, String id, String major) {
        this.name = name;
        this.id = id;
        this.major = major;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getId() {
        return this.id;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public String toString() {
        return "Name:" + this.name + "; ID:" + this.id + "; Major:" + this.major;
    }
}