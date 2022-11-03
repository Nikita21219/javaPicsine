import java.io.*;
import java.util.ArrayList;
import java.util.HashSet;

public class Program {

    private static BufferedReader getReader(String path) {
        try {
            InputStreamReader isr = new FileReader(path);
            BufferedReader reader = new BufferedReader(isr);
            return reader;
        } catch (Exception e) {
            return null;
        }
    }

    private static ArrayList<String> getArray(String path) {
        try {
            BufferedReader reader = getReader(path);
            if (reader == null)
                return null;
            ArrayList<String> array = new ArrayList<>();
            String line = reader.readLine();
            while (line != null) {
                String[] splitLine = line.split(" ");
                for (int i = 0; i < splitLine.length; i++) {
                    array.add(splitLine[i]);
                }
                line = reader.readLine();
            }
            reader.close();
            return array;
        } catch (Exception e) {
            System.err.println("Exception message: " + e.getMessage());
            return null;
        }
    }

    private static HashSet<String> getResultHashSet(ArrayList<String> array1, ArrayList<String> array2) {
        if (array1 == null || array2 == null)
            return null;
        HashSet<String> resultSet = new HashSet<>();
        resultSet.addAll(array1);
        resultSet.addAll(array2);
        return resultSet;
    }

    private static int getNumberOccurrences(ArrayList<String> arr, String x) {
        int result = 0;
        for (String str : arr)
            if (str.equals(x))
                result++;
        return result;
    }

    private static int[] getVector(ArrayList<String> arr, HashSet<String> set) {
        int[] resultArray = new int[set.size()];
        int j = 0;
        for (String i : set)
            resultArray[j++] = getNumberOccurrences(arr, i);
        return resultArray;
    }

    private static int getNumerator(int[] vectorA, int[] vectorB) {
        int result = 0;
        for (int i = 0; i < vectorA.length; i++)
            result += vectorA[i] * vectorB[i];
        return result;
    }

    private static double getDenominator(int[] vectorA, int[] vectorB) {
        double leftPart = Math.sqrt(getNumerator(vectorA, vectorA));
        double rightPart = Math.sqrt(getNumerator(vectorB, vectorB));
        double res =  leftPart * rightPart;
        return Math.floor(100 * res) / 100.0f;
    }

    private static void printResult(ArrayList<String> arr1, ArrayList<String> arr2, HashSet<String> set) {
        if (arr1.size() == 0 && arr2.size() == 0) {
            System.out.println("Similarity = 1.0");
            return;
        }
        int[] vectorA = getVector(arr1, set);
        int[] vectorB = getVector(arr2, set);
        int numerator = getNumerator(vectorA, vectorB);
        double denominator = getDenominator(vectorA, vectorB);
        if (denominator == 0.0)
            System.out.println("Similarity = 0");
        else {
            double res = numerator / denominator;
            System.out.println("Similarity = " + Math.floor(100 * res) / 100.0f);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> arr1 = getArray(args[0]);
        ArrayList<String> arr2 = getArray(args[1]);
        HashSet<String> set = getResultHashSet(arr1, arr2);
        if (set == null) {
            System.err.println("Error");
            System.exit(-1);
        }
        printResult(arr1, arr2, set);
    }
}
