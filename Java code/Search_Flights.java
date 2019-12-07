
package airline.management.system;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;




public class Search_Flights extends JFrame{  //Forth

    JTable table;
    JLabel f_code,j_date,d_time,a_time,Source,Destination,label,label1,search_flights,d_airport,a_airport,v_id;
    JButton Show;

    public static void main(String[] args){
        new Search_Flights();
    }
   
    public Search_Flights(){
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Search Flights");
    getContentPane().setBackground(new Color(204, 255, 255));
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   
    setLayout(null);
       
    Source = new JLabel("SOURCE");
    Source.setFont(new Font("Tahoma", Font.BOLD, 17));
    Source.setBounds(70, 200, 150, 27);
    add(Source);
   
        Destination = new JLabel("DESTINATION");
    Destination.setFont(new Font("Tahoma", Font.BOLD, 17));
    Destination.setBounds(370, 200, 150, 27);
    add(Destination);
       
      ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/search.png"));
            JLabel image = new JLabel(i2);
            image.setBounds(600,0,200,200);
            add(image);
       
       
    Show = new JButton("SHOW");
    Show.setBounds(680, 200, 100, 30);
    Show.setFont(new Font("Tahoma", Font.BOLD, 14));
    Show.setBackground(Color.BLACK);
    Show.setForeground(Color.WHITE);
    add(Show);

    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
       
    search_flights = new JLabel("Search Flights");
    search_flights.setForeground(Color.BLACK);
    search_flights.setFont(new Font("Tahoma", Font.BOLD, 41));
    search_flights.setBounds(220, 70, 359, 70);
    add(search_flights);
       
    f_code = new JLabel("Flight Code");
    f_code.setFont(new Font("Tahoma", Font.BOLD, 13));
    f_code.setBounds(45, 305, 83, 20);
    add(f_code);
       
     v_id = new JLabel("Voyage Id");
    v_id.setFont(new Font("Tahoma", Font.BOLD, 13));
    v_id.setBounds(150, 305, 83, 20);
    add(v_id);
    
    
    j_date = new JLabel("Date");
   j_date.setFont(new Font("Tahoma", Font.BOLD, 13));
   j_date.setBounds(270, 305, 83, 20);
   add(j_date);
       
   d_time = new JLabel("Departure Time");
   d_time.setFont(new Font("Tahoma", Font.BOLD, 13));
   d_time.setBounds(370, 305, 150, 20);
   add(d_time);
       
    a_time = new JLabel("Arrival Time");
    a_time.setFont(new Font("Tahoma", Font.BOLD, 13));
    a_time.setBounds(490, 305, 94, 20);
    add(a_time);
       
    d_airport = new JLabel("From");
    d_airport.setFont(new Font("Tahoma", Font.BOLD, 13));
    d_airport.setBounds(600, 305, 83, 20);
    add(d_airport);
       
    d_airport = new JLabel("To");
   d_airport.setFont(new Font("Tahoma", Font.BOLD, 13));
    d_airport.setBounds(710, 305, 94, 20);
    add(d_airport);

    String[] items1 = {"JAIPUR", "MUMBAI", "COCHIN", "DELHI","CALICUT","HYDERABAD","BANGALORE"};
    JComboBox comboBox = new JComboBox(items1);
    comboBox.setBounds(150, 200, 150, 27);
    add(comboBox);
       
       
    String[] items2 =  {"JAIPUR", "MUMBAI", "COCHIN", "DELHI","CALICUT","HYDERABAD","BANGALORE"};
    JComboBox comboBox_1 = new JComboBox(items2);
    comboBox_1.setBounds(500, 200, 150, 27);
    add(comboBox_1);
       
        table = new JTable();
    table.setBounds(38, 330, 770, 130);
    add(table);
   
       
       
    Show.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                int a=0;
        try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                   
                    conn c = new conn();
                   
                        String str = "select aeroplane,voyage_id,journey_date,departure_time,arrival_time,departure_airport,arrival_airport from voyage where departure_airport = '"+src+"' and arrival_airport = '"+dst+"'";
                       
                    ResultSet rs=c.s.executeQuery(str);
               
                    if(src==dst)
              {
                       JOptionPane.showMessageDialog(null,"You are already there!!");
                       a++;
                       
               }
                 
                       table.setModel(DbUtils.resultSetToTableModel(rs));
                       table.setBackground(new Color(255, 255, 153));
                       table.setShowGrid(true);
                       table.setBorder(BorderFactory.createLineBorder(Color.black));
                  

//               if(!rs.next())
//              {
//                       JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
//                       
//               }        
                   
                  c.close(); 
        }catch(Exception e){}
         try{
                    String src  = (String) comboBox.getSelectedItem();
                    String dst  = (String) comboBox_1.getSelectedItem();
                   
                    conn c = new conn();
                   
                        String str = "select aeroplane,journey_date,departure_time,arrival_time,departure_airport,arrival_airport from voyage where departure_airport = '"+src+"' and arrival_airport = '"+dst+"'";
                       
                    ResultSet rs=c.s.executeQuery(str);
                  
                 
                     //  table.setModel(DbUtils.resultSetToTableModel(rs));
                     //table.setBackground(Color.YELLOW);
//                  

               if(!rs.next() && a==0)
              {
                       JOptionPane.showMessageDialog(null,"No Flights between Source and Destination");
                       
               }        
                   
                  c.close(); 
        }catch(Exception e){}
        
        
            }
    });
       
    setSize(860,600);
        setLocation(250,100);
    setVisible(true);
       
    }
}


