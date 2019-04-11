package airLine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.JScrollPane;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;

import net.proteanit.sql.DbUtils;

public class AdSearchFlight extends JPanel {

	private DatabaseManagementClass dbm;
	private JTable table;
	String from,to,deptdate,flight;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public AdSearchFlight(final DatabaseManagementClass dbm, final JFrame jf, final Home frame) {
		this.dbm = dbm;
		setLayout(null);
		frame.setVisible(false);

		final JComboBox toCB = new JComboBox();
		toCB.setBounds(97, 77, 406, 34);
		add(toCB);

		final JComboBox fromCB = new JComboBox();
		fromCB.setBounds(97, 25, 406, 34);
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

		try {

			ResultSet rs = null;
			rs = dbm.getAirport();

			while (rs.next()) {
				toCB.addItem(rs.getString("City"));

			}

		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		JLabel lblEnterSource = new JLabel("From");
		lblEnterSource.setBounds(12, 34, 65, 16);
		add(lblEnterSource);

		JLabel lblTo = new JLabel("To");
		lblTo.setBounds(12, 86, 55, 16);
		add(lblTo);

		JComboBox toCb = new JComboBox();

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(12, 133, 47, 16);
		add(lblDate);

		final JComboBox dayCB = new JComboBox();
		dayCB.setModel(new DefaultComboBoxModel(new String[] { "Day", "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		dayCB.setBounds(97, 123, 55, 36);
		add(dayCB);

		final JComboBox monthCB = new JComboBox();
		monthCB.setModel(new DefaultComboBoxModel(new String[] { "Month", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		monthCB.setBounds(158, 123, 102, 34);
		add(monthCB);

		final JComboBox yearCB = new JComboBox();
		yearCB.setModel(new DefaultComboBoxModel(new String[] { "Year", "2015",
				"2016", "2017", "2018" }));
		yearCB.setBounds(276, 123, 98, 34);
		add(yearCB);
		JScrollPane scrollPane = new JScrollPane();
         scrollPane.setBounds(12, 185, 491, 218);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(AdSearchFlight.class.getResource("/airLine/Search-icon.png")));
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				from = fromCB.getSelectedItem().toString();
			   to = toCB.getSelectedItem().toString();

				 deptdate = dayCB.getSelectedItem().toString() + "-"
						+ monthCB.getSelectedItem().toString() + "-"
						+ yearCB.getSelectedItem().toString();
				ResultSet rs=null;
				boolean found = true;
				
				try {
					rs = dbm.getSchedule(from, to, deptdate);
		           table.setModel(DbUtils.resultSetToTableModel(rs));
		        
		          if( table.getRowCount()==0){
		        	  JOptionPane.showMessageDialog(null,
								"Flight not Available");  
		          }
			      } catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					JOptionPane.showMessageDialog(null,
							"Flight not Available");
				}
				
				

	
			}
		});
		btnSearch.setBounds(386, 123, 117, 34);
		add(btnSearch);
		
		JButton btnBack = new JButton("Back");
		btnBack.setIcon(new ImageIcon(AdSearchFlight.class.getResource("/airLine/back-icon.png")));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jf.dispose();
				frame.setVisible(true);
			}
		});
		btnBack.setBounds(441, 451, 98, 26);
		add(btnBack);

	}
}
