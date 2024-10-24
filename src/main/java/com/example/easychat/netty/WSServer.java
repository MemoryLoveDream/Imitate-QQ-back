package com.example.easychat.netty;

import io.netty.channel.*;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

@Slf4j
@Component
public class WSServer {

    private final ServerBootstrap server;

    private static class SingletonWSServer {
        static final WSServer instance = new WSServer();
    }

    public static WSServer getInstance() {
        return SingletonWSServer.instance;
    }

    public WSServer() {
        EventLoopGroup mainGroup = new NioEventLoopGroup();
        EventLoopGroup subGroup = new NioEventLoopGroup();
        server = new ServerBootstrap();
        server.group(mainGroup, subGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) {
                        ChannelPipeline pipeline = ch.pipeline();
                        // ====================== 以下是用于支持http协议    ======================
                        // websocket 基于http协议，所以要有http编解码器
                        pipeline.addLast(new HttpServerCodec());
                        // 对写大数据流的支持
                        pipeline.addLast(new ChunkedWriteHandler());
                        // 对httpMessage进行聚合，聚合成FullHttpRequest或FullHttpResponse
                        pipeline.addLast(new HttpObjectAggregator(1024*64));
                        // ====================== 增加心跳支持 start    ======================
                        // 如果是读空闲或者写空闲，不处理
                        //pipeline.addLast(new IdleStateHandler(8, 10, 12));
                        //pipeline.addLast(new HeartBeatHandler());
                        // ====================== 以下是支持httpWebsocket ======================
                        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));
                        pipeline.addLast(new SignalHandler());
                    }
                });
    }

    public void start() {
        ChannelFuture future = server.bind(8888);
        log.info("netty websocket server 启动完毕...");
    }
}
