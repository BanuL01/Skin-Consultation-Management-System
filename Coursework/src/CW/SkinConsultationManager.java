package CW;

import java.io.IOException;
import java.util.ArrayList;

public interface SkinConsultationManager {
    void add_new_doc(Doctor doctor);
    void delete_doc(String doctor_medical_num);
    void print_docs();
    void save_in_file(String store_Name) throws IOException;
    ArrayList<Doctor> getdocArray();
    ArrayList<Patient> getpatientArray();
    ArrayList<Consultation> getconsultationArray();


}
