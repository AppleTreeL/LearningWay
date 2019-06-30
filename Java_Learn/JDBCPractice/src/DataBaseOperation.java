import java.sql.*;
import java.time.LocalDateTime;

/**
 * @Classname DataBaseOperation
 * @Description TODO
 * @Date 2019/6/29 14:51
 * @Created by AppleTree
 */
public class DataBaseOperation {

    //连接我的数据库
    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");

            String url = "jdbc:mysql://localhost:3306/memo?useSSL=false&user=root&password=13488204166";

            Connection connection = DriverManager.getConnection(url);

            return connection;

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //创建MemoGroup
    public static Boolean createMemoGroup(MemoGroup memoGroup){
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("insert memo_group(id, name, created_time, modify_time) " +
                    "values (?, ?, ?, ?)");

            preparedStatement.setInt(1,memoGroup.getId());
            preparedStatement.setString(2,memoGroup.getName());
            preparedStatement.setTimestamp(3,Timestamp.valueOf(memoGroup.getCreatedTime()));
            preparedStatement.setTimestamp(4, Timestamp.valueOf(memoGroup.getModifyTime()));

            int res = preparedStatement.executeUpdate();
            if(res == 1){
                System.out.println("update successfully");
                return true;
            }else{
                System.out.println("failed to update");
                return false;
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    //通过ID查询MemoGroup
    public static MemoGroup queryMemoGroupById(Integer id){
        MemoGroup memoGroup = new MemoGroup();
        Connection connection = getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("select id, name, created_time, " +
                    "modify_time " +
                    "from memo_group where id=?" );
            preparedStatement.setInt(1,id);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                memoGroup.setId(resultSet.getInt("id"));
                memoGroup.setName(resultSet.getString("name"));
                memoGroup.setCreatedTime(resultSet.getTimestamp("created_time").toLocalDateTime());
                memoGroup.setModifyTime(resultSet.getTimestamp("modify_time").toLocalDateTime());
            }
            return memoGroup;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    //更新MemoGroup (name)
    public static Boolean updateMemoGroup(MemoGroup memoGroup){
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("update " +
                    "memo_group set name=?, created_time=?, modify_time=? " +
                    "where id=?");
            preparedStatement.setInt(4,memoGroup.getId());
            preparedStatement.setString(1,memoGroup.getName());
            preparedStatement.setTimestamp(2, Timestamp.valueOf(memoGroup.getCreatedTime()));
            preparedStatement.setTimestamp(3, Timestamp.valueOf(memoGroup.getModifyTime()));

            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    //根据名称模糊匹配删除MemoGroup(后模糊)
    public static Integer deleteMemoGroupByName(String name){
        Connection connection = getConnection();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = connection.prepareStatement("delete from memo_group where name=?");
            preparedStatement.setString(1,name);
            int res = preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            return res;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                preparedStatement.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }finally {
            try {
                preparedStatement.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            try {
                connection.close();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }

        return -1;
    }

    //创建MemoInfo
    //Boolean createMemoInfo(MemoGroup memoGroup, MemoInfo memoInfo);

    public static void main(String[] args) {
        //System.out.println(getConnection());

        /* 测试插入
        MemoGroup memoGroup = new MemoGroup();
        memoGroup.setId(6);
        memoGroup.setName("huhai");
        memoGroup.setCreatedTime(LocalDateTime.now());
        memoGroup.setModifyTime(LocalDateTime.now());
        createMemoGroup(memoGroup);
        */

        /*测试查询
        MemoGroup memoGroup = queryMemoGroupById(6);
        System.out.println(memoGroup);
        */

        /*测试更新*/
        MemoGroup memo = new MemoGroup(6, "Calvin", LocalDateTime.now(), LocalDateTime.now());
        System.out.println(updateMemoGroup(memo));

        /*测试删除
        System.out.println(deleteMemoGroupByName("huhai"));
        */
    }
}
