
public class Program {

    public static void main(String[] args) {
        // Test your method here
        int rows = 2;
int columns = 3;
int[][] matrix = new int[rows][columns];
matrix[0][1] = 5;
matrix[1][0] = 3;
matrix[1][2] = 7;
System.out.println(arrayAsString(matrix));
    }
    
    public static String arrayAsString(int[][] array) {
        String outString = "";
        for (int row = 0; row < array.length; row++) {
            for (int col = 0; col < array[row].length; col++) {
                outString += array[row][col];
            }
            if (row < array.length-1) {
                outString += "\n";
            }
        }
        return outString;
    }

}
