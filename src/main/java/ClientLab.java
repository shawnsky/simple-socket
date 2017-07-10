/**
 * Created by Administrator on 2017/6/29.
 */

import java.util.HashSet;

/**
 * Administrator
 *
 * @author xt
 *         06-29 13:48
 **/
public class ClientLab {
    private static HashSet<Heartbeat> clients;
    private ClientLab(){
    }

    public static HashSet<Heartbeat> getClients(){
        if(clients == null){
            clients = new HashSet<>();
        }
        return clients;
    }
}
