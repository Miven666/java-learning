package miven.java.spi;

/**
 *  SPI 制定者
 * @author mingzhi.xie
 * @date 2019/9/10
 * @since 1.0
 */
public interface SpiProvider {
    /**
     *  获取 demo 名字
     * @return demo 名字
     */
    String getDemoName();
}
