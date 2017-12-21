package test.tencentbgp;

import com.sun.xml.internal.bind.v2.util.QNameMap;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by WL on 2017/7/20.
 */
public class Hash {
    public static void main(String[] args) {
        HashMap<String,String>hashMap = new HashMap<String,String>();
        hashMap.put("cn","中国");
        hashMap.put("jp", "日本");
        hashMap.put("fr", "法国");
//        System.out.println(hashMap);
//       System.out.println("cn:" + hashMap.get("cn"));
//        System.out.println(hashMap.containsKey("cn"));
//        System.out.println(hashMap.keySet());
//        System.out.println(hashMap.isEmpty());
//        Iterator it = hashMap.keySet().iterator();
//        while(it.hasNext()){
//            String key = (String)it.next();
//            System.out.println("key:" + key);
//            System.out.println("value:" + hashMap.get(key));
//        }
        //遍历HashMap的另一种方法
        Set<Map.Entry<String,String>> sets= hashMap.entrySet();
        for (Map.Entry<String,String> entry: sets) {
            System.out.print(entry.getKey() + ", ");
            System.out.println(entry.getValue());
        }
    }
}
