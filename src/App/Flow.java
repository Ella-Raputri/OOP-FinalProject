/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Asus
 */
public class Flow {
    //attributes
    private String id;
    private String workflowID;
    private String nameInput;
    private String typeInput;
    private int dayFromInput;
    private int dayToInput;
    private String noteInput;
    private String colorInput;

    //constructor
    public Flow(String id, String workflowID, String nameInput, String typeInput, int dayFromInput, int dayToInput, 
            String noteInput, String colorInput) {
        this.id = id;
        this.workflowID = workflowID;
        this.nameInput = nameInput;
        this.typeInput = typeInput;
        this.dayFromInput = dayFromInput;
        this.dayToInput = dayToInput;
        this.noteInput = noteInput;
        this.colorInput = colorInput;
    }

    //getters and setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public String getWorkflowID() {
        return workflowID;
    }

    public void setWorkflowID(String wid) {
        this.workflowID = wid;
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

    public int getDayFromInput() {
        return dayFromInput;
    }

    public void setDayFromInput(int dayFromInput) {
        this.dayFromInput = dayFromInput;
    }

    public int getDayToInput() {
        return dayToInput;
    }

    public void setDayToInput(int dayToInput) {
        this.dayToInput = dayToInput;
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
    
    

   
}
