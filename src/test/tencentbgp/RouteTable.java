package test.tencentbgp;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WL on 2017/7/13.
 */
public class RouteTable {
    List<RouteTableEntry> routeTable = new ArrayList<RouteTableEntry>();

    // Map是key唯一，但是，实际上又有多个相同key，如何处理？？？
    // Map<String, List<RouteTableEntry>> routeTable = new HashMap();

    public void add(RouteTableEntry rte) {
        this.routeTable.add(rte);
    }

    public void remove(RouteTableEntry rte) {
        this.routeTable.remove(rte);
    }

    public List<RouteTableEntry> find(String prefix) {
        List<RouteTableEntry> retEntries = new ArrayList<>();
        boolean flag = false;
        for (RouteTableEntry e : this.routeTable) {
            if (e.getPrefix().equals(prefix)) {
                retEntries.add(e);
                flag = true;
            }
            if (!e.getPrefix().equals(prefix) && flag)
                break;
        }

        return retEntries;
    }

    public int update(String prefix, int tixId, RouteTableEntry rte) {
        int count = 0;
        for (RouteTableEntry e : this.routeTable) {
            if (e.getTixId() == tixId && e.getPrefix().equals(prefix)) {
                e.setNextHop(rte.getNextHop());
                e.setDelay(rte.getDelay());
                count++;
            }
        }

        return count;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for ( RouteTableEntry rte : routeTable ) {
            sb.append(rte.toString()).append("\n");
        }
        return sb.toString();
        //return super.toString();
    }
}
