import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private String fileName;

    public FileHandler(String fileName) {

        this.fileName = fileName;

    }
    public String getFileName() {
        return fileName;
    }
    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public void saveRecords(ArrayList<DisplayableRecord> records) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(getFileName()));
        out.writeObject(records);
        out.close();
    }

    public ArrayList<DisplayableRecord> loadRecords() {
        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(fileName));
            ArrayList<DisplayableRecord> records = (ArrayList<DisplayableRecord>) in.readObject();
            in.close();
            return records;
        } catch (IOException e) {
            System.out.println("Error loading records: " + e.getMessage());
            return null;
        } catch (ClassNotFoundException e) {
            System.out.println("Error: Class not found - " + e.getMessage());
            return null;
        }
    }

    public void exportReadableRecords(ArrayList<DisplayableRecord> records, String readableFileName) throws IOException {
        try (FileWriter out = new FileWriter(readableFileName)) {
            for (DisplayableRecord record : records) {
                out.write(record.toString() + "\n");
            }
        }
    }
}
