package airLine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Schedule extends JPanel {

	private DatabaseManagementClass dbm;
	private JTextField depDateTf;
	private JTextField arrDateTf;
	private JTextField schIdTf;
	private JTextField depTimeTf;
	private JTextField arrTimeTf;
	private JTextField fromTf;
	private JTextField toTf;
	private int routeId;
	private float distance;
	private String flightclass;
	private String from;
	private String to;
	String deptime, arrtime, deptdate, arrdate;
	int schedulId;

	public Schedule(final DatabaseManagementClass dbm, final JFrame jf,
			final Home frame) {
		this.dbm = dbm;
		setLayout(null);
		frame.setVisible(false);

		JLabel lblScheduleId = new JLabel("Schedule Id :");
		lblScheduleId.setBounds(12, 91, 78, 16);
		add(lblScheduleId);

		JLabel lblFlightId = new JLabel("Flight Id :");
		lblFlightId.setBounds(12, 133, 55, 16);
		add(lblFlightId);

		final JComboBox FlightCb = new JComboBox();
		FlightCb.setBounds(121, 126, 341, 31);
		add(FlightCb);

		JLabel lblDeptime = new JLabel("Dep_Date :");
		lblDeptime.setBounds(12, 175, 78, 16);
		add(lblDeptime);

		JLabel lblArrtime = new JLabel("Arr_Date:");
		lblArrtime.setBounds(12, 216, 67, 16);
		add(lblArrtime);

		JLabel lblFrom = new JLabel("From :");
		lblFrom.setBounds(12, 258, 55, 16);
		add(lblFrom);

		JLabel lblTo = new JLabel("To :");
		lblTo.setBounds(12, 303, 37, 16);

		fromTf = new JTextField();
		fromTf.setBounds(121, 251, 341, 33);
		add(fromTf);
		fromTf.setColumns(10);

		toTf = new JTextField();
		toTf.setBounds(121, 294, 341, 33);
		add(toTf);
		toTf.setColumns(10);

		add(lblTo);
		final JComboBox routeNoCb = new JComboBox();

		routeNoCb.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String rn = routeNoCb.getSelectedItem().toString();
				ResultSet rs = null;

				try {
					rs = dbm.getRouteinfo(rn);

					while (rs.next()) {
						fromTf.setText(rs.getString(2));
						toTf.setText(rs.getString(3));
						from = rs.getString(2);
						to = rs.getString(3);

					}

				} catch (SQLException e) {
				
					JOptionPane.showMessageDialog(null,
							"Plz Input Correct Arguement");
				}

			}
		});

		try {

			ResultSet rs = null;
			rs = dbm.getFlight();

			while (rs.next()) {
				FlightCb.addItem(rs.getString("FlightNo"));

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		try {

			ResultSet rs = null;
			rs = dbm.getRoute();

			while (rs.next()) {
				routeNoCb.addItem(rs.getString("Route_No"));
			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		depDateTf = new JTextField();
		depDateTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				String str=depDateTf.getText();
				if(str.length()>10)
				{
					JOptionPane.showMessageDialog(null, "Date Should be in 1-1-2015 Order");
				}
			}
		});
		depDateTf.setBounds(121, 169, 126, 29);
		add(depDateTf);
		depDateTf.setColumns(10);

		arrDateTf = new JTextField();
		arrDateTf.setBounds(121, 210, 126, 29);
		add(arrDateTf);
		arrDateTf.setColumns(10);
		schIdTf = new JTextField();
		schIdTf.setBounds(121, 84, 341, 31);
		add(schIdTf);
		schIdTf.setColumns(10);

		JLabel lblDeptime_1 = new JLabel("Dep_Time:");
		lblDeptime_1.setBounds(259, 169, 67, 22);
		add(lblDeptime_1);

		JLabel lblArrtime_1 = new JLabel("Arr_Time:");
		lblArrtime_1.setBounds(259, 216, 67, 16);
		add(lblArrtime_1);

		depTimeTf = new JTextField();
		depTimeTf.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String str=depTimeTf.getText();
				if(str.length()>5)
				{
					JOptionPane.showMessageDialog(null, "Time Should be in 1:00 Order");
				}
			}
		});
		depTimeTf.setBounds(344, 166, 118, 29);
		add(depTimeTf);
		depTimeTf.setColumns(10);

		arrTimeTf = new JTextField();
		arrTimeTf.setBounds(344, 203, 118, 29);
		add(arrTimeTf);
		arrTimeTf.setColumns(10);

		JLabel lblRouteno = new JLabel("RouteNo:");
		lblRouteno.setBounds(12, 43, 55, 16);
		add(lblRouteno);
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float fare = 100;

				String flightno;
				routeId = 0;
				routeId = Integer.parseInt(routeNoCb.getSelectedItem()
						.toString());
				String flightid;
				
				flightid = FlightCb.getSelectedItem().toString();
				deptime = depTimeTf.getText().toString();
				arrtime = arrTimeTf.getText().toString();
				deptdate = depDateTf.getText().toString();
				arrdate = arrDateTf.getText().toString();
				try {
					schedulId = Integer.parseInt(schIdTf.getText());
					dbm.addSchedule(schedulId, routeId, flightid, from, to,
							deptdate, arrdate, deptime, arrtime);

					JOptionPane.showMessageDialog(null, "Schedule Prepared");

				} catch (Exception e) {
					// e.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Plz Input Correct Arguement");
				}

				try {

					ResultSet rs = null;
					rs = dbm.getRoute();

					while (rs.next()) {
						if (Integer.parseInt(rs.getString("Route_No")) == routeId) {
							distance = Float.parseFloat(rs
									.getString("Route_Dis"));

						}
					}

				} catch (SQLException e1) {

					// e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Plz Input Correct Arguement");
				}
				try {

					ResultSet rs = null;
					rs = dbm.getFlight();

					while (rs.next()) {
						if (rs.getString("FlightNo").equals(
								FlightCb.getSelectedItem().toString())) {

							flightno = FlightCb.getSelectedItem().toString();
							
							int i = 1;

							while (i < rs.getInt("Seats")) {
								if (i <= 150) {

									flightclass = "Economy";
									fare = 100 * distance;
									dbm.addSeats(i, flightclass, "UnRes",
											deptdate, fare, flightno);

									i++;

								} else if (i < 250) {

									flightclass = "Business";
									fare = 110 * distance;
									dbm.addSeats(i, flightclass, "UnRes",
											deptdate, fare, flightno);

									i++;

								} else {

									flightclass = "FClass";
									fare = 120 * distance;
									dbm.addSeats(i, flightclass, "UnRes",
											deptdate, fare, flightno);
									i++;
								}

							}

						}
					}

				} catch (SQLException e1) {

					// e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Plz Input Correct Arguement");
				}

			}
		});
		btnAdd.setBounds(117, 339, 156, 29);
		add(btnAdd);
		routeNoCb.setBounds(121, 36, 341, 31);
		add(routeNoCb);

		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				schedulId = Integer.parseInt(schIdTf.getText());
				deptime = depTimeTf.getText().toString();
				arrtime = arrTimeTf.getText().toString();
				deptdate = depDateTf.getText().toString();
				arrdate = arrDateTf.getText().toString();
				try {
					dbm.updateSchedule(schedulId, deptdate, arrdate, deptime,
							arrtime);
					JOptionPane.showMessageDialog(null,
							"Schedule Updated Successfully");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					// e1.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Plz Input Correct Arguement");
				}

			}
		});
		btnNewButton.setBounds(290, 339, 172, 29);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jf.dispose();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(121, 383, 341, 26);
		add(btnNewButton_1);

	}
}
