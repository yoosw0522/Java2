package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JDBCConnector {
    private static final String DRIVER_PATH = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USER_NAME = "c##ysw";
    private static final String PASSWORD = "1234";

    private static Connection con;
    public static Connection getConnection(){

        try {
//        1. JDBC Driver Memory Load
            Class.forName(DRIVER_PATH);
            System.out.println("JDBC Driver 클래스를 메모리 로드 성공");
//        2. Connection
            con = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println("Connection Done Successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver 클래스를 찾을 수 없습니다.");
        } catch (SQLException e) {
            System.out.println("Connection Failed");
        }

        return con;
    }

    public static void resultSetTest(){

        try {
//        3. SQL문을 실행할 수 있는 문장객체 생성(미리 준비된 SQL문을 실행할 때 사용)
            String sql = "select * from 고객";
            PreparedStatement pstmt = con.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()){
                System.out.print(rs.getString("고객아이디") + "\t");
                System.out.print(rs.getString("고객이름") + "\t");
                System.out.print(rs.getString("직업") + "\t");
                System.out.println();
            }
        } catch (SQLException e) {
            System.out.println("연결된 DB로 문장객체 생성이 되지 않았습니다.");
        }
    }

    public static void main(String[] args) {
        getConnection();
        resultSetTest();
    }
}
