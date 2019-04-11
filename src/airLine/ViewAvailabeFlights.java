package airLine;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class ViewAvailabeFlights extends JPanel {
	private JTable table;
    private DatabaseManagementClass dbm;
	/**
	 * Create the panel.
	 */
	public ViewAvailabeFlights(DatabaseManagementClass dbm) {
		this.dbm=dbm;
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 49, 456, 272);
		add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel lblAvailableFfights = new JLabel("Available Flights");
		lblAvailableFfights.setBounds(148, 12, 100, 16);
		add(lblAvailableFfights);

	}
}
