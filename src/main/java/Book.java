/**
 * Created by Administrator on 2017/6/24.
 */

import java.io.Serializable;

/**
 * Administrator
 *
 * @author xt 06-24 15:00
 */
public class Book implements Serializable{
    private String name;
    private Integer id;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
