package miven.java.spi;

/**
 *  SPI  sample 实现
 * @author mingzhi.xie
 * @date 2019/9/10
 * @since 1.0
 */
public class SpiSampleProviderImpl implements SpiProvider {
    @Override
    public String getDemoName() {
        return "Sample name";
    }
}
