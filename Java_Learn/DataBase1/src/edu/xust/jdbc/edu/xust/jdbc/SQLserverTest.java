package edu.xust.jdbc;

import java.util.Properties;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class SQLserverTest {
	
	public static void main(String[] args) throws Exception{

		Connection conn = null;
	
	
			conn = getConnection();
			//main方法是
				String sql = null;
			
		sql = "INSERT INTO customers (SSN,NAME, EMAIL, BIRTH) " +
				"VALUES(140203199010039922,'Yuna', 'yy@xust.edu.cn', '1990-10-03')";
		//sql = "DELETE FROM customers WHERE id = 1";
		//sql = "UPDATE customers SET name = 'TOM' " +"WHERE id = 1";
	   update(sql);
	    
	    	sql = "SELECT ssn,id, name, email, birth FROM customers";
	    	query(sql);

	}
	//对release方法进行重载
	 /**(1) 关闭 Statement 、 Connection和ResultSet
	  * 关闭的顺序是: 先关闭后获取的. 即先关闭 Statement 和ResultSet，后关闭 Connection
	  * @param rs
	  * @param statement
	  * @param conn
	  */
	public static void release(ResultSet rs,Statement statement, Connection conn) {
		if(rs != null){
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
	
	/**
	 *(2) 关闭 Statement 和 Connection
	 * I.Connection、Statement 都是应用程序和数据库服务器的连接资源. 使用后一定要关闭.
	 * 需要在 finally 中关闭 Connection 和 Statement 对象. 
	 * 
	 *II.关闭的顺序是: 先关闭后获取的. 即先关闭 Statement 后关闭 Connection
	 * @param statement
	 * @param conn
	 */
	public static void release(Statement statement, Connection conn) {
		if (statement != null) {
			try {
				statement.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}

	public static void query(String sql){
		Connection conn = null;
		Statement statement = null;
		ResultSet rs = null;
		
		try {

			conn = getConnection();
			statement = conn.createStatement();

			rs = statement.executeQuery(sql);
	
			while(rs.next()){
				int id = rs.getInt(2);
				String name = rs.getString("name");
				String email = rs.getString(4);
				Date birth = rs.getDate(5);
				
				System.out.println(id);
				System.out.println(name);
				System.out.println(email);
				System.out.println(birth);
			}
			
		} catch (Exception e) {
					e.printStackTrace();
		} finally{
					release(rs, statement, conn);
		}
	}
	public static void update(String sql){
		//一、使用Statement 对象，对数据库进行简单的插入、删除和更新操作，
		/**思路(填空题)：
		 * 1. 获取数据库连接
		 * 2. 关闭连接
		 * 3.准备可以执行的 SQL 语句
		 * 4.执行sql操作
		 * 1). 获取操作 SQL 语句的 Statement 对象: 
		 * 2)调用 Statement 对象的 executeUpdate(sql) 执行 SQL 语句进行插入
		 * 5.关闭 Statement 对象.
		 * 如果碰到红线的部分,Suround with-->try/catch block或是添加抛出异常
		 *静态方法调用的也应该是静态的方法
		 */
		Connection conn = null;
		Statement statement = null;
		
		try {
			conn = getConnection();
			statement = conn.createStatement();
			statement.executeUpdate(sql);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			release(statement, conn);
		}
	}

public static Connection getConnection() throws Exception{
			//1. 准备连接数据库的 4 个字符串. 
			//1). 创建 Properties 对象
			Properties properties = new Properties();
			
			//2). 获取 jdbc.properties 对应的输入流
		InputStream in = SQLserverTest.class.getClassLoader().getResourceAsStream(
				"jdbc.properties");
			
			//3). 加载 2） 对应的输入流
			properties.load(in);
			
			//4). 具体决定 user, password 等4 个字符串. 
			String user = properties.getProperty("user");
			String password = properties.getProperty("password");
			String jdbcUrl = properties.getProperty("jdbcUrl");
			String driver = properties.getProperty("driver");
			
			//2. 加载数据库驱动程序(对应的 Driver 实现类中有注册驱动的静态代码块.)
			Class.forName(driver);
			
			//3. 通过 DriverManager 的 getConnection() 方法获取数据库连接. 
			return DriverManager.getConnection(jdbcUrl, user, password);
			}
}
