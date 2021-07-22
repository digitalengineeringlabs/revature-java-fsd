package common.util;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBUtil {
	
	private static final Logger logger = LogManager.getLogger(DBUtil.class);
	
	private static DBUtil _instance;
	private Connection conn = null;
	
	private DBUtil() {
		
	}
	
	public static DBUtil getInstance() {
		if(_instance == null) {
			_instance = new DBUtil();
		}
		return _instance;
	}
	
	public Connection getConnection() throws Exception {
		if(this.conn == null) {
			
			String configFilePath = System.getProperty(AppConstants.CONFIG_FILE);
			
			logger.info("Reading config file in location: "+configFilePath);
			
			try(FileInputStream fis = new FileInputStream(configFilePath)){
				
				Properties props = new Properties();
				props.load(fis);
				
				this.conn = DriverManager.getConnection(props.getProperty(AppConstants.DB_URL),
						props.getProperty(AppConstants.DB_USER),
						props.getProperty(AppConstants.DB_PASSWORD));
				
			} catch (Exception e) {
				logger.warn("Unable to get database connection",e);
				throw e;
			}
			
		}
		return this.conn;
	}

}
