package com.smart.algorithm.baiduAI;

import com.smart.algorithm.https.HttpClientUtil;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 相同图检索—— 图片入库
 * Created by fc.w on 2017/9/6.
 */
public class ImageAdd {

    public static String imgAdd(String imgFile) {
        String url = "https://aip.baidubce.com/rest/2.0/realtime_search/same/add";
        String accessToken = "24.732bef029fee60461d5786751ea487ad.2592000.1507342455.282335-10101665";
        url += "?access_token=" + accessToken;
        String appid = "10101665";
        HttpClientUtil httpClientUtil =  new HttpClientUtil();
        String charset = "utf-8";

        try {

            File file = new File(imgFile);
            File [] files = file.listFiles();
            for (int i = 0; i < files.length; i++) {
                File file1 = files[i];
                String imgUrl = imgFile + "\\" + file1.getName();
                String imgBase64 = Image2Base64.getImageStr(imgUrl);

                Map<String,String> createMap = new HashMap<String,String>();
                createMap.put("sub_lib", appid);
                createMap.put("image", imgBase64);

                String httpOrgCreateTestRtn = httpClientUtil.sendPOST(url, createMap, charset);
                System.out.println("result:"+httpOrgCreateTestRtn);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "";
    }

    public static void main(String[] args) {
        imgAdd("C:\\Users\\Administrator\\Desktop\\中原地产");
    }

}