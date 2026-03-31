import java.io.*;
import java.util.ArrayList;

// Emily Walker's Class - Saves and loads records using serialisation
public class FileHandler {

    // Field
    private String fileName;

    // Constructor which sets fileName to the string parameter passed in
    public FileHandler(String fileName) {
        this.fileName = fileName;
    }

    // Getter
    public String getFileName() {
        return fileName;
    }

    // Setter
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }


    // Saves the ArrayList passed in to a file with the file name specified by fileName using ObjectOutputStream
    public void saveRecords(ArrayList<DisplayableRecord> records) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(getFileName()));
        out.writeObject(records);
        out.close();
    }

    // Loads and returns an ArrayList from a file with the file name specified by fileName using ObjectInputStream.
    public ArrayList<DisplayableRecord> loadRecords() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            ArrayList<DisplayableRecord> records = (ArrayList<DisplayableRecord>) in.readObject();
            in.close();
            return records;
        } catch (IOException e) {
            // Error message displayed and null returned
            System.out.println("Error loading records: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            // Error message displayed and null returned
            System.out.println("Error: Class not found - " + e.getMessage());
            return null;
        }
    }

    // Writes the details of each record to the specified file name in human-readable text format.
    public void exportReadableRecords(ArrayList<DisplayableRecord> records, String readableFileName) throws IOException {
        try (FileWriter out = new FileWriter(readableFileName)) {
            for (DisplayableRecord record : records) {
                out.write(record.toString() + "\n");
            }
        }
    }
}
