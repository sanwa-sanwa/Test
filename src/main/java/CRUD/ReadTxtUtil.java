package CRUD;


import org.json.JSONArray;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ReadTxtUtil {


    public  HashMap<String, String> JsonToMap(String line) {
        //格式化json文件
        JSONObject jsonObject = new JSONObject(line);
        Long orderId = jsonObject.getLong("orderId");
        String orderFrom = jsonObject.getString("orderFrom");
        String orderNo = jsonObject.getString("orderNo");
        String orderState = jsonObject.getString("orderState");
        String orderTime = jsonObject.getString("orderTime");
        //String tid = jsonObject.getString("tid");
        String tid = jsonObject.get("tid").toString();  //todo:这里是什么类型??
        JSONObject payInfo = jsonObject.getJSONObject("payInfo");
        Long couponMoney = payInfo.getLong("couponMoney");
        Long incomeMoney = payInfo.getLong("incomeMoney");
        Long topayMoney = payInfo.getLong("topayMoney");
        String payState = payInfo.getString("payState");
        String payType = payInfo.get("payType").toString();
        String udpInfo = payInfo.get("udpInfo").toString();
        JSONObject postInfo = jsonObject.getJSONObject("postInfo");
        String mobilePhone = postInfo.getString("mobilePhone");
        String receiverName = postInfo.getString("receiverName");
        JSONObject referrerInfo = jsonObject.getJSONObject("referrerInfo");
        String referrerCode = referrerInfo.get("referrerCode").toString();
        String referrerDepartId = referrerInfo.get("referrerDepartId").toString();

        JSONObject goodsInfo = (JSONObject) jsonObject.getJSONArray("goodsInfo").get(0);
        JSONObject activityInfo = goodsInfo.getJSONObject("activityInfo");
        String activityType = activityInfo.get("activityType").toString();
        String eventId = activityInfo.get("eventId").toString();
        String eventName = activityInfo.get("eventName").toString();
        String actProtPer = activityInfo.get("actProtPer").toString();

        JSONObject certInfo = goodsInfo.getJSONObject("certInfo");
        String certAddr = certInfo.get("certAddr").toString();
        String certName = certInfo.get("certName").toString();
        String certNo = certInfo.get("certNo").toString();
        String certType = certInfo.get("certType").toString();
        String cityCode = goodsInfo.getString("cityCode");
        Long goodsId = goodsInfo.getLong("goodsId");
        String goodsName = goodsInfo.getString("goodsName");
        String goodsType = goodsInfo.getString("goodsType");
        String mainFlag = goodsInfo.getString("mainFlag");
        String numType = goodsInfo.getString("numType");
        String phoneNum = goodsInfo.getString("phoneNum");
        String productId = goodsInfo.getString("productId");
        String productName = goodsInfo.getString("productName");
        String productType = goodsInfo.getString("productType");

        JSONObject resourcesInfo = goodsInfo.getJSONObject("resourcesInfo");
        String resourcesBrand = resourcesInfo.get("resourcesBrand").toString();
        String resourcesCode = resourcesInfo.get("resourcesCode").toString();
        String resourcesColor = resourcesInfo.get("resourcesColor").toString();
        String resourcesModel = resourcesInfo.get("resourcesModel").toString();
        String tmplType = goodsInfo.get("tmplType").toString();
        String userTag = goodsInfo.get("userTag").toString();

        HashMap<String, String> TMap = new HashMap<String, String>();
        TMap.put("ORDER_SOURCE",orderFrom); //订单来源
        TMap.put("orderId",orderId.toString());
        TMap.put("ORDER_NO",orderNo);  //订单编号
        TMap.put("orderState",orderState);
        TMap.put("ORDER_DATE",orderTime); //订单时间
        TMap.put("couponMoney",couponMoney.toString());
        TMap.put("incomeMoney",incomeMoney.toString());
        TMap.put("payState",payState);
        TMap.put("payType",payType);
        TMap.put("topayMoney",topayMoney.toString());
        TMap.put("udpInfo",udpInfo);
        TMap.put("receiverName",receiverName);
        TMap.put("mobilePhone",mobilePhone);
        TMap.put("referrerCode",referrerCode);
        TMap.put("referrerDepartId",referrerDepartId);
        TMap.put("tid",tid);
        TMap.put("tmplType",tmplType);
        TMap.put("userTag",userTag);
        TMap.put("resourcesBrand",resourcesBrand);
        TMap.put("resourcesCode",resourcesCode);
        TMap.put("resourcesColor",resourcesColor);
        TMap.put("resourcesModel",resourcesModel);
        TMap.put("productType",productType);
        TMap.put("productName",productName);
        TMap.put("productId",productId);
        TMap.put("PHONE_NUM",phoneNum);  //预售号码
        TMap.put("numType",numType);
        TMap.put("mainFlag",mainFlag);
        TMap.put("goodsType",goodsType);
        TMap.put("goodsName",goodsName);
        TMap.put("goodsId",goodsId.toString());
        TMap.put("cityCode",cityCode);
        TMap.put("certAddr",certAddr);
        TMap.put("certName",certName);
        TMap.put("certNo",certNo);
        TMap.put("certType",certType);
        TMap.put("eventName",eventName);
        TMap.put("eventId",eventId);
        TMap.put("activityType",activityType);
        TMap.put("actProtPer",actProtPer);
        TMap.put("AREA_NO","字段缺失");  //地市
        TMap.put("GRID_ID","字段缺失");   //区县
        TMap.put("SD_DATE","字段缺失");  //审单时间
        TMap.put("SD_PERSON","字段缺失"); //审单人员
        TMap.put("OPEN_DATE","字段缺失"); //开户时间
        TMap.put("DISTR_TYPE","字段缺失");     //配送方式
        TMap.put("FH_DATE","字段缺失");  //发货时间
        TMap.put("QS_DATE","字段缺失");  //签收时间
        TMap.put("DISTR_PERSON","字段缺失");  //配送人员
        TMap.put("DEALER_ID","字段缺失");  //自营业厅
        TMap.put("LOGISTICS_ID","字段缺失");//物流公司
        TMap.put("LOGISTICS_NO","字段缺失");//物流单号
        TMap.put("JH_DATE","字段缺失");//激活时间
        TMap.put("FIRST_FEE_DATE","字段缺失");//首充时间
        TMap.put("FIRST_FEE","字段缺失");//首充金额
        TMap.put("CONTACT_NUM",mobilePhone);//联系电话
        TMap.put("CONTACT_ADDR","字段缺失");//联系地址
        TMap.put("DISTR_ADDR","字段缺失");//配送地址
        TMap.put("RESERCE_CLUN01","预留");
        TMap.put("RESERCE_CLUN02","预留");
        TMap.put("RESERCE_CLUN03","预留");
        TMap.put("RESERCE_CLUN04","预留");
        TMap.put("RESERCE_CLUN05","预留");
        TMap.put("RESERCE_CLUN06","预留");
        TMap.put("RESERCE_CLUN07","预留");
        TMap.put("RESERCE_CLUN08","预留");
        TMap.put("RESERCE_CLUN09","预留");
        TMap.put("RESERCE_CLUN10","预留");

        return TMap;
    }

    public ArrayList<String> OptoMap(String line) {
        ArrayList<String> arr = new ArrayList<String>();
        String[] strs = line.split(",");
        for(String str :strs){
            arr.add(str);
        }
        return arr;
    }
}
