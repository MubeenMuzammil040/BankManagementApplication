import Conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class s1 extends JFrame implements ActionListener//,Runnable
{

    long random;
    JLabel label, label1, label2, label3, label4, label5, label6, label7, label8, label9, l10, l11, l12, l13,l14,l15;
    JTextField t1, t2, t3, t4, t5, t6, t7,t8,t9;
    JRadioButton male, female;
    JRadioButton Matriculation, intermediate, Graduate, PostGraduate;
    JRadioButton saving, Fixed_Deposit_Account, Current_Account, Reccurring_Deposit_Account;
    JComboBox Country;
    JTextArea ta1;
    JCheckBox terms;
    // JButtonGroup gen;
    JButton jButton1, Cancel;
    JLabel msg;
    private String gender;

    //public void run() {
    //JOptionPane.showMessageDialog(null, "Thread is running");
     s1() {
        setBounds(300, 100, 700, 800);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container c = getContentPane();   //RETURN THE CONTENT PANE
        c.setLayout(null);
        JPanel panel = new JPanel();
        panel.setBounds(0,0,700,800);
        c.add(panel);

         ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("java images/form1.jpg"));
         Image i2 = icon.getImage().getScaledInstance(700, 800, Image.SCALE_DEFAULT);
         ImageIcon image = new ImageIcon(i2);
         JLabel label = new JLabel(image);
         panel.add(label);

        label1 = new JLabel("Name"); //label create
        label1.setBounds(20, 50, 150, 20);
        label1.setForeground(Color.white);
        Font fa = new Font("Arial", Font.PLAIN, 20);
        label1.setFont(fa);
        label.add(label1);

        t1 = new JTextField();  // label text box
        t1.setBounds(300, 50, 150, 20);
        label.add(t1);

        label2 = new JLabel("Father Name"); //label create
        label2.setBounds(20, 90, 150, 20);
        label2.setForeground(Color.white);
        Font fb = new Font("Arial", Font.PLAIN, 20);
        label2.setFont(fb);
        label.add(label2);

        t2 = new JTextField();  // label text box
        t2.setBounds(300, 90, 100, 20);
        label.add(t2);

        label3 = new JLabel("Date OF Birth");
        label3.setBounds(20, 130, 150, 20);
        label3.setForeground(Color.white);
        Font fc = new Font("Arial", Font.PLAIN, 20);
        label3.setFont(fc);
        label.add(label3);

        t3 = new JTextField();
        t3.setBounds(300, 130, 100, 20);
        label.add(t3);

        label4 = new JLabel("Email Address");
        label4.setBounds(20, 180, 200, 20);
        label4.setForeground(Color.white);
        Font fd = new Font("Arial", Font.PLAIN, 20);
        label4.setFont(fd);
        label.add(label4);

        t4 = new JTextField();  // label text box
        t4.setBounds(300, 180, 100, 20);
        label.add(t4);

        label5 = new JLabel("Gender");
        label5.setBounds(20, 220, 150, 20);
        label5.setForeground(Color.white);
        Font fe = new Font("Arial", Font.PLAIN, 20);
        label5.setFont(fe);
        label.add(label5);

        male = new JRadioButton("Male"); // create an unselected button
        female = new JRadioButton("Female");
        male.setBounds(300, 220, 80, 20);
        female.setBounds(400, 220, 80, 20);

        male.setSelected(true);
        label.add(male);
        label.add(female);

        ButtonGroup gen = new ButtonGroup();
        gen.add(male);
        gen.add(female);

        label7 = new JLabel("country");
        label7.setBounds(20, 270, 150, 20);
        label7.setForeground(Color.white);
        Font g = new Font("Arial", Font.PLAIN, 20);
        label7.setFont(g);
        label.add(label7);

        String Countries[] = {"pakistan", "china", "India", "England", "Afghanistan"};
        Country = new JComboBox(Countries);
        Country.setBounds(300, 270, 150, 20);
        label.add(Country);

        label8 = new JLabel("Address");
        label8.setBounds(20, 310, 150, 20);
        label8.setForeground(Color.white);
        Font h = new Font("Arial", Font.PLAIN, 20);
        label8.setFont(h);
        label.add(label8);
        ta1 = new JTextArea();
        ta1.setBounds(300, 310, 200, 20);
        label.add(ta1);

        l10 = new JLabel("ACCOUNT DETAILS");
        l10.setBounds(300, 370, 230, 30);
        l10.setForeground(Color.white);
        Font f = new Font("Arial", Font.PLAIN, 20);
        l10.setFont(f);
        label.add(l10);

        l11 = new JLabel("Account Type"); //label create
        l11.setBounds(20, 400, 200, 20);
        l11.setForeground(Color.white);
        Font a = new Font("Arial", Font.PLAIN, 20);
        l11.setFont(a);
        label.add(l11);
        saving = new JRadioButton("Saving");
        Fixed_Deposit_Account = new JRadioButton("Fixed Deposit Account");
        Current_Account = new JRadioButton("Curernt Account");
        Reccurring_Deposit_Account = new JRadioButton("Reccurring Deposit Accoutn");

        saving.setBounds(50, 440, 150, 20);
        Fixed_Deposit_Account.setBounds(230, 440, 200, 20);
        Current_Account.setBounds(50, 480, 150, 20);
        Reccurring_Deposit_Account.setBounds(230, 480, 200, 20);
        saving.setSelected(true);

        label.add(saving);
        label.add(Fixed_Deposit_Account);
        label.add(Current_Account);
        label.add(Reccurring_Deposit_Account);

        l12 = new JLabel("Card No ");
        l13 = new JLabel("PIN No");
        l12.setBounds(20, 520, 200, 20);
        l12.setForeground(Color.white);
        l13.setBounds(20, 560, 200, 20);
        l13.setForeground(Color.white);
        Font b = new Font("Arial", Font.PLAIN, 20);
        l12.setFont(b);
        Font d = new Font("Arial", Font.PLAIN, 20);
        l13.setFont(d);
        label.add(l12);
        label.add(l13);
        l14= new JLabel("xxxx,xxxx,xxxx,4123");
        l14.setBounds(300, 520, 250, 30);
        l14.setForeground(Color.white);
        Font m = new Font("Arial", Font.PLAIN, 20);
        l14.setFont(m);
        label.add(l14);

        l15= new JLabel("xxxx");
        l15.setBounds(300, 560, 200, 30);
        l15.setForeground(Color.white);
         Font n = new Font("Arial", Font.PLAIN, 20);
         l15.setFont(n);
        label.add(l15);

        jButton1 = new JButton("Finish");
        jButton1.setBounds(250, 620, 100, 40);
        Font o = new Font("Arial", Font.PLAIN, 20);
         jButton1.setFont(o);
        jButton1.addActionListener(this);
        label.add(jButton1);

        Cancel = new JButton("Clear");
        Cancel.setBounds(450, 620, 100, 40);
        Font p = new Font("Arial", Font.PLAIN, 20);
         Cancel.setFont(p);
        Cancel.addActionListener(this);
        label.add(Cancel);

        setVisible(true);
    }


    public void actionPerformed(ActionEvent e) {
       if (e.getSource() == jButton1) {

            String Name = t1.getText();
            String FatherName = t2.getText();
            String dateofbirth = t3.getText();
            String Gender=null;
            if (male.isSelected()) {
                gender = "Male";
            } else if (female.isSelected()) {
                gender = "Female";
            }
            String email = t4.getText();
            String address = ta1.getText();
            String Account_Type =null;
            if (saving.isSelected()) {
                Account_Type = "saving";
            } else if (Fixed_Deposit_Account.isSelected()) {
                Account_Type = "Fixed Deposit Account";
            } else if (Current_Account.isSelected()) {
                Account_Type = "Current Account";
            } else if (Reccurring_Deposit_Account.isSelected()) {
                Account_Type = "Reccurring Deposit Account";
            }
            Random random = new Random();
            String CardNo = "" + Math.abs((random.nextLong() % 90000000L) + 5044389000000000L);
            String PinNo = "" + Math.abs((random.nextLong() % 9000L) + 1000L);
            try {
                if (Name.equals("")) {
                    JOptionPane.showMessageDialog(null, "Name is Required");
                } else {
                    Conn c = new Conn();
                    String query1 = "insert into s1 values('" + Name + "','" + FatherName + "','" + dateofbirth + "','" + Gender + "','" + email + "','" + address + "','" + Account_Type + "', ' " + CardNo + " ',' " + PinNo + "' )";
                    c.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(this, "Card Number:" + CardNo + "\n PIN No" + PinNo);
                    String query2= "insert into login values('"+ CardNo+"','" +PinNo+"')";
                    c.s.executeUpdate(query2);

                }
            } catch (Exception t) {
                System.out.println(t);
            }
            }else if (e.getSource() == Cancel) {
               setVisible(false);
              // new login().setVisible(true);
          new TransactionDemo("").setVisible(true);

             }
        }




    public static void main(String[] args) {

       // Thread t1=new Thread(new Signup());
//t1.run();
        new s1();
    }
}
