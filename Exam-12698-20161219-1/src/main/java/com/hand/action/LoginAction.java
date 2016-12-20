package com.hand.action;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.hand.dao.ICustomerDao;
import com.hand.dao.impl.CustomerDao;
import com.hand.entity.Customer;

public class LoginAction extends HttpServlet{
	private ICustomerDao customerDao;
	public LoginAction(){
		this.customerDao=new CustomerDao();
	}
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//根据command的值进行不同的处理
		String command=request.getParameter("command");
		if("login".equals(command)){
				dologin(request,response);
		}
	}
	/**
	 * 登录
	 * @param request
	 * @param response
	 */
	private void dologin(HttpServletRequest request, HttpServletResponse response) {
		//封装用户请求中的客户信息
		Customer customer=wrap(request);
		try {
			customer=this.customerDao.selCus(customer);
		HttpSession session = request.getSession(true);
		if(customer!=null){
			session.setAttribute("loginUser", customer);
			request.getRequestDispatcher("filmAction?command=filmList").forward(request, response);
		}else{
			request.getRequestDispatcher("login.jsp").forward(request, response);
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

		private Customer wrap(HttpServletRequest request) {
			Customer customer=new Customer();
			String first_name=request.getParameter("first_name");
			customer.setFirst_name(first_name);
		return customer;
	}

		

}
