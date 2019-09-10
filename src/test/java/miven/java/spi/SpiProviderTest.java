package miven.java.spi;

import org.junit.Test;

import java.util.Iterator;
import java.util.ServiceLoader;

public class SpiProviderTest {

    @Test
    public void getDemoName() {
        ServiceLoader<SpiProvider> loader = ServiceLoader.load(SpiProvider.class);
        for (SpiProvider provider : loader) {
            String className = provider.getClass().getName();
            String name = provider.getDemoName();
            System.out.println(className + ": " + name);
        }
    }
}