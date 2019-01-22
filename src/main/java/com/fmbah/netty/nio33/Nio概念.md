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
* ByteBuffer.clear() ByteBuffer.compact()
* Capacity: ByteBuffer是一个固定大小的内存块,一旦满了,在下次写入之前,需要清空(clear)或读取(read)
* Position: 写入时,最初位置为0,每次写入都会移动到下一个位置,直到容量-1；当读取时,重置为0,每次读取一个字节后,移动到下一个位置等待读取,直到没有数据可读取
* Limit: 写入时,限制=容量；读取时即反转模式时,限制设置为写模式位置,意味着最多可以读取多少数据
* BufferTypes: ByteBuffer/MappedByteBuffer/CharBuffer/DoubleBuffer/FloatBuffer/IntBuffer/LongBuffer/ShortBuffer
* Allocate ByteBuffer: ByteBuffer buffer = ByteBuffer.allocate(48); CharBuffer buffer = CharBuffer.allocate(1024);
* Writing data to Buffer
    1. Write data from a channel into a buffer(int read = inChannel.read(buffer) read into buffer)
    2. Write data into Buffer yourself, via the buffer's put() methods.(buffer.put(1))
* flip(): read mode to write mode() or write mode() to read mode()
* Reading data from a Buffer
    1. Read data from the buffer into a Channel(int write = inChannel.write(buffer) read from buffer to channel)
    2. Read data from the buffer yourself, using one of get() methods(byte aByte = buffer.get())
* rewind(): set position=0, reread all the data, limit not change
* mark() and reset(): Buffer.mark()标记一个位置,Buffer.reset()回到标记的位置.
* equals() and compareTo() 用来比较两个缓冲区是否相等 和 大小
* Scatter(ˈskatər, 分散)
* Gather(, 收集)
* Selector()
    1. Selector selector = Selector.open()
    2. selector.configureBlocking(false)
    3. SelectionKey selectionKey = channel.register(selector, SelectionKey.OP_READ(Connect, Accept, Read, Write))
    4. int interestSet = selectionKey.interestOps();
    5. boolean isInterestedInAccept  = interestSet & SelectionKey.OP_ACCEPT;
       boolean isInterestedInConnect = interestSet & SelectionKey.OP_CONNECT;
       boolean isInterestedInRead    = interestSet & SelectionKey.OP_READ;
       boolean isInterestedInWrite   = interestSet & SelectionKey.OP_WRITE;  
    6. int readySet = selectionKey.readyOps();
       selectionKey.isAcceptable();
       selectionKey.isConnectable();
       selectionKey.isReadable();
       selectionKey.isWritable();
    7. Channel channel  = selectionKey.channel();
       Selector selector = selectionKey.selector();
    8. Attaching Objects: selectionKey.attach(theObject);
                          Object attachedObj = selectionKey.attachment();
                          SelectionKey key = channel.register(selector, SelectionKey.OP_READ, theObject);
    9. Set<SelectionKey> selectedKeys = selector.selectedKeys();
* File Channel
    1. channel.truncate(1024)
    2. channel.force(true);
* SocketChannel
    1.  


  
