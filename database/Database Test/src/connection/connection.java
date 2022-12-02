package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class connection {
	public static void main(String[] args) {
		
        Connection conn = null;

		 try{
	            // 1. ����̹� �ε�
	            // ����̹� �������̽��� ������ Ŭ������ �ε�
	            // mysql, oracle �� �� ������ ���� Ŭ���� �̸��� �ٸ���.
	            // mysql�� "com.mysql.jdbc.Driver"�̸�, �̴� �ܿ�� ���� �ƴ϶� ���۸��ϸ� �ȴ�.
	            // ����� ������ �����ߴ� jar ������ ���� com.mysql.jdbc ��Ű���� Driver ��� Ŭ������ �ִ�.
	            Class.forName("com.mysql.cj.jdbc.Driver");

	            // 2. �����ϱ�
	            // ����̹� �Ŵ������� Connection ��ü�� �޶�� ��û�Ѵ�.
	            // Connection�� ��� ���� �ʿ��� url ����, �����縶�� �ٸ���.
	            // mysql�� "jdbc:mysql://localhost/�����db�̸�" �̴�.
	            String url = "jdbc:mysql://localhost/boarddb?useUnicode=true&serverTimezone=Asia/Seoul";

	            // @param  getConnection(url, userName, password);
	            // @return Connection
	            conn = DriverManager.getConnection(url, "root", "dawnfire05");
	            System.out.println("���� ����");

	        }
	        catch(ClassNotFoundException e){
	            System.out.println("����̹� �ε� ����");
	        }
	        catch(SQLException e){
	            System.out.println("����: " + e);
	        }
	        finally{
	            try{
	                if( conn != null && !conn.isClosed()){
	                    conn.close();
	                }
	            }
	            catch( SQLException e){
	                e.printStackTrace();
	            }
	        }
		}
}
