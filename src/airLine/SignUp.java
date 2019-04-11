package airLine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class SignUp extends JPanel {
	private JTextField nameTF;
	private JTextField emailTF;
	private JPasswordField passwordField;
private DatabaseManagementClass dbm;
	/**
	 * Create the panel.
	 * @param dbm 
	 * @param jf 
	 * @param mainJUI 
	 * @param jf2 
	 */
	public SignUp(final DatabaseManagementClass dbm, final Home mainJUI, final JFrame jf, final JFrame jf2) {
		setBackground(new Color(50, 205, 50));
		setLayout(null);
		this.dbm=dbm;
		jf.dispose();
		JLabel lblUserName = new JLabel("User Name :");
		lblUserName.setForeground(new Color(0, 0, 0));
		lblUserName.setBackground(new Color(50, 205, 50));
		lblUserName.setBounds(12, 263, 98, 16);
		add(lblUserName);
		
		JLabel lblEmail = new JLabel("Email :");
		lblEmail.setForeground(new Color(0, 0, 0));
		lblEmail.setBackground(new Color(50, 205, 50));
		lblEmail.setBounds(12, 314, 55, 16);
		add(lblEmail);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setForeground(new Color(0, 0, 0));
		lblPassword.setBackground(new Color(50, 205, 50));
		lblPassword.setBounds(12, 355, 76, 16);
		add(lblPassword);
		
		nameTF = new JTextField();
		nameTF.setForeground(new Color(0, 0, 0));
		nameTF.setBackground(new Color(50, 205, 50));
		nameTF.setBounds(122, 261, 183, 20);
		add(nameTF);
		nameTF.setColumns(10);
		
		emailTF = new JTextField();
		emailTF.setForeground(new Color(0, 0, 0));
		emailTF.setBackground(new Color(50, 205, 50));
		emailTF.setBounds(122, 312, 183, 20);
		add(emailTF);
		emailTF.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setForeground(new Color(0, 0, 0));
		passwordField.setBackground(new Color(50, 205, 50));
		passwordField.setBounds(122, 353, 185, 20);
		add(passwordField);
		
		JButton btnOk = new JButton("OK");
		btnOk.setFont(new Font("Dialog", Font.BOLD, 24));
		btnOk.setIcon(new ImageIcon(SignUp.class.getResource("/airLine/ok.png")));
		btnOk.setForeground(new Color(255, 255, 255));
		btnOk.setBackground(new Color(50, 205, 50));
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name,email,pasword;
				name=nameTF.getText();
				email=emailTF.getText();
				pasword=passwordField.getText();
				
				try {
					
					dbm.SignUp(name, email, pasword);	 
					JOptionPane.showMessageDialog(null, "Thankyou for Joining us");
					jf2.dispose();
					JFrame jf = new JFrame();
					jf.setSize(1080	, 520);
					LoginPanel de = new LoginPanel(mainJUI, jf, dbm);
					jf.getContentPane().add(de);
					jf.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Sign Up Failed Try Agian");
				}
			}
		});
		btnOk.setBounds(12, 398, 293, 36);
		add(btnOk);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(SignUp.class.getResource("/airLine/join.gif")));
		lblNewLabel.setBounds(5, 0, 619, 243);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(SignUp.class.getResource("/airLine/free.jpg")));
		lblNewLabel_1.setBounds(331, 263, 153, 147);
		add(lblNewLabel_1);

	}
}
