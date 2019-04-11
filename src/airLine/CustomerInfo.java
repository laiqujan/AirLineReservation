package airLine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import java.awt.Color;

public class CustomerInfo extends JPanel {
	private DatabaseManagementClass dbm;
	private JTextField nameTf;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField cnicTf;
	private JTextField contactNoTf;
	private final ButtonGroup buttonGroup_1 = new ButtonGroup();
	private JTextField emailIdTf;
	private String flightNo;
	private int schId;
	private String deptDate;
	private String seatClass;
	private int totalSeats;
    int bk=0;
	/**
	 * Create the panel.
	 * 
	 * @param dbm
	 * @param flightNo
	 * @param schId
	 * @param seatClass
	 * @param deptdate
	 * @param jf 
	 * @param f 
	 */
	public CustomerInfo(final DatabaseManagementClass dbm, final int schId,
			final String flightNo, final String deptdate, final String seatClass, final JFrame j, final JFrame f) {
		setBackground(Color.GRAY);
		this.dbm = dbm;
		this.schId = schId;
		this.flightNo = flightNo;
		this.deptDate = deptdate;
		this.seatClass = seatClass;
		this.totalSeats = totalSeats;
		bk=1;
		setLayout(null);

		JLabel lblFullname = new JLabel("FullName:");
		lblFullname.setBounds(12, 34, 55, 16);
		add(lblFullname);

		nameTf = new JTextField();
		nameTf.setBounds(154, 29, 318, 27);
		add(nameTf);
		nameTf.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(154, 77, 318, 51);
		add(scrollPane);

		final JTextArea addTf = new JTextArea();
		scrollPane.setViewportView(addTf);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(12, 95, 55, 16);
		add(lblAddress);

		JLabel lblGender = new JLabel("Gender:");
		lblGender.setBounds(12, 140, 55, 16);
		add(lblGender);

		JRadioButton rdbtnMale = new JRadioButton("Male");
		rdbtnMale.setSelected(true);
		buttonGroup.add(rdbtnMale);
		rdbtnMale.setBounds(154, 136, 77, 24);
		add(rdbtnMale);

		final JRadioButton rdbtnFemale = new JRadioButton("FeMale");
		buttonGroup.add(rdbtnFemale);
		rdbtnFemale.setBounds(235, 136, 98, 24);
		add(rdbtnFemale);

		JLabel lblDob = new JLabel("DOB:");
		lblDob.setBounds(12, 177, 55, 16);
		add(lblDob);

		JLabel lblCnic = new JLabel("CNIC:");
		lblCnic.setBounds(12, 224, 55, 16);
		add(lblCnic);

		cnicTf = new JTextField();
		cnicTf.setBounds(154, 214, 318, 26);
		add(cnicTf);
		cnicTf.setColumns(10);

		JLabel lblContactno = new JLabel("ContactNo:");
		lblContactno.setBounds(12, 275, 68, 16);
		add(lblContactno);

		contactNoTf = new JTextField();
		contactNoTf.setBounds(154, 262, 318, 26);
		add(contactNoTf);
		contactNoTf.setColumns(10);

		JLabel lblContacttype = new JLabel("ContactType:");
		lblContacttype.setBounds(12, 319, 77, 16);
		add(lblContacttype);

		JRadioButton rdbtnHome = new JRadioButton("Home");
		rdbtnHome.setSelected(true);
		buttonGroup_1.add(rdbtnHome);
		rdbtnHome.setBounds(154, 315, 85, 24);
		add(rdbtnHome);

		final JRadioButton rdbtnOffice = new JRadioButton("Office");
		buttonGroup_1.add(rdbtnOffice);
		rdbtnOffice.setBounds(256, 315, 121, 24);
		add(rdbtnOffice);

		JLabel lblEmailid = new JLabel("EmailId:");
		lblEmailid.setBounds(12, 352, 55, 16);
		add(lblEmailid);

		emailIdTf = new JTextField();
		emailIdTf.setBounds(154, 347, 318, 27);
		add(emailIdTf);
		emailIdTf.setColumns(10);
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "Day", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31", "" }));
		comboBox.setBounds(154, 168, 85, 25);
		add(comboBox);
		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1
				.setModel(new DefaultComboBoxModel(new String[] { "Month", "1",
						"2", "3", "4", "5", "6", "7", "8", "9", "10", "11",
						"12" }));
		comboBox_1.setBounds(261, 168, 94, 25);
		add(comboBox_1);

		final JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setModel(new DefaultComboBoxModel(new String[] { "Year",
				"1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992",
				"1993", "1994", "1995", "1996" }));
		comboBox_2.setBounds(367, 168, 105, 25);
		add(comboBox_2);

		JLabel label = new JLabel("*");
		label.setIcon(new ImageIcon(CustomerInfo.class.getResource("/airLine/12.jpg")));
		label.setBounds(476, 34, 375, 298);
		add(label);

		JLabel label_1 = new JLabel("*");
		label_1.setBounds(476, 224, 55, 16);
		add(label_1);

		JLabel label_2 = new JLabel("*");
		label_2.setBounds(476, 269, 55, 16);
		add(label_2);

		JLabel label_3 = new JLabel("*");
		label_3.setBounds(476, 172, 55, 16);
		add(label_3);
		JButton btnBook = new JButton("Book");
		btnBook.setBackground(Color.GRAY);
		btnBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int p=totalSeats;
				String fullname, addr, gender, dob, cnic, contact, contacttype, email;
				fullname = nameTf.getText();
				dob = comboBox.getSelectedItem().toString() + "-"
						+ comboBox_1.getSelectedItem().toString() + "-"
						+ comboBox_2.getSelectedItem().toString();
				addr = addTf.getText();
				if (rdbtnFemale.isSelected()) {
					gender = "0";

				} else {
					gender = "1";

				}
				cnic = cnicTf.getText();
				email = emailIdTf.getText();
				contact = contactNoTf.getText();
				if (rdbtnOffice.isSelected()) {
					contacttype = "Office";
				} else {
					contacttype = "Home";
				}

				try {
					dbm.addCustomer(fullname, addr, dob, cnic, email, contact,
							contacttype, gender);
				  
					ResultSet rs = null;
					
					rs = dbm.getSeatSet();
					while (rs.next()&&bk==1) {
	if (rs.getString("deptdate").equals(deptDate)&& rs.getString("Flightno").equals(flightNo)&& rs.getString("class").equals(seatClass)) {
								if (rs.getString("Seat_Status").equals("UnRes")) {
									dbm.updateseat(flightNo, seatClass,
											deptdate, rs.getInt("SeatNo"));
									dbm.addTicket(rs.getInt("SeatNo"),deptdate, cnic, schId);
									bk++;
									//JOptionPane.showMessageDialog(null,
									//		"Selected Flight Seat is Resvered");
									j.setVisible(false);
									
									JFrame jf = new JFrame();
									jf.setSize(800, 450);
									jf.setResizable(false);
									jf.setTitle("  Ticket");
									ViewTicket de = new ViewTicket(dbm, jf,schId,rs.getInt("SeatNo"),rs.getString("Charges"),f,jf);
									jf.getContentPane().add(de);
									jf.setVisible(true);
									//jf.dispose();
									break;
									
								} 
								}
	                     
						    }

				} catch (SQLException e) {
				e.printStackTrace();
					JOptionPane.showMessageDialog(null, " Correct Arguement");
				}

			}
		});
		btnBook.setBounds(154, 386, 144, 27);
		add(btnBook);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				f.setVisible(true);
				j.setVisible(false);
			}
		});
		btnNewButton.setBounds(330, 386, 144, 26);
		add(btnNewButton);
		
		JLabel lblJ = new JLabel("j");
		lblJ.setBounds(490, 34, 55, 16);
		add(lblJ);
	}
}
