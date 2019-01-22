package com.fmbah.netty.nio33.nio33_mystudy;

import java.nio.channels.Selector;

/**
 * @ClassName FullSelectorExample
 * @Description
 * @Author root
 * @Date 18-12-25 下午7:32
 * @Version 1.0
 **/
public class FullSelectorExample {

    public static void main(String[] args) throws Exception{
        Selector selector = Selector.open();
//        channel.configureBlocking(false);
//
//        SelectionKey key = channel.register(selector, SelectionKey.OP_READ);
//
//
//        while(true) {
//
//            int readyChannels = selector.select();
//
//            if(readyChannels == 0) continue;
//
//
//            Set<SelectionKey> selectedKeys = selector.selectedKeys();
//
//            Iterator<SelectionKey> keyIterator = selectedKeys.iterator();
//
//            while(keyIterator.hasNext()) {
//
//                SelectionKey key = keyIterator.next();
//
//                if(key.isAcceptable()) {
//                    // a connection was accepted by a ServerSocketChannel.
//
//                } else if (key.isConnectable()) {
//                    // a connection was established with a remote server.
//
//                } else if (key.isReadable()) {
//                    // a channel is ready for reading
//
//                } else if (key.isWritable()) {
//                    // a channel is ready for writing
//                }
//
//                keyIterator.remove();
//            }
//        }
    }

}
