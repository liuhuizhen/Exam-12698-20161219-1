package com.hand.dao;

import java.sql.SQLException;
import java.util.List;

import com.hand.entity.Film;

public interface IFilmDao {
	/**
	 * 查询所有电影信息
	 * @return
	 * @throws SQLException
	 */
	public List<Film> selAllFilm() throws SQLException;
	/**
	 * t通过ID查询电影信息
	 * @param film_id
	 * @return
	 * @throws SQLException
	 */
	public Film selOneFilm(int film_id) throws SQLException;
	/**
	 * 添加电影信息
	 * @param film
	 * @return
	 * @throws SQLException
	 */
	public int addFilm(Film film) throws SQLException;
	/**
	 * 删除电影
	 * @param film_id
	 * @return
	 * @throws SQLException
	 */
	public int delFilm(int film_id) throws SQLException;
	/**
	 * 更新电影信息
	 * @param film
	 * @return
	 * @throws SQLException
	 */
	public int updateFilm(Film film) throws SQLException;

}
