/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package App;

/**
 *
 * @author Asus
 */
public class Workflow {
    //attributes
    private String title;
    private int checkpoint;
    private String id;
    private String userID;

    //constructor
    public Workflow(String title, int checkpoint, String id, String userid) {
        this.title = title;
        this.checkpoint = checkpoint;
        this.id = id;
        this.userID = userid;
    }

    //getters and setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCheckpoint() {
        return checkpoint;
    }

    public void setCheckpoint(int checkpoint1) {
        this.checkpoint = checkpoint1;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
