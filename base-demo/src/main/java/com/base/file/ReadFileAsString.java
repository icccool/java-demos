package com.base.file;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFileAsString {

    public static void main(String[] args) {
        try {
            /***
             *
             * 文本里内容如下
             *
             * </li><li class="item file">
             *             <a href="/435345345435345.mp4">
             *                 <span class="icon square"><img src="/_h5ai/public/cache/thumbs/thumb-e2dded70091e8a984a5693d058c1a44b87a8c21c-240x240.jpg" alt="vid-mp4" class="thumb"></span>
             *                 <span class="icon landscape"><img src="/_h5ai/public/cache/thumbs/thumb-e2dded70091e8a984a5693d058c1a44b87a8c21c-320x240.jpg" alt="vid-mp4" class="thumb"></span>
             *                 <span class="date" data-time="1620911278000">2021-05-13 21:07</span>
             *                 <span class="size" data-bytes="238042471">238.0 MB</span>
             *             <span class="selector">
             *             <img src="/_h5ai/public/images/ui/selected.svg" alt="selected">
             *         </span></a>
             *         </li>
             */
            readToBuffer("C:\\Users\\jjmes\\Desktop\\1.txt");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void readToBuffer(String filePath) throws Exception {
        String readLine;
        InputStream is = new FileInputStream(filePath);
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        readLine = reader.readLine();
        while (readLine != null) {
            String matcherLine = matcherLine(readLine);
            if(matcherLine != null){
                matcherLine = matcherLine.replace("href=\"","https://www.tgbak.com/").replace("\"","");
                System.out.println(matcherLine);
            }
            readLine = reader.readLine();
        }
        reader.close();
        is.close();
    }

    /***
     *
     * 提取连接
     * @param line
     * @return
     */
    public static String matcherLine(String line){
        Pattern pattern = Pattern.compile("(href=\".*.mp4\")");
        Matcher matcher = pattern.matcher(line);
        if(matcher.find()){//这个必须
           return matcher.group(0);
        }
        return null;
    }

}
