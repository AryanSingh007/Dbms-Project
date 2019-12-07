package airline.management.system;

import net.proteanit.sql.DbUtils;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

public class Flight_Info extends JFrame{  //Second Frame

    private JTable table;
    private JTextField textField;
   
    public static void main(String[] args){       
    new Flight_Info().setVisible(true);   
    }
   
    public Flight_Info(){
       setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(204,255,255));
        getContentPane().setFont(new Font("Tahoma", Font.PLAIN, 13));
       
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(860,523);
    setLayout(null);
    setVisible(true);
       
    JLabel Fcode = new JLabel("Enter Flight Code");
    Fcode.setFont(new Font("Tahoma", Font.BOLD, 17));
        Fcode.setBounds(20, 200, 200, 30);
    add(Fcode);
   
       
    JLabel FlightDetails = new JLabel("Help Desk");
    FlightDetails.setFont(new Font("Tahoma", Font.BOLD, 41));
    FlightDetails.setForeground(Color.BLACK);
    FlightDetails.setBounds(290, 20, 470, 45);
    add(FlightDetails);
       
    JButton btnShow = new JButton("VIEW");
    btnShow.setFont(new Font("Tahoma", Font.BOLD, 17));

           btnShow.setBackground(Color.BLACK);
           btnShow.setForeground(Color.WHITE);
    
   
        btnShow.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
   
                String code = textField.getText();
               
                try {
                    conn c = new conn();
                    String str = " select  voyage_id, company_name,distance,journey_date,departure_airport,arrival_airport, departure_time,arrival_time from voyage, aeroplane,airline_company where voyage.aeroplane=aeroplane.aeroplane_no and aeroplane.company_id = airline_company.company_id and voyage.aeroplane = '"+code+"'";
     
                    ResultSet rs = c.s.executeQuery(str);
                    table.setModel(DbUtils.resultSetToTableModel(rs));
                    table.setBackground(new Color(255, 255, 153));
                       table.setShowGrid(true);
                       table.setBorder(BorderFactory.createLineBorder(Color.black));
                   
                }catch(SQLException e){
                    e.printStackTrace();
                }
            }
        });

   
       
        table = new JTable();
        table.setBackground(new Color(255,255,153));
    table.setBounds(23, 250, 800, 300);
       
        JScrollPane pane = new JScrollPane(table);
    pane.setBounds(17, 400, 850, 200);
        pane.setBackground(new Color(255,255,153));
        pane.setBorder(BorderFactory.createLineBorder(Color.black));
        add(pane);
       
    textField = new JTextField();
        textField.setBounds(180, 200, 200, 30);
    add(textField);
    
         btnShow.setBounds(220, 250, 120, 30);
    add(btnShow);
    
       
   ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/help.png"));
            JLabel image = new JLabel(i2);
            image.setBounds(500,80,300,300);
            add(image);
       
   
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    setSize(900,650);
        setVisible(true);
       setLocation(250,100);
       
    }
}