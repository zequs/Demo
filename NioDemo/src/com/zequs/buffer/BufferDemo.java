package com.zequs.buffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;

import com.zequs.utils.PrintlnUtils;

public class BufferDemo {
    public static void main(String[] args) {
        BufferDemo demo = new BufferDemo();
//        demo.BufferApiDemo();
        demo.CharsetUTF8();
    }
    /**
     * bufferAPI
     */
    private void BufferApiDemo() {
        try {
            FileInputStream fin = new FileInputStream("E:\\test.txt");
            FileChannel fileChannel = fin.getChannel();
//          创建缓冲区，一种buffer.allocate(100);buffer.wrap(Byte[] byte);已byteBuffer为例，参数为byte数组，如果是charBuffer缓冲区参数为CharSequence序列
//          
//          ByteBuffer buffer = ByteBuffer.allocate(31);//容量不够时报错BufferOverflowException异常。
            ByteBuffer buffer = ByteBuffer.allocate(1024);
//            创建一个position为12,limit为42的缓冲区
//          ByteBuffer abuffer = ByteBuffer.wrap(new byte[50], 12, 30);
            fileChannel.read(buffer);
//            buffer.put()加一个字节
            buffer.put((byte)',');
            buffer.put((byte)'h');
            buffer.put((byte)'o');
            buffer.put((byte)'l');
            buffer.put((byte)'l');
            buffer.put((byte)'e');
//          buffer.put(byte[])加一个字节数组，当容量不够时，不能保存，报错BufferOverflowException异常
//          CharBuffer.put(String string)可以直接加字符串
            byte[] bytes = ",world".getBytes();
            buffer.put(bytes);
//            将填充状态的缓冲区翻转成读取状态的缓冲区，个人理解读取是position已经在后面了，进行posion为0；
//            flip()等价于buffer.limit(buffer.position()).position(0);
            System.out.println("position="+buffer.position());
//            clear()函数rewind()函数，flip()函数，看源码就懂，都会清除mark()标记
//            buffer.clear();
//            buffer.rewind();
            buffer.flip();
            buffer.remaining();
            System.out.println("剩余空间容量："+buffer.remaining());
            int a = 0;
            //每一次buffer.get()后position都多加1，所以position()==1的值只会打印一次
            while (buffer.hasRemaining()) {
                System.out.print((char)buffer.get());
                if (buffer.position()==2) {
                    buffer.mark();
                    System.out.println();
                    System.out.println("position位置");
                    System.out.println("剩余空间容量："+buffer.remaining());
                } else if (buffer.position()==7) {
                    if (a<1) {
                        buffer.reset();
                        a++;
                    }
                }
            }
//            clear()函数将缓冲区重置为空，它并不改变缓冲区中的任何元素，它只将缓冲区上界设为容量的值，把位置（position）设为0；
//            buffer.clear();
//            compact()：压缩，byteBuffer的方法。把当前position位置至limit之间的字节，复制到0至相应的长度（长度跟position至limit一致），再讲position为长度+1，将limit(界限)设为capacity（容量），如果设为了标记就丢弃。
            buffer.compact();
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    /**
     * 中文乱码
     */
    private void CharsetUTF8() {
        try {
            FileInputStream fin = new FileInputStream("E:\\test.txt");
            FileChannel fileChannel = fin.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(buffer);
            buffer.flip();
//            System.out.println("1："+buffer.asCharBuffer());
//            取得系统的文件编码
            String encoding = System.getProperty("file.encoding");
            System.out.println(encoding+":"+Charset.forName(encoding).decode(buffer));
//            buffer.rewind();
//            PrintlnUtils.byteBufferPrintln(buffer);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    private void readCharBufferDemo() {
        try {
            FileInputStream fin = new FileInputStream("E:\\test.txt");
            FileChannel fileChannel = fin.getChannel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            fileChannel.read(buffer);
            buffer.flip();
//            取得系统的文件编码
            String encoding = System.getProperty("file.encoding");
            System.out.println(encoding+":"+Charset.forName(encoding).decode(buffer));
            buffer.rewind();
//            PrintlnUtils.byteBufferPrintln(cBuffer);
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
