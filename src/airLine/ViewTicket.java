package airLine;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class ViewTicket extends JPanel {
	private DatabaseManagementClass dbm;

	JFrame jf;
	private JTextField FlightNo;
	private JTextField seatNoTf;
	private JTextField TicketNo;
	private JTextField depDate;
	private JTextField depTime;
	private JTextField cnic;
	private JTextField from;
	private JTextField to;
	private String charges;
	private JLabel lblCharges;
	private JTextField chargeTf;
	private int schId;
	private int seatNo;
	private JLabel lblNewLabel;
	/**
	 * Create the panel.
	 * @param i 
	 * @param schId 
	 * @param jf 
	 * @param dbm 
	 * @param charges 
	 * @param f 
	 * @param jf2 
	 */
	public ViewTicket(DatabaseManagementClass dbm, JFrame jf, int schid, int seatno, String charges, final JFrame f, final JFrame jf2) {
		setBackground(Color.GRAY);
		this.dbm=dbm;
		this.schId=schid;
		this.seatNo=seatno;
		this.charges=charges;
		
		setLayout(null);
		
		JLabel lblFlightno = new JLabel("FlightNo:");
		lblFlightno.setBounds(12, 12, 55, 16);
		add(lblFlightno);
		
		FlightNo = new JTextField();
		FlightNo.setFont(new Font("Dialog", Font.PLAIN, 16));
		FlightNo.setForeground(Color.WHITE);
		FlightNo.setBackground(Color.GRAY);
		FlightNo.setEditable(false);
		FlightNo.setBounds(111, 10, 231, 30);
		add(FlightNo);
		FlightNo.setColumns(10);
		JLabel lblSeatno = new JLabel("SeatNo:");
			lblSeatno.setBounds(12, 57, 55, 16);
			add(lblSeatno);
			
			seatNoTf = new JTextField();
			seatNoTf.setFont(new Font("Dialog", Font.PLAIN, 16));
			seatNoTf.setForeground(Color.WHITE);
			seatNoTf.setBackground(Color.GRAY);
			seatNoTf.setEditable(false);
			seatNoTf.setBounds(111, 55, 231, 30);
			add(seatNoTf);
			seatNoTf.setColumns(10);
			
			JLabel lblTicketno = new JLabel("TicketNo:");
			lblTicketno.setBounds(12, 104, 55, 16);
			add(lblTicketno);
			
			TicketNo = new JTextField();
			TicketNo.setFont(new Font("Dialog", Font.PLAIN, 16));
			TicketNo.setForeground(Color.WHITE);
			TicketNo.setBackground(Color.GRAY);
			TicketNo.setEditable(false);
			TicketNo.setBounds(111, 97, 231, 30);
			add(TicketNo);
			TicketNo.setColumns(10);
			
			JLabel lblDeptdate = new JLabel("DeptDate:");
			lblDeptdate.setBounds(12, 234, 55, 16);
			add(lblDeptdate);
			
			depDate = new JTextField();
			depDate.setFont(new Font("Dialog", Font.PLAIN, 16));
			depDate.setForeground(Color.WHITE);
			depDate.setBackground(Color.GRAY);
			depDate.setEditable(false);
			depDate.setBounds(111, 227, 231, 30);
			add(depDate);
			depDate.setColumns(10);
			
			JLabel lblDepttime = new JLabel("DeptTime:");
			lblDepttime.setBounds(12, 276, 69, 16);
			add(lblDepttime);
			
			depTime = new JTextField();
			depTime.setFont(new Font("Dialog", Font.PLAIN, 16));
			depTime.setForeground(Color.WHITE);
			depTime.setBackground(Color.GRAY);
			depTime.setEditable(false);
			depTime.setBounds(111, 269, 231, 30);
			add(depTime);
			depTime.setColumns(10);
			
			JLabel lblCnic = new JLabel("CNIC:");
			lblCnic.setBounds(12, 318, 55, 16);
			add(lblCnic);
			
			cnic = new JTextField();
			cnic.setFont(new Font("Dialog", Font.PLAIN, 16));
			cnic.setForeground(Color.WHITE);
			cnic.setBackground(Color.GRAY);
			cnic.setEditable(false);
			cnic.setBounds(111, 311, 231, 30);
			add(cnic);
			cnic.setColumns(10);
			
			JLabel lblFrom = new JLabel("From:");
			lblFrom.setBounds(12, 146, 55, 16);
			add(lblFrom);
			
			JLabel lblTo = new JLabel("To:");
			lblTo.setBounds(12, 190, 55, 16);
			add(lblTo);
			
			from = new JTextField();
			from.setFont(new Font("Dialog", Font.PLAIN, 16));
			from.setForeground(Color.WHITE);
			from.setBackground(Color.GRAY);
			from.setEditable(false);
			from.setBounds(111, 139, 233, 30);
			add(from);
			from.setColumns(10);
			
			to = new JTextField();
			to.setFont(new Font("Dialog", Font.PLAIN, 16));
			to.setForeground(Color.WHITE);
			to.setBackground(Color.GRAY);
			to.setEditable(false);
			to.setBounds(111, 181, 231, 34);
			add(to);
			to.setColumns(10);
			lblCharges = new JLabel("Charges:");
			lblCharges.setBounds(12, 364, 55, 16);
			add(lblCharges);
			
			chargeTf = new JTextField();
			chargeTf.setFont(new Font("Dialog", Font.PLAIN, 16));
			chargeTf.setForeground(Color.WHITE);
			chargeTf.setBackground(Color.GRAY);
			chargeTf.setEditable(false);
			chargeTf.setBounds(109, 353, 233, 29);
			add(chargeTf);
			chargeTf.setColumns(10);
			try {
				ResultSet rs=dbm.getTicketView(seatNo, schId);
				rs.next();
				FlightNo.setText(rs.getString("FlightNo"));
				seatNoTf.setText(rs.getString("SeatNo"));
				TicketNo.setText(rs.getString("Ticket_No"));
				depDate.setText(rs.getString("Dep_Date"));
				depTime.setText(rs.getString("Dep_Time"));
				from.setText(rs.getString("Sourse"));
				to.setText(rs.getString("Destination"));
				cnic.setText(rs.getString("CNIC"));
				chargeTf.setText(charges);
				
				JButton btnBack = new JButton("OK");
				btnBack.setBackground(Color.GRAY);
				btnBack.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						f.setVisible(true);
						jf2.dispose();
					}
				});
				btnBack.setBounds(354, 353, 452, 26);
				add(btnBack);
				
				lblNewLabel = new JLabel("New label");
				lblNewLabel.setIcon(new ImageIcon(ViewTicket.class.getResource("/airLine/Best.jpg")));
				lblNewLabel.setBounds(353, 12, 453, 280);
				add(lblNewLabel);
	
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

	}
}
