import java.util.Scanner;

/**
 * Write a description of class ManagingStudentMarks here.
 *
 * @author HirushkaEkanayake
 * @version (a version number or a date)
 */
public class ManagingStudentMarks
{
    
    private static String[] studentNames = new String[25];
    private static int[] studentMarks = new int[25];
    private static int mean;
        
    public static void main(String args[]){  
         InputMarks();
         highestMarks();
         lowestMarks();
         CalculateMean();
         CalculateStandardDeviation();
    }
    
    public static void InputMarks(){
        Scanner scan= new Scanner(System.in);
        System.out.println("Enter unit name");
        String unitName = scan.nextLine();
        int count = 25;
        int j = 1;
        while (j<=count){
            Scanner sc= new Scanner(System.in);
            System.out.println("Enter student "+(j)+" name");
            String StudentName = sc.nextLine();
            System.out.println("Enter student "+(j)+" marks");
            int StudentMarks = sc.nextInt();
            if (StudentMarks>=0 && StudentMarks<=100){
                studentMarks[j-1] = StudentMarks;
                studentNames[j-1] = StudentName;
                j = j+1;
            }
            else{
                System.out.println("Error : Marks should be between 0 and 100");
            }
        }
        System.out.println("Student's marks for "+unitName);
        System.out.println("****************************************");
        for (int i = 0; i < 25; i++){
            System.out.println("\n");
            System.out.println(studentNames[i]+" - "+studentMarks[i]);
            System.out.println("\n");
        }
        
    }
    
    public static void highestMarks(){
        int highest = 0;
        for(int i = 0; i < 25; i++){
            if(studentMarks[i]>highest){
                highest = studentMarks[i];
            }
        }
        System.out.println("Highest mark is "+highest);
    }
    
    public static void lowestMarks(){
        int lowest = 101;
        for(int i = 0; i < 25; i++){
            if(studentMarks[i]<lowest){
                lowest = studentMarks[i];
            }
        }
        System.out.println("lowest mark is "+lowest);
        System.out.println("\n");
    }
    
    public static void CalculateMean(){
        int total = 0;
        for(int i = 0; i < 25; i++){
            total = total + studentMarks[i];
        }
        mean = total / 25;
        System.out.println("The mean is "+mean);
    }
    
    public static void CalculateStandardDeviation(){
        int x = 0;
        double y = 0;
        double standardDeviation;
        for(int i = 0; i<25; i++){
            x = x + (int) Math.pow((studentMarks[i] - mean), 2);
        }
        y = x / 25;
        standardDeviation = Math.sqrt(y);
        System.out.println("The standard deviation is "+standardDeviation);
    }

}
