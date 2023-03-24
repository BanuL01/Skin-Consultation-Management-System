package CW;

import java.io.Serializable;

public class Patient extends Person implements Serializable {
    private String p_id;

    //constructors
    public Patient(String name, String surname, String date_of_birth, String mobile_number, String p_id) {
        super(name, surname, date_of_birth, mobile_number);
        this.p_id = p_id;
    }
    //getters

    public String getP_id() {
        return p_id;
    }
    //setters

    public void setP_id(String p_id) {
        this.p_id = p_id;
    }

    @Override
    public String toString() {
        return super.toString()+"Patient{" +
                "p_id='" + p_id + '\'' +
                '}';
    }
}
