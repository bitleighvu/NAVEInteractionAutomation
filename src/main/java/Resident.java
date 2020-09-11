public class Resident {
    private String name;
    private String building;
    private String room;
    private String interaction;
    private String theme;
    private String action;
    private String notes;

    public Resident(String name, String building, String room) {
        this.name = name;
        this.building = building;
        this.room = room;
        this.interaction = "1"; // Default: Text/Messaging
        this.theme = "1";// Default: Social/Get-to-know
        this.action = "0"; // Default: No Action
        this.notes = ""; // Default: Nothing
    }

    public Resident(String name, String building, String room, String interaction, String theme) {
        this.name = name;
        this.building = building;
        this.room = room;
        this.interaction = interaction;
        this.theme = theme;
        this.action = "0"; // Default: No action
        this.notes = ""; // Default: Nothing
    }

    public Resident(String name, String building, String room, String interaction, String theme, String action) {
        this.name = name;
        this.building = building;
        this.room = room;
        this.interaction = interaction;
        this.theme = theme;
        this.action = action;
        this.notes = ""; // Default: Nothing
    }

    public Resident(String name, String building, String room, String interaction, String theme, String action, String notes) {
        this.name = name;
        this.building = building;
        this.room = room;
        this.interaction = interaction;
        this.theme = theme;
        this.action = action;
        this.notes = notes;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBuilding() {
        return building;
    }

    public void setBuilding(String building) {
        this.building = building;
    }

    public String getRoom() {
        return room;
    }

    public void setRoom(String room) {
        this.room = room;
    }

    public String getInteraction() {
        return interaction;
    }

    public void setInteraction(String interaction) {
        this.interaction = interaction;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
