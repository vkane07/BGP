package test.tencentbgp;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        // 读时延矩阵文件
        /*int[][] matrix = new int[10][10];

        InputStream is1 =  ClassLoader.getSystemResourceAsStream("matrix_demo.txt");
        BufferedReader br1 = null;

        try {
            System.out.println("Read Matrix File.");
            br1 = new BufferedReader(new InputStreamReader(is1));
            String tmp;

            while ((tmp = br1.readLine()) != null) {
                System.out.println("Line Content = " + tmp);
                if (tmp.length() != 0) {
                    String[] strs = tmp.split("\t");

                    if (strs != null && strs.length != 0) {
                        int delay = Integer.parseInt(strs[0]);

                        System.out.println("Delay[delay] = " + (delay));

//                        System.out.println("Delay[strdelay + 2222] = " + (strs[0] + 2222));
//
//                        for (String s : strs) {
//                            System.out.println(s);
//                        }
                    }
                }
            }
            br1.close();
            is1.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // 读前缀表
        RouteTable table = new RouteTable();
        //......

        InputStream is2 =  ClassLoader.getSystemResourceAsStream("prefix_demo.txt");
        BufferedReader br2 = null;

        try {
            System.out.println("Read Prefix File.");
            br2 = new BufferedReader(new InputStreamReader(is2));
            String tmp;

            while ((tmp = br2.readLine()) != null) {
                System.out.println("Line Content = " + tmp);
            }
            br2.close();
            is2.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
*/      int[][] matrix = new int[10][10];
        String r =new String();
        r=null;
        RouteTable table = new RouteTable();
        matrix = FileUtils.readMatrix("matrix_demo.txt");
        for (int i = 0; i <5 ; i++) {
            for (int j = 0; j <5 ; j++) {
      //          System.out.print(matrix[i][j]+"\t");
            }
       //     System.out.println();
        }
        r = FileUtils.readPrefix("TIX-50.txt");
            String[] str = r.split("\r\n");
            //System.out.println(str[0]);
            for (int i = 0; i <str.length ; i++) {
//            System.out.println(str[i]);
            String[] termlist = str[i].split("\t\t");
            int tixid = Integer.parseInt(termlist[0]);
            String prefix = termlist[1];
            String nexthop = termlist[2];
//            int aspath = Integer.parseInt(termlist[3]);
//            int delay = Integer.parseInt(termlist[4]);
            int delay = Integer.parseInt(termlist[3]);
            int aspath = Integer.parseInt(termlist[4]);
            RouteTableEntry entry = new RouteTableEntry(tixid, prefix, nexthop, aspath, delay);
            table.add(entry);
        }
        long startTime=System.currentTimeMillis();
        // 跑算法
        Algorithm algorithm = new Algorithm(matrix, table);

        RouteTable result = algorithm.run();
        long endTime=System.currentTimeMillis();
        // 打印最后的前缀路由表
        // print .....

        System.out.println(result);
        System.out.println("程序运行时间： "+(endTime-startTime)+"ms");
    }
}
