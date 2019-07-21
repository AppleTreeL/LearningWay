package edu.xust.jdbc;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import org.junit.Test;

import exers.Student;

public class JDBCTest {

	@Test
	public void testResultSetMetaData() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			String sql = "SELECT flow_id flowId, type, id_card idCard, "
					+ "exam_card examCard, student_name studentName, "
					+ "location, grade " + "FROM examstudent1 WHERE flow_id = ?";
			
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 5);
			
			resultSet = preparedStatement.executeQuery();

			Map<String, Object> values = 
					new HashMap<String, Object>();
			
			//1. 得到 ResultSetMetaData 对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			while(resultSet.next()){
				//2. 打印每一列的列名
				for(int i = 0; i < rsmd.getColumnCount(); i++){
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(columnLabel);
					
					values.put(columnLabel, columnValue);
				}
			}
			
//			System.out.println(values); 

			Class clazz = Student.class;
			
			Object object = clazz.newInstance();
			for(Map.Entry<String, Object> entry: values.entrySet()){
				String fieldName = entry.getKey();
				Object fieldValue = entry.getValue();
				
//				System.out.println(fieldName + ": " + fieldValue);
				
				ReflectionUtils.setFieldValue(object, fieldName, fieldValue);
			}
			
			System.out.println(object); 
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
	}

	@Test
	public void testGet() {
		String sql = "SELECT id, name, email, birth "
				+ "FROM customers WHERE id = ?";
//		System.out.println(sql);

		Customer customer = get(Customer.class, sql,4);
		System.out.println(customer);

		sql = "SELECT flow_id flowId, type, id_card idCard, "
				+ "exam_card examCard, student_name studentName, "
				+ "location, grade " + "FROM examstudent1 WHERE flow_id = ?";
		System.out.println(sql);

		Student stu = get(Student.class, sql, 7);
		System.out.println(stu);
	}

	/**
	 * 通用的查询方法：可以根据传入的 SQL、Class 对象返回 SQL 对应的记录的对象
	 * @param clazz: 描述对象的类型
	 * @param sql: SQL 语句。可能带占位符
	 * @param args: 填充占位符的可变参数。
	 * @return
	 */
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		T entity = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//1. 得到 ResultSet 对象
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			//2. 得到 ResultSetMetaData 对象
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			//3. 创建一个 Map<String, Object> 对象, 键: SQL 查询的列的别名, 
			//值: 列的值
			Map<String, Object> values = new HashMap<>();
			
			//4. 处理结果集. 利用 ResultSetMetaData 填充 3 对应的 Map 对象
			if(resultSet.next()){
				for(int i = 0; i < rsmd.getColumnCount(); i++){
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(i + 1);
					
					//values.put(columnLabel, columnValue);
					System.out.println(columnLabel+"  "+columnValue.toString());
				}
			}
			
			//5. 若 Map 不为空集, 利用反射创建 clazz 对应的对象
			if(values.size() > 0){
				entity = clazz.newInstance();
				
				//5. 遍历 Map 对象, 利用反射为 Class 对象的对应的属性赋值. 
				for(Map.Entry<String, Object> entry: values.entrySet()){
					String fieldName = entry.getKey();
					Object value = entry.getValue();
					ReflectionUtils.setFieldValue(entity, fieldName, value);
				}
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return entity;
	}

	public Customer getCustomer(String sql, Object... args) {
		Customer customer = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				// stu = new Student();
				// stu.setFlowId(resultSet.getInt(1));
				// stu.setType(resultSet.getInt(2));
				// stu.setIdCard(resultSet.getString(3));

				customer = new Customer();
				customer.setId(resultSet.getInt(1));
				customer.setName(resultSet.getString(2));
				customer.setEmail(resultSet.getString(3));
				customer.setBirth(resultSet.getDate(4));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return customer;
	}

	public Student getStudent(String sql, Object... args) {
		Student stu = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				stu = new Student();
				stu.setFlowId(resultSet.getInt(1));
				stu.setType(resultSet.getInt(2));
				stu.setIdCard(resultSet.getString(3));
				// ...
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}

		return stu;
	}

	/**
	 * 使用 PreparedStatement 将有效的解决 SQL 注入问题.
	 */
	@Test
	public void testSQLInjection2() {
		String username = "a' OR PASSWORD = ";
		String password = " OR '1'='1";

		String sql = "SELECT * FROM users WHERE username = ? "
				+ "AND password = ?";

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);

			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);

			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) {
				System.out.println("登录成功!");
			} else {
				System.out.println("用户名和密码不匹配或用户名不存在. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
	}

	/**
	 * SQL 注入.
	 */
	@Test
	public void testSQLInjection() {
	String username = "a' OR PASSWORD = ";
	String password = " OR '1'='1";
	//		String username = "Tom";
		//	String password = "123456";
		String sql = "SELECT * FROM users WHERE username = '" + username
				+ "' AND " + "password = '" + password + "'";

		System.out.println(sql);

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
						
			if (resultSet.next()) {
				System.out.println("登录成功!");
			} else {
				System.out.println("用户名和密码不匹配或用户名不存在. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, statement, connection);
		}
	}
/**
 * 使用Statement讲一个对象更新至数据库遇到了比较辛苦的一件事情：拼接sql语句，容易出错
 * 介绍另外一个类PreparedStatement
 * （其是Statement的子接口，可以传入带占位符的sql语句；并且提供了填充占位符的方法）
 * (1) 创建PreparedStatement(使用connection的PreparedStatement方法，同时传入sql语句)
 * 
 * String sql = "INSERT INTO customers (name, email, birth)	VALUES(?,?,?)"
 * PreparedStatement preparedStatement =  connection.prepareStatement(sql);
 * 
 * (2) 调用PreparedStatement的setXxx(int index, Object val)
 * 		设置占位符的值（索引值从1开始，可以查看API文档）
 * 
 * (3) 执行SQL语句：executeQuery()或者executeUpdate().注意：执行时不再需要传入sql语句。
 */
	@Test
	public void testPreparedStatement() {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		try {
			connection = JDBCTools.getConnection();
			String sql = "INSERT INTO customers (ssn,name, email, birth) VALUES(?,?,?,?)";

			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, "140203197001010010");
			preparedStatement.setString(2, "XUST");
			preparedStatement.setString(3, "simpleit@163.com");
			preparedStatement.setDate(4,
					new Date(new java.util.Date().getTime()));
			//SQLDate如何创建，new Date(long time)
			//这个long型的毫秒数可以用util.Date中的getTime来获取用匿名内部类

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}


	

}
