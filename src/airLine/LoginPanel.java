package airLine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JButton;

import java.awt.Font;

import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import java.awt.Color;

public class LoginPanel extends JPanel {
	private JTextField nTF;
	private JPasswordField pF;
	private final ButtonGroup buttonGroup = new ButtonGroup();
private DatabaseManagementClass dbm;
	/**
	 * Create the panel.
	 * @param dbm 
	 * @param jf 
	 * @param loginFrame 
	 */
	public LoginPanel(final  Home frame,  final JFrame parentFrame, final DatabaseManagementClass dbm) {
		setBackground(Color.GRAY);
		this.dbm=dbm;
        setLayout(null);
		JLabel label = new JLabel("UserName:");
		label.setForeground(Color.WHITE);
		label.setBounds(29, 269, 86, 23);
		add(label);
		
		nTF = new JTextField();
		nTF.setForeground(Color.WHITE);
		nTF.setBackground(Color.GRAY);
		nTF.setBounds(118, 264, 206, 32);
		nTF.setColumns(10);
		add(nTF);
		
		JLabel label_1 = new JLabel("Password:");
		label_1.setForeground(Color.WHITE);
		label_1.setBounds(29, 317, 62, 14);
		add(label_1);
		
		pF = new JPasswordField();
		pF.setForeground(Color.WHITE);
		pF.setBackground(Color.GRAY);
		pF.setBounds(118, 308, 206, 32);
		add(pF);
		
		JButton btnSignin = new JButton("Sign In");
		btnSignin.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 30));
		btnSignin.setForeground(Color.WHITE);
		btnSignin.setBackground(Color.GRAY);
		btnSignin.setIcon(null);
		btnSignin.setBounds(118, 350, 206, 38);
		btnSignin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String n=nTF.getText();
				String p1=pF.getText();
				String p=new String(p1);
				String name = null;
				String pass=null;
				
				try {
					 ResultSet rs=	dbm.getLogin();
					 while(rs.next()){
						 name=rs.getString("Username");
						 pass=rs.getString("Pasword");
						 if(n.equals(name)&&p.equals(pass)){
						 break;
						 }	
					  
					 }
					 
			} catch (SQLException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
				JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
				}
				if(n.equals("admin")&&p.equals("123")){
					parentFrame.dispose();
				
				frame.setVisible(true);
				}
				else if(n.equals(name)&&p.equals(pass))
				{    parentFrame.setVisible(false);
				     nTF.setText("");
				     pF.setText("");
				     
				   JFrame jf = new JFrame();
				    jf.setSize(451, 303);
					UserPannel de = new UserPannel(parentFrame,jf);
					jf.getContentPane().add(de);
					jf.setSize(802, 462);
					jf.setResizable(false);
					jf.setTitle("User Pannel");
					// de.setVisible(true);
					 jf.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "PLZ Verify Your SignIn");
				}
			}
		});
		add(btnSignin);
		
		JButton btnSignup = new JButton("SignUP");
		btnSignup.setForeground(Color.WHITE);
		btnSignup.setBackground(Color.GRAY);
		btnSignup.setFont(new Font("DialogInput", Font.BOLD | Font.ITALIC, 30));
		btnSignup.setBounds(118, 400, 206, 32);
		btnSignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf = new JFrame();
				jf.setSize(500, 470);
				jf.setResizable(false);
			    SignUp de = new SignUp(dbm,frame,parentFrame,jf);
				jf.getContentPane().add(de);
				jf.setVisible(true);
			}
		});
		add(btnSignup);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(LoginPanel.class.getResource("/airLine/Boeing 787-881 Dreamliner ANATokyo 2012 JA806A (1).jpg")));
		lblNewLabel.setBounds(346, 0, 780, 491);
		add(lblNewLabel);
		
		JLabel label_2 = new JLabel("");
		label_2.setIcon(new ImageIcon(LoginPanel.class.getResource("/airLine/Bulz.gif")));
		label_2.setBounds(0, 0, 343, 171);
		add(label_2);


	}
	public User Getref(){
		return null;
		
	}
}
