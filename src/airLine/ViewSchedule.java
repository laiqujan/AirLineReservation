package airLine;

import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;

import net.proteanit.sql.DbUtils;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewSchedule extends JPanel {

	/**
	 * Create the panel.
	 */
	private DatabaseManagementClass dbm;
	private JTable table;
	public ViewSchedule(DatabaseManagementClass dbm, final JFrame jf, final JFrame j) {
		setBackground(Color.RED);
    this.dbm=dbm;
    setLayout(null);
    
    JScrollPane scrollPane = new JScrollPane();
    scrollPane.setBounds(0, 40, 675, 337);
    add(scrollPane);
    
    table = new JTable();
    scrollPane.setViewportView(table);
    
    JLabel lblViewSchedule = new JLabel("Schedule");
    lblViewSchedule.setFont(new Font("Dialog", Font.BOLD, 18));
    lblViewSchedule.setBounds(239, 12, 131, 16);
    add(lblViewSchedule);
    try {
		ResultSet rs=dbm.getSchedule();
		  table.setModel(DbUtils.resultSetToTableModel(rs));
		  
		  JButton btnNewButton = new JButton("");
		  btnNewButton.addActionListener(new ActionListener() {
		  	public void actionPerformed(ActionEvent arg0) {
		  		jf.setVisible(true);
		  		j.setVisible(false);
		  	}
		  });
		  btnNewButton.setBackground(Color.RED);
		  btnNewButton.setIcon(new ImageIcon(ViewSchedule.class.getResource("/airLine/back-icon.png")));
		  btnNewButton.setBounds(0, 12, 58, 16);
		  add(btnNewButton);
	} catch (SQLException e) {
	
		e.printStackTrace();
	}
	}
   
}
