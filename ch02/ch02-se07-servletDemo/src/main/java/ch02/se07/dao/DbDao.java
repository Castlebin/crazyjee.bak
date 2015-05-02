package ch02.se07.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DbDao {	
	private Connection conn;
	private String driver;
	private String url;
	private String username;
	private String password;
	
	// insert
	public boolean insert(String sql, Object... args) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = getConn().prepareStatement(sql);
		for(int i=0; i<args.length; i++) {
			pstmt.setObject(i+1, args[i]);
		}
		if(pstmt.executeUpdate() != 1) {
			return false;
		}
		
		return true;
	}
	
	// query
	public ResultSet query(String sql, Object... args) throws SQLException, ClassNotFoundException {
		PreparedStatement pstmt = getConn().prepareStatement(sql);
		for(int i=0; i<args.length; i++) {
			pstmt.setObject(i+1, args[i]);
		}
		
		return pstmt.executeQuery();
	}
	
	public DbDao(String driver, String url, String username, String password) {
		this.driver = driver;
		this.url = url;
		this.username = username;
		this.password = password;
	}
	public Connection getConn() throws ClassNotFoundException, SQLException {
		if(conn == null) {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, username, password);
		}
		
		return conn;
	}
	public String getDriver() {
		return driver;
	}
	public void setDriver(String driver) {
		this.driver = driver;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

}
