package airLine;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;

public class User extends JPanel {
	private DatabaseManagementClass dbm;
	LoginPanel loginP ;
	public User(JFrame parentFrame, final JFrame jf) {
	
		jf.setVisible(true);
		
	
    try {
			dbm = new DatabaseManagementClass("127.0.0.1", 1433,
					"AirLineReservation");
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}	
		
		jf.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 12, 450, 23);
		jf.add(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		menuBar.add(mnHome);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnHome.add(mntmExit);
		
		JMenu mnSearchflights = new JMenu("BookFlight");
		menuBar.add(mnSearchflights);
		
		JMenuItem mntmSearch = new JMenuItem("Search");
		mntmSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jf.setVisible(false);
				
				JFrame jf1=new JFrame();
				jf1.setSize(530, 530);
				jf1.setTitle("Avialable Flights");
				SearchFlight de = new SearchFlight(dbm,jf,jf1);
				jf1.getContentPane().add(de);
				jf1.setVisible(true);
				
			}
		});
		mnSearchflights.add(mntmSearch);
		
		JMenu mnSchedule = new JMenu("Schedule");
		menuBar.add(mnSchedule);
		
		JMenuItem mntmView = new JMenuItem("View");
		mntmView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			 
						
			}
		});
		mnSchedule.add(mntmView);

	}
}
