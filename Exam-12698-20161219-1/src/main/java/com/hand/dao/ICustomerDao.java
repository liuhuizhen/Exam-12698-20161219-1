package com.hand.dao;

import java.sql.SQLException;

import com.hand.entity.Customer;


public interface ICustomerDao {
	/**
	 * 通过姓名查询用户是否存在
	 * @param customer
	 * @return
	 * @throws SQLException
	 */
	Customer selCus(Customer customer) throws SQLException;

}
