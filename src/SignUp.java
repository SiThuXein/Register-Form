import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
 
public class SignUp implements ActionListener {
    JFrame frame;
    JLabel title=new JLabel("Create Account");
    JLabel email=new JLabel("Email Address");
    JLabel firstName=new JLabel("First Name");
    JLabel lastName=new JLabel("Last Name");
    JLabel phoneNumber=new JLabel("Phone Number");
    JLabel password=new JLabel("Password");
    JTextField emailTextField=new JTextField();
    JTextField firstNameTextField=new JTextField();
    JTextField lastNameTextField=new JTextField();
    JTextField phoneNumberTextField=new JTextField();
    JPasswordField passwordField=new JPasswordField();

    JButton registerButton=new JButton("Create");
   
 
    SignUp()
    {
        createWindow();
        setLocationAndSize();
        addComponentsToFrame();
        actionEvent();
    }
    public void createWindow()
    {
        frame=new JFrame();
        frame.setTitle("Registration Form");
        frame.setBounds(40,40,380,600);
//        frame.getContentPane().setBackground(Color.gray);
        frame.getContentPane().setLayout(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        registerButton.setBackground(Color.green);
    }
    public void setLocationAndSize()
    {
    	 title.setBounds(20,20,140,20);
    	 email.setBounds(20,40,140,70);
         firstName.setBounds(20,100,80,70);
         lastName.setBounds(20,160,100,70);
         phoneNumber.setBounds(20,220,180,70);
         password.setBounds(20,280,180,70);
         emailTextField.setBounds(20,93,215,30);
         firstNameTextField.setBounds(20,153,215,30);
         lastNameTextField.setBounds(20,213,215,30);
         phoneNumberTextField.setBounds(20,273,215,30);
         passwordField.setBounds(20,333,215,30);
         registerButton.setBounds(20,390,100,35);
  
    
    }
    public void addComponentsToFrame()
    {
    	frame.add(title);
    	frame.add(email);
        frame.add(firstName);
        frame.add(lastName);
        frame.add(phoneNumber);
        frame.add(password);
        frame.add(emailTextField);
        frame.add(firstNameTextField);
        frame.add(lastNameTextField);
        frame.add(phoneNumberTextField);
        frame.add(passwordField);
      
        frame.add(registerButton);
       
    }
    public void actionEvent()
    {
        registerButton.addActionListener(this);
       
    }
 
 
    @Override
  public void actionPerformed(ActionEvent e) {
			try{
				String email = emailTextField.getText();
				String fname = firstNameTextField.getText();
				String lname = lastNameTextField.getText();
				String p = phoneNumberTextField.getText();
				int phone = Integer.parseInt(p);
				String password = passwordField.getText();
			  	
//				System.out.println(email);
//				System.out.println(fname);
//				System.out.println(lname);
//				System.out.println(phone);
//				System.out.println(password);
	    		if(e.getSource()==registerButton)
	    		{
			          Class.forName("com.mysql.cj.jdbc.Driver");
			          System.out.println("Connecting to Database");
		          	  Connection conn=DriverManager.getConnection("jdbc:mysql://localhost/register","root","");
		          	  System.out.println("Create Statement");
		          	  Statement stmt = conn.createStatement();
		          	  String sql;
		          	  sql = "insert into create_account(email,first_name,last_name,phone,password) values("
		          	  			+ "'"+email+"','"+fname+"','"+lname+"',"+phone+",'"+password+"')";
		          	  stmt.executeUpdate(sql);

		          	  JOptionPane.showMessageDialog(null,"Data Registered Successfully");
		 		  
	    			
	    			}
	 
	            } catch(Exception e1) {
	               e1.printStackTrace();
	            }	
    	
    }
      
    
    
    public static void main(String[] args) {
    	new SignUp();
    }
}
