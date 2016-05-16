package com.zequs.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import com.zequs.utils.PrintlnUtils;

public class BufferCopyDemo {
    public static void main(String[] args) {
        BufferCopyDemo bdemo = new BufferCopyDemo();
        bdemo.bufferDuplicate();
    }

    /**
     * 缓冲区复制
     * 两个缓冲区共享数据元素，拥有相同的容量，但每个缓冲区拥有各自的位置，上界和标记属性，对一个缓冲区的数据元素所做的修改会反映到另一个上。
     * 
     */
    private void bufferDuplicate() {
        try {
            FileInputStream fin = new FileInputStream("E:\\test.txt");
            FileChannel fileChannel = fin.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(buffer);
            buffer.position(0);
            PrintlnUtils.byteBufferPrintln("oldbuffer",buffer);
            buffer.put(6,(byte)'z');
//          修改标识，界限，位置
            buffer.position (3).limit (310).mark( ).position (5);
//          复制
            ByteBuffer copyBuffer = buffer.duplicate();
//          清除
            buffer.clear();
            PrintlnUtils.byteBufferPrintln(buffer);
            PrintlnUtils.byteBufferPrintln(copyBuffer);
            copyBuffer.clear();
            int a = 0;
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
}
