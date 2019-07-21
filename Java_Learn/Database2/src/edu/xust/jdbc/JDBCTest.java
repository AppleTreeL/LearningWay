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
			
			//1. �õ� ResultSetMetaData ����
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			while(resultSet.next()){
				//2. ��ӡÿһ�е�����
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
	 * ͨ�õĲ�ѯ���������Ը��ݴ���� SQL��Class ���󷵻� SQL ��Ӧ�ļ�¼�Ķ���
	 * @param clazz: �������������
	 * @param sql: SQL ��䡣���ܴ�ռλ��
	 * @param args: ���ռλ���Ŀɱ������
	 * @return
	 */
	public <T> T get(Class<T> clazz, String sql, Object... args) {
		T entity = null;

		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;

		try {
			//1. �õ� ResultSet ����
			connection = JDBCTools.getConnection();
			preparedStatement = connection.prepareStatement(sql);
			for (int i = 0; i < args.length; i++) {
				preparedStatement.setObject(i + 1, args[i]);
			}
			resultSet = preparedStatement.executeQuery();

			//2. �õ� ResultSetMetaData ����
			ResultSetMetaData rsmd = resultSet.getMetaData();
			
			//3. ����һ�� Map<String, Object> ����, ��: SQL ��ѯ���еı���, 
			//ֵ: �е�ֵ
			Map<String, Object> values = new HashMap<>();
			
			//4. ��������. ���� ResultSetMetaData ��� 3 ��Ӧ�� Map ����
			if(resultSet.next()){
				for(int i = 0; i < rsmd.getColumnCount(); i++){
					String columnLabel = rsmd.getColumnLabel(i + 1);
					Object columnValue = resultSet.getObject(i + 1);
					
					//values.put(columnLabel, columnValue);
					System.out.println(columnLabel+"  "+columnValue.toString());
				}
			}
			
			//5. �� Map ��Ϊ�ռ�, ���÷��䴴�� clazz ��Ӧ�Ķ���
			if(values.size() > 0){
				entity = clazz.newInstance();
				
				//5. ���� Map ����, ���÷���Ϊ Class ����Ķ�Ӧ�����Ը�ֵ. 
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
	 * ʹ�� PreparedStatement ����Ч�Ľ�� SQL ע������.
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
				System.out.println("��¼�ɹ�!");
			} else {
				System.out.println("�û��������벻ƥ����û���������. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, preparedStatement, connection);
		}
	}

	/**
	 * SQL ע��.
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
				System.out.println("��¼�ɹ�!");
			} else {
				System.out.println("�û��������벻ƥ����û���������. ");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, statement, connection);
		}
	}
/**
 * ʹ��Statement��һ��������������ݿ������˱Ƚ������һ�����飺ƴ��sql��䣬���׳���
 * ��������һ����PreparedStatement
 * ������Statement���ӽӿڣ����Դ����ռλ����sql��䣻�����ṩ�����ռλ���ķ�����
 * (1) ����PreparedStatement(ʹ��connection��PreparedStatement������ͬʱ����sql���)
 * 
 * String sql = "INSERT INTO customers (name, email, birth)	VALUES(?,?,?)"
 * PreparedStatement preparedStatement =  connection.prepareStatement(sql);
 * 
 * (2) ����PreparedStatement��setXxx(int index, Object val)
 * 		����ռλ����ֵ������ֵ��1��ʼ�����Բ鿴API�ĵ���
 * 
 * (3) ִ��SQL��䣺executeQuery()����executeUpdate().ע�⣺ִ��ʱ������Ҫ����sql��䡣
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
			//SQLDate��δ�����new Date(long time)
			//���long�͵ĺ�����������util.Date�е�getTime����ȡ�������ڲ���

			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(null, preparedStatement, connection);
		}
	}


	

}
