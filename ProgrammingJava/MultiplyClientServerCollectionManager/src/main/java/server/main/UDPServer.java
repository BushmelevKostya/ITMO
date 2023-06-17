package server.main;

import server.ServerConcurrentExecutor;
import server.database.DBParser;
import server.database.Initializer;
import server.database.Connector;
import server.database.Migrations;

import java.sql.Connection;
import java.sql.Statement;

public class UDPServer {
	
	public static void main(String[] args) throws Exception {
		try (Connection connection = Connector.getConnection();
			Statement statement = connection.createStatement()) {
			Migrations migrations = new Migrations(connection, statement);
			new Initializer(migrations).initialize();
			DBParser parser = new DBParser(migrations);
			parser.parse();
			new ServerConcurrentExecutor().run();
		}
	}
}