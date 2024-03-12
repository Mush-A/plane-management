import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileManager is a utility class for managing files and directories.
 * It allows you to set a directory name, file name, and file content, and then create the directory and file.
 */
public class FileManager {
    private final String directoryName;
    private String fileName;
    private String fileContent;

    /**
     * Constructs a new FileManager with the specified directory name.
     *
     * @param directoryName the name of the directory
     */
    public FileManager(String directoryName) {
        this.directoryName = directoryName;
    }

    /**
     * Sets the name of the file to be created.
     *
     * @param fileName the name of the file
     * @return this FileManager instance
     */
    public FileManager setFileName(String fileName) {
        this.fileName = fileName;
        return this;
    }

    /**
     * Sets the content of the file to be created.
     *
     * @param fileContent the content of the file
     * @return this FileManager instance
     */
    public FileManager setFileContent(String fileContent) {
        this.fileContent = fileContent;
        return this;
    }

    /**
     * Creates a directory and file with the previously set name and content.
     * If the directory or file already exists, it will not be created again.
     *
     * @throws IOException if an I/O error occurs
     */
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