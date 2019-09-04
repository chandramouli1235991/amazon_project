package com.amazon.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.amazon.entity.AmazonUser;


public class AmazonDAO  implements AmazonDAOInterface{
	private AmazonDAO() {
		
	}

	public static AmazonDAOInterface createDaoObject(String string) {
		// TODO Auto-generated method stub
		return new AmazonDAO();
	}
	public int createProfileDao(AmazonUser au) {
		int i=0;
		try{
			//Class.forName("oracle.jdbc.driver.OracleDriver");
			//Connection con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","Zensar123");
			
		/*	Properties props=new Properties();
			props.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interface.NamingContextFactory");
			props.put(Context.PROVIDER_URL, "localhost:1099");
			props.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
			*/
			
			DataSource ds;
			Context ctx=new InitialContext();
			ds=(DataSource)ctx.lookup("java:/OracleDS");
			Connection con=ds.getConnection();
			
			PreparedStatement ps=con.prepareStatement("insert into facebookemployee values(?,?,?,?)");
			ps.setString(1, au.getName());
			ps.setString(2, au.getPass());
			ps.setString(3, au.getEmail());
			ps.setString(4, au.getAddress());
			i=ps.executeUpdate();
			
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return i;
	}

}

