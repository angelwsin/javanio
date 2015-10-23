package com.nio.channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
/*
 * 
    既可以从通道中读取数据，又可以写数据到通道。但流的读写通常是单向的。
    通道可以异步地读写。
    通道中的数据总是要先读到一个Buffer，或者总是要从一个Buffer中写入。

 */
public class FileChannel {

	public static void main(String[] args)throws Exception {
		   RandomAccessFile access = new RandomAccessFile("d:\\message.txt","rw");
		   java.nio.channels.FileChannel fileChannel = access.getChannel();
		   ByteBuffer buffer =  ByteBuffer.allocate(1024);
		  int index =   fileChannel.read(buffer);
		  while(index!=-1){
			  System.out.println("read "+index);
			  buffer.flip();
			  while(buffer.hasRemaining()){
				  System.out.println((char)buffer.get());
			  }
			 buffer.clear();
			 index =   fileChannel.read(buffer);
		  }
		  access.close();
		   
	}
}
