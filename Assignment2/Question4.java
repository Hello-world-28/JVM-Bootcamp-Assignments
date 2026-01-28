//Write a program to show application of Factory Design Pattern.


interface Biscuit { //product interface
    void showBiscuitType();
}

// Concrete products
class Oreo implements Biscuit {
    @Override
    public void showBiscuitType() {
        System.out.println("This is an Oreo biscuit");
    }
}

class Marie implements Biscuit {
    @Override
    public void showBiscuitType() {
        System.out.println("This is a Marie biscuit");
    }
}

// Factory class
class BiscuitFactory {

    public static Biscuit getBiscuit(String type) {
        if (type == null) {
            return null;
        }

        if (type.equalsIgnoreCase("OREO")) {
            return new Oreo();
        } else if (type.equalsIgnoreCase("MARIE")) {
            return new Marie();
        }
        throw new IllegalArgumentException("Unknown biscuit type");
    }
}

// Client
public class Question4 {
    public static void main(String[] args) {

        Biscuit biscuit1 = BiscuitFactory.getBiscuit("OREO");
        biscuit1.showBiscuitType();

        Biscuit biscuit2 = BiscuitFactory.getBiscuit("MARIE");
        biscuit2.showBiscuitType();
    }
}