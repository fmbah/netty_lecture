### java.io vs java.nio
* java.io基本核心是面对流(Stream)编程,java中,要么是输入流,要么是输出流.
* java.nio中拥有三个核心概念(Selector, Channel, Buffer).在nio中,面向块(block)或缓冲区(buffer)编程.buffer本身是一块内存,底层实现上,实际是个数组,数据的读/写都是通过Buffer实现.
    * 除了数组之外,Buffer还提供了对于数据的结构化访问方式,并且可以追踪到系统的读写过程.
    * java中的8种原生数据类型都有各自对应的Buffer类型,如IntBuffer,LongBuffer...
    * Channel类似io中的Stream,它可以向其中写入数据或是从中读取数据的对象
    * 所有数据的读写都是通过Buffer来进行的,永远不会出现直接向Channel写入数据的情况,或是直接从Channel读取数据的情况
    * 与Stream不同,Channel是双向的,一个流只可能是输入流或是输出流, Channel打开后则可以进行读取/写入/读写
    * 由于Channel是双向的,更能反映出底层操作系统的真实情况,在linux系统中,底层操作系统的通道就是双向的. 
    

* io: work with byte stream or character stream
* nio: work with channel and buffers(Data is always read from a channel into a buffer, or written from a buffer to a channel)
* Thread(1) -> Slector(1) -> Channel(n)
* 
  
