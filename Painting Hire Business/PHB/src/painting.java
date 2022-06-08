

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;

public class painting implements ActionListener {
    JFrame frame;
 
    JLabel idLabel=new JLabel("painting_id");
    JLabel typeLabel=new JLabel("Painting_name");
    JLabel themeLabel=new JLabel("Theme");
    JLabel costLabel=new JLabel("Cost");
    
    JTextField idTextField=new JTextField();
    JTextField typeTextField=new JTextField();
    JTextField themeTextField=new JTextField();
    JTextField costTextField=new JTextField();
    
    JButton AddButton=new JButton("Add");
    JButton resetButton=new JButton("RESET");
    JButton backButton=new JButton("Back");
    

    painting()
    {
    	
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
 

	public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Painting details");
        frame.setBounds(40,40,450,600);
        frame.getContentPane().setBackground(Color.orange);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        frame.setResizable(false);
    }
    public void setLocationAndSize()
    {
    
        idLabel.setBounds(20,20,70,70);
        typeLabel.setBounds(20,200,140,70);
        costLabel.setBounds(20,70,80,70);     
        themeLabel.setBounds(20,270,100,70);
       
        idTextField.setBounds(180,43,165,23);
        typeTextField.setBounds(180,223,165,23);
        costTextField.setBounds(180,93,165,23);      
        themeTextField.setBounds(180,293,165,23);
        
        AddButton.setBounds(30,400,100,35);
        resetButton.setBounds(160,400,100,35);
     
        backButton.setBounds(290,400,100,35);

    	
    }
    public void addComponentsToFrame()
    {
        frame.add(idLabel);
        frame.add(typeLabel);
        frame.add(costLabel);
        frame.add(themeLabel);
       
        frame.add(idTextField);     
        frame.add(typeTextField);
        frame.add(costTextField);
        frame.add(themeTextField);
       
        frame.add(AddButton);
        frame.add(resetButton);
        frame.add(backButton);
    }
    public void actionEvent()
    {
        AddButton.addActionListener(this);
        resetButton.addActionListener(this);
        backButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==AddButton)
        {
            try {
                //Creating Connection Object
                Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
                //PreapareStatement
                PreparedStatement Pstatement=connection.prepareStatement("insert into painting values(?,?,?,?,?)");
                //Specifying the values of it's parameter
                Pstatement.setString(1,idTextField.getText());
                
                Pstatement.setString(2,typeTextField.getText());
                Pstatement.setString(3,costTextField.getText());
                Pstatement.setString(4,themeTextField.getText());
               
                Pstatement.executeUpdate();


            } catch (SQLException e1) {
                e1.printStackTrace();
            }   }
        if(e.getSource()==backButton)
        {
        	register.main(new String[]{});
        }
        if(e.getSource()==resetButton)
        {
            idTextField.setText("");
            typeTextField.setText("");
            costTextField.setText("");
            themeTextField.setText("");
          
        }
    }
public static void main(String[] args)
    {	 
        new painting();
       
    }
	}
