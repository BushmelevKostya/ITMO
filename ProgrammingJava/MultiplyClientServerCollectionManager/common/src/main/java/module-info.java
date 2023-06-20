module common {
	requires java.sql;
	exports common.product;
	exports common.exception;
	exports common;
	exports common.client;
	exports common.server.database;
}