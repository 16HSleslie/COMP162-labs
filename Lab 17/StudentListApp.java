public class StudentListApp {
    public static void main(String[] args) {
        
       DoublyLinkedList < Student > studentList = new DoublyLinkedList < Student > ();
       studentList.add(new Student("Rohe Moore", "1234", "Doodling"));
       studentList.add(new Student("Kitty Gillespie", "1235", "Fortnite"));
       studentList.add(new Student("James Smith", "1235", "Advanced Snoozing"));
       studentList.displayList();

       DoublyLinkedList < Dog > dogList = new DoublyLinkedList < Dog > ();
       dogList.addLast(new Dog("Nan", "Corgi", 'f', 7564, 12, true, "small"));
       dogList.addLast(new Dog("Giles", "Schnauzer", 'm', 9457, 5, true, "medium"));
       dogList.addLast(new Dog("Remus", "Labrador", 'm', 5623, 3, true, "large"));
       dogList.addLast(new Dog("Carriad", "Golden Retriever", 'f', 9457, 5, true, "large"));
       dogList.addLast(new Dog("Muttleigh", "Mixed", 'f', 7457, 4, true, "small"));
       dogList.addLast(new Dog("Mrs Jones", "Miniature Schnauzer", 'f', 1238, 0, false, "small"));
       dogList.addLast(new Dog("Brian", "Mixed", 'm', 9234, 5, true, "medium"));
       dogList.addLast(new Dog("Beth", "Border Collie", 'f', 9457, 7, false, "medium"));
       dogList.addLast(new Dog("Jodie", "Labrador", 'f', 6547, 5, true, "large"));
       dogList.addLast(new Dog("Vicar", "Mixed", 'm', 7896, 8, true, "small"));
       dogList.addLast(new Dog("Trevor", "Mixed", 'm', 5489, 14, true, "large"));
       dogList.addLast(new Dog("Buster RIP", "Fox Terrier", 'm', 2659, 3, true, "small"));
       dogList.addLast(new Dog("Elsie", "Border Collie", 'f', 7349, 5, true, "medium"));
       dogList.addLast(new Dog("Prudence", "Poodle", 'f', 1356, 15, true, "large"));
       dogList.addLast(new Dog("Stan", "Mixed", 'm', 9823, 7, false, "small"));
       dogList.addLast(new Dog("Tud mya", "Jack Russell Terrier", 'm', 5357, 5, true, "small"));
       dogList.addLast(new Dog("Chloe", "Labrador", 'f', 9447, 7, true, "large"));
       dogList.addLast(new Dog("The Duchess", "Mixed", 'f', 9422, 8, true, "small"));
       dogList.addLast(new Dog("Marilyn", "Golden Retriever", 'm', 3358, 6, true, "large"));
       dogList.addLast(new Dog("Einstein", "Border Colloodle", 'm', 6291, 5, true, "medium"));
       dogList.add(new Dog("Molly", "Fox Terrier", 'f', 2947, 2, true, "small"));

       dogList.displayList();
       System.out.println();
       dogList.removeNode(19);

       System.out.println();
       dogList.displayList();
        
    }
}