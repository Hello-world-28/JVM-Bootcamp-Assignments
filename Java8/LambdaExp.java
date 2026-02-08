class LambdaExp{
    public static void main(String[] args){
        // Lambda expression
        Runnable obj = () -> {
            System.out.println("Hello, Lambda!");
        };
        // Invoking the lambda expression
        obj.run();
    }
}
@FunctionalInterface
interface A {
    void m1();
}
@FunctionalInterface
interface B extends A{
} 