import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.concurrent.Callable;

/**
 * Created by admin on 2017/5/17.
 */
public class SimpleChatClient {
    private String host;
    private int port;
    public SimpleChatClient(String host, int port){
        this.host = host;
        this.port = port;
    }

    public void run() throws Exception{
        EventLoopGroup worker = new NioEventLoopGroup();
        try{
            Bootstrap b = new Bootstrap();
            b.group(worker)
                    .channel(NioSocketChannel.class)
                    .handler(new SimpleChatClientInitializer());
            Channel channel = b.connect(host, port).sync().channel();
            Scanner scanner = new Scanner(System.in);



            Heartbeat heartbeat = new Heartbeat(channel.localAddress().toString());
            Thread sendHeartbeat = new Thread(() -> {
                while (true){
                    byte[] bytes = ConvertUtil.getBytes(heartbeat);
                    MyProtocol myProtocol = new MyProtocol(Constant.TYPE_HEARTBEAT, bytes);
                    channel.writeAndFlush(myProtocol);
                    try {
                        Thread.sleep(10*1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            sendHeartbeat.start();




            while(true){
                System.out.println("input book id:");
                int i = scanner.nextInt();
                System.out.println("input book name:");
                String name = scanner.next();
                Book book = new Book();
                book.setId(i);
                book.setName(name);
                byte[] bytes = ConvertUtil.getBytes(book);
                MyProtocol myProtocol = new MyProtocol(Constant.TYPE_OBJECT, bytes);
                channel.writeAndFlush(myProtocol);

            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        finally {
            worker.shutdownGracefully();
        }
    }
    public static void main(String[] args)throws Exception{

        new SimpleChatClient(Host.SERVER_HOST, Host.SERVER_PORT).run();

    }
}
