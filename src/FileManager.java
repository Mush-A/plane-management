import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileManager {
    private final String directoryName;
    private String fileName;
    private String fileContent;

    public FileManager(String directoryName) {
        this.directoryName = directoryName;
    }

    public FileManager setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    public FileManager setFileContent(String fileContent) {
        this.fileContent = fileContent;
        return this;
    }

    public void createDirectoryAndFile() throws IOException {
        File directory = new File(directoryName);
        if (!directory.exists()) {
            directory.mkdirs();
        }

        File file = new File(directory, fileName);
        if (!file.exists()) {
            file.createNewFile();
        }

        FileWriter writer = new FileWriter(file);
        writer.write(fileContent);
        writer.flush();

        writer.close();
    }
}
