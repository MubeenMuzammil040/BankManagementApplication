import Conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {
    JFrame frame;
    JPanel p1;
    JLabel l1;
    JTextField amount;
    JButton Withdraw, back;
   // int balance;

    String PinNo;
    public Withdraw(String PinNo) {
        this.PinNo=PinNo;
        setSize(950, 550);
        setLocation(250, 80);

        p1 = new JPanel();
        p1.setBounds(0, 0, 950, 550);
        add(p1);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("java images/img2.jpg"));
        Image i2 = icon.getImage().getScaledInstance(950, 550, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel label = new JLabel(image);
        p1.add(label);

        l1 = new JLabel("Enter the amount you want to Withdraw");
        l1.setBounds(400, 20, 600, 80);
        l1.setForeground(Color.white);
        Font fn = new Font("Arial", Font.PLAIN, 30);
        l1.setFont(fn);
        label.add(l1);

        amount = new JTextField();
        amount.setBounds(440, 130, 300, 30);
        label.add(amount);

        Withdraw= new JButton("Withdraw");
        Withdraw.setBounds(440, 300, 150, 30);
        Font f = new Font("Arial", Font.PLAIN, 20);
        Withdraw.setFont(f);
        Withdraw.addActionListener(this);
        label.add(Withdraw);

        back = new JButton("Back");
        back.setBounds(680, 300, 150, 30);
        Font fa = new Font("Arial", Font.PLAIN, 20);
        back.setFont(fa);
        back.addActionListener(this);
        label.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Withdraw) {
            String number=amount.getText();
           // String balance= String.valueOf(new Deposit(PinNo));
            Date date=new Date();
            if(number.equals("")) {
                JOptionPane.showMessageDialog(null, "please enter the amount you want to deposit");


          // String balance = null;
           /* if(!number.equals(balance)){
               JOptionPane.showMessageDialog(null,"Insufficient balance");*/

            }else {
                try{
                Conn c=new Conn();
                String query="insert into bank values('"+PinNo+"','"+date+"','Withdraw','"+number+"')";

                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs" +number+"Withdraw successfully");
                    setVisible(false);
                    new TransactionDemo(PinNo).setVisible(true);
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        } else if (e.getSource() == back) {
            setVisible(false);
            new TransactionDemo(PinNo).setVisible(true);

        }
    }


    public static void main(String[] args) {
        new Withdraw("");
    }
}
