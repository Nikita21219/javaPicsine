import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        MyImageReader img = new MyImageReader();
        Scanner in = new Scanner(System.in);
        String pathToImg;
        while (!(pathToImg = in.next()).equals("42")) {
            if (!img.open(pathToImg)) {
                System.err.println("Error: file can't open");
                continue;
            }
            String type = img.getFileTypeBySign();
            img.writeResultInFile(type);
            img.close();
        }
        in.close();
        img.closeResultFile();
    }
}
