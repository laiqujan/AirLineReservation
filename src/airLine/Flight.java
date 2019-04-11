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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextPane;

public class Flight extends JPanel {
	private JTextField FlightTF;
	private JTextField seatTF;
private DatabaseManagementClass dbm;
	
	public Flight(final DatabaseManagementClass dbm, final JFrame jf, final Home frame) {
		setBackground(Color.GRAY);
		this.dbm=dbm;
		setLayout(null);
		frame.setVisible(false);
		final JTextPane j = new JTextPane();
		j.setForeground(new Color(255, 0, 0));
		j.setFont(new Font("Dialog", Font.PLAIN, 16));
		j.setBackground(Color.GRAY);
		j.setBounds(22, 58, 259, 22);
		add(j);
		JLabel lblFlightNo = new JLabel("Flight No :");
		lblFlightNo.setFont(new Font("Dialog", Font.BOLD, 20));
		lblFlightNo.setForeground(Color.WHITE);
		lblFlightNo.setBounds(12, 20, 126, 28);
		add(lblFlightNo);
		
		JLabel lblTotalSeat = new JLabel("Total Seats :");
		lblTotalSeat.setFont(new Font("Dialog", Font.BOLD, 20));
		lblTotalSeat.setForeground(Color.WHITE);
		lblTotalSeat.setBounds(12, 92, 126, 16);
		add(lblTotalSeat);
		
		FlightTF = new JTextField();
		FlightTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String str;
				str=FlightTF.getText();
				if(str.length()>6){
					j.setText("Flight_No Should Be 1-6 Charcter ");
					 
				}
			}
		});
		FlightTF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				
			}
		});
		FlightTF.setForeground(Color.WHITE);
		FlightTF.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 16));
		FlightTF.setBackground(Color.GRAY);
		FlightTF.setBounds(161, 22, 120, 28);
		add(FlightTF);
		FlightTF.setColumns(10);
		
		seatTF = new JTextField();
		seatTF.setFont(new Font("Dialog", Font.PLAIN, 15));
		seatTF.setForeground(Color.WHITE);
		seatTF.setBackground(Color.GRAY);
		seatTF.setBounds(156, 88, 120, 28);
		add(seatTF);
		seatTF.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(Flight.class.getResource("/airLine/Add-item-icon.png")));
		btnAdd.setBackground(Color.GRAY);
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Dialog", Font.BOLD | Font.ITALIC, 19));
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String FlightNo=FlightTF.getText();
				try {
					String st=	seatTF.getText(); 
					int Seats=Integer.parseInt(seatTF.getText());
					  if(FlightNo.equals("") || st.equals("") ){
							JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
						  
					  }else{
					   dbm.addFlight(FlightNo, Seats);
					   JOptionPane.showMessageDialog(null, "Flight Added");
					  }
					} catch (Exception e) {
					
					//e.printStackTrace();
						JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
				}
			}
		});
		
		btnAdd.setBounds(86, 175, 181, 28);
		add(btnAdd);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setIcon(new ImageIcon(Flight.class.getResource("/airLine/back-icon.png")));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jf.dispose();
				frame.setVisible(true);
			
			}
		});
		btnNewButton.setBounds(86, 215, 181, 28);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Flight.class.getResource("/airLine/first class seats.preview.jpg")));
		lblNewLabel.setBounds(285, 0, 552, 357);
		add(lblNewLabel);
		
	
		

	}
}
