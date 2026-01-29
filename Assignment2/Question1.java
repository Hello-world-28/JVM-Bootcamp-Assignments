//Write a program to display values of enums using a constructor & getPrice() method (Example display house & their prices)

enum HOUSE {
    ONE_BHK(2500),
    TWO_BHK(5000),
    THREE_BHK(7500);

    private int price;

    //constructor
    HOUSE(int price) {
        this.price = price;
    }

    //getter method
    public int getPrice() {
        return this.price;
    }
}

class Question1 {
    public static void main(String[] args) {
        for (HOUSE house : HOUSE.values()) {
            System.out.println(house + " price: " + house.getPrice());
        }
    }
}
