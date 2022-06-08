
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class order implements ActionListener {
    JFrame frame;
   
    JLabel idLabel=new JLabel("Order_id");
    
 
    JLabel dateLabel=new JLabel("Return_date");
    JLabel date1Label=new JLabel("Hire_date");

   
    JTextField idTextField=new JTextField();
    
    
  
    JTextField dateTextField=new JPasswordField();
    JTextField date1TextField=new JPasswordField();
  
    JButton orderButton=new JButton("ORDER");
    JButton resetButton=new JButton("RESET");

    order()
    {
    	
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
 

	public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Order Form");
        frame.setBounds(40,40,450,600);
        frame.getContentPane().setBackground(Color.green);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
    
        idLabel.setBounds(20,20,70,70);
        
       
        dateLabel.setBounds(20,140,100,70);
        date1Label.setBounds(20,200,140,70);
       
        idTextField.setBounds(180,43,165,23);
        
      
      
        dateTextField.setBounds(180,163,165,23);
        date1TextField.setBounds(180,223,165,23);
        
        orderButton.setBounds(30,400,100,35);
        resetButton.setBounds(160,400,100,35);

    	
    }
    public void addComponentsToFrame()
    {
        frame.add(idLabel);
        
     
        frame.add(dateLabel);
        frame.add(date1Label);
       
        frame.add(idTextField);
        
      
        frame.add(dateTextField);
        frame.add(date1TextField);
       
        frame.add(orderButton);
        frame.add(resetButton);
    }
    public void actionEvent()
    {
        orderButton.addActionListener(this);
        resetButton.addActionListener(this);
    }


    
   public void actionPerformed(ActionEvent e) {
        if(e.getSource()==orderButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase","root","root");
                //Preapared Statement
                PreparedStatement Pstatement=connection.prepareStatement("insert into orderdetails values(?,?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,idTextField.getText());
               
                
                Pstatement.setString(3,dateTextField.getText());
                Pstatement.setString(4,date1TextField.getText());
               
                //Checking for the Password match
                

            } catch (SQLException e1) {
                e1.printStackTrace();
            }   }

        if(e.getSource()==resetButton)
        {
            idTextField.setText("");
          
            dateTextField.setText("");
            date1TextField.setText("");
           
        }
    }
public static void main(String[] args)
    {	 
        new order();
       
    }
}



