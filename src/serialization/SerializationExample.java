package serialization;

import java.io.*;

class Animal  {
    int age;
    int weight;

    Animal() {
        System.out.println("Inside a no-args Animal constructor");
    }

    Animal(int age) {
        this();
        this.age = age;
        System.out.println("Inside single args Animal constructor");
    }
}

// Class must implement Serializable if it does not extend
// a class that implements Serializable...
class Pet extends Animal implements Externalizable {
    private String name;
    private String type;
    private transient String breed = "Unknown";
    static int count;

    // No arguments constructor
    public Pet() {
        super(0);
        System.out.println("Inside no args Pet constructor");
    }

    // Constructor takes name and type of Pet
    Pet(String name, String type) {
        super(0);
        this.name = name;
        this.type = type;
        System.out.println("Inside Pet(name,type) constructor");
    }

    // Use IntelliJ generated toString() method
    public String toString() {
        return "Pet{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", breed='" + breed + '\'' +
                ", age='" + age + '\'' +
                ", weight='" + weight + '\'' +
                ", count='" + count + '\'' +
                '}';
    }

    // overrides default method on Serializable
    private void writeObject(java.io.ObjectOutputStream out)
            throws IOException {
        out.defaultWriteObject();
        out.writeInt(age);
        out.writeInt(weight);
    }

    // overrides default method on Serializable
    private void readObject(java.io.ObjectInputStream in)
            throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        age = in.readInt();
        weight = in.readInt();
    }

    public void writeExternal(ObjectOutput out) throws IOException {
        System.out.println("writeExternal");
        out.writeObject(name);
        out.writeObject(breed);
        out.write(age);
    }

    public void readExternal(ObjectInput in) throws IOException,
            ClassNotFoundException {
        System.out.println("readExternal");
        name = (String) in.readObject();
        breed = (String) in.readObject();
        age = in.read();
    }

}

public class SerializationExample {
    public static void main(String[] args) throws IOException,
            ClassNotFoundException {

        String fileName = "Brandy.ser";

        Pet originalPet = new Pet("Brandy", "Dog");
        originalPet.age = 5;
        originalPet.weight = 30;
        Pet.count = 55;

        System.out.println("--------- Original State -----------");
        System.out.println(originalPet);

        // Use try with resources (automatically closes file) to output
        // the Pet object
        try (ObjectOutputStream outputStream = new ObjectOutputStream(
                new FileOutputStream(fileName))) {
            // write the Pet to a file
            outputStream.writeObject(originalPet);
        }

        Pet deserializedPet = null;
        // Use try with resources (automatically closes file) to input
        // the Pet object
        try (ObjectInputStream inStream = new ObjectInputStream(
                new FileInputStream(fileName))) {
            try {
                // read the Pet from a file
                deserializedPet = (Pet) inStream.readObject();

                // Need to check for EOFException
            } catch (EOFException e) {
                // Ignore, end of file
            }
        }

        System.out.println("------- Deserialized State ------");
        System.out.println(deserializedPet);

    }
}
