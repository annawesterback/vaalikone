package dao;

import java.sql.DriverManager;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import data.Candidates;
import data.Questions;
import data.UserQuestions;

import java.sql.Connection;

/**
 * Date: 23.4.2022
 * This is Election Machine program. Admin can add, edit and remove candidates and questions.
 * @author owner group 20M Anna Westerback, Ansa Holttinen and Johanna Sieranoja TRTKM20A3
 * @version 1.0
 */
public class Dao { 
	/**
	 * string value for database url
	 */
	private String url;
	/**
	 * string value for database username
	 */
	private String user;
	/**
	 * string value for database password
	 */
	private String pass;
	/**
	 * connection value for database
	 */
	private Connection conn;
	
	// Luo yhteys tietokantaan rakentajassa
	/**
	 * This is method to creating of connection to database including log in information
	 * @param url first string value
	 * @param user second string value
	 * @param pass third string value
	 */
	public Dao(String url, String user, String pass) {
		this.url=url;
		this.user=user;
		this.pass=pass;
	}
	
	//Pyydet��n ottamaan yhteys
	/**
	 * This method get connection to database
	 * @return returning status of creating connection to database
	 */
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
	
	/**
	 * This method to read all candidates from database
	 * @return returns list of all candidates
	 */
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
	
	/**
	 * This method to update candidates
	 * @param f string value for list of candidates
	 * @return returns list of updated candidates
	 */
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
	
		/**
		 * This method  to add candidates and show list of all candidates
		 * @param f string value for adding new candidates
		 * @return returns list of updated candidates
		 */
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
		
		/**
		 * This is method to delete candidates
		 * @param id value for deleting candidates
		 * @return returns list of updated candidates
		 */
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

	/**
	 * This is method to read selected candidates 
	 * @param id value for selected candidate
	 * @return returns selected candidate
	 */
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
		/**
		 * This method to read all questions from database
		 * @return returns list of all questions
		 */
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
		/**
		 * This is method to read questions from database
		 * @param id value for reading questions
		 * @return returns questions
		 */
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
	/**
	 * This is method to update questions
	 * @param f value for selected question
	 * @return returns list of updated questions
	 */
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
		/**
		 * This is method for adding questions
		 * @param f value for added question
		 * @return returns updated list of questions
		 */
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
		/**
		 * This is method to delete questions
		 * @param kysymys_id value for selected question
		 * @return returns list of updated questions
		 */
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
		
		// USERILLE KYSYMYSTEN METODIT
		
		//Luetaan kaikki KYSYMYKSET taulusta
			/**
			 * This method to read all questions from database
			 * @return returns list of all questions
			 */
			public ArrayList<Questions> readAllQuestionsToUser() {
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
}
