//Write Java code to define List. Insert 5 floating point numbers in List, and using an iterator, find the sum of the numbers in List.

class Question1{
    public static void main(String[] args){
        java.util.List<Float> floatList = new java.util.ArrayList<>();
        floatList.add(1.2f);
        floatList.add(3.4f);
        floatList.add(5.6f);
        floatList.add(7.8f);
        floatList.add(9.0f);

        java.util.Iterator<Float> iterator = floatList.iterator();
        float sum = 0.0f;
        while(iterator.hasNext()){
            sum += iterator.next();
        }

        System.out.println("Sum of floating point numbers in the list: " + sum);
    }
}