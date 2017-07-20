package client;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import transport.MyProtocol;

/**
 * Created by admin on 2017/5/17.
 */
public class SimpleChatClientHandler extends SimpleChannelInboundHandler<MyProtocol> {

    /**
     * @param channelHandlerContext
     * @param myProtocol
     * @throws Exception
     */
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MyProtocol myProtocol) throws Exception {

    }

}
