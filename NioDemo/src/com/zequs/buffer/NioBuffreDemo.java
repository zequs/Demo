package com.zequs.buffer;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;


public class NioBuffreDemo {
    public static void main(String[] args) {
        String a = "F:\\text\\text.txt";
        String b = "F:\\text\\text2.txt";
        try {
            //FileInputStream(a).getChannel()会产生一个通道FileChannel
            
            FileChannel in = new FileInputStream(a).getChannel();
            FileChannel out = new FileOutputStream(b).getChannel();
            //使用allocate(x)静态的创建一个容量为x的缓冲区
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (in.read(buffer) != -1) {
                //反转此缓冲区。首先将限制设置为当前位置，然后将位置设置为 0。如果已定义了标记，则丢弃该标记。
                //在一系列通道读取或放置 操作之后，调用此方法为一系列通道写入或相对获取 操作做好准备
                buffer.flip();
                out.write(buffer);
//                out.transferFrom(in, 0, 1024); //连接其他通道
                //wrap()将 byte 数组包装到缓冲区中。
//                out.write(ByteBuffer.wrap("hello world".getBytes()));
                buffer.clear();
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        
    }
}
