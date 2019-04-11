package airLine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class Booking extends JPanel {
	private DatabaseManagementClass dbm;
	private String from, to, flight;
	private String deptdate;
	private JTextField flightIdTf;
	private JTextField fromTf;
	private JTextField toTf;
	private JTextField depDateTf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private int schId;
	private String seatClass;
	private int totalReqSeats;
	private JTextField availableSeatsTf;

	public Booking(final DatabaseManagementClass dbm, final String flight, String from,
			String to, final String deptdate, final JFrame f, final JFrame jj) {
	 
		setBackground(Color.RED);
		this.dbm = dbm;
		this.from = from;
		this.to = to;
		this.deptdate = deptdate;
		this.flight = flight;
		setLayout(null);
		try {
			ResultSet rs = dbm.getScheduleId(from, to, deptdate, flight);
			while (rs.next()) {
				schId = Integer.parseInt((rs.getString("Schedule_ID")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		JLabel lblFlightno = new JLabel("FlightNo:");
		lblFlightno.setBounds(12, 42, 55, 16);
		add(lblFlightno);

		flightIdTf = new JTextField();
		flightIdTf.setForeground(Color.WHITE);
		flightIdTf.setBackground(Color.DARK_GRAY);
		flightIdTf.setEditable(false);
		flightIdTf.setBounds(136, 36, 342, 28);
		add(flightIdTf);
		flightIdTf.setColumns(10);

		JLabel lblFrom = new JLabel("From:");
		lblFrom.setBounds(12, 87, 55, 16);
		add(lblFrom);

		fromTf = new JTextField();
		fromTf.setForeground(Color.WHITE);
		fromTf.setBackground(Color.DARK_GRAY);
		fromTf.setEditable(false);
		fromTf.setBounds(136, 81, 342, 28);
		add(fromTf);
		fromTf.setColumns(10);

		JLabel lblTo = new JLabel("To:");
		lblTo.setBounds(12, 127, 55, 16);
		add(lblTo);

		toTf = new JTextField();
		toTf.setForeground(Color.WHITE);
		toTf.setBackground(Color.DARK_GRAY);
		toTf.setEditable(false);
		toTf.setBounds(136, 121, 342, 28);
		add(toTf);
		toTf.setColumns(10);

		JLabel lblDepdate = new JLabel("Dep_Date:");
		lblDepdate.setBounds(12, 167, 65, 16);
		add(lblDepdate);

		depDateTf = new JTextField();
		depDateTf.setForeground(Color.WHITE);
		depDateTf.setBackground(Color.DARK_GRAY);
		depDateTf.setEditable(false);
		depDateTf.setBounds(136, 161, 342, 28);
		add(depDateTf);
		depDateTf.setColumns(10);

		JLabel lblAvailableSeats = new JLabel("Available Seats:");
		lblAvailableSeats.setBounds(14, 235, 104, 16);
		add(lblAvailableSeats);

		availableSeatsTf = new JTextField();
		availableSeatsTf.setForeground(Color.WHITE);
		availableSeatsTf.setBackground(Color.DARK_GRAY);
		availableSeatsTf.setEditable(false);
		availableSeatsTf.setBounds(136, 229, 342, 28);
		add(availableSeatsTf);
		availableSeatsTf.setColumns(10);
		flightIdTf.setText(flight);
		depDateTf.setText(deptdate);
		fromTf.setText(from);
		toTf.setText(to);

		JLabel lblSelectClass = new JLabel("Select Class:");
		lblSelectClass.setBounds(12, 196, 74, 16);
		add(lblSelectClass);

		final JRadioButton rdbtnFirstclass = new JRadioButton("FirstClass");
		rdbtnFirstclass.setForeground(Color.WHITE);
		rdbtnFirstclass.setBackground(Color.DARK_GRAY);
		rdbtnFirstclass.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs;
				try {
					seatClass = "FClass";
					rs = dbm.getAvailableSeat(flight, seatClass, deptdate);
					int i = 0;
					while (rs.next()) {
						if (rs.getString("Seat_Status").equals("UnRes")) {
							i++;
						}
						String s = "" + i;
						availableSeatsTf.setText(s);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
				}

			}
		});
		buttonGroup.add(rdbtnFirstclass);
		rdbtnFirstclass.setBounds(132, 197, 89, 24);
		add(rdbtnFirstclass);

		final JRadioButton rdbtnBuisness = new JRadioButton("Buisness");
		rdbtnBuisness.setForeground(Color.WHITE);
		rdbtnBuisness.setBackground(Color.DARK_GRAY);
		rdbtnBuisness.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs;
				try {
					seatClass = "Business";
					rs = dbm.getAvailableSeat(flight, seatClass, deptdate);
					int i = 0;
					while (rs.next()) {
						if (rs.getString("Seat_Status").equals("UnRes")) {
							i++;
						}
						String s = "" + i;
						availableSeatsTf.setText(s);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement"); 
				}
			}
		});
		buttonGroup.add(rdbtnBuisness);
		rdbtnBuisness.setBounds(236, 197, 112, 24);
		add(rdbtnBuisness);

		final JRadioButton rdbtnEconomy = new JRadioButton("Economy");
		rdbtnEconomy.setForeground(Color.WHITE);
		rdbtnEconomy.setBackground(Color.DARK_GRAY);
		rdbtnEconomy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ResultSet rs;
				try {
					seatClass = "Economy";
					rs = dbm.getAvailableSeat(flight, seatClass, deptdate);
					int i = 0;
					while (rs.next()) {
						if (rs.getString("Seat_Status").equals("UnRes")) {
							i++;
						}
						String s = "" + i;
						availableSeatsTf.setText(s);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
				}
			}
		});
		buttonGroup.add(rdbtnEconomy);
		rdbtnEconomy.setBounds(395, 197, 83, 24);
		add(rdbtnEconomy);

		JButton btnProceed = new JButton("");
		btnProceed.setIcon(new ImageIcon(Booking.class.getResource("/airLine/Transport-Go-Kart-icon.png")));
		btnProceed.setFont(new Font("Dialog", Font.BOLD, 22));
		btnProceed.setForeground(Color.WHITE);
		btnProceed.setBackground(Color.RED);
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				boolean r=true;

				int totalseat = 0;
				ResultSet rs = null;
				if (rdbtnFirstclass.isSelected()) {
					seatClass = "FClass";
				} else if (rdbtnEconomy.isSelected()) {
					seatClass = "Economy";
				}
				else if ( rdbtnBuisness.isSelected()){
						seatClass = "Business";
				}
						else {
							r=false;
							
					 }
			
      if(r){
				try {

					// totalseat = Integer.parseInt(totalSeatsTf.getText());
					int i = 1;
					rs = dbm.getAvailableSeat(flight, seatClass, deptdate);
					while (rs.next()) {
						if (rs.getString("Seat_Status").equals("UnRes")) {
							i++;
						}
					}

					if (i >= 1) {
						jj.setVisible(false);
						JFrame jf = new JFrame();
						jf.setSize(860,470);
						CustomerInfo de = new CustomerInfo(dbm, schId, flight,
								deptdate, seatClass, jf,f);
						jf.setTitle("Booking Continue.....");
						jf.setResizable(false);
						jf.getContentPane().add(de);
						jf.setVisible(true);
						 
					} else {

						JOptionPane.showMessageDialog(null,
								"Seats are not available");

					}
				} catch (SQLException e) {
					//e.printStackTrace();
					JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
				}
      }else{
    	  JOptionPane.showMessageDialog(null, "Plz Select Class"); 
      }
			}
		});
		btnProceed.setBounds(136, 284, 342, 26);
		add(btnProceed);
		
		JLabel lblBulzAirlines = new JLabel("                                BULZ Airlines ");
		lblBulzAirlines.setForeground(Color.BLUE);
		lblBulzAirlines.setFont(new Font("Footlight MT Light", Font.BOLD, 24));
		lblBulzAirlines.setBackground(Color.GREEN);
		lblBulzAirlines.setBounds(0, 0, 607, 30);
		add(lblBulzAirlines);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.setVisible(true);
				jj.setVisible(false);
			}
		});
		btnNewButton.setIcon(new ImageIcon(Booking.class.getResource("/airLine/back-icon.png")));
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 20));
		btnNewButton.setBackground(Color.RED);
		btnNewButton.setBounds(136, 320, 342, 26);
		add(btnNewButton);

	}
}
