

import Conn.Conn;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.sql.ResultSet;


class Main extends JFrame implements ActionListener, Runnable {
    JLabel label, label1, label2;

    JPanel p1 = new JPanel();
    JTextField t1;
    JPasswordField t2;
    JButton login, clear, sign_up;
    private ImageIcon img1Icon;
    private double balance = 50000.0;
    int previousTransaction;
    String CustomerName;
    private int amount;
    @Override
    public void run() {

        JLabel background;
        setTitle("ATM");
        setBounds(400, 100, 800, 500);
        setLayout(null);
        Container c = getContentPane();   //RETURN THE CONTENT PANE
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        p1 = new JPanel();
        p1.setBounds(385, 0, 400, 500);
        c.add(p1);

        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource("java images/img3.jpg"));
        Image i2 = icon.getImage().getScaledInstance(400, 500, Image.SCALE_DEFAULT);
        ImageIcon image = new ImageIcon(i2);
        JLabel label = new JLabel(image);
        p1.add(label);
        JPanel p = new JPanel();
        p.setBounds(20, 0, 400, 500);
        p.setBackground(Color.cyan);
        c.setBackground(Color.cyan);
        label1 = new JLabel("Card No"); //label create
        label1.setBounds(20, 50, 200, 50);
        Font fn = new Font("Arial", Font.PLAIN, 20);
        label1.setFont(fn);
        c.add(label1);

        t1 = new JTextField();  // label text box
        t1.setBounds(170, 65, 150, 20);
        c.add(t1);

        label2 = new JLabel("PIN Number"); //label create
        label2.setBounds(20, 150, 200, 20);
        Font f = new Font("Arial", Font.PLAIN, 20);
        label2.setFont(f);
        c.add(label2);

        t2 = new JPasswordField();  // label text box
        t2.setBounds(170, 150, 150, 20);
        c.add(t2);
        login = new JButton("SIGN IN");
        login.setBounds(60, 250, 80, 20);
        login.addActionListener(this);
        c.add(login);

        clear = new JButton("CLEAR");
        clear.setBounds(170, 250, 80, 20);
        clear.addActionListener(this);
        c.add(clear);

        sign_up = new JButton("SIGN UP");
        sign_up.setBounds(130, 320, 80, 20);
        sign_up.addActionListener(this);
        c.add(sign_up);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clear) {
            t1.setText("");
            t2.setText("");
            try{
                Thread.sleep(1000);       //sleep method
            }catch(Exception a){
                System.out.println(a);
            }

        } else if (e.getSource() == login) {
                    Conn c=new Conn();
                    String CardNo=t1.getText();
                    String PinNo=t2.getText();
                    String query="Select *from login where CardNo ='"+CardNo+"' and PinNo= '" +PinNo+"'";
                    try{
                      // ResultSet rs= c.s.executeQuery("select*from s1");
                        ResultSet rs= c.s.executeQuery(query);
                       if(rs.next()){
                           setVisible(false);
                           new Transaction(PinNo).setVisible(true);

                       }else{
                           JOptionPane.showMessageDialog(this,"Incorrect CardNo or PinNo");
                       }

                    }catch(Exception t){
                        System.out.println(t);
                    }

                } else if (e.getSource() == sign_up) {
              try{
                  Thread.sleep(2000);
              }catch(Exception e1){
                System.out.println(e1);
            }
                  setVisible(false);
                  new s1().setVisible(true);

                }
        }
    }

class login {
    public static void main(String[] args) {
        Thread t1=new Thread(new Main());
t1.start();
        //Main obj = new Main();


    }
}

