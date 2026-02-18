class Person {

    private Vehicle vehicle;
    int count = 1;

    Person(Vehicle vehicle) {
        this.vehicle = vehicle;
        System.err.println("Person count : " + count);
        count = count+1;
    }

}
