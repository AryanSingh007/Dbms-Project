package airline.management.system;

import java.awt.EventQueue;


import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Book_Tickets extends JFrame{ //Third Frame


    JTextField textField,textField_1,textField_2,textField_3,textField_4,textField_5,textField_6,textField_7,tf8;

        public Book_Tickets(){
            getContentPane().setForeground(Color.BLUE);
            getContentPane().setBackground(new Color(204,255,255));
            setTitle("Ticket Booking");
       
            setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
            setSize(778,486);
            getContentPane().setLayout(null);
           
            JLabel Adhaarno = new JLabel("Adhaar Number");
            Adhaarno.setFont(new Font("Tahoma", Font.BOLD, 17));
            Adhaarno.setBounds(60, 120, 150, 27);
            add(Adhaarno);
           
            textField = new JTextField();
            textField.setBounds(200,120, 150, 27);
            add(textField);
           
            JButton Next = new JButton("BOOK NOW!");
            Next.setBounds(200, 470, 150, 30);
            Next.setFont(new Font("Tahoma", Font.BOLD, 14));
            Next.setBackground(Color.BLACK);
            Next.setForeground(Color.WHITE);
            add(Next);
           
            JLabel fname = new JLabel("First Name");
            fname.setFont(new Font("Tahoma", Font.BOLD, 17));
            fname.setBounds(60, 170, 150, 27);
            add(fname);
            
              JLabel email = new JLabel("Email Id");
             email.setFont(new Font("Tahoma", Font.BOLD, 17));
             email.setBounds(60, 415, 150, 27);
            add(email);
            
            tf8 = new JTextField();
            tf8.setBounds(180,415, 190, 27);
            add(tf8);
           
           
            textField_1 = new JTextField();
            textField_1.setBounds(200, 170, 150, 27);
            add(textField_1);
           
            JLabel lname = new JLabel("Last Name");
            lname.setFont(new Font("Tahoma", Font.BOLD, 17));
            lname.setBounds(60, 220, 150, 27);
            add(lname);
           
            textField_2 = new JTextField();
            textField_2.setBounds(200, 220, 150, 27);
            add(textField_2);
                   
            JLabel Nationality = new JLabel("Nationality");
            Nationality.setFont(new Font("Tahoma", Font.BOLD, 17));
            Nationality.setBounds(60, 270, 150, 27);
            add(Nationality);
           
            textField_3 = new JTextField();
            textField_3.setBounds(200, 270, 150, 27);
            add(textField_3);
   
            JLabel Phone = new JLabel("Phone No");
            Phone.setFont(new Font("Tahoma", Font.BOLD, 17));
            Phone.setBounds(60, 320, 150, 27);
            add(Phone);
   
            textField_4 = new JTextField();
            textField_4.setBounds(200, 320, 150, 27);
            add(textField_4);
   
            JLabel Gender = new JLabel("Gender");
            Gender.setFont(new Font("Tahoma", Font.BOLD, 17));
            Gender.setBounds(60, 370, 150, 27);
            add(Gender);
       
            JRadioButton Male = new JRadioButton("Male");
            Male.setBackground(new Color(204,255,255));
            Male.setBounds(200, 370, 70, 27);
            add(Male);
   
            JRadioButton Female = new JRadioButton("Female");
            Female.setBackground(new Color(204,255,255));
            Female.setBounds(280, 370, 70, 27);
            add(Female);
            
            ButtonGroup bg = new ButtonGroup();
            bg.add(Female);
            bg.add(Male);
            
            JRadioButton Economy = new JRadioButton("Economy");
            Economy.setBackground(new Color(204,255,255));
            Economy.setBounds(200, 75, 80, 40);
            add(Economy);
   
            JRadioButton Business = new JRadioButton("Business");
            Business.setBackground(new Color(204,255,255));
            Business.setBounds(280, 75, 80, 40);
            add(Business);
            ButtonGroup bg1 = new ButtonGroup();
            bg1.add(Business);
            bg1.add(Economy);
            
            
           JLabel classs = new JLabel("Class");
            classs.setFont(new Font("Tahoma", Font.BOLD, 17));
            classs.setBounds(60, 80, 150, 27);
            add(classs);
            
            setVisible(true);
   
            JLabel AddPassengers = new JLabel("Online Ticket Booking");
            AddPassengers.setForeground(Color.BLACK);
            AddPassengers.setFont(new Font("Tahoma", Font.BOLD, 31));
            AddPassengers.setBounds(490, 65, 442, 35);
            add(AddPassengers);
           
   
            JLabel voyageId = new JLabel("Voyage ID");
            voyageId.setFont(new Font("Tahoma", Font.BOLD, 17));
            voyageId.setBounds(60, 30, 150, 27);
            add(voyageId);

            textField_6 = new JTextField();
            textField_6.setBounds(200, 30, 150, 27);
            add(textField_6);
           
            
           
            ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/tickets.png"));
            JLabel image = new JLabel(i1);
            image.setBounds(450,80,400,400);
            add(image);

           
            Next.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    String ssn = textField.getText();
                    String  fname = textField_1.getText();
                    String lname =  textField_2.getText();
                    String nationality = textField_3.getText();
                    String phone = textField_4.getText();
                    String voyage_id = textField_6.getText();
                    String email_id = tf8.getText();
                    String gender = null;
                    String classs = null;
             
                     
                     if(Economy.isSelected()){
                        classs = "Economy";
                   
                    }else if(Business.isSelected()){
                        classs = "Business";
                    }
                   
                    if(Male.isSelected()){
                        gender = "male";
                   
                    }else if(Female.isSelected()){
                        gender = "female";
                    }
                  
                    try {
                        conn c = new conn();
                        String str = "select voyage.aeroplane,arrival_airport,departure_airport,journey_date,arrival_time,departure_time,seat_no from voyage,seat where seat.aeroplane=voyage.aeroplane and availability=true and seat_class = '"+classs+"' and voyage_id='"+voyage_id+"' limit 1";
                       
                        ResultSet rs = c.s.executeQuery(str);
                        while(rs.next())
                        {
                       String s1 = rs.getString("aeroplane");
                        String s2 = rs.getString("arrival_airport");
                         String s3 = rs.getString("departure_airport");
                          String s4 = rs.getString("journey_date"); 
                           String s5 = rs.getString("arrival_time");
                            String s6 = rs.getString("departure_time");
                         String sno = rs.getString("seat_no");
                            String trip_id = voyage_id.concat(ssn);
                          //  System.out.println(trip_id);
                           // System.out.println(s4);
                          // 
                            conn c1 = new conn();
                        String str1 = "INSERT INTO flight_trip values( '"+trip_id+"', '"+voyage_id+"', '"+s3+"','"+s2+"', '"+s4+"','"+s6+"', '"+s5+"','"+email_id+"')";
                       
                        c1.s.executeUpdate(str1);
                        
                        conn c2 = new conn();
                        String str2 = "INSERT ignore INTO passenger values('"+ssn+"', '"+phone+"', '"+fname+"','"+lname+"', '"+nationality+"','"+gender+"')";
                       
                        c2.s.executeUpdate(str2);
                               
                       //   System.out.println(sno);
                         //  System.out.println(s4);
                         conn c4 = new conn();
                        String str4 = "INSERT INTO ticket values( '"+trip_id+"', '"+ssn+"', '"+sno+"','"+s1+"')";
                        c4.s.executeUpdate(str4);
                        
                        conn c5 = new conn();
                        String str5 = "update seat set availability=false where seat_no='"+sno+"' and aeroplane='"+s1+"'";
                        c5.s.executeUpdate(str5);
                        
                        
                        
                        
                        JOptionPane.showMessageDialog(null,"Ticket Booked!!!");
                       // setVisible(false);
                        }
                    }
                           catch (Exception e) {
                        e.printStackTrace();
                }
                
              
                    
                    
                }
                    
                    
                    
                    
                    
                    
                    
                    
                    
                    
                   // JOptionPane.showMessageDialog(null,"Ticket Successfully Booked");
                    
                    
                    
                    
                    
        
            });
           
            setSize(900,600);
            setVisible(true);
            setLocation(250,100);
           
    }
       
    public static void main(String[] args){
        new Book_Tickets();
    }  
}