package metaSearchEngine.program;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.postgresql.util.PSQLException;

public class Database {
  private String serverName;
  private int port;
  private String db;
  private String username;
  private String password;

  public Database(String s, int p, String d, String user, String pass) {
    serverName = s;
    port = p;
    db = d;
    username = user;
    password = pass;
  }

  Connection connect() {
    Connection c = null;
    try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager.getConnection("jdbc:postgresql://"+this.serverName+":"+this.port+"/"+this.db,this.username, this.password);
      c.setAutoCommit(false);
      } catch (Exception e) {
         e.printStackTrace();
         System.err.println(e.getClass().getName()+": "+e.getMessage());
         System.exit(0);
      }
      System.out.println("Opened database successfully");
      return c;
  }
  
  List<List<String>> query(Connection c, PreparedStatement q) {
    List<List<String>> result = new ArrayList<>();
    

    try {
      ResultSet rs = q.executeQuery();

      ResultSetMetaData metadata = rs.getMetaData();
      int numcols = metadata.getColumnCount();

      while (rs.next()) {
        List<String> row = new ArrayList<>(numcols);
        int i = 1;
        while (i <= numcols) {
          row.add(rs.getString(i++));
        }
        result.add(row);
      }
      if (rs != null) rs.close();
      if (q != null) q.close();
      if (c != null) c.close();

    } catch ( Exception e ) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
    }

    return result;
  }

  void update(String opt, Connection c, PreparedStatement q) throws SQLException{
    if (opt.equals("insert") | opt.equals("Insert"))
    {
      try {
    	q.execute();
        q.close();
        c.commit();
        c.close();
      } catch (SQLException e) {
    	  throw e;
      } catch (Exception e) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
      }
        System.out.println("Records created successfully");
    } else if (opt.equals("update") | opt.equals("Update")) {
        try {
          q.execute();
          q.close();
          c.commit();
          c.close();
        } catch ( Exception e ) {
           System.err.println( e.getClass().getName()+": "+ e.getMessage() );
           System.exit(0);
         }
         System.out.println("Operation done successfully");
     }
  } 
  
  
  //User related database functions
  @SuppressWarnings({ "unchecked" })
	public User login(String username, String password) throws EmptySQLreturnException {
	  	Database db = this; 
	  	String sql = "SELECT \"Password\" FROM \"Users\" WHERE \"Username\" = ?;";
		Connection c = db.connect();
		PreparedStatement prepStmt;
		User user = null;
		
		try {
			prepStmt = c.prepareStatement(sql);
			prepStmt.setString(1, username);
			List<List<String>> res = db.query(c,prepStmt);
			if (!res.isEmpty()) {
				
				//Trim all elements in list
				List<String> trimmedRes = new ArrayList<String>(res.get(0).size());
				for ( int i = 0; i < res.get(0).size(); i++ ) {
				    trimmedRes.add( res.get(0).get(i).trim() );
				}
				
				//Check if passwords match
				if (trimmedRes.contains(password)) {
					//Passwords match, get info about user.
					String sqlUserInfo = "SELECT \"id\",\"Username\",\"Age\",\"Email\",\"Admin\" FROM \"Users\" WHERE \"Username\" = ?;";
					PreparedStatement prepStmtUserInfo;
					
					try {
						Connection conn = db.connect();
						prepStmtUserInfo = conn.prepareStatement(sqlUserInfo);
						prepStmtUserInfo.setString(1, username);
						List<List<String>> resUserInfo = db.query(conn,prepStmtUserInfo);
						
						if (!resUserInfo.isEmpty()) {
							List<String> trimmedResUserInfo = new ArrayList<String>(resUserInfo.get(0).size());
							for ( int i = 0; i < resUserInfo.get(0).size(); i++ ) {
								if (resUserInfo.get(0).get(i)==null) {
									trimmedResUserInfo.add( resUserInfo.get(0).get(i));
								} else {
									trimmedResUserInfo.add( resUserInfo.get(0).get(i).trim());
								}
							}
							//Parse User information.
							int newId = Integer.parseInt(trimmedResUserInfo.get(0));
							String newUsername = trimmedResUserInfo.get(1);
							String newAge = trimmedResUserInfo.get(2);
							String newEmail = trimmedResUserInfo.get(3);
							boolean newAdmin = Boolean.valueOf(trimmedResUserInfo.get(4));
							
							user = new User(newId,newUsername,newEmail,newAdmin);
							
							if (newAge != null) user.setAge(Integer.parseInt(newAge));
							
							//Get Package object for user
							String getPackage = "SELECT \"Packages\" FROM \"Users\" WHERE \"Username\" = ?;";
							PreparedStatement pstmt;
										
							try {
								conn = db.connect();
								pstmt = conn.prepareStatement(getPackage);
								pstmt.setString(1, username);
								ResultSet rs = pstmt.executeQuery();
							    rs.next();
							    byte[] bytes = rs.getBytes(1);
							    ByteArrayInputStream bais = new ByteArrayInputStream(bytes);
								ObjectInputStream in = new ObjectInputStream(bais);
								List<Package> element = null;
								element = (List<Package>) in.readObject();
								user.setPackages(element);
								rs.close();
							    pstmt.close();
							    conn.commit();
							    conn.close();
							} catch (SQLException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (IOException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							} catch (ClassNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						} else {
							throw new EmptySQLreturnException("Sorry, the query had no return");
						} 
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
						
						
				} else {
					//Passwords don't match, return null
				}
			} else {
				throw new EmptySQLreturnException("Sorry, the query had no return");
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;	
	}
	
	public User createUser(String newUsername, String newPassword, String newEmail, boolean newAdmin, Integer newAge) throws EmptySQLreturnException, SQLException  {
		Database db = this;
		Connection c = db.connect();
		PreparedStatement prepStmt = null;
		User user = null;
		byte[] bytes = null;
		
		try {
			List<Package> emptyPackages = new ArrayList<Package>();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(baos);
			oos.writeObject(emptyPackages);
			bytes = baos.toByteArray();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		String sql = null;
		
		//Validate inputs
		if (!User.verifyUsername(newUsername)) {
			throw new IllegalArgumentException("Error: Username not of legal format.");
		} 
		
		if (!User.verifyEmail(newEmail)) {
			throw new IllegalArgumentException("Error: Email not of legal format.");
		}
		
		if (newAge != null) {
			if(!User.verifyAge(newAge)) {
				throw new IllegalArgumentException("Error: Invalid age for user.");
			}
			
			sql = "INSERT INTO \"Users\"(\"Password\", \"Username\", \"Age\", \"Email\", \"Admin\", \"Packages\") VALUES (?, ?, ?, ?, ?, ?);";
			
			try {
				prepStmt = c.prepareStatement(sql);
				prepStmt.setString(1, newPassword);
				prepStmt.setString(2, newUsername);
				prepStmt.setInt(3, newAge);
				prepStmt.setString(4, newEmail);
				prepStmt.setBoolean(5, newAdmin);
				prepStmt.setBytes(6, bytes);
				db.update("Insert",c ,prepStmt);
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				throw e;
			}
			
		} else {
			sql = "INSERT INTO \"Users\"(\"Password\", \"Username\", \"Email\", \"Admin\", \"Packages\") VALUES (?, ?, ?, ?, ?);";
			
			try {
				prepStmt = c.prepareStatement(sql);
				prepStmt.setString(1, newPassword);
				prepStmt.setString(2, newUsername);
				prepStmt.setString(3, newEmail);
				prepStmt.setBoolean(4, newAdmin);
				prepStmt.setBytes(5, bytes);
				db.update("Insert",c ,prepStmt);
			} catch (SQLException e) {
				throw e;
			}
		}
		
		try {
			user = login(newUsername,newPassword);
		} catch (EmptySQLreturnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
	
	public User editUser(User user, String newUsername, String newPassword, String newEmail, Boolean newAdmin, Integer newAge, List<Package> newPackages) {
		Database db = this;
		Connection c = db.connect();
		PreparedStatement prepStmt;
		byte[] bytes = null;
		String sql = null;
		
		if(!(newUsername == null)) {
			user.setUserName(newUsername);
		}
		if(!(newEmail == null)) {
			user.setEmail(newEmail);
		}
		if(!(newAdmin == null)) {
			user.setAdmin(newAdmin);
		}
		if(!(newAge == null)) {
			user.setAge(newAge);
		}
		if(!(newPackages == null)) {
			user.setPackages(newPackages);
		}
		
		try {
			List<Package> emptyPackages = user.getTrip();
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			ObjectOutputStream oos;
			oos = new ObjectOutputStream(baos);
			oos.writeObject(emptyPackages);
			bytes = baos.toByteArray();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		if(!(newPassword == null)) {
			sql = "UPDATE \"Users\" SET \"Password\"=?, \"Username\"=?, \"Age\"=?, \"Email\"=?, \"Admin\"=?,\"Packages\"=? WHERE \"id\" = ?;";
			
			try {
				prepStmt = c.prepareStatement(sql);
				prepStmt.setString(1, newPassword);
				prepStmt.setString(2, user.getUsername());
				prepStmt.setInt(3, user.getAge());
				prepStmt.setString(4, user.getEmail());
				prepStmt.setBoolean(5, user.getAdmin());
				prepStmt.setBytes(6, bytes);
				prepStmt.setInt(7, user.getId());
				db.update("Update",c,prepStmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			}
		} else {
			sql = "UPDATE \"Users\" SET \"Username\"=?, \"Age\"=?, \"Email\"=?, \"Admin\"=?,\"Packages\"=? WHERE \"id\" = ?;";
			
			try {
				prepStmt = c.prepareStatement(sql);
				prepStmt.setString(1, user.getUsername());
				prepStmt.setInt(2, user.getAge());
				prepStmt.setString(3, user.getEmail());
				prepStmt.setBoolean(4, user.getAdmin());
				prepStmt.setBytes(5, bytes);
				prepStmt.setInt(6, user.getId());
				db.update("Update",c,prepStmt);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (Exception e) {
				System.err.println( e.getClass().getName()+": "+ e.getMessage() );
			}
		}
		
		return user;
	}
}
