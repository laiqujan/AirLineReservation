package airLine;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgentsList extends JPanel {
	private JTable table;
	private DatabaseManagementClass dbm;

	/**
	 * Create the panel.
	 * @param dbm 
	 * @param frame 
	 * @param jf 
	 */
	public AgentsList(DatabaseManagementClass dbm, final JFrame jf, final Home frame) {
		setBackground(Color.GRAY);
		this.dbm=dbm;
		setLayout(null);
		frame.setVisible(false);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 56, 361, 198);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAllAgents = new JLabel("All Agents");
		lblAllAgents.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAllAgents.setForeground(Color.BLUE);
		lblAllAgents.setBackground(Color.RED);
		lblAllAgents.setBounds(141, 16, 150, 29);
		add(lblAllAgents);
		ResultSet rs;
		try {
			rs = dbm.getAgents();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton button = new JButton("Back");
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					jf.dispose();
					frame.setVisible(true);
				}
			});
			button.setIcon(new ImageIcon(AgentsList.class.getResource("/airLine/back-icon.png")));
			button.setFont(new Font("Dialog", Font.BOLD, 26));
			button.setBackground(Color.GRAY);
			button.setForeground(Color.WHITE);
			button.setBounds(53, 266, 341, 26);
			add(button);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Plz Input Correct Arguement");
		}
	}
}
