package com.sxrekord.chatting.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Rekord
 * @date 2023/4/24 16:40
 */
@Slf4j
public abstract class BaseServer implements Server {
    @Value("${netty.server.port}")
    protected int port;

    protected EventLoopGroup bossGroup;
    protected EventLoopGroup workerGroup;
    protected ChannelFuture serverChannelFuture;
    protected ServerBootstrap serverBootstrap;

    public void init() {
        bossGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors(), new ThreadFactory() {
            private final AtomicInteger index = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "BOSS_" + index.incrementAndGet());
            }
        });
        workerGroup = new NioEventLoopGroup(Runtime.getRuntime().availableProcessors() * 10, new ThreadFactory() {
            private final AtomicInteger index = new AtomicInteger(0);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "WORK_" + index.incrementAndGet());
            }
        });
        serverBootstrap = new ServerBootstrap();
    }

    @Override
    public void close() {
        try {
            // 停止接受新连接
            bossGroup.shutdownGracefully().sync();
            // 等待现有连接关闭
            serverChannelFuture.channel().close().sync();
            // 停止读写操作
            workerGroup.shutdownGracefully().sync();
        } catch (InterruptedException ie) {
            log.error("Interrupted while closing Netty WebSocket Server", ie);
            Thread.currentThread().interrupt();
        }
    }
}
