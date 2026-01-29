//Create a custom exception that do not have any stack trace.
class CustomException extends Exception {
    public CustomException(String message) {
        super(message);
    }
    
    @Override
    public void printStackTrace() {
        // Override to prevent stack trace printing
    }
}

class Question9{
    public static void main(String[] args){
        try{
            throw new CustomException("This is a custom exception without stack trace.");
        }catch(CustomException e){
            System.out.println(e.getMessage());
            e.printStackTrace(); // This will not print any stack trace
        }
    }
}