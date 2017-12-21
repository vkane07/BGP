package test.tencentbgp;

import java.util.Set;

/**
 * Created by WL on 2017/7/13.
 */
public class RouteTableEntry {
    private int tixId;
    private String prefix;
    private String nextHop;
    private int asPath;
    private int delay;

    public RouteTableEntry() {

    }

    public RouteTableEntry(int tixId,String prefix,String nextHop, int asPath, int delay){
        this.tixId = tixId;
        this.prefix = prefix;
        this.nextHop = nextHop;
        this.asPath = asPath;
        this.delay = delay;

    }
    public int getTixId() {
        return tixId;
    }

    public void setTixId(int tixId) {
        this.tixId = tixId;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getNextHop() {
        return nextHop;
    }

    public void setNextHop(String nextHop) {
        this.nextHop = nextHop;
    }

    public int getAsPath() {
        return asPath;
    }

    public void setAsPath(int asPath) {
        this.asPath = asPath;
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public String toString() {
        return "RouteTableEntry{" +
                "tixId=" + tixId +
                ", prefix='" + prefix + '\'' +
                ", nextHop='" + nextHop + '\'' +
                ", asPath='" + asPath + '\'' +
                ", delay=" + delay +
                '}';
    }




}


