package airline.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class Cancel extends JFrame { //Sixth
   
    private JTextField textField,textField_1,textField_2,textField_3,textField_4;

    public static void main(String[] args) {
        new Cancel();
    }
   
    public Cancel() {
        initialize();
        this.setLocationRelativeTo(null);
    }
   
    private void initialize() {
        setTitle("Cancel Booking");
    getContentPane().setBackground(new Color(255,102,102));
    setBounds(100, 100, 801, 472);
    setLayout(null);
       
    JLabel Cancellation = new JLabel("Cancel Your Booking");
    Cancellation.setFont(new Font("Tahoma", Font.BOLD, 31));
    Cancellation.setBounds(185, 24, 400, 38);
    
    add(Cancellation);
       
   
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/money.png"));
        Image i2 = i1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel NewLabel = new JLabel(i3);
    NewLabel.setBounds(500, 100, 250, 250);
    add(NewLabel);
       
    JLabel aadhar = new JLabel("Aadhar Number");
    aadhar.setFont(new Font("Tahoma", Font.BOLD, 22));
    aadhar.setBounds(50, 100, 190, 26);
    add(aadhar);
       
    JLabel vid = new JLabel("Voyage Id");
    vid.setFont(new Font("Tahoma", Font.BOLD, 22));
    vid.setBounds(50, 150, 190, 27);
    add(vid);
  
    JButton Cancel = new JButton("CANCEL");
    Cancel.setFont(new Font("Tahoma", Font.BOLD, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
    Cancel.setBounds(250, 250, 150, 30);
    add(Cancel);
       
    textField = new JTextField();
    textField.setBounds(250, 100, 150, 27);
    add(textField);
   
        textField_1 = new JTextField();
    textField_1.setBounds(250, 150, 150, 27);
    add(textField_1);
       

        Cancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
       
                String ssn= textField.getText();
        String vg = textField_1.getText();
      
                   int a=0;
                   
        try{   
            
            
                    conn c = new conn();
                    String str = "select ticket.flight_trip_id, seat_no, ticket.aeroplane from ticket,flight_trip,voyage where ticket.flight_trip_id= flight_trip.flight_trip_id and flight_trip.voyage_id=voyage.voyage_id and voyage.voyage_id='"+vg+"' and ssn='"+ssn+"'";
                    
                    ResultSet rs = c.s.executeQuery(str);
                    //JOptionPane.showMessageDialog(null,"Ticket Canceled");
                    //setVisible(false);
                        while(rs.next())
                        {
                            a++;
                       String s1 = rs.getString("ticket.flight_trip_id");
                        String s2 = rs.getString("seat_no");
                         String s3 = rs.getString("ticket.aeroplane");
                         
                         conn c1 = new conn();
                        String str1 = "delete from ticket where  ticket.flight_trip_id= '"+s1+"' and seat_no ='"+s2+"' and ticket.aeroplane= '"+s3+"'";
                        c1.s.executeUpdate(str1);
                         
                         conn c2 = new conn();
                        String str2 = "delete from passenger where  ssn = '"+ssn+"' and not exists(select count(ssn) as c from ticket where ssn='"+ssn+"' having c>0)";
                        c2.s.executeUpdate(str2);
                         
                           conn c3 = new conn();
                        String str3 = "delete from flight_trip where  flight_trip_id= '"+s1+"'";
                        c3.s.executeUpdate(str3);
                        
                         conn c4 = new conn();
                        String str4 = "update seat set availability=true where seat_no='"+s2+"' and aeroplane='"+s3+"'";
                        c4.s.executeUpdate(str4);
                       
                          JOptionPane.showMessageDialog(null,"Ticket Cancelled, Fare Refunded");
                          if(a==0)
                          {
                              
                          JOptionPane.showMessageDialog(null,"Enter Valid Details");
                          textField.setText("");
                           textField_1.setText("");
                          
                          }
                         
                        } 
        }catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
           
    setSize(860,500);
    setVisible(true);
        setLocation(400,200);
    }
}