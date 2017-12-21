package test.tencentbgp;

import java.io.IOException;
import java.util.*;


/**
 * Created by WL on 2017/7/13.
 */
public class Algorithm {
    private int[][] delayMatix;
    String prefix;
    private RouteTable rTable;

    public Algorithm(int[][] matrix, RouteTable rt) {
        this.delayMatix = matrix;
        this.rTable = rt;
    }

    public RouteTable run() throws IOException {
        //...
        //return null;
//        String r =null;
//        r = FileUtils.readPrefix("prefix_demo.txt");
//        String[] str = r.split("\r\n");
        //System.out.println(str[0]);
//        for (int i = 0; i <str.length ; i++) {
//            System.out.println(str[i]);
//        }
//        for (int i = 0; i <str.length ; i++) {
//            String []st = str[i].split("\t");
//            RouteTableEntry entry = new RouteTableEntry();
//            entry.setTixId(Integer.parseInt(st[0]));
//            entry.setPrefix(st[1]);
//        }
        //for (RouteTableEntry rte: rTable.routeTable){
//            prefix =rte.getPrefix();
//            List<RouteTableEntry> = rTable.find(prefix);
       // }
      //  List<RouteTableEntry> = routeTable.find()
        int temp = 0;
        int []k = new int[10];
        int r=0;
        Boolean flag =false;
        Map<Integer,Integer> map =new HashMap<Integer, Integer>();
        prefix = "19.16.1.0/24";
        List<RouteTableEntry> list = rTable.find(prefix);
        ArrayList<Integer> a1 =new ArrayList();
        ArrayList<Integer> a2 =new ArrayList();

        /***************** 建立路由表map *******************/
//        Map<String,Map<Integer,List<RouteTableEntry>>> rou = new HashMap<>();
//        for (RouteTableEntry rte : rTable.routeTable) {
//            String pf = rte.getPrefix();
//            int id = rte.getTixId();
//            if ( rou.containsKey(pf) ) {
//                Map<Integer,List<RouteTableEntry>> val = rou.get(pf);
//                if ( val.containsKey(id) ) {
//                    val.get(id).add(rte);
//                } else {
//                    List<RouteTableEntry> entry  = new ArrayList<>();
//                    entry.add(rte);
//                    val.put(id,entry);
//                }
//            } else {
//                Map<Integer,List<RouteTableEntry>> val = new HashMap<>();
//                List<RouteTableEntry> entry  = new ArrayList<>();
//                entry.add(rte);
//                val.put(id,entry);
//                rou.put(pf,val);
//            }
//        }
        /************************************/
        /***************** 所有前缀，其中的某个路由器的最小延迟 *******************/
        //RouteTableEntry(int tixId,String prefix,String nextHop, String asPath, int delay)
        Map<String,Map<Integer,RouteTableEntry>> rou = new HashMap<>();
        List<RouteTableEntry> new_table = new ArrayList<>();
        for (RouteTableEntry old : rTable.routeTable) {
            RouteTableEntry rte = new RouteTableEntry(old.getTixId()
                , old.getPrefix(), old.getNextHop(), old.getAsPath(), old.getDelay());
            new_table.add(rte);
            String pf = rte.getPrefix();
            int id = rte.getTixId();
            if ( rou.containsKey(pf) ) {
                Map<Integer,RouteTableEntry> val = rou.get(pf);
                if ( val.containsKey(id) ) {
                    if ( val.get(id).getDelay() > rte.getDelay() ) {
                        val.put(id, rte);
                    }
                } else {
                    val.put(id, rte);
                }
            } else {
                Map<Integer,RouteTableEntry> val = new HashMap<>();
                val.put(id, rte);
                rou.put(pf, val);
            }
        }
        /*************************************/
        for ( Map<Integer,RouteTableEntry> this_profix : rou.values() ) {
            for ( RouteTableEntry to_update_table : this_profix.values() ) {
                for ( RouteTableEntry other_table : this_profix.values() ) {
                    int delay1 = to_update_table.getDelay();
                    int delay2 = other_table.getDelay();
                    int delay3 = delayMatix[to_update_table.getTixId()][other_table.getTixId()];
                    if ( delay2 + delay3 < delay1 ) {
                        to_update_table.setDelay( delay2 + delay3 );
                        to_update_table.setAsPath( other_table.getAsPath() + 1 );
                        to_update_table.setNextHop( other_table.getNextHop() );
                    }
                }
            }
        }
        RouteTable new_rt = new RouteTable();
        new_rt.routeTable = new_table;
        /************************************/

//        for (RouteTableEntry rte:list) {
//            int i =rte.getTixId();
//            a1.add(i);
//            int j =rte.getDelay();
//            a2.add(j);
//            //map.put(rte.getTixId(),rte.getDelay());
//        }
//        Integer b[] = new Integer[a1.size()];
//       int b1[] = new int[a1.size()];
//        a1.toArray(b);
//        for (int i = 0; i <b.length; i++) {
//            b1[i] = b[i].intValue();
//        }
//        for(int i=0;i<b1.length;i++){
//            temp=b1[0];
//            if(temp == b1[i]){
//                k[r++] =i;
//                flag = true;
//            }
//            temp=b1[i];
//            k[0]=i;
//            continue;
//        }
        return new_rt;
 //       return new RouteTable();
    }

}
