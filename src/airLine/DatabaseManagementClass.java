package airLine;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class DatabaseManagementClass {
	private String connectionURL;
	private Connection con;
	private java.sql.Statement stmt;
	private String query;
	ResultSet rs;

	public DatabaseManagementClass(String serverName, int portNumber,
			String databaseName) throws ClassNotFoundException, SQLException {
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		connectionURL = "jdbc:sqlserver://" + serverName + ":" + portNumber
				+ ";" + "databaseName=" + databaseName + ";"
				+ "username=sa;password=laiqujan;";
		con = DriverManager.getConnection(connectionURL);
	}

	public void closeConnection() throws SQLException {
		con.close();
	}

	public void SignUp(String name, String email, String pasword)
			throws SQLException {
		stmt = null;

		query = "insert into Userlogin(Username,Email,Pasword) values" + "('"
				+ name + "','" + email + "','" + pasword + "')";

		stmt = con.createStatement();
		stmt.execute(query);

	}

	public ResultSet getLogin() throws SQLException {
		stmt = null;
		query = "select * from Userlogin";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getAgents() throws SQLException {
		stmt = null;
		query = "select  *from seeAgent";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getSchedule() throws SQLException {
		stmt = null;
		query = "select  * from seeSchedule";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getTicketView(int seatno, int schId) throws SQLException {
		stmt = null;
		query = "Select FlightNo,Ticket_No,SeatNo,Sourse,Destination,DeP_Date,Dep_Time,CNIC from TICKET,SCHEDULE "
				+ "where SeatNo='"
				+ seatno
				+ "'and SCHEDULE.Schedule_ID='"
				+ schId + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getFlight() throws SQLException {
		stmt = null;
		query = "select * from FLIGHT";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getAirport() throws SQLException {
		stmt = null;
		query = "select  * from AIRPORT";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public boolean addAirport(String name, String city, String country)
			throws SQLException {
		stmt = con.createStatement();
		boolean r = stmt
				.execute("insert into AIRPORT(Airport_Name,City,Country) values"
						+ "('" + name + "','" + city + "','" + country + "')");
		return r;

	}

	public boolean addSchedule(int schId, int routeNo, String flightNo,
			String from, String to, String depDate, String arrDate,
			String depTime, String arrTime) throws SQLException {

		stmt = con.createStatement();
		boolean r = stmt
				.execute("insert into SCHEDULE(Schedule_ID,Route_No ,Arr_Date,Dep_Date,Dep_Time,Arr_Time,Sourse,Destination,FlightNo) values"
						+ "('"
						+ schId
						+ "','"
						+ routeNo
						+ "','"
						+ arrDate
						+ "','"
						+ depDate
						+ "','"
						+ depTime
						+ "','"
						+ arrTime
						+ "','" + from + "','" + to + "','" + flightNo + "')");
		return r;
	}

	public void updateSchedule(int schId, String depDate, String arrDate,
			String depTime, String arrTime) throws SQLException {
		stmt = null;
		query = "exec sp_updateSchedule  '" + schId + "','" + depDate + "','"
				+ arrDate + "' ,'" + depTime + "','" + arrTime + "'";
		stmt = con.createStatement();
		stmt.executeUpdate(query);
	}

	public ResultSet getRoute() throws SQLException {
		stmt = null;
		query = "select * from FLIGHT_ROUTE";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getRouteinfo(String rn) throws SQLException {
		stmt = null;
		int id = Integer.parseInt(rn);
		query = "select * from FLIGHT_ROUTE where Route_No=" + id;
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public boolean addFlight(String FlightNo, int Seats) throws SQLException {
		stmt = null;
		query = "exec sp_addFlights'" + FlightNo + "','" + Seats + "'";
		// query = "INSERT into FLIGHT(FlightNo,Seats) values" + "('" + FlightNo
		// + "','" + Seats + "')";
		stmt = con.createStatement();
		boolean r = stmt.execute(query);
		return r;

	}

	public boolean deletSchedule(int id) throws SQLException {
		stmt = null;

		query = "exec sp_deletSchedule'" + id + "' ";
		stmt = con.createStatement();
		boolean r = stmt.execute(query);
		return r;

	}

	public ResultSet getFlight(String flightNo) throws SQLException {

		stmt = null;
		query = "select *from FLIGHT where cId='" + flightNo + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public boolean addRoute(int rNo, String from, String to, double dis)
			throws SQLException {
		stmt = con.createStatement();
		boolean r = stmt
				.execute("insert into Flight_Route(Route_No,Sourse,Destination,Route_Dis) values"
						+ "('"
						+ rNo
						+ "','"
						+ from
						+ "','"
						+ to
						+ "','"
						+ dis
						+ "')");
		return r;
	}

	public void addSeats(int SeatNo, String seatclass, String Seat_Status,
			String deptdate, float charge, String flightno) throws SQLException {
		stmt = null;

		query = "	insert into SEAT(SeatNo,class,Seat_Status,deptdate,Charges,FlightNo) values"
				+ "('"
				+ SeatNo
				+ "','"
				+ seatclass
				+ "','"
				+ Seat_Status
				+ "','" + deptdate + "','" + charge + "','" + flightno + "')";
		stmt = con.createStatement();
		stmt.execute(query);

	}

	public void bookTicket(int SeatNo, String ticketStatus, String flightno,
			String cnic, String schId) throws SQLException {
		stmt = null;
		query = "insert into BOOK_TICKET(Ticket_No,SeatNo,Ticket_Status,FlightNo,CNIC,Schedule_ID) values"
				+ "('"
				+ SeatNo
				+ "','"
				+ ticketStatus
				+ "','"
				+ flightno
				+ "','" + cnic + "','" + schId + "')";
		stmt = con.createStatement();
		stmt.execute(query);

	}

	public void addCustomer(String name, String add, String dob, String cnic,
			String email, String contactNo, String contacttype, String gender)
			throws SQLException {
		stmt = null;
		String query1 = "insert into CONTACT(CNIC,EmailID,ContactNo,ContactType) Values"
				+ "('"
				+ cnic
				+ "','"
				+ email
				+ "','"
				+ contactNo
				+ "','"
				+ contacttype + "')";

		query = "insert into CUSTOMERS(Name,CAddress,Gender,DOB,CNIC) values"
				+ "('" + name + "','" + add + "','" + gender + "','" + dob
				+ "','" + cnic + "')";
		stmt = con.createStatement();
		stmt.execute(query1);
         stmt.execute(query);
	
	}

	public ResultSet getSeatNo(String flightno, String to, String date)
			throws SQLException {

		stmt = null;
		query = "select Sourse,Destination,Dep_Date,Arr_Date,Arr_Time,Dep_Time,FlightNo from SCHEDULE where Sourse='"
				+ "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getReserved(String flightno) throws SQLException {
		String st = "1";
		stmt = null;
		query = "Select count(Ticket_Status) as totalSeats from BOOK_TICKET where FlightNo='"
				+ flightno + "' and Ticket_Status='" + st + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet gettotalSeats(String flightno, String seatClass,
			String depdate) throws SQLException {
		stmt = null;
		query = "Select  from SEAT where class='" + seatClass
				+ "' and Flightno='" + flightno + "' and depdate='" + depdate
				+ "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getSchedule(String from, String to, String date)
			throws SQLException {

		stmt = null;
		query = "select FlightNo,Sourse,Destination,Dep_Date,Arr_Date,Dep_Time,Arr_Time from SCHEDULE where Sourse='"
				+ from
				+ "'and Destination ='"
				+ to
				+ "'and Dep_date='"
				+ date
				+ "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public String[] getSearchedFlight(String from, String to, String date)
			throws SQLException {
		int i = 0;
		stmt = null;
		query = "select FlightNo from SCHEDULE where Sourse='" + from
				+ "'and Destination ='" + to + "'and Dep_date='" + date + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		int length = stmt.getFetchSize();
		String[] std = new String[length];
		boolean isRecord;
		do {
			isRecord = rs.next();
			if (isRecord && i < length) {
				std[i] = rs.getString("FlightNo");
				i++;
			}
		} while (isRecord);
		return std;
	}

	public ResultSet getScheduleId(String from, String to, String date,
			String flight) throws SQLException {

		stmt = null;
		query = "select Schedule_ID from SCHEDULE where Sourse='" + from
				+ "'and Destination ='" + to + "'and Dep_date='" + date
				+ "'and FlightNo='" + flight + "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getAllSchedule() throws SQLException {

		stmt = null;
		query = "select * from SCHEDULE where Dep_Date between ";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public ResultSet getAvailableSeat(String flightno, String seatClass,
			String depdate) throws SQLException {
		stmt = null;
		query = "Select  Seat_Status from SEAT where Flightno='" + flightno
				+ "'and deptdate='" + depdate + "'and class='" + seatClass
				+ "'";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

	public void updateSeat(String flightno, String seatClass, String depdate,
			int totalSeats, String Seat_Status) throws SQLException {
		stmt = null;
		String St = "Res";

		query = "UPDATE SEAT SET  Seat_Status='"
				+ St
				+ "' where  Flightno='"
				+ flightno
				+ "'and deptdate='"
				+ depdate
				+ "'and class='"
				+ seatClass
				+ "'"
				+ "and (Select Count(*)  as Total from SEAT where Seat_Status='"
				+ St + "' and Flightno='" + flightno + "' and class ='"
				+ seatClass + "' and deptdate='" + depdate + "')<='"
				+ totalSeats + "'";
		stmt = con.createStatement();
		stmt.executeUpdate(query);

	}

	public void updateseat(String flightno, String seatClass, String depdate,
			int seatno) throws SQLException {
		stmt = null;
		String St = "Res";

		query = "UPDATE SEAT SET  Seat_Status='" + St + "' where  Flightno='"
				+ flightno + "'and deptdate='" + depdate + "'and class='"
				+ seatClass + "'and SeatNo='" + seatno + "'";
		stmt = con.createStatement();
		stmt.executeUpdate(query);

	}

	public void addTicket(int i, String bookdate, String cnic, int schId)
			throws SQLException {
		stmt = null;
		query = "Insert into TICKET(SeatNo,Booking_Date,CNIC,Schedule_ID) values('"
				+ i + "','" + bookdate + "','" + cnic + "','" + schId + "')";
		stmt = con.createStatement();
		stmt.executeUpdate(query);

	}

	public ResultSet minseatNo(String flightno, String seatClass,
			String dep_date, int total_Seat) throws SQLException {
		int s;
		String St = "UnRes";
		stmt = null;

		query = " select min(SeatNo) as mSeat from Seat where Seat_Status='"
				+ St + "' and Flightno='" + flightno + "' and class ='"
				+ seatClass + "' and deptdate='" + dep_date + "'";
		stmt = con.createStatement();

		ResultSet rs = stmt.executeQuery(query);

		return rs;

	}

	public ResultSet getSeatSet() throws SQLException {

		stmt = null;
		query = "select * from SEAT  ";
		stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(query);
		return rs;

	}

}
