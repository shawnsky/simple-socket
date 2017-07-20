package transport; /**
 * Created by Administrator on 2017/6/27.
 */

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * Administrator
 *
 * @author xt
 *         06-27 15:24
 **/
public class MyEncoder extends MessageToByteEncoder<MyProtocol> {

    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MyProtocol myProtocol, ByteBuf byteBuf) throws Exception {
        byteBuf.writeInt(myProtocol.getHeadData());
        byteBuf.writeInt(myProtocol.getContentType());
        byteBuf.writeInt(myProtocol.getContentLength());
        byteBuf.writeBytes(myProtocol.getContent());
    }
}

