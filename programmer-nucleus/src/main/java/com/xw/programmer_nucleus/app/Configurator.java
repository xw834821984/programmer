package com.xw.programmer_nucleus.app;

import java.util.WeakHashMap;

/**
 * Created by nazi on
 * date： 2017/12/1
 */

public class Configurator {

    private static final WeakHashMap<String, Object> LATTE_CONFIGS = new WeakHashMap<>();

    private Configurator() {

        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), false);
    }

    public static Configurator getInstance() {
        return Holder.INSTANCE;
    }

    final WeakHashMap<String, Object> getLatteConfigs() {
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

    public final void configure() {

        LATTE_CONFIGS.put(ConfigType.CONFIG_READY.name(), true);
    }

    public final Configurator withApiHost(String host) {
        LATTE_CONFIGS.put(ConfigType.API_HOST.name(), host);
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
