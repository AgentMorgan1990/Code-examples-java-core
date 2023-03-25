package ru.examples.netty.discard;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class DiscardServer {

    public void run() throws Exception {
        /**
         * Создание двух групп потоков (вариант executor service из библиотеки concurrent)
         * bossGroup        - будет заниматься ожиданием клиентов
         * workerGroup      - буде заниматься обработкой собыйтий, которы происходят
         * */
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            /**
             * Настраиваем сервер
             * */
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup)
                    /**
                     * ServerSocket - обозначает, что это сервер
                     * */
                    .channel(NioServerSocketChannel.class)
                    /**
                     * при подключении клиента срабатывает этот метод
                     * */
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            /**
                             * в конец цепочки (ppeLine) этого клинта добавляем ещё один хэндлер
                             * */
                            socketChannel.pipeline().addLast(new DiscardServerHandler());
                        }
                        });

                    /**
                     * Можно добавлять различные опции
                     * */
//                    .childHandler(ChannelOption.SO_KEEPALIVE,true);
            /**
             * Указываем, какой порт слушать и запускаем
             * */
            ChannelFuture f = b.bind(8189).sync();
            /**
             * ожидаем закрытия канала, чтобы перейти к следующему блоку кода
             * */
            f.channel().closeFuture().sync();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) throws Exception {
        new DiscardServer().run();
    }
}
