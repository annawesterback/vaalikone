package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Candidates;
import data.Questions;

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
	
		
	}
		//Luetaan kaikki ehdokkaat taulusta
	
	public ArrayList<Candidates> readAllCandidates() {
		ArrayList<Candidates> list=new ArrayList<>();
		String sql = "select * from ehdokkaat";
		try {
			Statement stmt=conn.createStatement();
			ResultSet RS=stmt.executeQuery(sql);
			while (RS.next()){
				Candidates f=new Candidates();
				f.setId(RS.getInt("ehdokas_id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setIka(RS.getInt("ika"));
				f.setKunta(RS.getString("kotipaikkakunta"));
				f.setPuolue(RS.getString("puolue"));
				f.setAmmatti(RS.getString("ammatti"));
				f.setMiksi(RS.getString("miksi_eduskuntaan"));
				f.setMita(RS.getString("mita_asioita_haluat_edistaa"));
			
				list.add(f);
			}
			RS.close();
			stmt.close();
			conn.close();
			return list;
		}
		catch(SQLException e) {
			System.out.println(String.format("Virhe kyselyss�: %s, %s", sql,e.toString()));
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		
	}
		//P�ivitet��n tietoja
	
	public ArrayList<Candidates> updateCandidates(Candidates f) {
		String sql="update ehdokkaat set "
				+ " sukunimi=?, etunimi=?, ika=?, kotipaikkakunta=?, puolue=?, ammatti=? "
				+ ", miksi_eduskuntaan=?, mita_asioita_haluat_edistaa=? where ehdokas_id=?";
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getSukunimi());
			pstmt.setString(2, f.getEtunimi());
			pstmt.setInt(3, f.getIka());
			pstmt.setString(4, f.getKunta());
			pstmt.setString(5, f.getPuolue());
			pstmt.setString(6, f.getAmmatti());
			pstmt.setString(7, f.getMiksi());
			pstmt.setString(8, f.getMita());
			pstmt.setInt(9, f.getId());
			pstmt.executeUpdate();
		
			pstmt.close();
			conn.close();
			return readAllCandidates();
		}
		catch(SQLException e) {
			System.out.println(String.format("Virhe ehdokkaan muokkaamisessa: %s, %s", sql,e.toString()));
			try {
				conn.close();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			return null;
		}
		
	}
		//Lis�t��n tietoja
	
		public ArrayList<Candidates> addCandidates(Candidates f) {
			String sql="insert into ehdokkaat"
					+ "(ehdokas_id ,sukunimi, etunimi, ika, kotipaikkakunta, puolue, ammatti,"
					+ "miksi_eduskuntaan, mita_asioita_haluat_edistaa) VALUES (?,?,?,?,?,?,?,?,?)";
			try {
				
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, f.getId());
				pstmt.setString(2, f.getSukunimi());
				pstmt.setString(3, f.getEtunimi());
				pstmt.setInt(4, f.getIka());
				pstmt.setString(5, f.getKunta());
				pstmt.setString(6, f.getPuolue());
				pstmt.setString(7, f.getAmmatti());
				pstmt.setString(8, f.getMiksi());
				pstmt.setString(9, f.getMita());
				pstmt.executeUpdate();
				
				pstmt.close();
				conn.close();
				return readAllCandidates();
			}
			catch(SQLException e) {
				System.out.println(String.format("Virhe ehdokkaan lis��misess�: %s, %s", sql,e.toString()));
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				return null;
			}
		
	}
			// Poistetaan tietoja
		
		public ArrayList<Candidates> deleteCandidates(String id) {
			String sql="delete from ehdokkaat where ehdokas_id=?";
			
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql); // prepare valmistele kysely
				pstmt.setString(1, id); // aseta tietokantakyselyn indeksi
				pstmt.executeUpdate(); // p�ivit� taulu
				
				return readAllCandidates(); // n�yt� p�ivitetty taulu, viesti p�ivityksen onnistumisest� riitt��
			}
			catch(SQLException e) {
				System.out.println(String.format("Virhe ehdokkaan poistamisessa: %s, %s", sql,e.toString()));
				try {
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			return null;
			}
	}
	
	// Luetaan tietoja

	public Candidates readCandidates(String id) {
		Candidates f=null;
		String sql="select * from ehdokkaat where ehdokas_id=?";
		try {
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet RS=pstmt.executeQuery();
			while (RS.next()){
				f=new Candidates();
				f.setId(RS.getInt("ehdokas_id"));
				f.setSukunimi(RS.getString("sukunimi"));
				f.setEtunimi(RS.getString("etunimi"));
				f.setIka(RS.getInt("ika"));
				f.setKunta(RS.getString("kotipaikkakunta"));
				f.setPuolue(RS.getString("puolue"));
				f.setAmmatti(RS.getString("ammatti"));
				f.setMiksi(RS.getString("miksi_eduskuntaan"));
				f.setMita(RS.getString("mita_asioita_haluat_edistaa"));

			}
			pstmt.close();
			conn.close();
			return f;
		}
		catch(SQLException e) {
			System.out.println(String.format("Virhe tietojen hakemisessa: %s, %s", sql,e.toString()));
		
			return null;
		}
	}

// KYSYMYSTEN METODIT
	
	//Luetaan kaikki KYSYMYKSET taulusta
		public ArrayList<Questions> readAllQuestions() {
			ArrayList<Questions> list=new ArrayList<>();
			String sql = "select * from kysymykset";
			try {
				Statement stmt=conn.createStatement();
				ResultSet RS=stmt.executeQuery(sql);
				while (RS.next()){
					Questions f=new Questions();
					f.setId(RS.getInt("kysymys_id"));
					f.setKysymys(RS.getString("kysymys"));
					
					list.add(f);
				}

				return list;
			}
			catch(SQLException e) {
				System.out.println(String.format("Virhe tietojen hakemisessa: %s, %s", sql,e.toString()));
			
				return null;
			}
			
		}
		
	// Luetaan 	KYSYMYKSI�
		public Questions readQuestions(String id) {
			Questions f=null;
			String sql="select * from kysymykset where kysymys_id=?";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, id);
				ResultSet RS=pstmt.executeQuery();
				while (RS.next()){
					f=new Questions();
					f.setId(RS.getInt("kysymys_id"));
					f.setKysymys(RS.getString("kysymys"));
					
				}
				return f;
			}
			catch(SQLException e) {
				System.out.println(String.format("Virhe kysymystietojen hakemisessa: %s, %s", sql,e.toString()));
				
				return null;
			}
		}
		
	//P�ivitet��n KYSYMYKSI�
	public ArrayList<Questions> updateQuestions(Questions f) {
		String sql="update kysymykset set "
				+ "kysymys=? where kysymys_id=?";
		try {
			
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, f.getKysymys());
			pstmt.setInt(2, f.getId());
			pstmt.executeUpdate();
			
			return readAllQuestions();
		}
		catch(SQLException e) {
			System.out.println(String.format("Virhe kysymyksen muokkaamisessa: %s, %s", sql,e.toString()));
		
			return null;
		}
		
	}
	//Lis�t��n KYSYMYKSI�
		public ArrayList<Questions> addQuestions(Questions f) {
			String sql="insert into kysymykset"
					+ "(kysymys_ID, kysymys) VALUES (?,?)";
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, f.getId());
				pstmt.setString(2, f.getKysymys());
				pstmt.executeUpdate();
				
				return readAllQuestions();
			}
			catch(SQLException e) {
				System.out.println(String.format("Virhe kysymyksen lis��misess�: %s, %s", sql,e.toString()));
				
				return null;
			}
		
	}
		// Poistetaan KYSYMYKSI�
		public ArrayList<Questions> deleteQuestions(String kysymys_id) {
			String sql="delete from kysymykset where kysymys_id=?";
			
			try {
				PreparedStatement pstmt=conn.prepareStatement(sql); // prepare valmistele kysely
				pstmt.setString(1, kysymys_id); // aseta tietokantakyselyn indeksi
				pstmt.executeUpdate(); // p�ivit� taulu
			
				return readAllQuestions(); // n�yt� p�ivitetty taulu, viesti p�ivityksen onnistumisest� riitt��
			}
			catch(SQLException e) {
				System.out.println(String.format("Virhe kysymyksen poistamisessa: %s, %s", sql,e.toString()));
			
			return null;
			}
	}
}
