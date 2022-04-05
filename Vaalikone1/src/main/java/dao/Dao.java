package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Candidates;

import java.sql.Connection;

public class Dao {
	private String url;
	private String user;
	private String pass;
	private Connection conn;
	
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	//Pyydet��n ottamaan yhteys
	public boolean getConnection() {
		try {
	        if (conn == null || conn.isClosed()) {
	            try {
	                Class.forName("com.mysql.jdbc.Driver").newInstance();
	            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
	                throw new SQLException(e);
	            }
	            conn = DriverManager.getConnection(url, user, pass);
	        }
	        return true;
		}
		catch (SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		
		//Luetaan kaikki ehdokkaat taulusta
	}
	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list=new ArrayList<>();
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery("select * from ehdokkaat");
			while (RS.next()){
				Candidates f=new Candidates();
				f.setId(RS.getInt("ehdokas_id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setPuolue(RS.getString("puolue"));
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
		
		//P�ivitet��n tietoja
	}
	public ArrayList<Candidates> updateCandidates(Candidates f) {
		try {
			String sql="update ehdokkaat set sukunimi=? where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getSukunimi());
			pstmt.setString(2, f.getEtunimi());
			pstmt.setString(3, f.getPuolue());
			pstmt.setInt(4, f.getId());
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
		
		//Lis�t��n tietoja T�M� ON KESKEN
		}
		public ArrayList<Candidates> addCandidates(Candidates f) {
			try {
				String sql="insert into ehdokkaat set sukunimi=? where ehdokas_id=? set etunimi=? set puolue=?";
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, f.getSukunimi());
				pstmt.setString(2, f.getEtunimi());
				pstmt.setString(3, f.getPuolue());
				pstmt.setInt(4, f.getId());
				pstmt.executeUpdate();
				return readAllCandidates();
			}
			catch(SQLException e) {
				return null;
			}
			
		// Poistetaan tietoja
	}
	public ArrayList<Candidates> deleteCandidates(String id) {
		try {
			String sql="delete from ehdokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	// Luetaan tietoja

	public Candidates readCandidates(String id) {
		Candidates f=null;
		try {
			String sql="select * from ehokkaat where ehdokas_id=?";
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Candidates();
				f.setId(RS.getInt("id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setPuolue(RS.getString("puolue"));
			}
			return f;
		}
		catch(SQLException e) {
			return null;
		}
	}
}
