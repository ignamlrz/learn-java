package problems;

// Simple Neighbor class, has a name
class Neighbor {
    private final String name;

    // Constructor
    public Neighbor(String name) {
        this.name = name;
    }

    // synchronized method cannot execute if the instance is locked,
    // will lock instance when operation is invoked, and release lock
    // when operation completes
    public synchronized void greet(Neighbor neighbor) {
        System.out.println("Hi " + neighbor.name
                + ", how are you?");

        neighbor.respond(this);
    }

    // synchronized method cannot execute if the instance is locked,
    // Must wait for lock on instance to be released
    public void respond(Neighbor neighbor) {
        System.out.println("I am fine, " + neighbor.name +
                ", how are the kids? ");
    }

}

// Simple deadlock example
public class DeadLockExample {

    public static void main(String[] args) {
        // Create two neighbors
        Neighbor dave = new Neighbor("Dave");
        Neighbor craig = new Neighbor("Craig");

        // Create and execute two threads,
        // each has the neighbor greet the other.
        new Thread(() -> dave.greet(craig)).start();
        new Thread(() -> craig.greet(dave)).start();
    }
}
