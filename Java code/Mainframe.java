package airline.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class Mainframe extends JFrame{

    public static void main(String[] args) {
        new Mainframe().setVisible(true);
    }
   
    public Mainframe() {
        
        super("Airline Management System");
      
        initialize();
         setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

   
    private void initialize() {
   
        setForeground(Color.CYAN);
        setLayout(null);

        JLabel NewLabel = new JLabel("");
    NewLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("airline/management/system/icon/airplane.jpg")));
      NewLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
    
    NewLabel.setBounds(0, 0, 1370, 720);
    add(NewLabel);
       
        JLabel AirlineManagementSystem = new JLabel("Fly the Friendly Skies");
    AirlineManagementSystem.setForeground(Color.BLACK);
        AirlineManagementSystem.setFont(new Font("Tahoma", Font.BOLD, 42));
    AirlineManagementSystem.setBounds(470, 60, 1000, 55);
    NewLabel.add(AirlineManagementSystem);
       
       
        JMenuBar menuBar = new JMenuBar();
        menuBar.setBackground(new Color(255,255,153));
        menuBar.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    setJMenuBar(menuBar);
       
        JMenu AirlineSystem = new JMenu("TRAVEL THE GLOBE");
        AirlineSystem.setForeground(Color.BLACK);
    menuBar.add(AirlineSystem);
       
        JMenuItem SearchFlights = new JMenuItem("Find Flights");
    AirlineSystem.add(SearchFlights);
       
    JMenuItem BookTickets = new JMenuItem("Book Ticket");
    AirlineSystem.add(BookTickets);
       
        JMenuItem Ticket = new JMenuItem("Find Ticket");
    AirlineSystem.add(Ticket);
       
    JMenuItem FlightDetails = new JMenuItem("Help Desk");
    AirlineSystem.add( FlightDetails);
    
    JMenuItem Cancellation = new JMenuItem("Cancel Ticket");
    AirlineSystem.add(Cancellation);

       
    FlightDetails.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Flight_Info();
            }
    });
       
    BookTickets.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Book_Tickets();
        } catch (Exception e) {
                    e.printStackTrace();
        }
            }
    });
       
        SearchFlights.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                try {
                    new Search_Flights();
                } catch (Exception e) {
                    e.printStackTrace();
        }
            }
    });
       
                Cancellation.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
                new Cancel();
            }
    });
       
        Ticket.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent ae){
               
                   new Ticket().setVisible(true);
             
            }
               
            
                
        });
  

        setSize(1950,1090);
  
    setVisible(true);
    
    }
}