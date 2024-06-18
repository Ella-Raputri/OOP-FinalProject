/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Asus
 */
public class Task {
    //attributes
    private String id;
    private String userID;
    private String nameInput;
    private String typeInput;
    private String timeFromInput;
    private String timeToInput;
    private String noteInput;
    private String colorInput;
    private boolean completed = false;

    //constructor
    public Task(String id, String nameInput, String typeInput, String timeFromInput, String timeToInput, 
            String noteInput, String colorInput, String userID, boolean comp) {
        this.id = id;
        this.userID = userID;
        this.nameInput = nameInput;
        this.typeInput = typeInput;
        this.timeFromInput = timeFromInput;
        this.timeToInput = timeToInput;
        this.noteInput = noteInput;
        this.colorInput = colorInput;
        this.completed = comp;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getUserID() {
        return userID;
    }

    public void setUserID(String uid) {
        this.userID = uid;
    }

    public String getNameInput() {
        return nameInput;
    }

    public void setNameInput(String nameInput) {
        this.nameInput = nameInput;
    }

    public String getTypeInput() {
        return typeInput;
    }

    public void setTypeInput(String typeInput) {
        this.typeInput = typeInput;
    }

    public String getTimeFromInput() {
        return timeFromInput;
    }

    public void setTimeFromInput(String timeFromInput) {
        this.timeFromInput = timeFromInput;
    }

    public String getTimeToInput() {
        return timeToInput;
    }

    public void setTimeToInput(String timeToInput) {
        this.timeToInput = timeToInput;
    }

    public String getNoteInput() {
        return noteInput;
    }

    public void setNoteInput(String noteInput) {
        this.noteInput = noteInput;
    }

    public String getColorInput() {
        return colorInput;
    }

    public void setColorInput(String colorInput) {
        this.colorInput = colorInput;
    }
    
    public boolean getCompleted() {
        return completed;
    }

    public void setCompleted(boolean comp) {
        this.completed = comp;
    }
}
