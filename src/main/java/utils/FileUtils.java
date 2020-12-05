package utils;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    /**
     * readFile function to read the file and return its contents as List<String>
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    public static List<String> readFile(String fileName) throws IOException {
        List<String> fileContent = new ArrayList<>();
        String filePath = FileUtils.class.getClassLoader().getResource(Constants.FOLDER_NAME + fileName).getPath();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String readLine;
        while ((readLine = br.readLine()) != null) {
            fileContent.add(readLine);
        }
        return fileContent;
    }
}
