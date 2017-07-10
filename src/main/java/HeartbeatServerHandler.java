/**
 * Created by Administrator on 2017/6/29.
 */

import io.netty.channel.Channel;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * Administrator
 *
 * @author xt
 *         06-29 15:23
 **/
public class HeartbeatServerHandler extends ChannelInboundHandlerAdapter {

    /**
     * idleStateHandler会帮助监听channel状态，本方法用来捕获事件并处理
     * ALL_IDLE 服务器自动清理异常连接
     * @param ctx
     * @param evt
     * @throws Exception
     */
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        Channel channel = ctx.channel();
        if (evt instanceof IdleStateEvent) {
            IdleStateEvent e = (IdleStateEvent) evt;
            switch (e.state()) {
                case READER_IDLE:
                    //System.out.println(channel.remoteAddress()+" reader idle");

                    break;
                case WRITER_IDLE:
                    //System.out.println(channel.remoteAddress()+" write idle");

                    break;
                case ALL_IDLE:
                    //System.out.println(channel.remoteAddress()+" all idle");
                    ctx.writeAndFlush("stop").addListener(ChannelFutureListener.CLOSE);
                    break;
                default:
                    break;
            }
        }

    }

    private void sendHeartbeat(ChannelHandlerContext ctx){
        byte[] bytes = ConvertUtil.getBytes(new Heartbeat(ctx.channel().remoteAddress().toString()));
        ctx.channel().writeAndFlush(new MyProtocol(Constant.TYPE_HEARTBEAT,bytes));
    }
}
