package server;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import transport.MyDecoder;
import transport.MyEncoder;

import java.util.concurrent.TimeUnit;

/**
 * Created by admin on 2017/5/17.
 */
public class SimpleChatServerInitializer extends ChannelInitializer<SocketChannel> {
    /**
     * 这个类用来增加多个处理类到 ChannelPipeline 上，包括编码/解码/server.SimpleChatServerHandler
     */
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("idle", new IdleStateHandler(10,10,30, TimeUnit.SECONDS));
        pipeline.addLast("decoder", new MyDecoder());
        pipeline.addLast("encoder", new MyEncoder());
        pipeline.addLast("heartbeat", new HeartbeatServerHandler());
        pipeline.addLast("handler", new SimpleChatServerHandler());
    }
}
