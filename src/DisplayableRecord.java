import java.io.Serializable;

// Provided interface
public interface DisplayableRecord extends Serializable {
     String getId();
     void generateID();
     void getDisplayText();
}
