
//Zeynep K?l?ç 22120205065

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main implements ItemListener {
    private  JCheckBox female,male,no;
    public void main(){
        JFrame jFrame=new JFrame("Latest Project");
        JLabel jLabel1=new JLabel("Name Surname");
        JLabel jLabel2=new JLabel("Phone number");
        JLabel jLabel3=new JLabel("Email");
        JLabel jLabel4=new JLabel("Gender");
        final TextField textField1=new TextField(" ");
        final TextField textField2=new TextField(" ");
        final TextField textField3=new TextField(" ");
        JButton button1=new JButton("Register");
        female=new JCheckBox("Female");
        female.addItemListener(this);
        male=new JCheckBox("Male");
        male.addItemListener(this);
        no=new JCheckBox("I don't want to specify");
        no.addItemListener(this);

        jFrame.setSize(500,400);
        jFrame.setLocation(200,50);
        jFrame.getContentPane().add(BorderLayout.CENTER, new JTextArea(10, 40));
        jLabel1.setBounds(34,49,150,18);
        jLabel2.setBounds(34,89,150,18);
        jLabel3.setBounds(34,129,150,18);
        jLabel4.setBounds(34,169,150,18);
        textField1.setBounds(200,49,160,20);
        textField2.setBounds(200,89,160,20);
        textField3.setBounds(200,129,160,20);
        button1.setBounds(180,300,200,20);
        female.setBounds(210,170,80,30);
        male.setBounds(210,210,80,30);
        no.setBounds(210,250,200,30);



        jFrame.add(jLabel1);
        jFrame.add(jLabel2);
        jFrame.add(jLabel3);
        jFrame.add(jLabel4);
        jFrame.add(textField1);
        jFrame.add(textField2);
        jFrame.add(textField3);
        jFrame.add(button1);
        jFrame.add(female);
        jFrame.add(male);
        jFrame.add(no);

        jFrame.setLayout(null);
        jFrame.setVisible(true);

        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                button1.setText("Recorded");
                String name_surname= textField1.getText();
                String phone_number=textField2.getText();
                String email=textField3.getText();
                String gender = "";

                if (female.isSelected()) {
                    gender = "Female";
                } else if (male.isSelected()) {
                    gender = "Male";
                } else if (no.isSelected()) {
                    gender = "Not specified";
                }

                try {
                    BufferedWriter writer = new BufferedWriter(new FileWriter("Person.txt", true));
                    writer.write("Name Surname:"+name_surname+"\n"+"Phone Number:"+phone_number+"\n"+"Mail Address:"+email+"\n"+"Gender:"+gender);
                    writer.newLine();
                    writer.close();
                    System.out.println("The data was written to file.");
                    System.out.println("Please check the file");
                } catch (IOException ex) {
                    System.out.println("File writing error: " + ex.getMessage());
                }

            }
        });
    }

    @Override
    public void itemStateChanged(ItemEvent e) {

    }


    public static void main(String[] args) {
        Main Main=new Main();
        Main.main();
    }
}

