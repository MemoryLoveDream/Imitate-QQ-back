package com.example.easychat.netty;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleState;
import io.netty.handler.timeout.IdleStateEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class HeartBeatHandler extends ChannelInboundHandlerAdapter {

    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {

        // 判断evt是否是IdleStateEvent（用于触发用户事件，包含 读空闲/写空闲/读写空闲 ）
        if (evt instanceof IdleStateEvent event) {
            // 强制类型转换
            if (event.state() == IdleState.READER_IDLE) {
//                log.info("进入读空闲...");
            } else if (event.state() == IdleState.WRITER_IDLE) {
//                log.info("进入写空闲...");
            } else if (event.state() == IdleState.ALL_IDLE) {
//                log.info("channel关闭前，users的数量为：" + ChatHandler.users.size());
//                Channel channel = ctx.channel();
//                channel.close();
//                log.info("channel关闭后，users的数量为：" + ChatHandler.users.size());
            }
        }
    }
}
