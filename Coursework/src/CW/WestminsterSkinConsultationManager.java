package CW;

import CW.GUI.GUI_Book;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WestminsterSkinConsultationManager implements SkinConsultationManager {
    public  ArrayList<Doctor>doc_list = new ArrayList<>();
    public  ArrayList<Consultation> con_list = new ArrayList<>();
    public File doc_file =new File("fileDB/doctorList.txt");//file path for doctor stored data
    public File con_file =new File("fileDB/consultationList.txt");//file path for doctor stored data

    public WestminsterSkinConsultationManager() throws IOException {
        doc_list = loadDateFromfile(doc_list,doc_file,"Doctor");
        con_list = loadDateFromfile(con_list,con_file,"Consultation");
    }

    @Override
    public void add_new_doc(Doctor doctor) {
        doc_list.add(doctor);
    }

    @Override
    public void delete_doc(String doctor_medical_num) {
        boolean check2_flag = false;
        for (Doctor doctor : doc_list){
            if (doctor_medical_num.equals(doctor.getLicence_number())) {
                check2_flag = true;
                System.out.println("\n_________________________________________________________________________________________________________________");
                System.out.println("Doctor deleted from the list successfully");
                System.out.println("Doctor name is " + doctor.getName());
                System.out.println("Doctor's surname is " + doctor.getSurname());
                System.out.println("Doctor's birthday is  " + doctor.getDate_of_birth());
                System.out.println("Doctor's mobile number is " + doctor.getMobile_number());
                System.out.println("Doctor's licence number is " + doctor.getLicence_number());
                System.out.println("Doctor is specialized in  " + doctor.getSpecialisation());
                System.out.println("\n_________________________________________________________________________________________________________________");
                doc_list.remove(doctor);
                System.out.println("Total number of doctors in the list: " + doc_list.size());
                break;
            }

        }
        if (!(check2_flag)){
            System.out.println("Doctor not found");
        }
        System.out.println();
    }

    @Override
    public void print_docs() {
        Collections.sort(doc_list);
        for (Doctor doctor : doc_list) {
            System.out.println("\n_________________________________________________________________________________________________________________");
            System.out.println("Doctor's details :");
            System.out.println("Doctor name is " + doctor.getName());
            System.out.println("Doctor's surname is " + doctor.getSurname());
            System.out.println("Doctor's birthday is  " + doctor.getDate_of_birth());
            System.out.println("Doctor's mobile number is " + doctor.getMobile_number());
            System.out.println("Doctor's licence number is " + doctor.getLicence_number());
            System.out.println("Doctor is specialized in  " + doctor.getSpecialisation());
            System.out.println("\n_________________________________________________________________________________________________________________");
        }
    }

    @Override
    public void save_in_file(String store_Name) throws IOException {
        ObjectOutputStream oos = null;
        File fileName = null;
        ArrayList listName = null;
        if (store_Name.equals("Doctor")){
            fileName=this.doc_file;
            listName=this.doc_list;
        }
       else {
            fileName=this.con_file;
            listName=this.con_list;
        }

        try {
            oos=new ObjectOutputStream(new FileOutputStream(fileName));
            oos.writeObject(listName);
            System.out.println("Successfully saved in "+ store_Name);
        }
        catch (Exception e){
//            System.out.println(e);
            System.out.println("Error in "+ store_Name);
        }
        finally {
            oos.close();
        }
    }
    //Load data from to file to list
    public static <T> ArrayList<T> loadDateFromfile(ArrayList<T> listName,File filename,String storename) throws IOException {
        ObjectInputStream ois=null;
        Boolean checkFile=false;

        try {
            if (filename.isFile()){
                if ((filename).length()==0) {
                    System.out.println("No any old data in store "+storename);//Store meaning to file
                }
                else{
                    ois=new ObjectInputStream(new FileInputStream(filename));
                    listName= (ArrayList<T>) ois.readObject();
                    checkFile=true;
                }
            }
            else {
                System.out.println("Cant find store "+storename);
            }
        }
        catch (Exception e){
//            System.out.println(e);
            System.out.println("Error in "+storename);
        }
        finally {
            if (checkFile){
                ois.close();
            }
        }
        return listName;
    }


    public ArrayList<Doctor> getdocArray() {
        return doc_list;
    }

    @Override
    public ArrayList<Patient> getpatientArray() {
        return null;
    }

    @Override
    public ArrayList<Consultation> getconsultationArray() {
        return con_list;
    }
}
