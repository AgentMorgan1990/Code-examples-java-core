package ru.examples.netty.discard;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;


/**
 * Inbound - работает на приём
 *
 * */
public class DiscardServerHandler extends ChannelInboundHandlerAdapter {


    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)  {
        System.out.println("Received and released");
        /**
         * Нетти выдаёт байтБуффер и посто, как мы с ним порбаталимы отдаём его обратно, чтобы незанмать его
         * */
        ((ByteBuf)msg).release();
    }

//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg)  {
//        ByteBuf in = (ByteBuf) msg;
//        try {
//            while (in.isReadable()){
//                /**
//                 * Будет работать только на латинице, т.к. кириллица занимает 2 байта
//                 * */
//                System.out.println((char)in.readByte());
//            }
//        } finally {
//          in.release();
//        }
//    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) {
        cause.printStackTrace();
        ctx.close();
    }


}
