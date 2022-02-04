import java.util.ArrayList;

/**
 * This is the NotebookTest class and it will create a Notebook object in the main method.
 * This class allows is to see our methods in action and to perform some simple tests.
 * A notebook will be created in our main method and we will pass it an ArrayList of Strings.
 * 
 * @author Lukas DeLoach
 * @version 01/22/2022
 */
public class NotebookTest{


    /**
     * Main method that creates a Notebook object.
     * Uses the setNotes method to pass the notebook object an ArrayList of Strings
     * Contains two for loops one which moves a note up a certain amount of times-
     * and another that moves a note down a certain amount of times. 
     * Has a for-each loop to print out the notes in the collection.
     * @param args
     */
    public static void main(String[]args)
    {
        Notebook notebook = new Notebook();
        ArrayList<String> notes = new ArrayList<>();

        notes.add("java");
        notes.add("c++");
        notes.add("python");

        notebook.setNotes(notes);


        notebook.addNote("ruby");
        notebook.addNote("html");


        notebook.setNote("apple", 4);
        notebook.addNote("apple");

        System.out.println();

        int value = 2;

        //Moving the note up
        for (int i = 0; i < value; i++)
        {
            notebook.moveNoteUp("python");
        }

        //Moving the note down
        for (int i = 0; i < value; i++)
        {
            notebook.moveNoteDown("java");
        }

        for (String note : notebook.getNotes())
        {
            System.out.println(note);
        }
    }
}