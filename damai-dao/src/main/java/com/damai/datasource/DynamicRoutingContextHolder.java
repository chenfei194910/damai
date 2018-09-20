package com.damai.datasource;

public class DynamicRoutingContextHolder {
	private static final ThreadLocal<RoutingStrategy> contextHolder =
            new ThreadLocal<>();

    public static void setRouteStrategy(RoutingStrategy customerType) {
        contextHolder.set(customerType);
    }

    public static RoutingStrategy getRouteStrategy() {
        return (RoutingStrategy) contextHolder.get();
    }

    public static void clearRouteStrategy() {
        contextHolder.remove();
    }
}
