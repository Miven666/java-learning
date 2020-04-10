package miven.java.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.channels.FileChannel.MapMode.READ_ONLY;
import static java.nio.channels.FileChannel.MapMode.READ_WRITE;
import static java.nio.file.StandardOpenOption.*;

/**
 * @see Channel
 * Channel类似于传统的“流”，只不过Channel不能直接访问数据，
 * Channel只能与buffer交互。而且流是单向的，分为输入流和输出流，
 * 但是通道是双向的，通过缓冲区buffer两边都可达。
 *
 * 比喻：山西有煤，我们想要，于是乎建了一条铁路连通到山西，
 * 这条铁路就是这里的"Channel",那么煤通过什么运过来呢？铁路建好了，就差火车了，
 * 因此这里的火车就像是缓冲区，火车把山西的煤运到这边来，把我们这里的钱运过去，
 * 这样双向传输就愉快的完成了。
 *
 * 主要实现：
 * @see FileChannel 用于对文件进行读取、写入、映射等操作的通道
 * @see DatagramChannel 通过UDP读取网络中数据的通道
 * @see SocketChannel 通过TCP读取网路中数据的通道
 * @see ServerSocketChannel 可以监听新进来的TCP连接，为每个连接建立一个SocketChannel
 *
 * @author mingzhi.xie
 * @date 2020/4/9
 * @since 1.0
 */
public class ChannelExample {

    public static void main(String[] args) {
        // 利用通道和非直接缓冲区完成复制
        buffer();

        // 利用通道和内存映射文件完成复制
        memoryMapping();
        
        // 通道互相转化写法（本质实现还是依靠缓冲区）
        transfer();
    }


    private static void transfer() {
        String src = "src/main/resources/";
        String target = "target/classes/";
        String inName = "images/channel.jpg";
        String outName = "images/channel-transfer.jpg";
        ClassLoader classLoader = ChannelExample.class.getClassLoader();
        URL url = classLoader.getResource(inName);
        assert url != null;
        String inPath = url.getPath();
        String outPath = inPath.replace(target, src).replace(inName, outName);

        try (FileInputStream fis = new FileInputStream(inPath);
             FileOutputStream fos = new FileOutputStream(outPath)) {
                FileChannel inChannel = fis.getChannel();
                FileChannel outChannel = fos.getChannel();

                // 内部是直接缓冲区实现
                // inChannel.transferTo(0, inChannel.size(), outChannel);
                outChannel.transferFrom(inChannel, 0, inChannel.size());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private static void memoryMapping() {
        Path inPath = Paths.get("/Users/miven/Project/github/java-learning/java-se/src/main/resources/images/channel.jpg");
        Path outPath = Paths.get("/Users/miven/Project/github/java-learning/java-se/src/main/resources/images/channel-mapping.jpg");
        try (FileChannel inChannel = FileChannel.open(inPath, READ);
             FileChannel outChannel = FileChannel.open(outPath, READ, WRITE, CREATE)) {

            MappedByteBuffer inBuffer = inChannel.map(READ_ONLY, 0, inChannel.size());
            byte[] bytes = new byte[inBuffer.limit()];
            inBuffer.get(bytes);

            MappedByteBuffer outBuffer = outChannel.map(READ_WRITE, 0, inChannel.size());
            outBuffer.put(bytes);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static void buffer() {
        try (FileInputStream fis = new FileInputStream("src/main/resources/images/channel.jpg");
             FileOutputStream fos = new FileOutputStream("src/main/resources/images/channel-buffer.jpg");
             // 获取连接源文件的通道
             FileChannel inChannel = fis.getChannel();
             // 获取连接目标文件的通道
             FileChannel outChannel = fos.getChannel()) {
            // 创建非直接缓冲区，用于传输数据
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            while (inChannel.read(buffer) != -1) {
                // 将缓冲区反转
                buffer.flip();
                outChannel.write(buffer);
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
