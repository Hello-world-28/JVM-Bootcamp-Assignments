@FunctionalInterface
interface A{
    int m1();
    String toString();
    @Override
    int hashCode();
}
class Main{
    public static void main(String[] args){
        // Object a1 = new Object();
        A a = ()->10;
        System.out.println(a.hashCode());
    }
}