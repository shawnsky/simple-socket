package utils; /**
 * Created by Administrator on 2017/6/24.
 */

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Administrator
 *
 * @author xt
 *         06-24 11:02
 **/
public class DateUtil {
    public static String getTime(){
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
        return sdf.format(new Date());
    }
}
