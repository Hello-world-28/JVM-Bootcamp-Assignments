//WAP showing try, multi-catch and finally blocks.
class Question7{
    public static void main(String[] args){
        try{
            int a = 5/0;
        } catch(ArithmeticException e){
            System.out.println("Arithmetic Exception occurred: " + e.getMessage());
        } catch(Exception e){
            System.out.println("Some other exception occurred: " + e.getMessage());
        } finally{
            System.out.println("Execution of try-catch block is complete.");
        }
    }
}