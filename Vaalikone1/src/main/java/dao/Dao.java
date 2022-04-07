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
	
	// Luo yhteys tietokantaan rakentajassa
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	//Pyydet‰‰n ottamaan yhteys
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
	
		
	}
		//Luetaan kaikki ehdokkaat taulusta
	
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
				f.setKunta(RS.getString("kotipaikkakunta"));
				f.setPuolue(RS.getString("puolue"));
				f.setAmmatti(RS.getString("ammatti"));
				f.setMiksi(RS.getString("miksi_eduskuntaan"));
				f.setMita(RS.getString("mita_asioita_haluat_edistaa"));
			
				list.add(f);
			}
			return list;
		}
		catch(SQLException e) {
			return null;
		}
		
	}
		//P‰ivitet‰‰n tietoja
	
	public ArrayList<Candidates> updateCandidates(Candidates f) {
		String sql="update ehdokkaat set "
				+ " sukunimi=?, etunimi=?, kotipaikkakunta=?, puolue=?, ammatti=? "
				+ ", miksi_eduskuntaan=?, mita_asioita_haluat_edistaa=? where ehdokas_id=?";
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getSukunimi());
			pstmt.setString(2, f.getEtunimi());
			pstmt.setString(3, f.getKunta());
			pstmt.setString(4, f.getPuolue());
			pstmt.setString(5, f.getAmmatti());
			pstmt.setString(6, f.getMiksi());
			pstmt.setString(7, f.getMita());
			pstmt.setInt(8, f.getId());
			pstmt.executeUpdate();
			return readAllCandidates();
		}
		catch(SQLException e) {
			System.out.println(String.format("Virhe ehdokkaan muokkaamisessa:%s,%s", sql,e.toString()));
			return null;
		}
		
	}
		//Lis‰t‰‰n tietoja
	
		public ArrayList<Candidates> addCandidates(Candidates f) {
			String sql="insert into ehdokkaat"
					+ "(ehdokas_id ,sukunimi, etunimi, kotipaikkakunta, puolue, ammatti,"
					+ "miksi_eduskuntaan, mita_asioita_haluat_edistaa) VALUES (?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, f.getId());
				pstmt.setString(2, f.getSukunimi());
				pstmt.setString(3, f.getEtunimi());
				pstmt.setString(4, f.getKunta());
				pstmt.setString(5, f.getPuolue());
				pstmt.setString(6, f.getAmmatti());
				pstmt.setString(7, f.getMiksi());
				pstmt.setString(8, f.getMita());
				pstmt.executeUpdate();
				return readAllCandidates();
			}
			catch(SQLException e) {
				System.out.println(String.format("Virhe ehdokkaan lis‰‰misess‰:%s,%s", sql,e.toString()));
				return null;
			}
		
	}
			// Poistetaan tietoja
		
		public ArrayList<Candidates> deleteCandidates(String id) {
			String sql="delete from ehdokkaat where ehdokas_id=?";
			
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql); // prepare valmistele kysely
				pstmt.setString(1, id); // aseta tietokantakyselyn indeksi
				pstmt.executeUpdate(); // p‰ivit‰ taulu
				return readAllCandidates(); // n‰yt‰ p‰ivitetty taulu, viesti p‰ivityksen onnistumisest‰ riitt‰‰
			}
			catch(SQLException e) {
				System.out.println(String.format("Virhe ehdokkaan poistamisessa:%s,%s", sql,e.toString()));
			return null;
			}
	}
	
	// Luetaan tietoja

	public Candidates readCandidates(String id) {
		Candidates f=null;
		String sql="select * from ehokkaat where ehdokas_id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Candidates();
				f.setId(RS.getInt("id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setKunta(RS.getString("kotipaikkakunta"));
				f.setPuolue(RS.getString("puolue"));
				f.setAmmatti(RS.getString("ammatti"));
				f.setMiksi(RS.getString("miksi_eduskuntaan"));
				f.setMita(RS.getString("mita_asioita_haluat_edistaa"));

			}
			return f;
		}
		catch(SQLException e) {
			System.out.println(String.format("Virhe tietojen hakemisessa:%s,%s", sql,e.toString()));
			return null;
		}
	}
}
