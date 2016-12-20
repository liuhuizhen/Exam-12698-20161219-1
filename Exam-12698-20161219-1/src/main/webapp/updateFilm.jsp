<%@page import="com.hand.entity.Language"%>
<%@page import="com.hand.entity.Film"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>修改电影信息</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  <form action="filmAction?command=update" method="post">
    <div>
		<table width="" class="film_table" id="filmTable" border="0" style="text-align: center;">
			<tr class="film_title">
				<td width="80">题目</td>
				<td width="80">简介</td>
				<td width="80">语言</td>
				<td width="80"></td>
				
			</tr>
<%Film film=session.getAttribute("film")!=null?(Film)session.getAttribute("film"):null;
					%>
			<tr >
										<input type="hidden" name="film_id" value="<%=film.getFilm_id()%>" />
				<td width="300"><input type="text" value="<%=film.getTitle()%>" style="width: 400px ;height: 50px;" name="title" ></td>
				<td width="300"><input type="text" value="<%=film.getDescription() %>" style="width: 400px;height: 50px;" name="description" ></td>
				<td width="300"><select name="namesel" id="selectAdd">
												<%
													Collection<Language> languages=session.getAttribute("languages")!=null?(Collection)session.getAttribute("languages"):null;
																	for(Language language : languages ){
												%>
												<option value=""><%=language.getName()%></option>
												<%
													}
												%>
										</select></td>
				<td><input type="submit" value="确认修改"></td>
			</tr>
			</table>
			</div></form>
  </body>
</html>
