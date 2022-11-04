import ImagesToChar.ImagesToChar;

import java.io.*;

public class Program {
    public static void main(String[] args) {
        if (args.length != 1) {
            System.err.println("Number of arguments is incorrect");
            System.exit(-1);
        }
        ImagesToChar itc = new ImagesToChar();
        itc.displayResult(args[0]);
    }
}

//  /Users/a1/Downloads/IT/school21/javaPicsine/d04/it.bmp