import Conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {
    JPanel p1;
    JButton back;
    String PinNo;
    Balance(String PinNo) {
        this.PinNo = PinNo;
        setSize(800, 550);
        setLocation(300, 0);
        p1 = new JPanel();
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("java images/img2.jpg"));
        Image i2 = icon.getImage().getScaledInstance(800, 550, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel label = new JLabel(image);
        p1.add(label);
        add(p1);
        back = new JButton("Back");
        back.setBounds(600, 400, 150, 30);
        back.setFont(new Font("System", Font.PLAIN, 20));
        back.addActionListener(this);
        label.add(back);

        Conn c = new Conn();
        int balance = 0;
        try {
            //make a query to check wheater amount is avaiable or not in your acconnt
            ResultSet rs = c.s.executeQuery("select*from bank where PinNo = '" + PinNo + "'");
            while (rs.next()) {   //is looping the row
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));  //to get the amount of user
                }
            }
        }catch(Exception a){
                System.out.println(a);
            }

        JLabel text=new JLabel("your current Account Balance is Rs"+ balance);
        text.setForeground(Color.white);
        text.setBounds(400,200,400,30);
        text.setFont(new Font("System",Font.PLAIN,20));
        label.add(text);
            setVisible(true);

        }

    @Override
    public void actionPerformed(ActionEvent e) {
      setVisible(false);
       // String PinNo = null;
        new TransactionDemo(PinNo).setVisible(true);
    }

    public static void main(String[] args) {
        new Balance("");
    }


}
