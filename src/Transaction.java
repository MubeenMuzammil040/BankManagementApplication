import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

class TransactionDemo implements ActionListener {
JFrame frame;
JPanel p1;
JLabel l1;
JButton deposit,withdraw,fastCash,changePin,balance, exit;
String PinNo;
    TransactionDemo(String PinNo) {
        this.PinNo=PinNo;
         frame = new JFrame();
        frame.setBounds(350, 80, 650, 550);
        frame.setLayout(null);
        p1 = new JPanel();
        l1 = new JLabel("Select Your Transaction Please");
        l1.setBounds(100, 20, 500, 80);
        Font fn = new Font("Arial", Font.PLAIN, 30);
        l1.setFont(fn);
        frame.add(l1);
        p1 = new JPanel();
        p1.setBounds(0, 0, 650, 550);
        frame.add(p1);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("java images/img4.jpg"));
        Image i2 = icon.getImage().getScaledInstance(650, 550, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel label = new JLabel(image);
        p1.add(label);

         deposit = new JButton("Deposit");
         withdraw = new JButton("WITHDRAW");
        fastCash = new JButton("FAST CASH");
        changePin = new JButton("CHANGE PIN");
         balance = new JButton("BALANCE");
         exit = new JButton("EXIT");
         
        deposit.setBounds(40, 100, 200, 50);
        Font f = new Font("Arial", Font.PLAIN, 20);
        deposit.setFont(f);
        deposit.addActionListener(this);
        label.add(deposit);

        withdraw.setBounds(300, 100, 200, 50);
        Font a = new Font("Arial", Font.PLAIN, 20);
        withdraw.setFont(a);
        withdraw.addActionListener(this);
        label.add(withdraw);

        fastCash.setBounds(40, 200, 200, 50);
        Font b = new Font("Arial", Font.PLAIN, 20);
        fastCash.setFont(b);
        fastCash.addActionListener(this);
        label.add(fastCash);

        changePin.setBounds(300, 200, 200, 50);
        Font c = new Font("Arial", Font.PLAIN, 20);
        changePin.setFont(c);
        balance.addActionListener(this);
        label.add(changePin);

        balance.setBounds(40, 300, 200, 50);
        Font d = new Font("Arial", Font.PLAIN, 20);
        balance.setFont(f);
        balance.addActionListener(this);
        label.add(balance);

        exit.setBounds(300, 300, 200, 50);
        Font e = new Font("Arial", Font.PLAIN, 20);
        exit.setFont(e);
        exit.addActionListener(this);
        label.add(exit);

        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == exit) {
            System.exit(0);
            
        }else if(e.getSource()==deposit){
            setVisible(false);
            String PinNo = null;
            new Deposit("").setVisible(true);
        }

    }

    void setVisible(boolean b) {
    }

}
class Transaction {
    public Transaction() {
    }
    public static void main(String[] args) {
       TransactionDemo obj = new TransactionDemo("");
    }

    public void setVisible(boolean b) {
    }
}