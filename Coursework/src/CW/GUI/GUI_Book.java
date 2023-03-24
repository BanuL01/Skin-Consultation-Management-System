package CW.GUI;

import CW.Consultation;
import CW.Doctor;
import CW.Patient;

import javax.print.Doc;
import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Random;

import static CW.Console_Application.manager;

public class GUI_Book extends JFrame {
    JFrame frame=new JFrame();
    JPanel panel=new JPanel();
    JPanel panel2 = new JPanel();
    JPanel panel3 = new JPanel();
    JPanel panel4 = new JPanel();
    JLabel book_con =new JLabel("Book Consultation");
    JLabel book_consultation2 =  new JLabel("Book Consultation");
    JLabel register =new JLabel("Register Here!");
    ImageIcon book_image = new ImageIcon("Images/book_con.png");
    JLabel book_image_lable = new JLabel(book_image);
    ImageIcon booked_cons = new ImageIcon("Images/book_cons.png");
    JLabel booked_cons_lable = new JLabel(booked_cons);
    ImageIcon confirm_img = new ImageIcon("Images/Confirm.png");

    JLabel confirm_lable = new JLabel(confirm_img);
    JLabel book_licence = new JLabel("Enter Consulter's Medical Licence Number");

    JLabel book_date = new JLabel("Enter Consultation Date [YYYY/MM/DD]");
    JLabel book_time = new JLabel("Enter Consultation Time [HH:MM]  08.00 - 22.00");
    JLabel book_spent = new JLabel("Enter Consultation Hours You Need ");
    JLabel licence_required = new JLabel("* Required");
    JLabel date_required = new JLabel("* Required");
    JLabel time_required = new JLabel("* Required");
    JLabel s_hours_required = new JLabel("* Required");
    JLabel  add_note =new JLabel("Add a note :");
    JLabel  doc_name = new JLabel("Dr. Banuji Thathsari");
    JLabel doc_available = new JLabel("is available for you");
    JLabel not_available = new JLabel("is not available");

    JLabel allocated = new JLabel("You are Allocated to");
    JTextField book_licence2 = new JTextField();
    JTextField book_date2 = new JTextField();
    JTextField book_time2 = new JTextField();
    JTextField book_spent2 = new JTextField();
    JTextField note = new JTextField();

    JButton back = new JButton("Back");
    JButton reset = new JButton("Reset");
    JButton available = new JButton("Check Availability");

    JButton back2 = new JButton("Back");
    JButton book_consultation = new JButton("Book Consultation");

    JButton back_p4 = new JButton("Back");
    JButton reset_p4 = new JButton("Reset");
    JButton confirm_p4 = new JButton("Confirm");
    JLabel f_name = new JLabel("First Name");
    JLabel s_name = new JLabel("Surname");

    JLabel  dob = new JLabel("Date of Birth [YYYY/MM/DD]");

    JLabel m_no = new JLabel("Contact Number");
    JLabel id = new JLabel("ID Number");

    JTextField f_name1 = new JTextField();
    JTextField s_name1 = new JTextField();
    JTextField dob1 =new JTextField();
    JTextField  m_no1 = new JTextField();
    JTextField id1 = new JTextField();

    JLabel f_name_req = new JLabel("* Required");
    JLabel s_name_req = new JLabel("* Required");
    JLabel dob_req = new JLabel("* Required");
    JLabel m_no_req = new JLabel("* Required");
    JLabel id_req = new JLabel("* Required");

    Doctor final_doctor;


    public GUI_Book(){
        frame.setSize(1035,900);
        frame.setVisible(true);
        frame.setTitle("Westminster Skin Consultation Center");
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        panel.setVisible(true);
        panel.setSize(1035,900);
        panel.setLayout(null);
        panel.setBackground(new Color(237, 192, 158));

        panel2.setVisible(false);
        panel2.setSize(1035,900);
        panel2.setLayout(null);
        panel2.setBackground(new Color(237, 192, 158));

        panel3.setVisible(true);
        panel3.setSize(1035,350);
        panel3.setLocation(0,130);
        panel3.setLayout(null);
        panel3.setBackground(new Color(212, 197, 180));

        panel4.setVisible(false);
        panel4.setSize(1035,900);
        panel4.setLayout(null);
        panel4.setBackground(new Color(237, 192, 158));

        book_con.setVisible(true);
        book_con.setSize(340,90);
        book_con.setLocation(390,15);
        book_con.setFont(new Font("Times New Roman",Font.BOLD,40));
        book_con.setForeground(new Color(0,0,0));

        book_consultation2.setVisible(true);
        book_consultation2.setSize(340,90);
        book_consultation2.setLocation(390,15);
        book_consultation2.setFont(new Font("Times New Roman",Font.BOLD,40));
        book_consultation2.setForeground(new Color(0,0,0));

        register.setVisible(true);
        register.setSize(340,90);
        register.setLocation(390,15);
        register.setFont(new Font("Times New Roman",Font.BOLD,40));
        register.setForeground(new Color(0,0,0));

        book_image_lable.setSize(1035,900 );
        confirm_lable.setSize(1035,900);
        booked_cons_lable.setSize(1035,900);


        //lables panel
        book_licence.setLocation(100,105);
        book_licence.setFont(new Font("Times New Roman",Font.BOLD,24));
        book_licence.setForeground(new Color(0,0,0));
        book_licence.setSize(450,70);


        book_date.setLocation(100,230);
        book_date.setFont(new Font("Times New Roman",Font.BOLD,24));
        book_date.setForeground(new Color(0,0,0));
        book_date.setSize(450,70);

        book_time.setLocation(100,345);
        book_time.setFont(new Font("Times New Roman",Font.BOLD,24));
        book_time.setForeground(new Color(0,0,0));
        book_time.setSize(550,70);

        book_spent.setLocation(100,460);
        book_spent.setFont(new Font("Times New Roman",Font.BOLD,24));
        book_spent.setForeground(new Color(0,0,0));
        book_spent.setSize(550,70);

        //lables - panel2

        add_note.setSize(350,70);
        add_note.setLocation(220,510);
        add_note.setFont(new Font("Times New Roman",Font.BOLD,24));
        add_note.setForeground(new Color(0,0,0));

        //lables - panel3
        doc_name.setVisible(false);
        doc_name.setSize(450,70);
        doc_name.setLocation(400,30);
        doc_name.setFont(new Font("Times New Roman",Font.BOLD,30));
        doc_name.setForeground(new Color(0,0,0));

        doc_available.setVisible(false);
        doc_available.setSize(650,70);
        doc_available.setLocation(415,100);
        doc_available.setFont(new Font("Times New Roman",Font.BOLD,30));
        doc_available.setForeground(new Color(0,0,0));

        not_available.setVisible(false);
        not_available.setSize(650,70);
        not_available.setLocation(440,105);
        not_available.setFont(new Font("Times New Roman",Font.BOLD,30));
        not_available.setForeground(new Color(0,0,0));

        allocated.setVisible(false);
        allocated.setSize(650,70);
        allocated.setLocation(300,180);
        allocated.setFont(new Font("Times New Roman",Font.BOLD,30));
        allocated.setForeground(new Color(0,0,0));



        //lables _panel 4
        f_name.setLocation(250,125);
        f_name.setFont(new Font("Times New Roman",Font.BOLD,24));
        f_name.setForeground(new Color(0,0,0));
        f_name.setSize(450,70);

        s_name.setLocation(250,240);
        s_name.setFont(new Font("Times New Roman",Font.BOLD,24));
        s_name.setForeground(new Color(0,0,0));
        s_name.setSize(450,70);

        dob.setLocation(250,355);
        dob.setFont(new Font("Times New Roman",Font.BOLD,24));
        dob.setForeground(new Color(0,0,0));
        dob.setSize(450,70);

        m_no.setLocation(250,470);
        m_no.setFont(new Font("Times New Roman",Font.BOLD,24));
        m_no.setForeground(new Color(0,0,0));
        m_no.setSize(450,70);

        id.setLocation(250,585);
        id.setFont(new Font("Times New Roman",Font.BOLD,24));
        id.setForeground(new Color(0,0,0));
        id.setSize(450,70);




        //text field - panel
        book_licence2.setSize(450,40);
        book_licence2.setLocation(450,170);
        book_licence2.setHorizontalAlignment(JTextField.CENTER);

        book_date2.setSize(450,40);
        book_date2.setLocation(450,285);
        book_date2.setHorizontalAlignment(JTextField.CENTER);

        book_time2.setSize(450,40);
        book_time2.setLocation(450,400);
        book_time2.setHorizontalAlignment(JTextField.CENTER);

        book_spent2.setSize(450,40);
        book_spent2.setLocation(450,515);
        book_spent2.setHorizontalAlignment(JTextField.CENTER);

        //text field - panel2
        note.setSize(450,90);
        note.setLocation(350,500);
        note.setHorizontalAlignment(JTextField.CENTER);

        //text field - panel4
        f_name1.setSize(450,40);
        f_name1.setLocation(400,170);
        f_name1.setHorizontalAlignment(JTextField.CENTER);

        s_name1.setSize(450,40);
        s_name1.setLocation(400,285);
        s_name1.setHorizontalAlignment(JTextField.CENTER);

        dob1.setSize(450,40);
        dob1.setLocation(400,410);
        dob1.setHorizontalAlignment(JTextField.CENTER);

        m_no1.setSize(450,40);
        m_no1.setLocation(400,525);
        m_no1.setHorizontalAlignment(JTextField.CENTER);

        id1.setSize(450,40);
        id1.setLocation(400,630);
        id1.setHorizontalAlignment(JTextField.CENTER);



// required lable
        licence_required.setSize(450,70);
        licence_required.setLocation(620,118);
        licence_required.setForeground(new Color(133, 0, 0));
        licence_required.setVisible(false);

        date_required.setSize(450,70);
        date_required.setLocation(620,233);
        date_required.setForeground(new Color(133, 0, 0));
        date_required.setVisible(false);

        time_required.setSize(450,70);
        time_required.setLocation(620,348);
        time_required.setForeground(new Color(133, 0, 0));
        time_required.setVisible(false);

        s_hours_required.setSize(450,70);
        s_hours_required.setLocation(620,463);
        s_hours_required.setForeground(new Color(133, 0, 0));
        s_hours_required.setVisible(false);

        //required label-panel4
        f_name_req.setSize(450,70);
        f_name_req.setLocation(880,148);
        f_name_req.setVisible(false);
        f_name_req.setForeground(new Color(133, 0, 0));

        s_name_req.setSize(450,70);
        s_name_req.setLocation(880,263);
        s_name_req.setVisible(false);
        s_name_req.setForeground(new Color(133, 0, 0));

        dob_req.setSize(450,70);
        dob_req.setLocation(880,388);
        dob_req.setVisible(false);
        dob_req.setForeground(new Color(133, 0, 0));

        m_no_req.setSize(450,70);
        m_no_req.setLocation(880,503);
        m_no_req.setVisible(false);
        m_no_req.setForeground(new Color(133, 0, 0));

        id_req.setSize(450,70);
        id_req.setLocation(880,608);
        id_req.setVisible(false);
        id_req.setForeground(new Color(133, 0, 0));






//buttons - panel
        back.setSize(140,70);
        back.setLocation(80,700);
        back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back.setBackground(new Color(212, 197, 180));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUI_Table();
            }
        });

        reset.setSize(230,70);
        reset.setLocation(370,700);
        reset.setFont(new Font("Times New Roman", Font.BOLD, 24));
        reset.setBackground(new Color(212, 197, 180));
        reset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                book_licence2.setText(null);
                book_date2.setText(null);
                book_time2.setText(null);
                book_spent2.setText(null);
                licence_required.setVisible(false);
                date_required.setVisible(false);
                time_required.setVisible(false);
                s_hours_required.setVisible(false);
            }
        });

        available.setSize(230,70);
        available.setLocation(750,700);
        available.setFont(new Font("Times New Roman", Font.BOLD, 24));
        available.setBackground(new Color(212, 197, 180));
        available.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validate_date();
                validate_licence();
                validate_time();
                validate_hours();
                if ((validate_licence()) && (validate_date()) && (validate_time()) && (validate_hours())){
                    Doctor current_doctor=find_currentDoctor();

                    boolean check_flag_currentDoctor=false;

                    for (Consultation consultation : manager.getconsultationArray()){
                        if ( current_doctor.getLicence_number().equals(consultation.getDoctor().getLicence_number()) && ( book_time2.getText().equals(consultation.getTime()))
                                && ( (book_date2.getText().equals(consultation.getDate()))) ){
                            check_flag_currentDoctor=true;
                            break;
                        }
                    }

                    if (check_flag_currentDoctor){
                        // current doctor booked
                        Random ran=new Random();
                        int doc_index;
                        boolean next_doc_check;

                        while (true){
                            next_doc_check=false;
                            doc_index=ran.nextInt(0,manager.getdocArray().size());

                            if ( !(current_doctor==manager.getdocArray().get(doc_index) )){
                                //checking the random doctor availability
                                for (Consultation consultation:manager.getconsultationArray()){
                                    if ( (manager.getdocArray().get(doc_index).getLicence_number().equals(consultation.getDoctor().getLicence_number()) && ( book_time2.getText().equals(consultation.getTime()))
                                            && ( (book_date2.getText().equals(consultation.getDate()))))){
                                        next_doc_check=true;
                                        break;
                                    }
                                }
                            }
                            else {
                                next_doc_check=true;
                            }

                            if (!next_doc_check){
                                break;
                            }
                        }

                        final_doctor=manager.getdocArray().get(doc_index);
                        doc_name.setText("Dr."+current_doctor.getName() +" "+ current_doctor.getSurname() );
                        doc_name.setVisible(true);
                        not_available.setVisible(true);
                        allocated.setText("You are Allocated to: " +"Dr."+final_doctor.getName()+" "+final_doctor.getSurname());
                        allocated.setVisible(true);


                    }else {
                        //current doctor free time
                        final_doctor=current_doctor;

                        doc_name.setText("Dr."+final_doctor.getName()+" "+final_doctor.getSurname());
                        doc_name.setVisible(true);
                        doc_available.setVisible(true);
                        allocated.setVisible(false);

                    }

                    panel.setVisible(false);
                    panel2.setVisible(true);
                }
            }
        });

        //buttons - panel2
        back2.setSize(140,70);
        back2.setLocation(80,700);
        back2.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back2.setBackground(new Color(212, 197, 180));
        back2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel2.setVisible(false);
                panel.setVisible(true);
            }
        });

        book_consultation.setSize(230,70);
        book_consultation.setVisible(true);
        book_consultation.setLocation(750,700);
        book_consultation.setFont(new Font("Times New Roman", Font.BOLD, 24));
        book_consultation.setBackground(new Color(212, 197, 180));
        book_consultation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    panel2.setVisible(false);
                    panel4.setVisible(true);
            }
        });

        //buttons panel 4
        back_p4.setSize(140,70);
        back_p4.setLocation(80,770);
        back_p4.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back_p4.setBackground(new Color(212, 197, 180));
        back_p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel4.setVisible(false);
                panel2.setVisible(true);
            }
        });

        reset_p4.setSize(230,70);
        reset_p4.setLocation(370,770);
        reset_p4.setFont(new Font("Times New Roman", Font.BOLD, 24));
        reset_p4.setBackground(new Color(212, 197, 180));
        reset_p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f_name1.setText(null);
                s_name1.setText(null);
                dob1.setText(null);
                m_no1.setText(null);
                id1.setText(null);
                f_name_req.setVisible(false);
                s_name_req.setVisible(false);
                dob_req.setVisible(false);
                m_no_req.setVisible(false);
                id_req.setVisible(false);
            }
        });

        confirm_p4.setSize(230,70);
        confirm_p4.setLocation(750,770);
        confirm_p4.setFont(new Font("Times New Roman", Font.BOLD, 24));
        confirm_p4.setBackground(new Color(212, 197, 180));
        confirm_p4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                validate_fname();
                validate_sname();
                validate_dob();
                validate_mob_number();
                validate_id();
                if ((validate_fname()) && validate_sname()&& validate_dob() && validate_mob_number() && validate_id()) {

                    Patient patient = new Patient(f_name1.getText(),s_name1.getText(),dob1.getText(),m_no1.getText(),id1.getText());


                    Consultation consultation = new Consultation(book_date2.getText(),book_time2.getText(),generate_cost(),note.getText(),final_doctor, patient, Integer.parseInt(book_spent2.getText()));
                    manager.getconsultationArray().add(consultation);
                    System.out.println(consultation);

                    try {
                        manager.save_in_file("Consultation");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }


                    frame.setVisible(false);
                    new GUI_success(consultation);
                }
            }
        });



//add
        frame.add(panel);
        frame.add(panel2);
        frame.add(panel4);
        panel.add(book_con);
        panel.add(book_image_lable);
        panel4.add(confirm_lable);
        panel2.add(booked_cons_lable);
        book_image_lable.add(book_licence);
        book_image_lable.add(book_date);
        book_image_lable.add(book_time);
        book_image_lable.add(book_spent);
        book_image_lable.add(book_licence2);
        book_image_lable.add(book_date2);
        book_image_lable.add(book_time2);
        book_image_lable.add(book_spent2);

        book_image_lable.add(licence_required);
        book_image_lable.add(date_required);
        book_image_lable.add(time_required);
        book_image_lable.add(s_hours_required);

        book_image_lable.add(back);
        book_image_lable.add(reset);
        book_image_lable.add(available);

        confirm_lable.add(register);
        confirm_lable.add(f_name);
        confirm_lable.add(s_name);
        confirm_lable.add(dob);
        confirm_lable.add(m_no);
        confirm_lable.add(id);
        confirm_lable.add(f_name1);
        confirm_lable.add(s_name1);
        confirm_lable.add(dob1);
        confirm_lable.add(m_no1);
        confirm_lable.add(id1);
        confirm_lable.add(f_name_req);
        confirm_lable.add(s_name_req);
        confirm_lable.add(dob_req);
        confirm_lable.add(m_no_req);
        confirm_lable.add(id_req);
        confirm_lable.add(back_p4);
        confirm_lable.add(reset_p4);
        confirm_lable.add(confirm_p4);


        booked_cons_lable.add(book_consultation);
        booked_cons_lable.add(back2);
        booked_cons_lable.add(note);
        booked_cons_lable.add(panel3);
        booked_cons_lable.add(book_consultation2);
        booked_cons_lable.add(add_note);

        panel3.add(doc_name);
        panel3.add(doc_available);
        panel3.add(not_available);
        panel3.add(allocated);
    }

    private Doctor find_currentDoctor() {
        Doctor doc=null;

        for (Doctor doctor:manager.getdocArray()){
            if (book_licence2.getText().equals(doctor.getLicence_number())){
                doc=doctor;
                break;
            }
        }

        return doc;
    }

    private int generate_cost() {
        int hours = Integer.parseInt(book_spent2.getText());
        Boolean check_flag=false;

        for (Consultation consultation : manager.getconsultationArray()){
            if (id1.getText().equals(consultation.getPatient().getP_id())){
                check_flag=true;
                break;
            }
        }

        if (check_flag){
            return 25*hours; //old patient
        }
        else {
            return 15*hours; //new patient
        }
    }

    //validate licence number
    private boolean validate_licence(){
        if (book_licence2.getText().length()==0 ){
            licence_required.setVisible(true);
            licence_required.setText("*Required");
            return false;
        }
        else {
            boolean check_flag=false;

            for (Doctor doctor : manager.getdocArray()) {
                if ((doctor.getLicence_number().equals(book_licence2.getText()))){
                    check_flag=true;
                    break;
                }
            }
            if (check_flag){
                licence_required.setVisible(false);
                return true;
            }
            else {
                licence_required.setVisible(true);
                licence_required.setText("*Can't Find a Doctor");
                return false;
            }
        }
    }

    private boolean validate_date(){
        if (book_date2.getText().length()==0){
            date_required.setVisible(true);
            date_required.setText("*Required");
            return false;
        }
        else {
            DateTimeFormatter formater= DateTimeFormatter.ofPattern("yyyy/MM/dd");
            try {
                formater.parse(book_date2.getText());
                int year = Integer.parseInt("" + book_date2.getText().charAt(0) + book_date2.getText().charAt(1) + book_date2.getText().charAt(2) + book_date2.getText().charAt(3));
                int current_year = Calendar.getInstance().get(Calendar.YEAR);

                if (year >= current_year ){
                    return true;
                }
                else {
                    date_required.setVisible(true);
                    date_required.setText("*Invalid date");
                    return false;
                }
            }
            catch (Exception e) {
                date_required.setVisible(true);
                date_required.setText("*Date is not in Format");
                return false;
            }

        }

    }

    private boolean validate_time() {
        if (book_time2.getText().length() == 0) {
            time_required.setVisible(true);
            time_required.setText("*Required");
            return false;
        }
        else {
            DateTimeFormatter formater = DateTimeFormatter.ofPattern("HH:mm");
            try {
                formater.parse(book_time2.getText());
                int time = Integer.parseInt("" +  book_time2.getText().charAt(0) +book_time2.getText().charAt(1));
                if ( (time>=8) && (time<=22)){
                    time_required.setVisible(false);
                    return true;
                }
                else {
                    time_required.setVisible(true);
                    time_required.setText("*We are closed");
                    return false;
                }

            } catch (Exception e) {
                time_required.setVisible(true);
                time_required.setText("*Invalid Time");
                return false;
            }

        }
    }

    private boolean validate_hours() {
        if (book_spent2.getText().length() == 0) {
            s_hours_required.setVisible(true);
            s_hours_required.setText("*Required");
            return false;
        }
        else {
            try {
                Integer.parseInt( book_spent2.getText());
                s_hours_required.setVisible(false);
                return true;

            }
            catch (Exception e){
                s_hours_required.setVisible(true);
                s_hours_required.setText("*Enter number of hours");
                return false;
            }
        }
    }

    private boolean validate_fname(){
        f_name_req.setVisible(false);
        if (f_name1.getText().length() == 0){
            f_name_req.setVisible(true);
            f_name_req.setText("*Required");
            return false;
        }
        else {
            f_name_req.setVisible(false);
            return true;
        }

    }

    private boolean validate_sname(){
        s_name_req.setVisible(false);
        if (s_name1.getText().length() == 0){
            s_name_req.setVisible(true);
            s_name_req.setText("*Required");
            return false;
        }
        else {
            s_name_req.setVisible(false);
            return true;
        }

    }

    private boolean validate_dob() {
        if (dob1.getText().length() == 0) {
            dob_req.setVisible(true);
            dob_req.setText("*Required");
            return false;
        }
        else {

            DateTimeFormatter formater = DateTimeFormatter.ofPattern("yyyy/MM/dd");

            try {
                formater.parse(dob1.getText());
                int birth_year = Integer.parseInt("" + dob1.getText().charAt(0) + dob1.getText().charAt(1) + dob1.getText().charAt(2) + dob1.getText().charAt(3));
                int current_year = Calendar.getInstance().get(Calendar.YEAR);
                if (birth_year < current_year) {
                    dob_req.setVisible(false);
                    return true;
                }
                else {
                    dob_req.setVisible(true);
                    dob_req.setText("Cannot Consult");
                    return false;
                }
            }
            catch (Exception e) {
                dob_req.setVisible(true);
                dob_req.setText("Invalid date");
                return false;
            }
        }
    }

    public boolean validate_mob_number() {
        if (m_no1.getText().length() == 0) {
            m_no_req.setVisible(true);
            m_no_req.setText("*Required");
            return false;
        }
        else {
            try {
                Long.parseLong(m_no1.getText());
                if (m_no1.getText().length() == 10) {
                    m_no_req.setVisible(false);
                    return (true);
                }
                else {
                    m_no_req.setVisible(true);
                    m_no_req.setText("*Invalid Mobile Number");
                    return (false);
                }
            }
            catch (Exception e){
                m_no_req.setVisible(true);
                m_no_req.setText("*Invalid Mobile Number");
                return (false);
            }
        }
    }

    public boolean validate_id() {
        if (id1.getText().length() == 0) {
            id_req.setVisible(true);
            id_req.setText("*Required");
            return false;
        }
        else {
            id_req.setVisible(false);
            return (true);
        }
    }
}
