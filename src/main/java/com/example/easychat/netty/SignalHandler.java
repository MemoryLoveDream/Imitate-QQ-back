package com.example.easychat.netty;

import java.util.HashMap;
import java.util.Objects;

import com.example.easychat.utils.JsonUtil;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import io.netty.util.concurrent.GlobalEventExecutor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SignalHandler extends SimpleChannelInboundHandler<TextWebSocketFrame> {

    public static ChannelGroup users = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

    public static HashMap<Integer, Channel> manager = new HashMap<>();

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, TextWebSocketFrame msg) {
        String signal = msg.text();
        log.info(signal);
        WebSocketSignal webSocketSignal = JsonUtil.jsonToObject(signal, WebSocketSignal.class);

        if (webSocketSignal != null ) {
            Integer signalType = webSocketSignal.getSignalType();
            String content = webSocketSignal.getContent();

            if (Objects.equals(signalType, WebSocketSignal.FIRST_CONNECTION)) {
                manager.put(Integer.parseInt(content), ctx.channel());
                log.info(content);
            }
            else if(Objects.equals(signalType, WebSocketSignal.SEND_CHAT)) {
                log.info(content);
                WebSocketSignal.Chat chat = JsonUtil.jsonToObject(content, WebSocketSignal.Chat.class);
                if (chat != null) {
                    if(manager.containsKey(chat.getReceiverId())) {
                        manager.get(chat.getReceiverId()).writeAndFlush(new TextWebSocketFrame(signal));
                    }

                }
            }
            else if(Objects.equals(signalType, WebSocketSignal.DISCONNECTION)) {
                manager.remove(Integer.parseInt(content));
            }
            else if(Objects.equals(signalType, WebSocketSignal.REQUEST_PEER_ID)) {
                log.info(content);
                WebSocketSignal.Call call = JsonUtil.jsonToObject(content, WebSocketSignal.Call.class);
                if (call != null) {
                    manager.get(call.getCalleeId()).writeAndFlush(new TextWebSocketFrame(signal));
                }
            }
            else if(Objects.equals(signalType, WebSocketSignal.SEND_PEER_ID)) {
                log.info(content);
                WebSocketSignal.Peer peer = JsonUtil.jsonToObject(content, WebSocketSignal.Peer.class);
                if (peer != null) {
                    manager.get(peer.getCallerId()).writeAndFlush(new TextWebSocketFrame(signal));
                }
            }
        }


//        // 1. 获取客户端发来的消息
//        DataContent dataContent = JsonUtils.jsonToPojo(content, DataContent.class);
//        Integer action = dataContent.getAction();
//        // 2. 判断消息类型，根据不同的类型来处理不同的业务
//
//        if (action == MsgActionEnum.CONNECT.type) {
//            // 	2.1  当websocket 第一次open的时候，初始化channel，把用的channel和userid关联起来
//            String senderId = dataContent.getChatMsg().getSenderId();
//            UserChannelRel.put(senderId, currentChannel);
//
//            // 测试
//            for (Channel c : users) {
//                System.out.println(c.id().asLongText());
//            }
//            UserChannelRel.output();
//        } else if (action == MsgActionEnum.CHAT.type) {
//            //  2.2  聊天类型的消息，把聊天记录保存到数据库，同时标记消息的签收状态[未签收]
//            ChatMsg chatMsg = dataContent.getChatMsg();
//            String msgText = chatMsg.getMsg();
//            String receiverId = chatMsg.getReceiverId();
//            String senderId = chatMsg.getSenderId();
//
//            // 保存消息到数据库，并且标记为 未签收
//            UserService userService = (UserService)SpringUtil.getBean("userServiceImpl");
//            String msgId = userService.saveMsg(chatMsg);
//            chatMsg.setMsgId(msgId);
//
//            DataContent dataContentMsg = new DataContent();
//            dataContentMsg.setChatMsg(chatMsg);
//
//            // 发送消息
//            // 从全局用户Channel关系中获取接受方的channel
//            Channel receiverChannel = UserChannelRel.get(receiverId);
//            if (receiverChannel == null) {
//                // TODO channel为空代表用户离线，推送消息（JPush，个推，小米推送）
//            } else {
//                // 当receiverChannel不为空的时候，从ChannelGroup去查找对应的channel是否存在
//                Channel findChannel = users.find(receiverChannel.id());
//                if (findChannel != null) {
//                    // 用户在线
//                    receiverChannel.writeAndFlush(
//                            new TextWebSocketFrame(
//                                    JsonUtils.objectToJson(dataContentMsg)));
//                } else {
//                    // 用户离线 TODO 推送消息
//                }
//            }
//
//        } else if (action == MsgActionEnum.SIGNED.type) {
//            //  2.3  签收消息类型，针对具体的消息进行签收，修改数据库中对应消息的签收状态[已签收]
//            UserService userService = (UserService)SpringUtil.getBean("userServiceImpl");
//            // 扩展字段在signed类型的消息中，代表需要去签收的消息id，逗号间隔
//            String msgIdsStr = dataContent.getExtand();
//            String msgIds[] = msgIdsStr.split(",");
//
//            List<String> msgIdList = new ArrayList<>();
//            for (String mid : msgIds) {
//                if (StringUtils.isNotBlank(mid)) {
//                    msgIdList.add(mid);
//                }
//            }
//
//            System.out.println(msgIdList.toString());
//
//            if (msgIdList != null && !msgIdList.isEmpty() && msgIdList.size() > 0) {
//                // 批量签收
//                userService.updateMsgSigned(msgIdList);
//            }
//
//        } else if (action == MsgActionEnum.KEEPALIVE.type) {
//            //  2.4  心跳类型的消息
//            System.out.println("收到来自channel为[" + currentChannel + "]的心跳包...");
//        }
    }

    @Override
    public void handlerAdded(ChannelHandlerContext ctx) {
        log.info("通道{}加入", ctx.channel().id().asShortText());
        users.add(ctx.channel());
    }

    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) {
        log.info("通道{}移除", ctx.channel().id().asShortText());
        users.remove(ctx.channel());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        log.error(cause.getMessage());
        ctx.channel().close();
        users.remove(ctx.channel());
    }

//    public static void output() {
//        for (HashMap.Entry<Integer, Channel> entry : manager.entrySet()) {
//            System.out.println("UserId: " + entry.getKey()
//                    + ", ChannelId: " + entry.getValue().id().asLongText());
//        }
//    }

}
