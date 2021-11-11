package com.demos.netty.httpfileserver;

import com.demos.netty.timserver3.TimeServerHandler;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.LineBasedFrameDecoder;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpRequestDecoder;
import io.netty.handler.codec.http.HttpResponseDecoder;
import io.netty.handler.codec.http.HttpResponseEncoder;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.stream.ChunkedWriteHandler;

public class HttpFileServer {

    //默认当前路径
    private static final String URL = "/";

    public static void main(String[] args) throws InterruptedException {
        new HttpFileServer().bind(8099, URL);
    }

    public void bind(int port, String url) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ch.pipeline().addLast("http-decoder", new HttpRequestDecoder());
                    ch.pipeline().addLast("http-aggregator", new HttpObjectAggregator(65536));
                    // 新增HTTP响应编码器，对HTTP响应消息进行编码
                    ch.pipeline().addLast("http-encoder", new HttpResponseEncoder());
                    // 新增Chunked handler，主要作用是支持异步发送大的码流（例如大文件传输）
                    // 但是不占用过多的内存，防止发生java内存溢出错误
                    ch.pipeline().addLast("http-chunked", new ChunkedWriteHandler());
                    // HttpFileServerHandler用于文件服务器的业务逻辑处理
                    ch.pipeline().addLast("fileServerHandler", new HttpFileServerHandler(url));
                }
            });
            String host = "127.0.0.1";
            ChannelFuture future = b.bind(host, port).sync();
            System.out.println("HTTP文件目录服务器启动，网址是 : http://" + host + ":" + port + url);
            //等待服务端监听端口关闭
            future.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }

}
