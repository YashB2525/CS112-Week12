public class BookRecord implements DisplayableRecord {

    private String id;
    private String title;
    private String author;
    private int year;

    public BookRecord(String title, String author, int year) {
        if (title == null) {
            throw new IllegalArgumentException("Title cannot be Empty");
        }
        if (author == null) {
            throw new IllegalArgumentException("Author cannot be Empty");
        }
        if (year < 0 || year > 2026) {
            throw new IllegalArgumentException("Year must be between 0 and 2026");
        }
        this.title = title;
        this.author = author;
        this.year = year;
        generateID();
    }

    @Override
    public String getId(){
        return id;
    }

    @Override
    public void generateID() {
        String titlePrefix = title.length() >= 3 ? title.substring(0, 3) : title;
        String authorPrefix = author.length() >= 3 ? author.substring(0, 3) : author;
        id = titlePrefix + year + authorPrefix;
    }

    @Override
    public String toString() {
        return id + " - " + title + " by " + author + " (" + year + ")";
    }

    @Override
    public void getDisplayText(){
        System.out.print(toString());
    }

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
