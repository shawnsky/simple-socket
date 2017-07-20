package client;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import transport.MyDecoder;
import transport.MyEncoder;

/**
 * Created by admin on 2017/5/17.
 */
public class SimpleChatClientInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();
        pipeline.addLast("decoder", new MyDecoder());
        pipeline.addLast("encoder", new MyEncoder());
        pipeline.addLast("handler", new SimpleChatClientHandler());
    }


}
