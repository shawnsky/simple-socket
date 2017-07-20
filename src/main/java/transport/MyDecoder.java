package transport; /**
 * Created by Administrator on 2017/6/27.
 */

import constant.Constant;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * Administrator
 *
 * @author xt
 *         06-27 17:30
 **/
public class MyDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {

        if(byteBuf.readableBytes()< Constant.BASE_LENGTH){
            return;
        }
        //find head data
        int beginIndex;
        while (true){
            beginIndex = byteBuf.readerIndex();
            byteBuf.markReaderIndex();
            if(byteBuf.readInt()== Constant.HEAD_DATA){
                break;
            }

            byteBuf.resetReaderIndex();
            byteBuf.readByte();

            if(byteBuf.readableBytes()< Constant.BASE_LENGTH){
                return;
            }
        }
        int type = byteBuf.readInt();
        int length = byteBuf.readInt();

        if(byteBuf.readableBytes()<length){
            byteBuf.readerIndex(beginIndex);
            return;
        }

        byte[] data = new byte[length];
        byteBuf.readBytes(data);

        MyProtocol myProtocol = new MyProtocol(type, data);
        list.add(myProtocol);
    }
}
