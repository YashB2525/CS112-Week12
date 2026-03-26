import java.util.ArrayList;

public class RecordManager {
    private ArrayList<DisplayableRecord> records;


    // The constructor that initialises the arraylist records to an empty ArrayList.
    public RecordManager() {
        records = new ArrayList<>();
    }
    // Adds a record and throws IllegalArgumentException if duplicate record exists.
    public void addRecord(DisplayableRecord record) {
        if (record == null) {
            throw new IllegalArgumentException("Record cannot be null");
        }

        for (DisplayableRecord r : records) {
            if (r.equals(record)) {
                throw new IllegalArgumentException("Duplicate record exists");
            }
        }
        records.add(record);
    }

    // Removes the record with the matching ID from the collection.
    // Returns true if the record was found and removed, and false if no record with that ID exists.
    public boolean removeRecord(String id ) {
        for (DisplayableRecord record : records) {
            if (record.getId().equals(id)) {
                records.remove(record);
                return true;
            }
        }
        return false;
    }

    // Returns all stored records.
    public ArrayList<DisplayableRecord> getAllRecords() {
        return records;
    }

    // Returns the record if found, otherwise null.
    public DisplayableRecord findRecordById(String id) {
        for (DisplayableRecord record : records) {
            if (record.getId().equals(id)) {
                return record;
            }
        }
        return null;
    }

    // Replaces the current list of records with the parameter passed in
    public void setRecords(ArrayList<DisplayableRecord> records) {
        this.records = records;
    }

    // Prints out the details for every DisplayableRecord in records
    public void displayAllRecords() {
        if ( records.isEmpty()) {
            System.out.println("No records to display.");
            return;
        }
        for (DisplayableRecord record : records) {
            record.getDisplayText();
        }
    }
}
