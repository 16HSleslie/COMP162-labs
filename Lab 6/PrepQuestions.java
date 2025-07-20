/*
1. The class Art is extended by 2 classes, Sculpture and Print. The Sculpture class has its call to the
super constructor written. Complete the Print constructor so all its data fields are correctly instantiated.
*/

/*
2. If there were to be other data fields, year and creator, which class should they be in?

They would be in the Art class
*/

/*
3. Finish the for-each loop in the application class so the total value of the collection is correctly calcu-
lated.
*/

public class Art {
    protected int height;
    protected int width;
    protected int value;
    public Art(int width, int height, int value) {
        this.width = width;
        this.height = height;
        this.value = value;
    }
}

public class Sculpture extends Art {
    private int weight;
    private int depth;
    public Sculpture(int width, int height, int depth, int weight, int value) {
        super(width, height, value);
        this.depth = depth;
        this.weight = weight;
        
    }
}

public class Print extends Art {
    private int numMade;
    public Print(int width, int height, int numMade, int value) {
        super(width, height, value); // Question 1
        this.numMade = numMade; // Question 1
    }
}

public class ArtApp {
    public static void main(String[] args) {
        Art[] collection = {
            new Sculpture(200, 500, 300, 25, 25000),
            new Print(800, 900, 40, 400),
            new Sculpture(350, 835, 553, 150, 4500)
        };
        
        int totalValue = 0;
        
        for (Art work: collection) {
            totalValue +=    
        }
        System.out.println("total value $" + totalValue);
    }
}

/*
4. 
(a) Examine the class hierarchy in the diagram, then answer the questions below

    i.    There are three different travel methods, A B and C. Which one does Kiwi use?
    
          B

    ii.   Which one does LittleBlue use?
    
          C

    iii.  Which one does Albatross use?
    
          A

    iv.   List all the methods that Kiwi can use?
    
          getWingSpan(), nests(), layEggs(), travel()

    v.    Can LittleBlue use the getWingSpan() method?
    
          Yes the subclass LittleBlue has desceneded from all the classes in the inheritance chain.
          This means it has inherited all public or protected members from each superclass in said
          chain. Since there is a direct chain of inheritance from Bird -> LittleBlue, LittleBlue has
          inherited memebers from Bird.

    vi.   Can Albatross moult()?
    
          No Albatorss cannot use moult(). This is because the moult() method is declaired in the class
          Pengiun and not inherited from the superclass Bird. Since Albatross is a subclass of Bird, and
          not Pengiun it did not inherite the method moult().

    vii.  Write a statement for the Kiwi class so it can access access Bird’s nests() method.
    
          super.nests();

    viii. Declare an array which may hold up to 5 Bird elements. This array will be able to store references 
          to any type of Bird (Kiwi OR Albatross OR Penguin OR LittleBlue OR EmperorOR Bird). 
          Write another statement which makes the first element of the array a reference to
          a new instance of LittleBlue.
          
          Bird[] birds = new Bird[5];
          birds[0] = new LittleBlue();

(b) Why is inheritance useful?

    Inheritance is useful because when you want to create a new class and there is already
    a class that already includes some of the code that you want, you can derive your new
    class from the existing class. in doing this you can reuse the fields and methods of
    the existing class whitout having to rewrite them again. It also allows for polymorphism,
    this is where subclasses of a class can define their own unique behaviours and still share
    some of the same functionality of the superclass. It also allows for more maintainable and
    oraganised code.

(c) What is over-riding? Give an example from the Bird hierarchy.

    Over-riding a method allows a class to inherit from a superclass whos behaviour is close-enough
    and then modify behaviour as needed. This allows methods inherited from the superclass to 
    have different behaviour for each subclass.
    
    An example from the Bird hierachy is the nests() method. A common characteristic of birds
    is that they create nest, but the characteristics of said nests can vary bewtween different
    birds. Each subclass of the Bird class has the nests() method, but each subclass implement 
    different behaviour of the method based on the characteristics of the type of birds the
    subclass represents.
*/