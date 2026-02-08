@FunctionalInterface
interface Add{
    public void sum(int a, int b);
}
class withoutLambda implements Add{
    public void sum(int a, int b){
        System.out.println("The sum of the 2 numbers is : " + (a+b));
    }
    public static void main(String[] args){
        withoutLambda a1 = new withoutLambda();
        a1.sum(4,5);
    }
}
class withLambda {
    public static void main(String[] args){
        Add a1 = (a, b) -> System.out.println("The sum of the 2 numbers is : " + (a+b));
        a1.sum(4,5);
    }
}
