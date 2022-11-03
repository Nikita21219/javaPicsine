import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

public class FileManager {
    private File curDir;

    private void pwd() {System.out.println(curDir.getAbsolutePath());}

    public FileManager(String dir) {
        String curDirectory = getInitialDir(dir);
        curDir = new File(curDirectory);
        if (!curDir.isDirectory())
            exit("It is not a directory");
        pwd();
    }

    private String getInitialDir(String dir) {
        String[] arr = dir.split("=");
        if (arr.length != 2)
            exit("Error");
        return arr[1];
    }

    private void exit(String str) {
        System.err.println(str);
        System.exit(-1);
    }

    public void execCommand(String command) {
        if (command.equals("ls"))
            ls();
        else if (command.startsWith("mv "))
            mv(command);
        else if (command.startsWith("cd "))
            cd(command);
    }

    private void mv(String command) {
        String[] mvSplit = command.split(" ");
        if (mvSplit.length != 3) {
            System.err.println("Wrong args mv");
            return;
        }
        File what = new File(curDir + File.separator + mvSplit[1]);
        if (!what.exists()) {
            System.err.println("File does not exists");
            return;
        }
        String[] list = curDir.list();
        File where = new File(curDir + File.separator + mvSplit[2]);
        if (list == null)
            return;
        String[] whereSplit = mvSplit[2].split(File.separator);
        if (whereSplit.length < 1)
            return;
        if (
                !Arrays.asList(list).contains(whereSplit[0])
                && !whereSplit[0].equals(".")
                && !whereSplit[0].equals("..")
        ) {
            if (!what.renameTo(where))
                System.err.println("Renamed failure");
        } else {
            try {
                Path src = Paths.get(curDir.toString()
                        + File.separator
                        + mvSplit[1]);
                Path dst = Paths.get(
                        curDir.toString()
                            + File.separator
                            + mvSplit[2]
                            + File.separator
                            + src.getFileName()
                );
                Files.move(src, dst);
            } catch (Exception e) {
                System.err.println("File not moved: " + e.getMessage());
            }
        }
    }

    private void ls() {
        String[] list = curDir.list();
        if (list == null)
            return;
        for (String i : list) {
            File f = new File(i);
            int res = (int) f.length() / 1000;
            System.out.println(i + " " + res + " KB");
        }
    }

    private boolean itConsistsOnlyChar(char c, String str) {
        char[] strLikeChars = new char[str.length()];
        str.getChars(0, str.length(), strLikeChars, 0);
        for (char ch : strLikeChars)
            if (ch != c)
                return false;
        return true;
    }

    private void initNewCurDir(String dirName) {
        if (dirName.equals("."))
            return;
        if (dirName.equals("..")) {
            curDir = new File(curDir.getParent());
            return;
        }
        String[] dirNameSplit = dirName.split(File.separator);
        File newCurDir = new File(curDir.getAbsolutePath());
        for (String dir : dirNameSplit) {
            if (dir.equals(".")) {
                dirName = dirName.substring(2);
            } else if (dir.equals("..")) {
                dirName = dirName.substring(2);
                try {
                    newCurDir = new File(newCurDir.getParent());
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                    return;
                }
            } else {
                try {
                    newCurDir = new File(newCurDir.getAbsolutePath() + File.separator + dir);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                    return;
                }
            }
        }
        if (!newCurDir.isDirectory())
            System.err.println("Not a directory");
        else
            curDir = newCurDir;
    }

    private void cd(String command) {
        String[] splitCommand = command.split(" ");
        if (splitCommand.length != 2)
            return;
        initNewCurDir(splitCommand[1]);
        pwd();
    }
}

// cd ................
// cd ../../../../../../../../../../../../../../../../../../../../../../../../
// cd ././././
