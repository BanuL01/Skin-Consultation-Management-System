package CW;

import java.io.Serializable;

public class Doctor extends Person implements Comparable, Serializable {
    private String licence_number;
    private String specialisation;

    //constructors
    public Doctor(String name, String surname, String date_of_birth, String mobile_number, String licence_number, String specialisation) {
        super(name, surname, date_of_birth, mobile_number);
        this.licence_number = licence_number;
        this.specialisation = specialisation;
    }
    //getters

    public String getLicence_number() {
        return licence_number;
    }

    public String getSpecialisation() {
        return specialisation;
    }
    //setters

    public void setLicence_number(String licence_number) {
        this.licence_number = licence_number;
    }

    public void setSpecialisation(String specialisation) {
        this.specialisation = specialisation;
    }

    @Override
    public int compareTo(Object o) {
        Doctor doctor = (Doctor)o;
        if (this.getSurname().compareToIgnoreCase(doctor.getSurname())>0){
            return 1;
        }
        else if (this.getSurname().compareToIgnoreCase(doctor.getSurname())<0) {
            return -1;
        }
        else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return super.toString()+"Doctor{" +
                "licence_number='" + licence_number + '\'' +
                ", specialisation='" + specialisation + '\'' +
                '}';
    }
}
