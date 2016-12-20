package com.hand.dao.util;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 
 * @author maoyunao
 *
 */
public interface IProResultSet {

	void resultSetToObj(ResultSet resultSet) throws SQLException;
	
}
