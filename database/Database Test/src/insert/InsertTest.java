package insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertTest {
    public static void main(String[] args) {
        // pet ���̺��� �̸�/������/��/����/����� Į���� �ֽ��ϴ�.
        insert("hyunjoong", "������", 3, "happy", 1);
    }

    public static void insert(String userID, String name, int grade,
                              String pw, int permission){
        Connection conn = null;
        PreparedStatement pstmt = null;

        try{
            // 1. ����̹� �ε�
            Class.forName("com.mysql.cj.jdbc.Driver");

            // 2. �����ϱ�
            String url = "jdbc:mysql://localhost/boarddb?useUnicode=true&serverTimezone=Asia/Seoul";
            conn = DriverManager.getConnection(url, "root", "dawnfire05");


            // 3. SQL ���� �غ�
            // �߰��Ϸ��� �������� ���� ���޵� ���ڸ� ���� �������� �Ҵ�Ǵ� ���̴�.
            // �� � ���� ���޵��� �𸣹Ƿ� Select �� ���� �޸�
            // stmt = conn.createStatement(); �� �ۼ����� �ʰ�
            // pstmt = conn.prepareStatement(sql); �� �ۼ��Ͽ� �����͸� �߰��� ������ �˸��ϴ�.
            // ���� sql ���� ������ + �����ڷ� �� �ٷ� �ۼ��� �� ������ �������� �ʹ� �������� �ǹǷ�
            // �� ����� ���մϴ�.
            String sql = "INSERT INTO user VALUES (?,?,?,?,?)";
            pstmt = conn.prepareStatement(sql);


            // 4. ������ binding
            pstmt.setString(1, userID);
            pstmt.setString(2, name);
            pstmt.setInt(3, grade);
            pstmt.setString(4, pw);
            pstmt.setInt(5, permission);


            // 5. ���� ���� �� ��� ó��
            // SELECT�� �޸� INSERT�� ��ȯ�Ǵ� �����͵��� �����Ƿ�
            // ResultSet ��ü�� �ʿ� ����, �ٷ� pstmt.executeUpdate()�޼��带 ȣ���ϸ� �˴ϴ�.
            // INSERT, UPDATE, DELETE ������ �̿� ���� �޼��带 ȣ���ϸ�
            // SELECT������ stmt.executeQuery(sql); �޼��带 ����߾����ϴ�.
            // @return     int - �� ���� row�� ������ ���ƴ����� ��ȯ
            int count = pstmt.executeUpdate();
            if( count == 0 ){
                System.out.println("������ �Է� ����");
            }
            else{
                System.out.println("������ �Է� ����");
            }
        }
        catch( ClassNotFoundException e){
            System.out.println("����̹� �ε� ����");
        }
        catch( SQLException e){
            System.out.println("���� " + e);
        }
        finally{
            try{
                if( conn != null && !conn.isClosed()){
                    conn.close();
                }
                if( pstmt != null && !pstmt.isClosed()){
                    pstmt.close();
                }
            }
            catch( SQLException e){
                e.printStackTrace();
            }
        }
    }
}