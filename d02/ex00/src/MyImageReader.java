import java.io.*;
import java.util.ArrayList;

public class MyImageReader {
    private InputStream is;

    public MyImageReader() {is = null;}

    public boolean open(String pathToImage) {
        if (is == null) {
            try {
                is = new FileInputStream(pathToImage);
            } catch (Exception e) {
                return false;
            }
            return true;
        }
        return false;
    }

    public boolean close() throws IOException {
        if (is != null) {
            try {
                is.close();
            } catch (Exception e) {
                return false;
            }
            is = null;
            return true;
        }
        return false;
    }

    private String getSignature() {
        if (is == null)
            return null;
        int bytesCounter = 0;
        int value = -1;
        StringBuilder sbHex = new StringBuilder();
        StringBuilder sbResult = new StringBuilder();
        try {
            while ((value = is.read()) != -1) {
                sbHex.append(String.format("%02X ", value));
                if (bytesCounter == 16) {
                    sbResult.append(sbHex).append("\n");
                    sbHex.setLength(0);
                    bytesCounter = 0;
                } else {
                    bytesCounter++;
                }
            }
        } catch (Exception e) {
            return null;
        }
        if (bytesCounter != 0) {
            for (; bytesCounter < 16; bytesCounter++) {
                sbHex.append("   ");
            }
            sbResult.append(sbHex).append("\n");
        }
        return sbResult.toString();
    }

    private ArrayList<String> getImgTypes() {
        try {
            FileReader fr = new FileReader("signatures.txt");
            BufferedReader reader = new BufferedReader(fr);
            ArrayList<String> imgTypes = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                imgTypes.add(line);
                line = reader.readLine();
            }
            reader.close();
            return imgTypes;
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException catch");
            return null;
        } catch (Exception e) {
            System.out.println("Exception catch");
            System.out.println("Message: " + e.getMessage());
            return null;
        }
    }

    private String getType(String type, String sign) {
        String [] splitStr = type.split(",");
        if (splitStr.length != 2)
            return null;
        if (sign.indexOf(splitStr[1].trim()) == 0)
            return splitStr[0];
        return null;
    }

    public void getFileTypeBySign() {
        String sign = getSignature();
        if (sign == null)
            return;
        ArrayList<String> imgTypes = getImgTypes();
        if (imgTypes == null)
            return;
        for (int i = 0; i < imgTypes.size(); i++) {
            String type = getType(imgTypes.get(i), sign);
            if (type != null) {
                System.out.println(type);
                break;
            }
        }
    }
}
