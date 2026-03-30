// Yash Bajaj's Class - Represents one book record.
public class BookRecord implements DisplayableRecord {

    // Fields
    private String id;
    private String title;
    private String author;
    private int year;

    // Constructor which handles input validation
    public BookRecord(String title, String author, int year) {
        // Title cannot be empty
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be Empty");
        }
        // Author cannot be empty
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be Empty");
        }
        // Year cannot be less than 0 or greater than 2026
        if (year < 0 || year > 2026) {
            throw new IllegalArgumentException("Year must be between 0 and 2026");
        }
        this.title = title;
        this.author = author;
        this.year = year;
        generateID();
    }

    // Getter
    @Override
    public String getId(){
        return id;
    }

    // Generates an ID string that will be used to set id following spec instructions
    @Override
    public void generateID() {
        // First 3 characters of the book name
        String titlePrefix = title.length() >= 3 ? title.substring(0, 3) : title;
        // First 3 characters of the author name
        String authorPrefix = author.length() >= 3 ? author.substring(0, 3) : author;
        // Places them all together with year in middle
        id = titlePrefix + year + authorPrefix;
    }

    // Returns formatted display text
    @Override
    public String toString() {
        return id + " - " + title + " by " + author + " (" + year + ")";
    }

    // Prints out the formatted display text
    @Override
    public void getDisplayText(){
        System.out.print(toString());
    }


    // Returns true if the object passed in is an instance of BookRecord and the author, book title and id
    // match the fields on the instance this is called with
    @Override
    public boolean equals(Object otherBook) {
        if (this == otherBook) {
            return true;
        }
        if (!(otherBook instanceof BookRecord)) {
            return false;
        }
        BookRecord book  = (BookRecord) otherBook;
        return id.equals(book.id) && title.equals(book.title) && author.equals(book.author);
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public int getYear() {
        return year;
    }
}
