package airLine;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JLabel;

public class UserPannel extends JPanel {
	private DatabaseManagementClass dbm;

	/**
	 * Create the panel.
	 * @param jf 
	 * @param parentFrame 
	 */
	public UserPannel(final JFrame parentFrame, final JFrame jf) {
		  try {
				dbm = new DatabaseManagementClass("127.0.0.1", 1433,
						"AirLineReservation");
			} catch (ClassNotFoundException e) {
			
				//e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Plz Enter Correct Arguments");
			} catch (SQLException e) {

				//e.printStackTrace();
				JOptionPane.showMessageDialog(null,"Plz Enter Correct Arguments");
			}
		setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Forte", Font.BOLD, 24));
		menuBar.setForeground(new Color(51, 0, 102));
		menuBar.setBackground(Color.RED);
		menuBar.setBounds(0, 0, 802, 39);
		add(menuBar);
		
		JMenu Home = new JMenu("Home");
		Home.setForeground(Color.WHITE);
		Home.setFont(new Font("Dialog", Font.BOLD, 18));
		Home.setIcon(new ImageIcon(UserPannel.class.getResource("/airLine/Home-icon.png")));
		menuBar.add(Home);
		
		JMenuItem mntmLogout = new JMenuItem("Logout");
		mntmLogout.setIcon(new ImageIcon(UserPannel.class.getResource("/airLine/Log-Out-icon.png")));
		mntmLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jf.setVisible(false);
				parentFrame.setVisible(true);
				
			}
		});
		Home.add(mntmLogout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		mntmExit.setIcon(new ImageIcon(UserPannel.class.getResource("/airLine/user-business-close-icon.png")));
		Home.add(mntmExit);
		
		JMenu mnNewMenu = new JMenu("Book Flight");
		mnNewMenu.setIcon(new ImageIcon(UserPannel.class.getResource("/airLine/buy-now-icon.png")));
		mnNewMenu.setForeground(Color.WHITE);
		mnNewMenu.setFont(new Font("Dialog", Font.BOLD, 18));
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Search");
		mntmNewMenuItem.setIcon(new ImageIcon(UserPannel.class.getResource("/airLine/Search-icon.png")));
		mntmNewMenuItem.addActionListener(new ActionListener() {
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
		mnNewMenu.add(mntmNewMenuItem);
		
		JMenu mnNewMenu_1 = new JMenu("Schedule");
		mnNewMenu_1.setIcon(new ImageIcon(UserPannel.class.getResource("/airLine/Calendar-icon.png")));
		mnNewMenu_1.setFont(new Font("Dialog", Font.BOLD, 18));
		mnNewMenu_1.setForeground(Color.WHITE);
		mnNewMenu_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jf.setVisible(false);
					JFrame j = new JFrame();
				j.setSize(673, 378);
				ViewSchedule de = new ViewSchedule(dbm,jf,j);
				j.setResizable(false);
				j.getContentPane().add(de);
				j.setVisible(true);
              
			
			}
		});
		mnNewMenu_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jf.setVisible(false);
				JFrame j = new JFrame();
				j.setSize(673, 378);
				ViewSchedule de = new ViewSchedule(dbm,jf,j);
				j.getContentPane().add(de);
				j.setVisible(true);
			}
		});
		menuBar.add(mnNewMenu_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(UserPannel.class.getResource("/airLine/Airbus A330-343X  Thai Airways International HS-TEU (cn 1090)  Phuket (HKT- VTSP) Thailand, November 25, 2011.jpg")));
		lblNewLabel.setBounds(0, 35, 802, 427);
		add(lblNewLabel);

	}
}
