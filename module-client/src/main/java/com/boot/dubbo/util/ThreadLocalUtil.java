package com.boot.dubbo.util;


import com.boot.dubbo.domain.BaseRequest;

public class ThreadLocalUtil {

    private static final ThreadLocal<BaseRequest> LOCAL = new ThreadLocal<>();

    public static void set(BaseRequest request) {
        LOCAL.set(request);
    }

    public static BaseRequest get() {
        return LOCAL.get();
    }

    public static void reset() {
        LOCAL.remove();
    }
}
