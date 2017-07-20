package server;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import transport.MyProtocol;
import utils.ConvertUtil;
import utils.DateUtil;

/**
 * Created by admin on 2017/5/17.
 */
public class SimpleChatServerHandler extends SimpleChannelInboundHandler<MyProtocol> {
    //begin

    public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);


    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        channels.add(incoming);
        channels.writeAndFlush(DateUtil.getTime()+" "+incoming.remoteAddress()+" online\n");
        System.out.println(DateUtil.getTime()+" "+ incoming.remoteAddress()+" online ");

    }

    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel incoming = ctx.channel();
        channels.remove(incoming);
        channels.writeAndFlush(DateUtil.getTime()+" "+incoming.remoteAddress()+" offline\n");
        System.out.println(DateUtil.getTime()+" "+ incoming.remoteAddress()+" offline ");
    }


    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("ERROR: "+cause.getMessage());
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyProtocol myProtocol) throws Exception {
        if(myProtocol.getContentType() == Constant.TYPE_HEARTBEAT){
            Heartbeat heartbeat = (Heartbeat) ConvertUtil.getObject(myProtocol.getContent());
            System.out.println("received heartbeat "+heartbeat.getInfo()+" from "+heartbeat.getOrigin());
        } else {
            Book book = (Book) ConvertUtil.getObject(myProtocol.getContent());
            Channel incoming = ctx.channel();
            System.out.println(DateUtil.getTime()+" "+incoming.remoteAddress()+" "+book.toString());
            channels.writeAndFlush(DateUtil.getTime()+" "+incoming.remoteAddress()+" "+book.toString()+"\n");
        }

    }
}
