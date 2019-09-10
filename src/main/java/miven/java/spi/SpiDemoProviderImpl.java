package miven.java.spi;

/**
 *  SPI  demo 实现
 * @author mingzhi.xie
 * @date 2019/9/10
 * @since 1.0
 */
public class SpiDemoProviderImpl implements SpiProvider {
    @Override
    public String getDemoName() {
        return "Demo name";
    }
}
