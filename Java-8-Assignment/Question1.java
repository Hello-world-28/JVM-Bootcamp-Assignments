//Write the following a functional interface and implement it using lambda: 
//  1. To check whether the first number is greater than second number or not, Parameter (int ,int ) Return type boolean 
//  2. Increment the number by 1 and return incremented value Parameter (int) Return int 
// 3. Concatination of 2 string Parameter (String , String ) Return (String) 
// 4. Convert a string to uppercase and return . Parameter (String) Return (String)

@FunctionalInterface
interface GreaterCheck {
    boolean isGreater(int a, int b);
}

@FunctionalInterface
interface Increment {
    int incrementByOne(int a);
}

@FunctionalInterface
interface StringConcatination{
    String concat(String a, String b);
}

@FunctionalInterface
interface ToUpperCase {
    String convert(String a);
}

class Question1 {
    public static void main(String[] args){
        //  1. To check whether the first number is greater than second number or not, Parameter (int ,int ) Return type boolean
        GreaterCheck check = (a, b) -> a > b;
        System.out.println(check.isGreater(5, 10));
        System.out.println(check.isGreater(10, 5));
        //2. Increment the number by 1 and return incremented value Parameter (int) Return int
        Increment increse = (a) -> a + 1;
        System.out.println(increse.incrementByOne(5));
        // 3. Concatination of 2 string Parameter (String , String ) Return (String)
        StringConcatination concat = (a, b) -> a + b;
        System.out.println(concat.concat("Saurabh", " Singh"));
        // 4. Convert a string to uppercase and return . Parameter (String) Return (String)
        ToUpperCase UpperCase = (a) -> a.toUpperCase();
        System.out.println(UpperCase.convert("saurabh singh"));
    }
}