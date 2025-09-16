import java.util.Scanner;
/** Represents an dog */
public class Dog {
    private String name;
    private String breed;
    private char sex;
    private int regNo;
    private int age;
    private boolean microChipped;
    private String size;

    /** Constructor that takes 7 parameters, used to initialise the datafields.*/
    public Dog(String name, String breed, char sex, int regNo, int age, boolean microChipped, String size) {
        this.name = name;
        this.breed = breed;
        this.sex = sex;
        this.regNo = regNo;
        this.age = age;
        this.microChipped = microChipped;
        this.size = size;
    }

    /**accessor for this dog's name*/
    public String getName() {
        return name;
    }

    /**accessor for this dog's breed*/
    public String getBreed() {
        return breed;
    }

    /**accessor for this dog's sex*/
    public char getSex() {
        return sex;
    }
    /**accessor for this dog's registration number*/
    public int getRegNo() {
        return regNo;
    }

    /**accessor for this dog age*/
    public int getAge() {
        return age;
    }

    /**accessor for whether this dog is microchipped*/
    public boolean isMicroChipped() {
        return microChipped;
    }

    /**accessor for this dog size*/
    public String getSize() {
        return size;
    }

    /**mutator to set this dog's age to true*/
    public void setAge(int age) {
        this.age = age;
    }

    /**mutator to set this dog's microchipped status to true*/
    public void setMicroChipped() {
        this.microChipped = true;
    }

    /** returns a String summary of this Dog*/
    public String toString() {
        String sex = this.sex == 'm' ? "male" : "female";
        String microChipped = this.microChipped ? "has" : "has not";

        return "Dog " + regNo + ": " + name + " is a " + size + ", " + age + " year-old, " +
            sex + " " + breed + ", who " + microChipped + " been micro chipped.";
    }
}