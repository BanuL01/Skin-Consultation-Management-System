package CW;

import CW.GUI.GUI_Book;
import CW.GUI.GUI_Cover;
import CW.GUI.GUI_Table;
import CW.GUI.GUI_success;

import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Scanner;

public class Console_Application {
    public static Scanner scanner = new Scanner(System.in);

    public static SkinConsultationManager manager;

    static {
        try {
            manager = new WestminsterSkinConsultationManager();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws IOException {
          new GUI_Cover();

    }
    public static void doctor_part() throws IOException {
        while (true) {
            String option;
            while (true) {
                System.out.println("Enter [A] to Add a new doctor");
                System.out.println("Enter [D] to Delete a doctor");
                System.out.println("Enter [P] to Print the list of the doctors");
                System.out.println("Enter [S] to Save in a file ");
                System.out.println("Enter [G] to Open the GUI");
                System.out.println("Enter [Q] to Quite the Program ");
                System.out.println("Choose your option:");
                option = scanner.next().toUpperCase();

                if ((option.equals("A")) || (option.equals("D")) || (option.equals("P")) || (option.equals("S")) || (option.equals("Q")) || option.equals("G")) {
                    break;
                } else {
                    System.out.println("You have entered an invalid option");
                }
            }

            if (option.equals("A")) {
                add_new_doctor();
            }
            else if (option.equals("D")) {
                System.out.println("Enter the doctor's licence number you want to delete: ");
                manager.delete_doc(scanner.next());
            }
            else if (option.equals("P")) {
                manager.print_docs();
            }
            else if (option.equals("S")) {
                manager.save_in_file("Doctor");
            }
            else if (option.equals("G")){
                new GUI_Table();
                break;
            }
            else {
                System.exit(0);
            }

        }
    }
    public static void add_new_doctor(){
        String name;
        String surname;
        String dob;
        String mobile_num;
        String licence_num;
        String specialization;

        if (manager.getdocArray().size() < 10) {
            System.out.println("Enter the Doctor's details below : ");
            System.out.println("Enter the first name");
            name = scanner.next();
            System.out.println("Enter the surname");
            surname = scanner.next();
            //gets a validate dob
            dob = validate_dob();
            //gets a validate TP number
            mobile_num = validate_mobile_num();
            //gets a validate medical licence number
            licence_num = validate_medical_license();
            System.out.println("Enter the specialization");
            specialization = scanner.next();

            Doctor doctor = new Doctor(name,surname,dob, mobile_num,licence_num,specialization);

            System.out.println("\n_________________________________________________________________________________________________________________");
            System.out.println("Successfully added the doctor to the list! ");
            System.out.println("Doctor name is " + doctor.getName());
            System.out.println("Doctor's surname is " + doctor.getSurname());
            System.out.println("Doctor's birthday is  " + doctor.getDate_of_birth());
            System.out.println("Doctor's mobile number is " + doctor.getMobile_number());
            System.out.println("Doctor's licence number is " + doctor.getLicence_number());
            System.out.println("Doctor is specialized in  " + doctor.getSpecialisation());
            System.out.println("\n_________________________________________________________________________________________________________________");

            manager.add_new_doc(doctor);
        }
        else {
            System.out.println("Already 10 doctors in the list. Can't add more.");
        }
    }
    //returns a validate TP number having 10 string numbers
    public static String validate_mobile_num(){
        String mobile_num;
        while (true) {
            System.out.println("Enter Doctor's mobile number");
            mobile_num = scanner.next();
            try{
                Long.parseLong(mobile_num);
                if(mobile_num.length() == 10){
                    break;
                }
                else {
                    System.out.println("Invalid telephone number (use 10 digits)");
                }
            }
            catch (Exception e){
                System.out.println("Insert a valid telephone number (Includes integers) ");
            }
        }
        return mobile_num;
    }

    //returns validate dob according to the format
    public static String validate_dob(){
        String birthday;
        DateTimeFormatter formater= DateTimeFormatter.ofPattern("yyyy/MM/dd");

        while (true){
            System.out.print("Enter Doctor's Birthday [ YYYY/MM/DD ] : ");
            birthday=scanner.next();
            try {
                formater.parse(birthday);
                int birth_year=Integer.parseInt(""+birthday.charAt(0)+birthday.charAt(1)+birthday.charAt(2)+birthday.charAt(3));
                int current_year= Calendar.getInstance().get(Calendar.YEAR);
                //Checking in (60-25) years birth year
                if ((  birth_year>= (current_year-70)) && (birth_year < (current_year-20))){
                    break;
                }
                else {
                    System.out.println("Insert a year between "+(current_year-70)+"-"+(current_year-20));
                }
            }
            catch (Exception e){
                System.out.println("Invalid date type");
            }
        }
        return birthday;
    }

    public static String validate_medical_license(){
        String licence_num;
        if(manager.getdocArray().size() == 0){
            System.out.println("Enter Doctor's medical licence number: ");
            licence_num = scanner.next();
        }
        else {

            Boolean check_flag;
            while (true) {
                check_flag = false;
                System.out.println("Enter the licence number");
                licence_num = scanner.next();
                for (Doctor doctor : manager.getdocArray()) {
                    if (licence_num.equals(doctor.getLicence_number())) {
                        check_flag = true;
                        System.out.println("Licence number is already used. Use another");
                        break;
                    }
                }
                if (!(check_flag)) {
                    break;
                }
            }
        }
        return licence_num;
    }

}

