import java.util.ArrayList;

/**
 * This is the Notebook class and its purpose is to create Notebook object that uses multiple methods. 
 * The Notebook can be added to, rearranged, and elements can be deleted.
 * The Notebook class has only one instance variable, notes.
 * The Notebook is only capable of holding an ArrayList of Strings.
 * 
 * @author Lukas DeLoach
 * @version 01/22/2022
 */
public class Notebook {

    private ArrayList<String> notes;

    /**
     * Constructor for the Notebook class that instantiates the instance variable, notes.
     * We need the constructor to allow us to create a Noteboob instance in our NotebookTest main method.
     */
    public Notebook()
    {
        notes = new ArrayList<String>();
    }

    /**
     * The getNotes is of return type ArrayList<String> and returns the instance variable, notes.
     * @return notes
     */
    public ArrayList<String> getNotes()
    {
        return notes;
    }

    /**
     * Mutator method setNotes takes one parameter of type ArrayList<String>
     * Sets the instance variable to the parameter if NOT null
     * @param notes
     */
    public void setNotes(ArrayList<String> notes)
    {
        if(notes != null)
        {
            this.notes = notes;
        }
    }

    /**
     * The numberOfNotes method is of return type int and returns the total number of notes in the collection
     * @return notes.size()
     */
    public int numberOfNotes()
    {
        return notes.size();
    }

    /**
     * Mutator method addNote takes on parameter and first checks to see if it is already in the collection.
     * If it is not, adds the note to the collection of notes. Otherwise prints a statement notifying -
     * the user that the note already exists.
     * @param note
     */
    public void addNote(String note)
    {
        if (notes.contains(note) == false)
        {
            notes.add(note);
        }

        else
        {
            System.out.println("Already added.");
        }
    }

    /**
     * Mutator method deleteNote that takes one parameter of type int.
     * First checks that the index is not invalid, meaning less than 0 or greater than the collection size itself.
     * If that check passes, removes the note at the given index.
     * @param index
     */
    public void deleteNote(int index)
    {
        if (index < 0 || index >= numberOfNotes())
        {
            System.out.println("Invalid index");
        }
        else
        {
            notes.remove(index);
        }
    }
    
    /**
     * The getNoteNumber method returns the int value of the note's location.
     * First checks that the note exists (-1 meaning does not exist) and it is not null.
     * If those checks pass, returns the index of the note.
     * @param note
     * @return notes.indexOf(note) - the index of the note parameters location in the collection
     */
    public int getNoteNumber(String note)
    {
        if (notes.indexOf(note) == -1 || note == null)
        {
            System.out.println("Note does not exist");
            return -1;
        }
        return notes.indexOf(note);
    }

    /**
     * The getNote method returns the note at the given index. 
     * Takes a paremter of type int.
     * First checks that the index is not less than 0 and greater than the number of notes in the collection.
     * If those checks pass, returns the note at the provided index
     * @param index
     * @return notes.get(index) - String value
     */
    public String getNote(int index)
    {
        if (index < 0 || index >= numberOfNotes())
        {
            return "Invalid Index";
        }
        return notes.get(index);
    }

    /**
     * Mutator method setNote thats purpose is update a note at a given index. 
     * Method first checks to see that the index is valid and within the boundaries.
     * If that check passes, removes the current note at the index and then adds the updated note at the given index.
     * @param note
     * @param index
     */
    public void setNote(String note, int index)
    {
        if (index < 0 || index >= numberOfNotes())
        {
            System.out.println("Invalid index");
        }
        else
        {
            notes.remove(index);
            notes.add(index, note);  
        } 
    }

    /**
     * Mutator method moveNoteUp moves the given note to the previous index. 
     * Takes the note and moves it to the previous index...moving the previous note to the next index-performs a swap.
     * Method first checks to see if the note exists in the collection.
     * Then checks to see that, if the note will not be moved out of bounds, performs a swap.
     * If the note is to be moved out of bounds or to a non-existent index, prints a message saying so. 
     * @param note
     */
    public void moveNoteUp(String note)
    {
        int value = notes.indexOf(note);

        if (value == -1 || note == null)
        {
            System.out.println("Cannot find note");
            return;
        }

        else if ((value-1) >= 0)
        {
            String temp = notes.get(value);
            notes.remove(temp);
            notes.add(value-1, temp);
        }
        
        else
        {
            System.out.println("Cannot move note up...already in first index");
        }
    }

    /**
     * Mutator method moveNoteDown moves the given note to the next index. 
     * Takes the note at the next index and moves it to the previous index...performs a swap.
     * Method first checks to see if the note exists in the collection.
     * Then checks to see that, if the note will not be moved out of bounds, performs a swap.
     * If the note is to be moved out of bounds or to a non-existent index, prints a message saying so. 
     * @param note
     */
    public void moveNoteDown(String note)
    {
        int value = notes.indexOf(note);
        if (value == -1 || note == null)
        {
            System.out.println("Cannot find note");
        }

        else if ((value + 1) != numberOfNotes())
        {
            String temp = notes.get(value);
            notes.remove(temp);
            notes.add(value+1, temp);
        }

        else
        {
            System.out.println("Cannot move note down...Note is at the last index");
        }
    }

    /**
     * Mutator method moveNoteToTop simply takes a note and moves it to the top of the collection.
     * Local variable value is created to hold the index of the given note.
     * Then checks to see if the note exists.
     * If it does exist, creates a variable temp which holds the note. 
     * Removes the note and then adds the temporary note to the top.
     * @param note
     */
    public void moveNoteToTop(String note)
    {
        int value = notes.indexOf(note);
        if (value == -1 || note == null)
        {
            System.out.println("Cannot find note");
        }
        else
        {
            String temp = notes.get(value);
            notes.remove(temp);
            notes.add(0, temp);
        }
    }

    /**
     * Mutator method moveNoteToBottom simply takes a note and moves it to the bottom of the collection.
     * Local variable value is created to hold the index of the given note.
     * Then checks to see if the note exists.
     * If it does exist, creates a variable temp which holds the note. 
     * Removes the note and then adds the temporary note to the end.
     * @param note
     */
    public void moveNoteToBottom(String note)
    {
        int value = notes.indexOf(note);

        if (value == -1 || note == null)
        {
            System.out.println("Cannote find note");
        }

        else
        {
            String temp = notes.get(value);
            notes.remove(temp);
            notes.add(temp);
        }
    }
}
