package CW;

import java.io.Serializable;

public class Consultation implements Serializable {
    private String date;
    private String time;
    private int cost;
    private String notes;
    private Doctor doctor;
    private Patient patient;
    private int spend_hours;



    //constructor

    public Consultation(String date, String time, int cost, String notes, Doctor doctor, Patient patient, int spend_hours) {
        this.date = date;
        this.time = time;
        this.cost = cost;
        this.notes = encrypt(notes);
        this.doctor = doctor;
        this.patient = patient;
        this.spend_hours = spend_hours;
    }

    //getters
    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    public int getCost() {
        return cost;
    }

    public String getNotes() {
        return notes;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public int getSpend_hours() {
        return spend_hours;
    }
//setters

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setSpend_hours(int spend_hours) {
        this.spend_hours = spend_hours;
    }

    //encryption
    public String encrypt(String plainText) {
        StringBuilder encryptedText = new StringBuilder();
        for (int i = 0; i < plainText.length(); i++) {
            char c = plainText.charAt(i);
            encryptedText.append((char) (c + 5));
        }
        return encryptedText.toString();
    }

    // Decryption code
    public String decrypt() {
        String encryptedText = this.notes;
        StringBuilder decryptedText = new StringBuilder();
        for (int i = 0; i < encryptedText.length(); i++) {
            char c = encryptedText.charAt(i);
            decryptedText.append((char) (c - 5));
        }
        return decryptedText.toString();
    }


    @Override
    public String toString() {
        return super.toString()+"Consultation{" +
                "date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", cost=" + cost +
                ", encrypt_notes='" + notes + '\'' +
                ", decrypt_notes='" + decrypt() + '\'' +
                ", doctor=" + doctor +
                ", patient=" + patient +
                ", spend_hours=" + spend_hours +
                '}';
    }
}
