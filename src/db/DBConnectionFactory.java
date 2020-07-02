package db;

import db.mysql.MySQLConnection;

// 提供多种数据库的选择
public class DBConnectionFactory {  
	private static final String DEFAULT_DB = "mysql";
	
	public static DBConnection getConnection(String db) {
		switch(db){
		case "mysql":
			return new MySQLConnection();
			
		case "mongoDB":
			//return new MongoDBConnection();
			return null;
		default:
			throw new IllegalArgumentException("Invalid db: " + db);
		}
	}
	public static DBConnection getConnection() {
		return getConnection(DEFAULT_DB);
		
	}
}
