package com.hand.dao;

import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Language;

public interface ILanguageDao {
	/**
	 * 查询所有语言
	 * @return
	 * @throws SQLException
	 */
	public List<Language> selLanguage() throws SQLException;

	/**
	 * 通过语言ID查询语言信息 
	 * @param parameter
	 * @return
	 * @throws SQLException
	 */
	public Language selOneLan(String parameter) throws SQLException;


}
