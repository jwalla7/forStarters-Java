package IO;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static java.lang.String.valueOf;

//  1.0 Serialization describes the process of taking an object's state and transforming it into a stream of bytes
    //  1.1 The stream of bytes created by serialization only includes the member variables off an object.
public class Serialization implements Serializable {
    private String myName;
    private int myAge;
    private Occupation occupation;

//    Constructor
    public Serialization(String myName, int myAge) {
        this.myName = myName;
        this.myAge = myAge;
        this.occupation = new Occupation("job input goes here");
    }

//    Methods
    public String toString() {
        return String.format("Hello, my name is %s. I am %d, and %s", this.myName, this.myAge, this.occupation);
    }


    //   Inner Class
    public class Occupation implements Serializable {
        private String occupation;

        //   Inner Class Constructor
        public Occupation(String occupation) {
            this.occupation = occupation;
        }


        //  Getter
        public String getOccupation() {
            return this.occupation;
        }

        //   toString Method
        public String toString() {
            return String.format("I work as a/an %s for a living.", this.occupation);
        }
    }

    public static void main(String[] args) throws FileNotFoundException,
                                                  IOException,
                                                  ClassNotFoundException {
//        USER INPUT
        //  Message Prompt at the start of executing Serialization.main()
        System.out.println("Nice to meet you! Who do I have the pleasure of speaking with?");
        //  Implementation of Scanner to receive user input
        Scanner console = new Scanner(System.in);
        //  Define user input
        String nameStr;
        String jobStr;
        int ageInt;
        //  Accepted user input
        String validateStr = "^[a-zA-Z\\s]*$";
        int validateInt;

        do {
            try {
                nameStr = console.nextLine();
                if (nameStr.matches(validateStr)) {
                    System.out.println("Cool, nice to meet you " + nameStr + ".");

                    break;
                } else {
                System.out.println("name validation test failed, please try again.");
                }
            } catch (Exception e) {
                System.out.println("name validation test failed, please try again.");
            } finally {
//                console.nextLine();
            }
        } while (true);
        System.out.println("How many years old are you?");
        do {
            try {
                ageInt = console.nextInt();
                if (ageInt >= 4 && ageInt <= 120) {
                    System.out.println("Great!");
                    break;
                } else {
                    System.out.println("age validation test failed, please try again.");
                }
            } catch (InputMismatchException matchE){
                    System.out.println("age validation test failed, please try again.");
            } catch (ArithmeticException arithE){
                    System.out.println("are you really this old? Please try again.");
            } finally {
                console.nextLine();
            }
        } while (true);
        System.out.println("What do you work as for a living?");
        do {
            try {
                jobStr = console.nextLine();
                if (jobStr.matches(validateStr)) {
                    System.out.println("Wow, it's cool meeting a/an " + jobStr.toLowerCase() + "!");
                    break;
                } else {
                    System.out.println("occupation validation test failed, please try again.");
                }
            } catch (Exception e) {
                System.out.println("occupation validation test failed, please try again.");
            } finally {
//                console.nextLine();
            }
        } while (true);

//        STREAM
        Serialization user1 = new Serialization(nameStr, ageInt);

        FileOutputStream useFileOutputStream = new FileOutputStream("user1Serialization.txt");
        ObjectOutputStream useObjectOutputStream = new ObjectOutputStream(useFileOutputStream);
        useObjectOutputStream.writeObject(user1);

        FileInputStream useFileInputStream = new FileInputStream("user1Serialization.txt");
        ObjectInputStream useObjectInputStream = new ObjectInputStream(useFileInputStream);


        Serialization user1Copy = (Serialization) useObjectInputStream.readObject();

        boolean isCopyIdentical = user1Copy == user1;
        System.out.println("(Copy) created - " + user1Copy);
        System.out.println("Serialized text file: " + useFileInputStream.getFD() + " created.");
    }
}

