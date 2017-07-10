import com.sun.xml.internal.bind.v2.TODO;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.timeout.IdleStateEvent;

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
