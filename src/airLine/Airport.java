package airLine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Airport extends JPanel {
	private JTextField nameTF;
	private JTextField cityTF;
	private JTextField countryTF;
 private DatabaseManagementClass dbm;
	
	public Airport(final DatabaseManagementClass dbm, final JFrame jf, final Home frame) {
		setForeground(Color.WHITE);
		setBackground(new Color(34, 139, 34));
		this.dbm=dbm;
		setLayout(null);
		frame.setVisible(false);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setForeground(Color.WHITE);
		lblName.setFont(new Font("Dialog", Font.BOLD, 15));
		lblName.setBounds(12, 32, 55, 16);
		add(lblName);
		
		JLabel lblCity = new JLabel("City :");
		lblCity.setForeground(Color.WHITE);
		lblCity.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCity.setBounds(12, 85, 55, 16);
		add(lblCity);
		
		JLabel lblCountry = new JLabel("Country :");
		lblCountry.setForeground(Color.WHITE);
		lblCountry.setFont(new Font("Dialog", Font.BOLD, 15));
		lblCountry.setBounds(12, 125, 82, 16);
		add(lblCountry);
		
		nameTF = new JTextField();
		nameTF.setForeground(Color.WHITE);
		nameTF.setFont(new Font("Dialog", Font.PLAIN, 18));
		nameTF.setBackground(new Color(34, 139, 34));
		nameTF.setBounds(105, 26, 226, 28);
		add(nameTF);
		nameTF.setColumns(10);
		
		cityTF = new JTextField();
		cityTF.setBackground(new Color(34, 139, 34));
		cityTF.setFont(new Font("Dialog", Font.PLAIN, 18));
		cityTF.setForeground(Color.WHITE);
		cityTF.setBounds(105, 79, 226, 28);
		add(cityTF);
		cityTF.setColumns(10);
		
		countryTF = new JTextField();
		countryTF.setBackground(new Color(34, 139, 34));
		countryTF.setForeground(Color.WHITE);
		countryTF.setFont(new Font("Dialog", Font.PLAIN, 18));
		countryTF.setBounds(106, 119, 225, 28);
		add(countryTF);
		countryTF.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setFont(new Font("Dialog", Font.BOLD, 30));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setIcon(new ImageIcon(Airport.class.getResource("/airLine/Add-item-icon.png")));
		btnAdd.setBackground(new Color(34, 139, 34));
		btnAdd.setBounds(105, 171, 226, 26);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name,city,country;
				name=nameTF.getText();
				city=cityTF.getText();
				country=countryTF.getText();
				try {
		              dbm.addAirport(name,city,country);
				      JOptionPane.showMessageDialog(null, "Airport Added");
					
				} catch (SQLException e) {
		
					e.printStackTrace();
				}
			}
		});
		add(btnAdd);
		
		JButton btnBack = new JButton(" Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				frame.setVisible(true);
			}
		});
		btnBack.setIcon(new ImageIcon(Airport.class.getResource("/airLine/back-icon.png")));
		btnBack.setForeground(Color.WHITE);
		btnBack.setFont(new Font("Dialog", Font.BOLD, 30));
		btnBack.setBackground(new Color(34, 139, 34));
		btnBack.setBounds(105, 209, 226, 28);
		add(btnBack);
		
		 

	}
}
