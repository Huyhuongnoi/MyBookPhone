import java.io.Serializable;

public class Contact {
    private String name;
    private String phoneNumber;
    private String note;

    public Contact(String name, String phoneNumber, String note) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.note = note;
    }

    public void setName(String newName) {
        this.name = newName;
    }

    public String getName() {
        return name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getNote() {
        return note;
    }
    public String getContact(){
        return getName() + "|" + getPhoneNumber() + "|" + getNote();
    }
}

