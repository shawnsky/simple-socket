/**
 * Created by Administrator on 2017/6/29.
 */

import java.io.Serializable;
import java.util.Date;

/**
 * Administrator
 *
 * @author xt
 *         06-29 11:17
 **/
public class Heartbeat implements Serializable{
    private Date time;
    private String origin;
    private String info;

    public Heartbeat() {
        this.time = new Date();
        this.origin = "unknown";
        this.info = "";
    }
    public Heartbeat(String origin){
        this.time = new Date();
        this.origin = origin;
        this.info = "";
    }

    public Heartbeat(String origin, String info){
        this.time = new Date();
        this.origin = origin;
        this.info = info;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
