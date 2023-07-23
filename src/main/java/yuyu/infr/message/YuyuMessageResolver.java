package yuyu.infr.message;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Singleton;

import jp.co.slcs.swak.web.message.MessageResolver;
import yuyu.def.base.configuration.YuyuBaseConfig;

@Singleton
public class YuyuMessageResolver implements MessageResolver {

    @Inject
    private YuyuBaseConfig config;

    private Comparator<String> DISPLAY_ORDER_COMPARATOR;

    @Override
    public String getIconResource(String messageId) {
        String capitalLetter = String.valueOf(messageId.charAt(0));
        return config.getMessageIconResources().get(capitalLetter);
    }

    @Override
    public String getValidationIconResource() {
        return config.getMessageIconResources().get("E");
    }

    @Override
    public Comparator<String> getDisplayOrderComparator() {
        if (DISPLAY_ORDER_COMPARATOR == null) {
            DISPLAY_ORDER_COMPARATOR = new Comparator<String>() {

                private final Map<String, Integer> orders = getOrders();

                private Map<String, Integer> getOrders() {
                    Map<String, Integer> ordersMap = new HashMap<String, Integer>();
                    int i = 0;
                    for (String key : config.getMessageIconResources().keySet()) {
                        ordersMap.put(key, ++i);
                    }
                    return ordersMap;
                }

                @Override
                public int compare(String o1, String o2) {
                    return orders.get(String.valueOf(o1.charAt(0))) - orders.get(String.valueOf(o2.charAt(0)));
                }

            };
        }
        return DISPLAY_ORDER_COMPARATOR;
    }

}
