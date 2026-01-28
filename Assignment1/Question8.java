//WAP to produce NoClassDefFoundError and ClassNotFoundException exception.
class Question8{
    public static void main(String[] args){
        try
        {
            // This will produce ClassNotFoundException
            Class.forName("NonExistentClass");
        }catch(Exception e){
            System.out.println(e);
        }
        
        // First attempt to load the class
        try {
            ClassNotFoundExample.display();
        } catch (Throwable t) {
            
        }

        // Second attempt triggers NoClassDefFoundError
        try {
            ClassNotFoundExample.display();
        } catch (Throwable t) {
            System.out.println(t);
        }
    }
}
class ClassNotFoundExample {
    static{
        int a = 5/0; //static initialization failure
    }
    public static void display(){
        System.out.println("This is ClassNotFoundExample class");
    }
}