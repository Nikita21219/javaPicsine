import java.io.*;
import java.util.HashSet;

public class Words {
    private HashSet<String> set1;
    private HashSet<String> set2;
    private String path1;
    private String path2;

    Words(String path1, String path2) {
        this.path1 = path1;
        this.path2 = path2;
    }

    public void initHashSet() {
        try {
            HashSet<String> set = new HashSet<>();
            BufferedReader reader = getBufferedReader(path1);
            String line = reader.readLine();
            while (line != null) {
                String[] splitLine = line.split(" ");
                for (int i = 0; i < splitLine.length; i++) {
                    set.add(splitLine[i]);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Exception message: " + e.getMessage());
        }
    }

    public BufferedReader getBufferedReader(String path) {
        try {
            InputStreamReader isr = new FileReader(path);
            BufferedReader reader = new BufferedReader(isr);
            return reader;
        } catch (Exception e) {
            return null;
        }
    }
}
