package Conn;
import java.sql.*;
public class Conn {
    Connection c;  //conn create
    public Statement s;
    public Conn(){

        try{
            c=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","1234");
            s=c.createStatement();
        }catch(Exception e){
            System.out.println(e);

        }
    }
}
