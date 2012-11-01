package com.sf;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sforce.soap.enterprise.Connector;
import com.sforce.soap.enterprise.EnterpriseConnection;
import com.sforce.soap.enterprise.QueryResult;
import com.sforce.soap.enterprise.sobject.Account;
import com.sforce.ws.ConnectionException;
import com.sforce.ws.ConnectorConfig;

/**
 * Servlet implementation class DisplayServlet
 */
public class DisplayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static final String USERNAME = "itgoujie2@gmail.com";
	static final String PASSWORD = "a1988012997zmGLApZxQOSRNJdc0xhIRP";
	static EnterpriseConnection connection;
    /**
     * Default constructor. 
     */
    public DisplayServlet() {
        // TODO Auto-generated constructor stub
    }
    
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
		ConnectorConfig config = new ConnectorConfig();
		config.setUsername(USERNAME);
		config.setPassword(PASSWORD);
		
		
		try{
			connection = Connector.newConnection(config);
			queryAccount(request,response);
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/WEB-INF/display.jsp");
			rd.forward(request,response);
		}catch(ConnectionException e){
			e.printStackTrace();
		}
	}
	
	public static void queryAccount(HttpServletRequest request, HttpServletResponse response){
		try {
			QueryResult queryResults = connection.query("select Id,Name from Account");
			if (queryResults.getRecords().length>0){
				HttpSession session = request.getSession(true);
				List<LocalAccount> accounts = new ArrayList<LocalAccount>();
				
				for (int i=0;i<queryResults.getRecords().length;i++){
					Account temp = (Account) queryResults.getRecords()[i];
					
					String tempName = temp.getName();
					LocalAccount tempLocalAccount = new LocalAccount();
					
					tempLocalAccount.setName(tempName);
					accounts.add(tempLocalAccount);
				}
				session.setAttribute("accounts", accounts);
			}
			
		} catch (ConnectionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}

}
