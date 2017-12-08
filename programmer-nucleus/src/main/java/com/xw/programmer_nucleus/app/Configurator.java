package com.xw.programmer_nucleus.app;

import com.joanzapata.iconify.IconFontDescriptor;
import com.joanzapata.iconify.Iconify;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by nazi on
 * date： 2017/12/1
 */

public class Configurator {

    private static final HashMap<String, Object> LATTE_CONFIGS = new HashMap<>();

    private static final ArrayList<IconFontDescriptor> ICONS = new ArrayList();

    private Configurator() {

        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }


    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final HashMap<String, Object> getLatteConfigs() {
        return LATTE_CONFIGS;

    }

    /*关于单例模式，如果要使用懒汉模式的话，要么就使用双从交验锁，也就是（c坤奈斯）关键字 来防止线程冲突
     * 因为在多线程开发中得时候，在正常情况下写的懒汉模式都是有问题的，
     * 要么就是用枚举类，来进行统一的初始化。
     *现在可以使用静态内部类的单例模式初始化
      * */
    private static class Holder {
        private static final Configurator INSTANCE = new Configurator();
    }

    //初始化

    public final void configure() {

        initIcons();

        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }


    public final Configurator withApiHost(String host) {


        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
        return this;
    }


    private void initIcons() {
        if (ICONS.size() > 0) {
            final Iconify.IconifyInitializer initializer = Iconify.with(ICONS.get(0));
            for (int i = 1; i < ICONS.size(); i++) {
                initializer.with(ICONS.get(i));
            }
        }
    }

    public final Configurator withIcon(IconFontDescriptor descriptor) {

        ICONS.add(descriptor);
        return this;
    }

    private void checkConfiguration() {
        final boolean isReady = (boolean) LATTE_CONFIGS.get(ConfigType.CONFIG_READY.name());
        if (isReady) {
            throw new RuntimeException("Configuration is not ready,call configuration");
        }
    }

    @SuppressWarnings("unchecked")
    final <T> T getConfiguration(Enum<ConfigType> key) {
        checkConfiguration();
        return (T) LATTE_CONFIGS.get(key);
    }
}
