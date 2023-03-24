package CW.GUI;

import CW.Doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;

import static CW.Console_Application.doctor_part;
import static CW.Console_Application.manager;

public class GUI_Table extends JFrame {
    JFrame frame = new JFrame();
    JPanel panel = new JPanel();
    JLabel doc_list =new JLabel("Doctor List");
    JLabel doc_name = new JLabel("Doctor Name");
    JLabel licence_num = new JLabel("Licence Number");
    JLabel spec = new JLabel("Specialization");
    JButton sort = new JButton("Sort");
    JButton back = new JButton("Back");
    JButton view_consultation = new JButton("View Consultation");
    JButton book_consultation = new JButton("Book Consultation");
    ImageIcon table = new ImageIcon("Images/doc_list.png");
    JLabel table_lable = new JLabel(table);

    JTable doctor_list;
    JTable doctor_list_sorted;

    public GUI_Table(){
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

        table_lable.setSize(1035,900);

        doc_list.setSize(700,150);
        doc_list.setLocation(390,15);
        doc_list.setFont(new Font("Times New Roman", Font.BOLD,45));
        doc_list.setForeground(new Color(0,0,0));

        //create table
        createTable(manager.getdocArray());


        doc_name.setVisible(true);
        doc_name.setSize(140,70);
        doc_name.setLocation(66,140);
        doc_name.setFont(new Font("Times New Roman",Font.BOLD,24));
        doc_name.setForeground(new Color(0,0,0));

        licence_num.setVisible(true);
        licence_num.setSize(250,70);
        licence_num.setLocation(366,140);
        licence_num.setFont(new Font("Times New Roman",Font.BOLD,24));
        licence_num.setForeground(new Color(0,0,0));

        spec.setVisible(true);
        spec.setSize(180,70);
        spec.setLocation(666,140);
        spec.setFont(new Font("Times New Roman",Font.BOLD,24));
        spec.setForeground(new Color(0,0,0));

        frame.add(panel);
        panel.add(table_lable);
        table_lable.add(doc_list);
        table_lable.add(doc_name);
        table_lable.add(licence_num);
        table_lable.add(spec);
        table_lable.add(sort);
        table_lable.add(back);
        table_lable.add(view_consultation);
        table_lable.add(book_consultation);

        sort.setSize(100,50);
        sort.setLocation(445,660);
        sort.setFont(new Font("Times New Roman", Font.BOLD, 15));
        sort.setBackground(new Color(212, 197, 180));
        sort.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (sort.getText().equals("Sort")) {
                    ArrayList<Doctor> temp_array= (ArrayList<Doctor>) manager.getdocArray().clone();
                    temp_array.sort(Comparator.comparing(Doctor::getName));
                    doctor_list.setVisible(false);
                    createTable(temp_array);
                    sort.setText("Return");
                }
                else {
                    doctor_list.setVisible(false);
                    createTable(manager.getdocArray());
                    sort.setText("Sort");
                }
            }
        });

        back.setSize(140,70);
        back.setLocation(80,770);
        back.setFont(new Font("Times New Roman", Font.BOLD, 20));
        back.setBackground(new Color(212, 197, 180));
        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUI_Cover();
            }
        });

        view_consultation.setSize(230,70);
        view_consultation.setLocation(370,770);
        view_consultation.setFont(new Font("Times New Roman", Font.BOLD, 24));
        view_consultation.setBackground(new Color(212, 197, 180));

        book_consultation.setSize(230,70);
        book_consultation.setLocation(750,770);
        book_consultation.setFont(new Font("Times New Roman", Font.BOLD, 24));
        book_consultation.setBackground(new Color(212, 197, 180));
        book_consultation.addActionListener (new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
                new GUI_Book();
            }
        });
    }

    private void createTable(ArrayList<Doctor> list_name){

        String data[][]=new String[list_name.size()][3];
        for (int i =0;i<list_name.size();i++){
            data[i][0]="Dr."+list_name.get(i).getName()+" "+list_name.get(i).getSurname();
            data[i][1]=list_name.get(i).getLicence_number();
            data[i][2]=list_name.get(i).getSpecialisation();
        }

        String column[]={"Doctor's Name","Medical Licence Number","Doctor Type"};

        doctor_list = new JTable(data,column);
        doctor_list.setSize(900,430);
        doctor_list.setLocation(70,220);
        doctor_list.setBackground(new Color(237, 192, 158));
        doctor_list.setShowVerticalLines(false);
        doctor_list.setFont(new Font("Times New Roman",Font.BOLD,22));
        doctor_list.setForeground(new Color(0,0,0));
        doctor_list.setRowHeight(40);
        doctor_list.setVisible(true);
        table_lable.add(doctor_list);
    }
}