package netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class NettyServer {

    public static void main(String[] args) {
        EventLoopGroup bossLoop = new NioEventLoopGroup();
        EventLoopGroup workerLoop = new NioEventLoopGroup();
        try {
            // 服务器启动对象
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap
                    // 绑定两个线程池 bossLoop 用来处理客户端的连接请求 workerLoop 用来处理业务请求
                    .group(bossLoop, workerLoop)
                    // 绑定通道
                    .channel(NioServerSocketChannel.class)
                    // 设置连接数1024
                    .option(ChannelOption.SO_BACKLOG, 1024)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast();
                        }
                    });
            ChannelFuture future = bootstrap.bind(9000).sync();
            future.addListener(new ChannelFutureListener() {
                @Override
                // 监听想要的事件
                public void operationComplete(ChannelFuture channelFuture) throws Exception {
                    if (channelFuture.isSuccess()) {
                        System.out.println("监听端口9000成功");
                    } else {
                        System.out.println("监听端口9000失败");
                    }
                }
            });
            // 等待服务器监听端口关闭closeFuture异步操作
            // 通过sync方法同步等待通道关闭处理完毕 ，这里会阻塞等待通道关闭，内部调用Object的wait（）方法
            future.channel().closeFuture().sync();
        } catch (Exception e) {

        }
    }

}
