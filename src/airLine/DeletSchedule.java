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
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class DeletSchedule extends JPanel {

	private DatabaseManagementClass dbm;
	private int routeId;
	private float distance;
	private String flightclass;
	private String from;
	private String to;
	private JTextField idTf;

	public DeletSchedule(final DatabaseManagementClass dbm, final JFrame jf, final Home frame) {
		setBackground(Color.GRAY);
		this.dbm=dbm;
		frame.setVisible(false);
		setLayout(null);
	   JLabel lblEnterScheduleId = new JLabel("Enter Schedule Id:");
		lblEnterScheduleId.setForeground(Color.WHITE);
		lblEnterScheduleId.setFont(new Font("Dialog", Font.BOLD, 14));
		lblEnterScheduleId.setBounds(0, 48, 155, 16);
		add(lblEnterScheduleId);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setIcon(new ImageIcon(DeletSchedule.class.getResource("/airLine/Delete-icon.png")));
		btnDelete.setBackground(Color.GRAY);
		btnDelete.setForeground(Color.WHITE);
		btnDelete.setFont(new Font("Dialog", Font.BOLD, 30));
		btnDelete.setBounds(23, 99, 307, 26);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(DeletSchedule.class.getResource("/airLine/delet sh.jpg")));
		lblNewLabel.setBounds(341, 42, 225, 225);
		add(lblNewLabel);
		
		idTf = new JTextField();
		idTf.setBackground(Color.GRAY);
		idTf.setBounds(141, 47, 189, 26);
		add(idTf);
		idTf.setColumns(10);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					int id=Integer.parseInt(idTf.getText());
					boolean r=dbm.deletSchedule(id);
					JOptionPane.showMessageDialog(null, "Schedule Deleted");
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
				}
			}
		});
		add(btnDelete);
		
		JButton button = new JButton("Back");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				jf.dispose();
			}
		});
		button.setIcon(new ImageIcon(DeletSchedule.class.getResource("/airLine/back-icon.png")));
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Dialog", Font.BOLD, 30));
		button.setBackground(Color.GRAY);
		button.setBounds(23, 140, 307, 28);
		add(button);

		
	





	}
}
