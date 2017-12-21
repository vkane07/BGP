package test.tencentbgp;

import java.io.*;

/**
 * Created by WL on 2017/7/19.
 */
public class FileUtils {

    // 读时延矩阵文件
    public static int[][] readMatrix(String fileName)throws IOException {
        int[][] matrix = new int[10][10];
//        File file = new File(fileName);
//        if (!file.exists()) {
//            throw new IOException("文件未找到:" + fileName);
//        }
        InputStream is1 = ClassLoader.getSystemResourceAsStream(fileName);
        BufferedReader br1 = null;
        int i =0;
        try {
            System.out.println("Read Matrix File.");
            br1 = new BufferedReader(new InputStreamReader(is1));
            String tmp;

            while ((tmp = br1.readLine()) != null) {
                //System.out.println("Line Content = " + tmp);
                if (tmp.length() != 0) {
                    String[] strs = tmp.split("\t");
                    if(strs !=null && strs.length !=0){
                    for(int j =0;j<strs.length;j++){
                        matrix[i][j] = Integer.parseInt(strs[j]);
                    }
                    i++;
                        }
//                    if (strs != null && strs.length != 0) {
//                        int delay = Integer.parseInt(strs[0]);

  //                      System.out.println("Delay[delay] = " + (delay));

//                        System.out.println("Delay[strdelay + 2222] = " + (strs[0] + 2222));
//
//                        for (String s : strs) {
//                            System.out.println(s);
//                        }
                  //  }
                }
            }
            br1.close();
            is1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return matrix;
    }

    // 读前缀表
    public static String readPrefix(String fileName)throws IOException {
        RouteTable table = new RouteTable();
        //......
//        File file = new File(fileName);
//        if (!file.exists()) {
//            throw new IOException("文件未找到:" + fileName);
//        }
        InputStream is2 =  ClassLoader.getSystemResourceAsStream(fileName);
        BufferedReader br2 = null;
        StringBuffer sb =new StringBuffer();
        try {
            System.out.println("Read Prefix File.");
            br2 = new BufferedReader(new InputStreamReader(is2));
            String tmp;

            while ((tmp = br2.readLine()) != null) {
               // System.out.println("Line Content = " + tmp);
                sb.append(tmp);
                sb.append("\r\n");
            }
            br2.close();
            is2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
            return sb.toString();
    }

}
