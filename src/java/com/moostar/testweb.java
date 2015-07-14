package com.moostar;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class testweb
 */
// @WebServlet("/testweb")
public class testweb extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public testweb() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	       Connection conn = null;
	        String sql;
	        // MySQLçš„JDBC URLç¼–å†™æ–¹å¼�ï¼šjdbc:mysql://ä¸»æœºå��ç§°ï¼šè¿žæŽ¥ç«¯å�£/æ•°æ�®åº“çš„å��ç§°?å�‚æ•°=å€¼
	        // é�¿å…�ä¸­æ–‡ä¹±ç �è¦�æŒ‡å®šuseUnicodeå’ŒcharacterEncoding
	        // æ‰§è¡Œæ•°æ�®åº“æ“�ä½œä¹‹å‰�è¦�åœ¨æ•°æ�®åº“ç®¡ç�†ç³»ç»Ÿä¸Šåˆ›å»ºä¸€ä¸ªæ•°æ�®åº“ï¼Œå��å­—è‡ªå·±å®šï¼Œ
	        // ä¸‹é�¢è¯­å�¥ä¹‹å‰�å°±è¦�å…ˆåˆ›å»ºjavademoæ•°æ�®åº“
	        String url = "jdbc:mysql://localhost:3306/mytest?"
	                + "useUnicode=true&characterEncoding=UTF8";
	 
	        try {
	            // ä¹‹æ‰€ä»¥è¦�ä½¿ç”¨ä¸‹é�¢è¿™æ�¡è¯­å�¥ï¼Œæ˜¯å› ä¸ºè¦�ä½¿ç”¨MySQLçš„é©±åŠ¨ï¼Œæ‰€ä»¥æˆ‘ä»¬è¦�æŠŠå®ƒé©±åŠ¨èµ·æ�¥ï¼Œ
	            // å�¯ä»¥é€šè¿‡Class.forNameæŠŠå®ƒåŠ è½½è¿›åŽ»ï¼Œä¹Ÿå�¯ä»¥é€šè¿‡åˆ�å§‹åŒ–æ�¥é©±åŠ¨èµ·æ�¥ï¼Œä¸‹é�¢ä¸‰ç§�å½¢å¼�éƒ½å�¯ä»¥
	            Class.forName("com.mysql.jdbc.Driver");// åŠ¨æ€�åŠ è½½mysqlé©±åŠ¨
	            // or:
	            // com.mysql.jdbc.Driver driver = new com.mysql.jdbc.Driver();
	            // orï¼š
	            // new com.mysql.jdbc.Driver();
	 
	            System.out.println("test");
	            // ä¸€ä¸ªConnectionä»£è¡¨ä¸€ä¸ªæ•°æ�®åº“è¿žæŽ¥
	            conn = DriverManager.getConnection(url,"mytest","mytest");
	            // Statementé‡Œé�¢å¸¦æœ‰å¾ˆå¤šæ–¹æ³•ï¼Œæ¯”å¦‚executeUpdateå�¯ä»¥å®žçŽ°æ�’å…¥ï¼Œæ›´æ–°å’Œåˆ é™¤ç­‰
	            Statement stmt = conn.createStatement();
	            sql = "create table student(NO char(20),name varchar(20),primary key(NO))";
	            int result = stmt.executeUpdate(sql);// executeUpdateè¯­å�¥ä¼šè¿”å›žä¸€ä¸ªå�—å½±å“�çš„è¡Œæ•°ï¼Œå¦‚æžœè¿”å›ž-1å°±æ²¡æœ‰æˆ�åŠŸ
	            if (result != -1) {
	                System.out.println("test");
	                sql = "insert into student(NO,name) values('2012001','tes1')";
	                result = stmt.executeUpdate(sql);
	                sql = "insert into student(NO,name) values('2012002','test2')";
	                result = stmt.executeUpdate(sql);
	                sql = "select * from student";
	                ResultSet rs = stmt.executeQuery(sql);// executeQueryä¼šè¿”å›žç»“æžœçš„é›†å�ˆï¼Œå�¦åˆ™è¿”å›žç©ºå€¼
	                System.out.println("ok");
	                while (rs.next()) {
	                    System.out
	                            .println(rs.getString(1) + "\t" + rs.getString(2));// å…¥å¦‚æžœè¿”å›žçš„æ˜¯intç±»åž‹å�¯ä»¥ç”¨getInt()
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("MySQL error");
	            e.printStackTrace();
	        } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	        	if(conn != null)
					try {
						conn.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
