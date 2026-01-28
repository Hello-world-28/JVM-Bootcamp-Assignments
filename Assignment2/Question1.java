//Write a program to display values of enums using a constructor & getPrice() method (Example display house & their prices)

enum House {
    APARTMENT(3000000),
    VILLA(8000000),
    BUNGALOW(12000000),
    COTTAGE(4500000);

    private int price;

    // enum constructor
    House(int price) {
        this.price = price;
    }

    // getter method
    public int getPrice() {
        return price;
    }
}

class Question1 {
    public static void main(String[] args) {

        for (House h : House.values()) {
            System.out.println(h + " price = " + h.getPrice());
        }
    }
}