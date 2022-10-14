import Conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener {
    JPanel p1;
    JLabel l1, l2, l3;
    JPasswordField pin, t;
    JButton change, back;
String PinNo;
    PinChange(String PinNo) {
        this.PinNo=PinNo;
        setSize(850, 600);
        setLocation(300, 0);
        p1 = new JPanel();
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("java images/img2.jpg"));
        Image i2 = icon.getImage().getScaledInstance(850, 600, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel label = new JLabel(image);
        p1.add(label);
        add(p1);

        l1 = new JLabel("Change Your Pin");
        l1.setFont(new Font("System", Font.PLAIN, 30));
        l1.setForeground(Color.white);
        l1.setBounds(440, 50, 250, 80);
        label.add(l1);

        l2 = new JLabel("New Pin");
        l2.setFont(new Font("System", Font.PLAIN, 16));
        l2.setFont(new Font("System", Font.PLAIN, 20));
        l2.setForeground(Color.white);
        l2.setBounds(440, 170, 180, 20);
        label.add(l2);
         pin = new JPasswordField();
        pin.setBounds(620, 170, 130, 30);
        label.add(pin);

        l3= new JLabel("Re_Enter New Pin");
        l3.setFont(new Font("System", Font.PLAIN, 20));
        l3.setForeground(Color.white);
        l3.setBounds(440, 260, 180, 20);
        label.add(l3);

        t = new JPasswordField();
        t.setBounds(620, 260, 130, 30);
        label.add(t);

        change = new JButton("Change");
        change.setFont(new Font("System", Font.PLAIN, 20));
        change.setBounds(440, 430, 120, 30);
        change.addActionListener(this);
        label.add(change);

        back = new JButton("back");
        back.setFont(new Font("System", Font.PLAIN, 20));
        back.setBounds(600, 430, 120, 30);
        back.addActionListener(this);
        label.add(back);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == change) {
            try {
                String l2 = pin.getText();
                String l3 = t.getText();
                if (!l2.equals(l3)) {
                    JOptionPane.showMessageDialog(null, "Entered pin does not match");
                    return;
                }
                if(l2.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Enter new Pin");
                   return;
                }
                if(l3.equals("")){
                    JOptionPane.showMessageDialog(null, "Please Re_Enter new Pin");
                    return;
                }
                Conn c=new Conn();
                String query1="update bank set PinNo = '"+l3+"' where PinNo='"+PinNo+"'";
                String query2="update login set PinNo = '"+l3+"' where PinNo='"+PinNo+"'";
                String query3="update s1 set PinNo = '"+l3+"' where PinNo='"+PinNo+"'";
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                c.s.executeUpdate(query3);
                JOptionPane.showMessageDialog(null,"PIN change successfully");
                setVisible(false);
                new Transaction(PinNo).setVisible(true);
               } catch (Exception a) {
                System.out.println(a);
            }
        } else {
            setVisible(false);
           // String PinNo = null;
            new TransactionDemo(PinNo).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("");
    }
}


