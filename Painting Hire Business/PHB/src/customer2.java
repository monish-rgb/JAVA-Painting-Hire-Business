import javax.swing.*; 
import java.awt.*; 
import java.awt.event.*; 
  
 class frame1 extends JFrame{
	 private Container c;
	 private JLabel title;
	 public JLabel customer_id;
	 public JTextField cid;
	 public JLabel category;
	 private JButton sub; 
	 
	 public frame1() {
		 setTitle("Customer Details ::");
		 setResizable(false); 
		  
	        c = getContentPane(); 
	        c.setLayout(null);
	        title = new JLabel("Customer Details::");
	        title.setFont(new Font("Arial", Font.PLAIN, 30)); 
	        title.setSize(300, 30); 
	        title.setLocation(220, 30); 
	        c.add(title);
	        
	        customer_id = new JLabel("customer_id:"); 
	        customer_id.setFont(new Font("Arial", Font.PLAIN, 15)); 
	        customer_id.setSize(100, 20); 
	        customer_id.setLocation(100, 100); 
	        c.add(customer_id); 
	  
	        cid = new JTextField(); 
	        cid.setFont(new Font("Arial", Font.PLAIN, 15)); 
	        cid.setSize(190, 20); 
	        cid.setLocation(200, 100); 
	        c.add(cid);
	        
	        category = new JLabel("Category:"); 
	        category.setFont(new Font("Arial", Font.PLAIN, 15)); 
	        category.setSize(100, 20); 
	        category.setLocation(100, 150); 
	        c.add(category);
	        
	        sub = new JButton("Submit"); 
	        sub.setFont(new Font("Arial", Font.PLAIN, 15)); 
	        sub.setSize(100, 20); 
	        sub.setLocation(250, 200);  
	        c.add(sub);
	           
	 }
}
class customer2 { 
	  
    public static void main(String[] args)
    { 
        frame1 f = new frame1(); 
        f.getContentPane().setBackground(Color.cyan);
        f.setSize(600,300);
        String cat[]={"Gold","Silver","Bronze","None"};        
        JComboBox cb=new JComboBox(cat);    
        cb.setBounds(200,152,90,20);   
        f.add(cb);        
        f.setLayout(null);     
        f.setVisible(true);
    } 
} 