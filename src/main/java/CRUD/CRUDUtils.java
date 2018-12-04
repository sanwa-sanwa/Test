package CRUD;

import javax.xml.transform.Source;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLOutput;
import java.sql.Statement;
import java.util.Collections;

public class CRUDUtils {
    private static Connection conn = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;

    public static void query(String sql) throws  Exception{
        conn= JDBCUtils.getConnection();
        stmt= conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
            System.out.println(rs);
        }
    }
    public static void  update(String sql)throws  Exception{
        conn= JDBCUtils.getConnection();
        stmt= conn.createStatement();
        int num = stmt.executeUpdate(sql);
        if(num>0){
            System.out.println("修改成功");

        }
    }


}
