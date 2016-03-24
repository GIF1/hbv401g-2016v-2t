import java.util.*;

public class dbtest {
  public static void main( String[] args ) {
  String server = "Localhost";
  int port = 5432;
  String db = "Tripplaner";
  String username = "postgres";
  String pass = "tester123";

  Database datab = new Database(server,port,db,username,pass);

  String q = "SELECT * FROM \"Flugvellir\";";
  String ins = "INSERT INTO \"Flugvellir\"(\"Nafn\", \"Stadsetning\") VALUES ('Grindavík', point(19,3));";

  datab.update("insert",ins);
  List<List<String>> res = datab.query(q);

  System.out.println(res.get(4));
  }
}
