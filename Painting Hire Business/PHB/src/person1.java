import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*;  
class MyFrame 
    extends JFrame 
    implements ActionListener { 
  
    // Components of the Form 
    private Container c; 
    private JLabel title; 
    private JLabel name; 
    private JTextField tname; 
    private JLabel mno; 
    private JTextField tmno; 
 
    private JLabel add; 
    private JTextArea tadd; 
    private JCheckBox term; 
    private JButton sub; 
    private JButton reset; 
    private JTextArea tout; 
    private JLabel res; 
    private JButton addc;
    private JTextArea resadd; 
  
    // constructor, to initialize the components 
    // with default values. 
   public MyFrame() 
    { 
        setTitle("register Form"); 
        setBounds(300, 90,900,650); 
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setResizable(false); 
  
        c = getContentPane(); 
        c.setLayout(null); 
  
        title = new JLabel("Registration Form"); 
        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
        title.setSize(300, 30); 
        title.setLocation(300, 30); 
        c.add(title); 
  
        name = new JLabel("Name"); 
        name.setFont(new Font("Arial", Font.PLAIN, 20)); 
        name.setSize(100, 20); 
        name.setLocation(100, 100); 
        c.add(name); 
  
        tname = new JTextField(); 
        tname.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tname.setSize(190, 20); 
        tname.setLocation(200, 100); 
        c.add(tname); 
  
        mno = new JLabel("Mobile"); 
        mno.setFont(new Font("Arial", Font.PLAIN, 20)); 
        mno.setSize(100, 20); 
        mno.setLocation(100, 150); 
        c.add(mno); 
  
        tmno = new JTextField(); 
        tmno.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tmno.setSize(150, 20); 
        tmno.setLocation(200, 150); 
        c.add(tmno); 
  
 
  
        add = new JLabel("Address"); 
        add.setFont(new Font("Arial", Font.PLAIN, 20)); 
        add.setSize(100, 20); 
        add.setLocation(100, 300); 
        c.add(add); 
  
        tadd = new JTextArea(); 
        tadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tadd.setSize(200, 75); 
        tadd.setLocation(200, 300); 
        tadd.setLineWrap(true); 
        c.add(tadd); 
  
        term = new JCheckBox("Accept Terms And Conditions."); 
        term.setFont(new Font("Arial", Font.PLAIN, 15)); 
        term.setSize(250, 20); 
        term.setLocation(150, 400); 
        c.add(term); 
  
        sub = new JButton("Submit"); 
        sub.setFont(new Font("Arial", Font.PLAIN, 15));
        sub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=tname.getText();
			String contact=tmno.getText();			
			String address=tadd.getText();
			
			int i=db.save(name,contact,address);
			if(i>0){
				JOptionPane.showMessageDialog(MyFrame.this,"person added successfully!");
				
			}else{
				JOptionPane.showMessageDialog(MyFrame.this,"Sorry, unable to save!");
			}
			}
		});
        sub.setSize(100, 20); 
        sub.setLocation(150, 450); 
        sub.addActionListener(this); 
        c.add(sub); 
  
        reset = new JButton("Reset"); 
        reset.setFont(new Font("Arial", Font.PLAIN, 15)); 
        reset.setSize(100, 20); 
        reset.setLocation(270, 450); 
        reset.addActionListener(this); 
        c.add(reset); 
        
  
        tout = new JTextArea(); 
        tout.setFont(new Font("Arial", Font.PLAIN, 15)); 
        tout.setSize(300, 400); 
        tout.setLocation(500, 100); 
        tout.setLineWrap(true); 
        tout.setEditable(false); 
        c.add(tout); 
        
        addc = new JButton("Add customer"); 
        addc.setFont(new Font("Arial", Font.PLAIN, 15)); 
        addc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			try {
				customer2.main(new String[]{});
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			}
		});
        addc.setSize(150, 30); 
        addc.setLocation(220, 530); 
        addc.addActionListener(this); 
        c.add(addc);
  
        res = new JLabel(""); 
        res.setFont(new Font("Arial", Font.PLAIN, 20)); 
        res.setSize(500, 25); 
        res.setLocation(100, 500); 
        c.add(res); 
  
        resadd = new JTextArea(); 
        resadd.setFont(new Font("Arial", Font.PLAIN, 15)); 
        resadd.setSize(200, 75); 
        resadd.setLocation(580, 175); 
        resadd.setLineWrap(true); 
        c.add(resadd); 
  
        setVisible(true); 
    } 
  
    // method actionPerformed() 
    // to get the action performed 
    // by the user and act accordingly 
    public void actionPerformed(ActionEvent e) 
    { 
        if (e.getSource() == sub) { 
            if (term.isSelected()) { 
                String data1 = null; 
                String data 
                    = "Name : "
                      + tname.getText() + "\n"
                      + "Mobile : "
                      + tmno.getText() + "\n"; 
                  
                String data3 = "Address : " + tadd.getText(); 
                tout.setText(data + data1 + data3); 
                tout.setEditable(false); 
                res.setText("Registration Successfull.."); 
            } 
            else { 
                tout.setText(""); 
                resadd.setText(""); 
                res.setText("Please accept the"
                            + " terms & conditions.."); 
            } 
        } 
  
        else if (e.getSource() == reset) { 
            String def = ""; 
            tname.setText(def); 
            tadd.setText(def); 
            tmno.setText(def); 
            res.setText(def); 
            tout.setText(def); 
            term.setSelected(false); 
            
            resadd.setText(def); 
        } 
    } 
} 
  
// Driver Code 
class person1 { 
  
    public static void main(String[] args) throws Exception 
    { 

       MyFrame f = new MyFrame(); 
      f.getContentPane().setBackground(Color.cyan);

        
    } 
} 