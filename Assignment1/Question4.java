//Create a two dimensional array of integers and display:
    //1. sum of all elements of each column
    //2. sum of all elements of each row
class Question4{
    public static void main(String[] args){
        int [][] TwoDArray = new int [2][3];
        TwoDArray[0][0] = 4;
        TwoDArray[0][1] = 6;
        TwoDArray[0][2] = 8;
        TwoDArray[1][0] = 9;
        TwoDArray[1][1] = 7;
        TwoDArray[1][2] = 8;

        for(int i = 0; i<TwoDArray.length; i++){
            System.out.print(" | ");
            for(int j = 0; j<TwoDArray[i].length; j++){
                System.out.print(TwoDArray[i][j] + " | ");
            }
            System.out.println();
        }
        // Sum of each row
        System.out.println("Sum of each row:");
        for(int i = 0; i<TwoDArray.length; i++){
            int rowSum = 0;
            for(int j = 0; j<TwoDArray[i].length; j++){
                rowSum += TwoDArray[i][j];
                System.out.print(TwoDArray[i][j] + " + ");
            }
            System.out.println(" = " + rowSum);
        }
        // Sum of each column
        System.out.println("Sum of each column:");
        for (int j = 0; j < TwoDArray[0].length; j++) {
            int colSum = 0;
            for (int i = 0; i < TwoDArray.length; i++) {
                colSum += TwoDArray[i][j];
                System.out.print(TwoDArray[i][j] + " + ");
            }
            System.out.println(" = " + colSum);
        }   
    }
}