package airLine;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.geom.Arc2D.Float;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Route extends JPanel {

	private String flightno;
	private int routeno;
	private String from;
	private String to;
	private double distance;
	private double fare=100;

	private DatabaseManagementClass dbm;
	private JTextField distanceTF;
	private JTextField routeNoTF;

	public Route(final DatabaseManagementClass dbm, final JFrame jf, final Home frame) {
		setBackground(Color.GRAY);
		this.dbm = dbm;
		setLayout(null);
		frame.setVisible(false);

		final JComboBox fromCB = new JComboBox();
		fromCB.setBackground(Color.RED);
		fromCB.setBounds(127, 68, 280, 26);
		add(fromCB);
		try {

			ResultSet rs = null;
			rs = dbm.getAirport();

			while (rs.next()) {
				fromCB.addItem(rs.getString("City"));

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		final JComboBox toCB = new JComboBox();
		toCB.setForeground(Color.BLACK);
		toCB.setBackground(Color.RED);
		toCB.setBounds(127, 111, 280, 26);
		add(toCB);

		try {

			ResultSet rs = null;
			rs = dbm.getAirport();

			while (rs.next()) {
				toCB.addItem(rs.getString("City"));

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		JLabel lblRouteNo = new JLabel("Route No :");
		lblRouteNo.setBackground(Color.RED);
		lblRouteNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRouteNo.setForeground(Color.RED);
		lblRouteNo.setBounds(12, 29, 97, 26);
		add(lblRouteNo);

		JLabel lblFrom = new JLabel("From :");
		lblFrom.setBackground(Color.RED);
		lblFrom.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblFrom.setForeground(Color.RED);
		lblFrom.setBounds(12, 78, 55, 16);
		add(lblFrom);

		JLabel lblTo = new JLabel("To :");
		lblTo.setBackground(Color.RED);
		lblTo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTo.setForeground(Color.RED);
		lblTo.setBounds(12, 119, 55, 16);
		add(lblTo);
		JLabel lblDistance = new JLabel("Distance :");
		lblDistance.setBackground(Color.RED);
		lblDistance.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDistance.setForeground(Color.RED);
		lblDistance.setBounds(12, 177, 105, 16);
		add(lblDistance);

		distanceTF = new JTextField();
		distanceTF.setForeground(Color.WHITE);
		distanceTF.setBackground(Color.RED);
		distanceTF.setBounds(127, 167, 280, 26);
		add(distanceTF);
		distanceTF.setColumns(10);
		routeNoTF = new JTextField();
		routeNoTF.setForeground(Color.WHITE);
		routeNoTF.setBackground(Color.RED);
		routeNoTF.setBounds(127, 19, 280, 26);
		add(routeNoTF);
		routeNoTF.setColumns(10);
		JButton btnAdd = new JButton("Add");
		btnAdd.setIcon(new ImageIcon(Route.class.getResource("/airLine/Add-item-icon.png")));
		btnAdd.setBackground(Color.RED);
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				routeno = Integer.parseInt(routeNoTF.getText());
				from = (String) fromCB.getSelectedItem();
				
				to = (String) toCB.getSelectedItem();
				if(from.equals(to)){
					JOptionPane.showMessageDialog(null, "Plz Select diffrent Sourse and Detinations");	
					}
				else{
				
				

				try {
					distance = Double.parseDouble(distanceTF.getText());
					if(routeno>0&&routeno<1000){
					dbm.addRoute(routeno, from, to, distance);
					JOptionPane.showMessageDialog(null, "Record added");
					}else{
						JOptionPane.showMessageDialog(null, "RouteNo should be in Range 1-1000");
					}
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
				}
				}

			}
		});
		btnAdd.setBounds(127, 206, 132, 28);
		add(btnAdd);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				frame.setVisible(true);
			}
		});
		button.setBackground(Color.RED);
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 30));
		button.setIcon(new ImageIcon(Route.class.getResource("/airLine/back-icon.png")));
		button.setBounds(260, 206, 146, 28);
		add(button);
		
		JLabel label = new JLabel("");
		label.setBounds(415, 272, 55, 16);
		add(label);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setForeground(new Color(0, 0, 51));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBackground(Color.RED);
		lblNewLabel.setIcon(new ImageIcon(Route.class.getResource("/airLine/Homeimage2.jpg")));
		lblNewLabel.setBounds(0, -1, 838, 248);
		add(lblNewLabel);

	}
}
