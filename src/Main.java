import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        int size = 1000; // So I can change how long the program takes
        MainTest test = new MainTest();
        long[] outputsLogN = new long[size];
        for(int i = 0; i < outputsLogN.length; i++) {
            outputsLogN[i] = test.testLogN(i * 100);
        }
        long[] outputsN = new long[size];
        for(int i = 0; i < outputsN.length; i++) {
            outputsN[i] = test.testN(i * 100);
        }

        // I want to output to a file for easier graphing
        PrintStream out = new PrintStream(
                new FileOutputStream("performance.txt"));


        for(int i = 0; i < size; i++) {
            out.print(i + "," + outputsLogN[i] + "," + outputsN[i]);
            out.println();
        }

        out.close();
    }
}
