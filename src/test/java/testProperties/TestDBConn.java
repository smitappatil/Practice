package testProperties;

import java.sql.SQLException;

import utilities.DbManager;

public class TestDBConn {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		DbManager.setMysqlDbConnection();
		System.out.println(DbManager.getMysqlQuery("select FirstName from Persons"));

	}

}
