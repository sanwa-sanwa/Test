package CRUD;

import scala.annotation.StaticAnnotation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class CRUDTest    {
    /**设置参数**/
    private static Connection orderInfoCon = null;
    private static Connection orderLogCon = null;
    private static Statement stmt = null;
    private static ResultSet rs = null;
    public static void main(String[] args) throws  Exception {
            String line=null;
            //读取info文件
            File ReadJsonFile = new File("E://ToBD2//2IOrderInfo.txt");
            //读取log文件
            File ReadOpFile = new File("E://ToBD2//2IOrderLog.txt");
            //获取每一行数据
            BufferedReader Jsonbr = new BufferedReader(new InputStreamReader(new FileInputStream(ReadJsonFile)));
            BufferedReader Opbr = new BufferedReader(new InputStreamReader(new FileInputStream(ReadOpFile)));
            int t=2;
            int i=1;
            while((line=Jsonbr.readLine())!=null&&i<=t){
                //System.out.println(line);
                i++;
                orderInfoCon = JDBCUtils.getConnection();
                 stmt= orderInfoCon.createStatement();
                //json转化为Hashmap
                HashMap<String,String> map = new ReadTxtUtil().JsonToMap(line);
                //插入数据
                String AREA_NO = map.get("AREA_NO");
                String GRID_ID = map.get("GRID_ID");
                String ORDER_NO = map.get("ORDER_NO");
                String ORDER_DATE = map.get("ORDER_DATE");
                String ORDER_SOURCE = map.get("ORDER_SOURCE");
                String PHONE_NUM = map.get("PHONE_NUM");
                String SD_DATE = map.get("SD_DATE");
                String SD_PERSON = map.get("SD_PERSON");
                String OPEN_DATE = map.get("OPEN_DATE");
                String DISTR_TYPE = map.get("DISTR_TYPE");
                String FH_DATE = map.get("FH_DATE");
                String QS_DATE = map.get("QS_DATE");
                String DISTR_PERSON = map.get("DISTR_PERSON");
                String DEALER_ID = map.get("DEALER_ID");
                String LOGISTICS_ID = map.get("LOGISTICS_ID");
                String LOGISTICS_NO = map.get("LOGISTICS_NO");
                String JH_DATE = map.get("JH_DATE");
                String FIRST_FEE_DATE = map.get("FIRST_FEE_DATE");
                String FIRST_FEE = map.get("FIRST_FEE");
                String CONTACT_NUM = map.get("CONTACT_NUM");
                String CONTACT_ADDR = map.get("CONTACT_ADDR");
                String DISTR_ADDR = map.get("DISTR_ADDR");
                String RESERCE_CLUN01 = map.get("RESERCE_CLUN01");
                String RESERCE_CLUN02 = map.get("RESERCE_CLUN02");
                String RESERCE_CLUN03 = map.get("RESERCE_CLUN03");
                String RESERCE_CLUN04 = map.get("RESERCE_CLUN04");
                String RESERCE_CLUN05 = map.get("RESERCE_CLUN05");
                String RESERCE_CLUN06 = map.get("RESERCE_CLUN06");
                String RESERCE_CLUN07 = map.get("RESERCE_CLUN07");
                String RESERCE_CLUN08 = map.get("RESERCE_CLUN08");
                String RESERCE_CLUN09 = map.get("RESERCE_CLUN09");
                String RESERCE_CLUN10 = map.get("RESERCE_CLUN10");
                System.out.println("----------------------------------------------");
                Set<String> keySet = map.keySet();
                for(String str :keySet){
                    System.out.println(str+":"+map.get(str));
                }
               //编写sql
                String  sql ="insert into MID.MID_D_ORDER_KAFKA_REALTIME values(AREA_NO,GRID_ID,ORDER_NO,ORDER_DATE,ORDER_SOURCE,PHONE_NUM,SD_DATE,SD_PERSON,OPEN_DATE,DISTR_TYPE," +
                        "FH_DATE,QS_DATE,DISTR_PERSON,DEALER_ID,LOGISTICS_ID,LOGISTICS_NO,JH_DATE,FIRST_FEE_DATE,FIRST_FEE,CONTACT_NUM,CONTACT_ADDR,DISTR_ADDR," +
                        "RESERCE_CLUN01,RESERCE_CLUN02,RESERCE_CLUN03,RESERCE_CLUN04,RESERCE_CLUN05,RESERCE_CLUN06,RESERCE_CLUN07,RESERCE_CLUN08,RESERCE_CLUN09,RESERCE_CLUN10) ";
                //执行sql
                String  sql1 ="insert into MID.MID_D_ORDER_KAFKA_REALTIME values(1,1,1,1,1,1,1,1,1,1," +
                        "1,1,1,1,1,1,1,1,1,1,1,1," +
                        "1,1,1,1,1,1,1,1,1,1) ";

                int num = stmt.executeUpdate(sql1);
                if(num>0)
                    System.out.println("插入成功！   ");


                //System.out.println("jsonToMap:"+map.toString());
            }

            while((line=Opbr.readLine())!=null) {
                System.out.println(line);
                //分号间隔的字符串转化为Hashmap
               ArrayList<String> arr = new ReadTxtUtil().OptoMap(line);

            }



        }



}






