  package airLine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Seats extends JPanel {
	private JTextField chargeTF;
private DatabaseManagementClass dbm;
	public Seats(DatabaseManagementClass dbm, JFrame jf) {
		this.dbm=dbm;
		setLayout(null);
		
		JLabel lblFlightNo = new JLabel("Flight No :");
		lblFlightNo.setBounds(23, 32, 55, 16);
		add(lblFlightNo);
		
		JLabel lblSeatNo = new JLabel("Seat No :");
		lblSeatNo.setBounds(23, 83, 55, 16);
		add(lblSeatNo);
		
		JLabel lblClass = new JLabel("Class :");
		lblClass.setBounds(23, 128, 55, 16);
		add(lblClass);
		
		JLabel lblCharge = new JLabel("Charge :");
		lblCharge.setBounds(23, 174, 55, 16);
		add(lblCharge);
		
		JComboBox flightNoCB = new JComboBox();
		flightNoCB.setBounds(131, 23, 121, 25);
		add(flightNoCB);
		
		JComboBox seatNoCB = new JComboBox();
		seatNoCB.setBounds(131, 79, 121, 25);
		add(seatNoCB);
		
		JComboBox classCB = new JComboBox();
		classCB.setBounds(131, 124, 121, 25);
		add(classCB);
		
		chargeTF = new JTextField();
		chargeTF.setBounds(131, 172, 121, 25);
		add(chargeTF);
		chargeTF.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(308, 238, 98, 26);
		add(btnAdd);

	}
}
