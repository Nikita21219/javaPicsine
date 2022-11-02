import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

//Try to open file with 000 rules

public class Program {
    public static void main(String[] args) throws IOException {
        MyImageReader img = new MyImageReader();
        String pathToImg = "/Users/a1/Downloads/IT/school21/javaPicsine/d02/img/1.png";
        if (!img.open(pathToImg)) {
            System.err.println("Error open");
            System.exit(-1);
        }
        img.getFileTypeBySign();
        img.close();
    }
}

//    /Users/a1/Downloads/IT/school21/javaPicsine/d02/img/1.png
//    /Users/a1/Downloads/IT/school21/javaPicsine/d02/img/2.jpg
//    /Users/a1/Downloads/IT/school21/javaPicsine/d02/img/3.heic
