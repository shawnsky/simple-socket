package transport;
import constant.Constant;
/**
 * Created by Administrator on 2017/6/27.
 */

/**
 * 自定义传输协议类
 * 传输结构:
 * 消息头headData+contentLength+contentType
 * 消息体content
 * @author xt 06-27 17:33
 */

public class MyProtocol {

    private int headData;

    private int contentType;

    private int contentLength;

    private byte[] content;

    public MyProtocol(int contentType, byte[] content) {
        this.headData = Constant.HEAD_DATA;
        this.contentType = contentType;
        this.content = content;
        this.contentLength = content.length;
    }

    public int getHeadData() {
        return headData;
    }

    public void setHeadData(int headData) {
        this.headData = headData;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public int getContentType() {
        return contentType;
    }

    public void setContentType(int contentType) {
        this.contentType = contentType;
    }

    public byte[] getContent() {
        return content;
    }

    public void setContent(byte[] content) {
        this.content = content;
    }
}
