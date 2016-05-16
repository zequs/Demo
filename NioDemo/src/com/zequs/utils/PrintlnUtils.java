package com.zequs.utils;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

public class PrintlnUtils {
    public static void byteBufferPrintln(ByteBuffer buffer){
        System.out.println("position="+buffer.position()+",limit="+buffer.limit()+",capation="+buffer.capacity());
        while (buffer.hasRemaining()) {
            System.out.print((char)buffer.get());
        }
        System.out.println();
    }
    public static void byteBufferPrintln(String string,ByteBuffer buffer){
        System.out.println(string+":"+"position="+buffer.position()+",limit="+buffer.limit()+",capation="+buffer.capacity());
        System.out.print(string+":");
        while (buffer.hasRemaining()) {
            System.out.print((char)buffer.get());
        }
        System.out.println();
    }
    public static void byteBufferPrintln(CharBuffer buffer){
        System.out.println("position="+buffer.position()+",limit="+buffer.limit()+",capation="+buffer.capacity());
        while (buffer.hasRemaining()) {
            System.out.print((char)buffer.get());
        }
        System.out.println();
    }
}
