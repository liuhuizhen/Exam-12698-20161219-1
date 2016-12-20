package com.hand.action;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.dao.IFilmDao;
import com.hand.dao.ILanguageDao;
import com.hand.dao.impl.FilmDao;
import com.hand.dao.impl.LanguageDao;
import com.hand.entity.Film;
import com.hand.entity.Language;

public class FilmAction extends HttpServlet{
	private IFilmDao filmDao;
	private ILanguageDao languageDao;
	public FilmAction(){
		this.filmDao=new FilmDao();
		this.languageDao=new LanguageDao();
	}
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String command=request.getParameter("command");
		if(command.equals("filmList")){
			filmList(request,response);
		}else if(command.equals("toUpdate")){
			toUpdate(request,response);
		}else if(command.equals("delete")){
			delete(request,response);
		}else if(command.equals("add")){
			add(request,response);
		}else if(command.equals("update")){
			update(request,response);
		}else if(command.equals("toAdd")){
			toAdd(request,response);
		}
	}

	private void update(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			Film film = wrap(request);
			int result=this.filmDao.updateFilm(film);
			if(result>0){
				request.getRequestDispatcher("filmAction?command=filmList").forward(request, response);
		}
		}catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}

	private void toAdd(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session=request.getSession(true);
			List<Language> languages=this.languageDao.selLanguage();
			session.setAttribute("languages", languages);
			request.getRequestDispatcher("addFilm.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void add(HttpServletRequest request, HttpServletResponse response) {
		try {
			Film film=wrap(request);
			int result=this.filmDao.addFilm(film);
			if(result>0){
				request.getRequestDispatcher("filmAction?command=filmList").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private Film wrap(HttpServletRequest req) throws SQLException {
		Film film=new Film();
		film.setFilm_id(Integer.valueOf(req.getParameter("film_id")));
		film.setTitle(req.getParameter("title"));
		film.setDescription(req.getParameter("description"));
		Language language=this.languageDao.selOneLan(req.getParameter("name"));
		film.setLanguage_id(language.getLanguage_id());
		return film;
	}

	private void delete(HttpServletRequest request, HttpServletResponse response) {
		int film_id=Integer.valueOf(request.getParameter("film_id"));
		try {
			int result=this.filmDao.delFilm(film_id);
			if(result>0){
				request.getRequestDispatcher("filmAction?command=filmList").forward(request, response);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void toUpdate(HttpServletRequest request, HttpServletResponse response) {
		int film_id=Integer.valueOf(request.getParameter("film_id"));
		try {
			Film film=this.filmDao.selOneFilm(film_id);
			HttpSession session=request.getSession(true);
			session.setAttribute("film", film);
			request.getRequestDispatcher("updateFilm.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private void filmList(HttpServletRequest request,
			HttpServletResponse response){
		try {
			HttpSession session=request.getSession(true);
			List<Language> languages=this.languageDao.selLanguage();
			session.setAttribute("languages", languages);
			List<Film> films=filmDao.selAllFilm();
			session.setAttribute("films", films);
			request.getRequestDispatcher("main.jsp").forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
