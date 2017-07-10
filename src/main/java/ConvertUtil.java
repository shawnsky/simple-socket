/**
 * Created by Administrator on 2017/6/27.
 */

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

import java.io.*;

/**
 * Administrator
 *
 * @author xt
 *         06-27 17:51
 **/
public class ConvertUtil {

    public static byte[] getBytes(Object o){
        byte[] bytes;
        ByteArrayOutputStream bo = new ByteArrayOutputStream();
        try {
            ObjectOutputStream oo = new ObjectOutputStream(bo);
            oo.writeObject(o);
            bytes =  bo.toByteArray();

            bo.close();
            oo.close();
        } catch (IOException e) {
            bytes = null;
            e.printStackTrace();
        }

        return bytes;
    }


    public static Object getObject(byte[] bytes){
        Object o;
        ByteArrayInputStream bi = new ByteArrayInputStream(bytes);
        try {
            ObjectInputStream oi = new ObjectInputStream(bi);
            o =  oi.readObject();

            bi.close();
            oi.close();
        } catch (Exception e) {
            o = null;
            e.printStackTrace();
        }

        return o;
    }
}
