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

import net.proteanit.sql.DbUtils;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;

public class SearchFlight extends JPanel {

	private DatabaseManagementClass dbm;
	private JTable table;
	String from,to,deptdate,flight;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	public SearchFlight(final DatabaseManagementClass dbm, final JFrame jf, final JFrame jf2) {
		setBackground(Color.GRAY);
		this.dbm = dbm;
		setLayout(null);
	 
		final JComboBox toCB = new JComboBox();
		toCB.setForeground(Color.WHITE);
		toCB.setBackground(Color.GRAY);
		toCB.setBounds(107, 64, 406, 34);
		add(toCB);

		final JComboBox fromCB = new JComboBox();
		fromCB.setForeground(Color.WHITE);
		fromCB.setBackground(Color.GRAY);
		fromCB.setBounds(107, 29, 406, 34);
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
		lblEnterSource.setForeground(Color.WHITE);
		lblEnterSource.setBackground(Color.GRAY);
		lblEnterSource.setBounds(22, 38, 65, 16);
		add(lblEnterSource);

		JLabel lblTo = new JLabel("To");
		lblTo.setForeground(Color.WHITE);
		lblTo.setBackground(Color.GRAY);
		lblTo.setBounds(22, 73, 55, 16);
		add(lblTo);
		final JLabel sl = new JLabel("Select Flight For Booking:");
		sl.setForeground(Color.WHITE);
		sl.setBackground(Color.GRAY);
		sl.setBounds(22, 413, 171, 16);
		add(sl);


		JComboBox toCb = new JComboBox();

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(Color.WHITE);
		lblDate.setBackground(Color.GRAY);
		lblDate.setBounds(22, 120, 47, 16);
		add(lblDate);

		final JComboBox sCB = new JComboBox();
		sCB.setForeground(Color.WHITE);
		sCB.setBackground(Color.GRAY);
		sCB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				flight=(String) sCB.getSelectedItem();
				if(flight!=null){
				jf2.setVisible(false);
			    JFrame j = new JFrame();
				j.setSize(530, 530);
			    Booking de = new Booking(dbm,flight,from, to, deptdate,jf,j);
			    j.setTitle("Booking Start");
			    j.setResizable(false);
				j.getContentPane().add(de);
				j.setVisible(true);
				}else{
					JOptionPane.showMessageDialog(null, "Plz Select Flight");
				}
				
			}
		});

		sCB.setBounds(272, 404, 241, 34);
		add(sCB);

		final JComboBox dayCB = new JComboBox();
		dayCB.setForeground(Color.WHITE);
		dayCB.setBackground(Color.GRAY);
		dayCB.setModel(new DefaultComboBoxModel(new String[] { "Day", "1", "2",
				"3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13",
				"14", "15", "16", "17", "18", "19", "20", "21", "22", "23",
				"24", "25", "26", "27", "28", "29", "30", "31" }));
		dayCB.setBounds(107, 110, 55, 25);
		add(dayCB);

		final JComboBox monthCB = new JComboBox();
		monthCB.setForeground(Color.WHITE);
		monthCB.setBackground(Color.GRAY);
		monthCB.setModel(new DefaultComboBoxModel(new String[] { "Month", "1",
				"2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12" }));
		monthCB.setBounds(168, 110, 98, 25);
		add(monthCB);

		final JComboBox yearCB = new JComboBox();
		yearCB.setForeground(Color.WHITE);
		yearCB.setBackground(Color.GRAY);
		yearCB.setModel(new DefaultComboBoxModel(new String[] { "Year", "2015",
				"2016", "2017", "2018" }));
		yearCB.setBounds(268, 110, 80, 25);
		add(yearCB);
		JScrollPane scrollPane = new JScrollPane();
         scrollPane.setBounds(22, 180, 491, 218);
		add(scrollPane);

		table = new JTable();
		scrollPane.setViewportView(table);
		JButton btnSearch = new JButton("Search");
		btnSearch.setIcon(new ImageIcon(SearchFlight.class.getResource("/airLine/Search-icon.png")));
		btnSearch.setForeground(Color.WHITE);
		btnSearch.setBackground(Color.GRAY);
		sl.setVisible(false);
		table.setVisible(false);
		sCB.setVisible(false);
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
					sl.setVisible(true);
					table.setVisible(true);
					sCB.setVisible(true);
		           table.setModel(DbUtils.resultSetToTableModel(rs));
		        
		          if( table.getRowCount()==0){
		        	  JOptionPane.showMessageDialog(null,
								"Flight not Available");  
		          }
			      } catch (SQLException e) {
					// TODO Auto-generated catch block
					 
					JOptionPane.showMessageDialog(null,
							"Flight not Available");
				}
				try {
				//int length = s.getFetchSize();

				String[] std;
				int i=0;
				std= dbm.getSearchedFlight(from, to, deptdate);
				
				sCB.setModel(new DefaultComboBoxModel(std));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
				}
				

	
			}
		});
		btnSearch.setBounds(360, 105, 153, 34);
		add(btnSearch);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jf2.dispose();
				jf.setVisible(true);
		 
			}
		});
		btnNewButton.setIcon(new ImageIcon(SearchFlight.class.getResource("/airLine/back-icon.png")));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Dialog", Font.BOLD, 17));
		btnNewButton.setBackground(Color.GRAY);
		btnNewButton.setBounds(272, 450, 241, 26);
		add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("                                BULZ Airlines ");
		lblNewLabel.setFont(new Font("Footlight MT Light", Font.BOLD, 24));
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setBackground(Color.GREEN);
		lblNewLabel.setBounds(0, 0, 562, 26);
		add(lblNewLabel);
		
		
	}
}
