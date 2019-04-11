package airLine;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.SQLException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;

public class Home extends JFrame {

	private JPanel contentPane;
	private static DatabaseManagementClass dbm;
	static Home frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					  frame = new Home();
					  frame.setSize(800, 465);

					frame.setResizable(false);

					JFrame loginFrame = new JFrame();
					loginFrame.setTitle("Login Dialog");
			
					LoginPanel loginP = new LoginPanel(frame, loginFrame, dbm);
					loginP.setBorder(new EmptyBorder(5, 5, 5, 5));
					loginFrame.setContentPane(loginP);
					frame.setTitle("Admin Home");

					loginFrame.setSize(1080	, 520);
					loginFrame.setVisible(true);
					loginFrame.setResizable(false);
					// loginFrame.setBounds(400, 80, 450, 450);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Home() {
		setTitle("Admin");
		setIconImage(Toolkit.getDefaultToolkit().getImage(Home.class.getResource("/airLine/Air-Plane-icon.png")));
		setResizable(false);

		try {
			dbm = new DatabaseManagementClass("127.0.0.1", 1433,
					"AirLineReservation");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 797, 462);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.WHITE);
		menuBar.setBackground(Color.RED);
		setJMenuBar(menuBar);
		
		JMenu mnHome = new JMenu("Home");
		mnHome.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnHome.setForeground(Color.WHITE);
		mnHome.setIcon(new ImageIcon(Home.class.getResource("/airLine/Home-icon.png")));
		menuBar.add(mnHome);
		
		JMenuItem mntmViewAgents = new JMenuItem("View Agents");
		mntmViewAgents.setIcon(new ImageIcon(Home.class.getResource("/airLine/22.png")));
		mntmViewAgents.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf = new JFrame();
				jf.setSize(480, 335);
				jf.setTitle("Agent List");
				AgentsList de = new AgentsList(dbm,jf,frame);
				jf.getContentPane().add(de);
				jf.setVisible(true);
			}
		});
		mnHome.add(mntmViewAgents);
		
		JMenuItem mntmExit = new JMenuItem("Log Out");
		mntmExit.setIcon(new ImageIcon(Home.class.getResource("/airLine/Log-Out-icon.png")));
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				 

				frame.setResizable(false);

				JFrame loginFrame = new JFrame();
				loginFrame.setTitle("Login Dialog");
				 

				LoginPanel loginP = new LoginPanel(frame, loginFrame, dbm);
				loginP.setBorder(new EmptyBorder(5, 5, 5, 5));
				loginFrame.setContentPane(loginP);

				loginFrame.setSize(1080	, 520);
				loginFrame.setVisible(true);
				loginFrame.setResizable(false);
			 
			}
		});
		mnHome.add(mntmExit);

		JMenu mnFlight = new JMenu("Flight");
		mnFlight.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnFlight.setForeground(Color.WHITE);
		mnFlight.setIcon(new ImageIcon(Home.class.getResource("/airLine/Air-tickets-icon.png")));
		menuBar.add(mnFlight);

		JMenuItem mntmAddFlights = new JMenuItem("Add Flights");
		mntmAddFlights.setIcon(new ImageIcon(Home.class.getResource("/airLine/Add-item-icon.png")));
		mntmAddFlights.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				frame.setVisible(false);
				JFrame jf = new JFrame();
				jf.setSize(833, 357);
				jf.setResizable(false);
				Flight de = new Flight(dbm, jf,frame);
				jf.getContentPane().add(de);
				jf.setVisible(true);
			}
		});
		mnFlight.add(mntmAddFlights);

		JMenu mnAddSchedule = new JMenu(" Schedule");
		mnAddSchedule.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnAddSchedule.setForeground(Color.WHITE);
		mnAddSchedule.setIcon(new ImageIcon(Home.class.getResource("/airLine/Calendar-icon.png")));
		menuBar.add(mnAddSchedule);

		JMenuItem mntmAddScedule = new JMenuItem("Add Scedule");
		mntmAddScedule.setIcon(new ImageIcon(Home.class.getResource("/airLine/Add-item-icon.png")));
		mntmAddScedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf = new JFrame();
				jf.setSize(700, 700);
				jf.setTitle(" Add Schedule");
				Schedule de = new Schedule(dbm, jf,frame);
				jf.getContentPane().add(de);
				jf.setVisible(true);
			}
		});
		mnAddSchedule.add(mntmAddScedule);

		JMenuItem mntmUpdateScedule = new JMenuItem("Update Scedule");
		mntmUpdateScedule.setIcon(new ImageIcon(Home.class.getResource("/airLine/comment-edit-icon.png")));
		mntmUpdateScedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf = new JFrame();
				jf.setSize(700, 700);
				jf.setTitle(" Update Schedule");
				Schedule de = new Schedule(dbm, jf,frame);
				jf.getContentPane().add(de);
				jf.setVisible(true);
			}
		});
		mnAddSchedule.add(mntmUpdateScedule);
		
		JMenuItem mntmSearchSchedule = new JMenuItem("Search Schedule");
		mntmSearchSchedule.setIcon(new ImageIcon(Home.class.getResource("/airLine/Search-icon.png")));
		mntmSearchSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jf = new JFrame();
				jf.setSize(700, 700);
				jf.setTitle(" Search Schedule");
				AdSearchFlight	de = new AdSearchFlight(dbm, jf,frame);
				jf.getContentPane().add(de);
				jf.setVisible(true);
			}
		});
		mnAddSchedule.add(mntmSearchSchedule);
		
		JMenuItem mntmDeleteSchedule = new JMenuItem("Delete Schedule");
		mntmDeleteSchedule.setIcon(new ImageIcon(Home.class.getResource("/airLine/Delete-icon.png")));
		mntmDeleteSchedule.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame jf = new JFrame();
				jf.setSize(578, 300);
				jf.setTitle(" Delete Schedule");
				jf.setResizable(false);
				DeletSchedule	de = new DeletSchedule(dbm, jf,frame);
				jf.getContentPane().add(de);
				jf.setVisible(true);
			}
		});
		mnAddSchedule.add(mntmDeleteSchedule);

		JMenu mnAirports = new JMenu("Airports");
		mnAirports.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnAirports.setForeground(Color.WHITE);
		mnAirports.setIcon(new ImageIcon(Home.class.getResource("/airLine/Air-Plane-icon.png")));
		menuBar.add(mnAirports);

		JMenuItem mntmAddAirports = new JMenuItem("Add Airports");
		mntmAddAirports.setIcon(new ImageIcon(Home.class.getResource("/airLine/Add-item-icon.png")));
		mntmAddAirports.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf = new JFrame();
				jf.setSize(700, 700);
				Airport de = new Airport(dbm, jf,frame);
				jf.getContentPane().add(de);
				jf.setVisible(true);
			}
		});
		mnAirports.add(mntmAddAirports);
		
		JMenu mnRoute = new JMenu("Route");
		mnRoute.setFont(new Font("Tahoma", Font.BOLD, 16));
		mnRoute.setForeground(Color.WHITE);
		mnRoute.setIcon(new ImageIcon(Home.class.getResource("/airLine/Map-Marker-Marker-Outside-Azure-icon.png")));
		menuBar.add(mnRoute);
		
		JMenuItem mntmAddRoute = new JMenuItem("Add Route");
		mntmAddRoute.setIcon(new ImageIcon(Home.class.getResource("/airLine/Add-item-icon.png")));
		mntmAddRoute.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame jf = new JFrame();
				jf.setSize(838, 275);
				jf.setResizable(false);
				jf.setTitle("Route");
				Route de = new Route(dbm, jf,frame);
				jf.getContentPane().add(de);
				jf.setVisible(true);
				
				
			}
		});
		mnRoute.add(mntmAddRoute);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		//lblNewLabel.setIcon(new ImageIcon(Home.class.getResource("/airLine/Airbus A330-341  Garuda Indonesia PK-GPA (cn 138)  Sydney - Kingsford Smith International (Mascot) (SYD-YSSY) Australia - New South Wales, May 2011  Beautiful livery, complement well with the sea colour..jpg")));
		lblNewLabel.setBounds(0, 0, 825, 446);
		contentPane.add(lblNewLabel);
	}

	public DatabaseManagementClass getDbm() {
		return dbm;
	}
}
