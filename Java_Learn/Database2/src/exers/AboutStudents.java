package exers;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import org.junit.Test;
/**������������˼��������ݿ����
 * 
 */


public class AboutStudents {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1. �õ���ѯ������
		int searchType = getSearchTypeFromConsole();

		// 2. �����ѯѧ����Ϣ
		Student student = searchStudent(searchType);

		// 3. ��ӡѧ����Ϣ
		printStudent(student);
	}

	/**
	 *=== 1. �ӿ���̨����һ������, ȷ��Ҫ��ѯ������====
	 * 
	 * @return: (1) �����֤��ѯ. (2) ��׼��֤�Ų�ѯ ��������Ч. ����ʾ���û���������.
	 */
	private static int getSearchTypeFromConsole() {

		System.out.println("\t��ѡ�������ѯ����:\n\t 1. �����֤��ѯ.\n \t2. ��׼��֤�Ų�ѯ ");

		Scanner scanner = new Scanner(System.in);
		int type = scanner.nextInt();

		if (type != 1 && type != 2) {
			System.out.println("������������������!");
			throw new RuntimeException();
		}

		return type;
	}

	/**
	 * 2. �����ѯѧ����Ϣ��. ����һ�� Student ����. ��������, �򷵻� null
	 * 
	 * @param searchType
	 *            : 1 �� 2.
	 * @return
	 */
	private static Student searchStudent(int searchType) {

		String sql = "SELECT flowid, type, idcard, examcard,"
				+ "studentname, location, grade " + "FROM examstudent "
				+ "WHERE ";

		Scanner scanner = new Scanner(System.in);

		// 1. ��������� searchType, ��ʾ�û�������Ϣ:
		// 1.1 �� searchType Ϊ 1, ��ʾ: ���������֤��. ��Ϊ 2 ��ʾ: ������׼��֤��
		// 2. ���� searchType ȷ�� SQL
		if (searchType == 1) {
			System.out.print("������׼��֤��:");
			String examCard = scanner.next();
			sql = sql + "examcard = '" + examCard + "'";
		} else {
			System.out.print("���������֤��:");
			String examCard = scanner.next();
			sql = sql + "idcard = '" + examCard + "'";
		}

		// 3. ִ�в�ѯ
		Student student = getStudent(sql);

		// 4. �����ڲ�ѯ���, �Ѳ�ѯ�����װΪһ�� Student ����

		return student;
	}
	
	/**
	 * ���ݴ���� SQL ���� Student ����
	 * 
	 * @param sql
	 * @return
	 */
	private static Student getStudent(String sql) {

		Student stu = null;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = JDBCTools.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			if (resultSet.next()) {
				stu = new Student(resultSet.getInt(1), resultSet.getInt(2),
						resultSet.getString(3), resultSet.getString(4),
						resultSet.getString(5), resultSet.getString(6),
						resultSet.getInt(7));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTools.releaseDB(resultSet, statement, connection);
		}

		return stu;
	}


	/**
	 * 3. ��ӡѧ����Ϣ: ��ѧ���������ӡ�������Ϣ. ��������: ��ӡ���޴���.
	 * 
	 * @param student
	 */
	private static void printStudent(Student student) {
		if (student != null) {
			System.out.println("====��ѯ���====");
			System.out.println(student);
		} else {
			System.out.println("���޴���!");
		}
	}

	

	@Test
	public void testAddNewStudent() {
		Student student = getStudentFromConsole();
		addNewStudent2(student);
	}

	/**
	 * �ӿ���̨����ѧ������Ϣ
	 */
	private static  Student getStudentFromConsole() {

		Scanner scanner = new Scanner(System.in);

		Student student = new Student();

		System.out.print("FlowId:");
		student.setFlowId(scanner.nextInt());

		System.out.print("Type: ");
		student.setType(scanner.nextInt());

		System.out.print("IdCard:");
		student.setIdCard(scanner.next());

		System.out.print("ExamCard:");
		student.setExamCard(scanner.next());

		System.out.print("StudentName:");
		student.setStudentName(scanner.next());

		System.out.print("Location:");
		student.setLocation(scanner.next());

		System.out.print("Grade:");
		student.setGrade(scanner.nextInt());

		return student;
	}

	public void addNewStudent2(Student student) {
		String sql = "INSERT INTO examstudent(flowid, type, idcard, "
				+ "examcard, studentname, location, grade) "
				+ "VALUES(?,?,?,?,?,?,?)";

		JDBCTools.update(sql, student.getFlowId(), student.getType(),
				student.getIdCard(), student.getExamCard(),
				student.getStudentName(), student.getLocation(),
				student.getGrade());
	}

	public void addNewStudent(Student student) {
		// 1. ׼��һ�� SQL ���:
		String sql = "INSERT INTO examstudent VALUES(" + student.getFlowId()
				+ "," + student.getType() + ",'" + student.getIdCard() + "','"
				+ student.getExamCard() + "','" + student.getStudentName()
				+ "','" + student.getLocation() + "'," + student.getGrade()
				+ ")";

		System.out.println(sql);

		// 2. ���� JDBCTools ��� update(sql) ����ִ�в������.
		JDBCTools.update(sql);
	}

}


