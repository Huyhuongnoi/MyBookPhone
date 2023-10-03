import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Functions extends Contact{
    private static List<String> listContact = new ArrayList<>();
    private static String fileName = "phonebook.txt";
    private static  File file = new File(Functions.fileName);

    public Functions() {
        super(null, null, null);
    }

    public void addNewContact(String name, String phoneNumber, String note) {
        readObject();
        for (int idx = 0; idx < Functions.listContact.size(); idx++) {
            String[] list = Functions.listContact.get(idx).split("\\|");
            if (Objects.equals(list[1], phoneNumber)) {
                System.out.println("Phone number already exists");
                return;
            }
        }
        Contact contact = new Contact(name, phoneNumber, note);
        Functions.listContact.clear();
        writeObject(contact.getContact());

    }

    public void editInformation(int choose, String phoneNumber, String newInformation) {
        readObject();
        int index = -1;
        for (int idx = 0; idx < Functions.listContact.size(); idx++) {
            String[] list = Functions.listContact.get(idx).split("\\|");
            if (Objects.equals(list[1], phoneNumber)) {
                index = idx;
            }
        }
        if (index == -1) {
            System.out.println("Phone number does not exist!");
            return;
        }
        switch (choose) {
            case 1:
                String[] newListN = Functions.listContact.get(index).split("\\|");
                String newInformationContactName = newInformation + "|" + newListN[1] + "|" + newListN[2];
                Functions.listContact.set(index, newInformationContactName);
                for (int idx = 0; idx < Functions.listContact.size(); idx++) {
                    System.out.println(Functions.listContact.get(idx));
                }
                Functions.file.delete();
                for (int idx = 0; idx < Functions.listContact.size(); idx++) {
                    writeObject(Functions.listContact.get(idx));
                }
                Functions.listContact.clear();
                break;
            case 2:
                String[] newListPN = Functions.listContact.get(index).split("\\|");
                String newInformationContactPhoneNumber = newListPN[0] + "|" + newInformation + "|" + newListPN[2];
                Functions.listContact.set(index, newInformationContactPhoneNumber);
                Functions.file.delete();
                for (int idx = 0; idx < Functions.listContact.size(); idx++) {
                    writeObject(Functions.listContact.get(idx));
                }
                Functions.listContact.clear();
                break;
            case 3:
                String[] newListNO = Functions.listContact.get(index).split("\\|");
                String newInformationContactNote = newListNO[0] + "|" + newListNO[1] + "|" + newInformation;
                Functions.listContact.set(index, newInformationContactNote);
                Functions.file.delete();
                for (int idx = 0; idx < Functions.listContact.size(); idx++) {
                    writeObject(Functions.listContact.get(idx));
                }
                Functions.listContact.clear();
                break;
            default:
                System.out.println("No information found that needs editing!");
                break;
        }
    }

    public void deleteContact(String phoneNumber) {
        readObject();
        int index = -1;
        for (int idx = 0; idx < Functions.listContact.size(); idx++) {
            String[] list = Functions.listContact.get(idx).split("\\|");
            if (Objects.equals(list[1], phoneNumber)) {
                index = idx;
            }
        }
        if (index == -1) {
            System.out.println("Phone number already exists!");
            return;
        }
        Functions.listContact.remove(index);
        Functions.file.delete();
        for (int idx = 0; idx < Functions.listContact.size(); idx++) {
            writeObject(Functions.listContact.get(idx));
        }
        Functions.listContact.clear();
    }

    public void viewContact() {
        readObject();
        for (int idx = 0; idx < Functions.listContact.size(); idx++) {
            String[] list = Functions.listContact.get(idx).split("\\|");
            String contact = "STT: " + String.valueOf(idx) + "\n" + "Name: " + list[0] + "\n" + "Number: "
                    + list[1] + "\n" + "Note: " + list[2] + "\n";
            System.out.println(contact);
        }
        Functions.listContact.clear();
    }

    public void writeObject(String contact) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(Functions.fileName, true));
            bufferedWriter.write(contact);
            bufferedWriter.newLine();
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readObject() {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(Functions.fileName));
            String contact;
            while ((contact = bufferedReader.readLine()) != null) {
                Functions.listContact.add(contact);
                System.out.println(contact);
            }
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public void delete(){
        Functions.file.delete();
    }
}
