import Conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {
    JFrame frame;
    JPanel p1;
    JLabel l1;
    JTextField amount;
    JButton deposit, back;


     String PinNo;
    public Deposit(String PinNo) {
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

        l1 = new JLabel("Enter the amount you want to deposit");
        l1.setBounds(440, 20, 600, 80);
        l1.setForeground(Color.white);
        Font fn = new Font("Arial", Font.PLAIN, 30);
        l1.setFont(fn);
        label.add(l1);

        amount = new JTextField();
        amount.setBounds(440, 130, 300, 30);
        label.add(amount);

        deposit = new JButton("Deposit");
        deposit.setBounds(440, 300, 150, 30);
        Font f = new Font("Arial", Font.PLAIN, 20);
        deposit.setFont(f);
        deposit.addActionListener(this);
        label.add(deposit);

        back = new JButton("Back");
        back.setBounds(680, 300, 150, 30);
        Font fa = new Font("Arial", Font.PLAIN, 20);
        back.setFont(fa);
        back.addActionListener(this);
        label.add(back);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deposit) {
            String number=amount.getText();
            Date date=new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null,"please enter the amount you want to deposit");

            }else{
                Conn c=new Conn();
                String query="insert into bank values('"+PinNo+"','"+date+"','Deposit','"+number+"')";
                try {
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null,"Rs" +number+"Deposited successfully");
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
        new Deposit("");
    }
}
