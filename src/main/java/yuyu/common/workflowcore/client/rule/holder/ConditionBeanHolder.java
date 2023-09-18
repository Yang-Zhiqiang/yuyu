package yuyu.common.workflowcore.client.rule.holder;

import java.util.HashMap;
import java.util.Map;

/**
 * ルールエンジンへのインプットとなるコンディションBeanを保持・管理するクラスです。
 * <pre>
 *  {@link ConditionBeanHolder#getInstance()}を使用し、当クラスのインスタンスを取得します。
 *  {@link ConditionBeanHolder#set(String, Object)}を使用し、コンディションBeanを設定します。
 *  {@link ConditionBeanHolder#get(String, Class)}を使用し、コンディションBeanを取得します。
 *
 * 【使用例】
 *  {@code
 *  // ホルダー取得
 *  ConditionBeanHolder holder = ConditionBeanHolder.getInstance();
 *
 *  // 設定
 *  holder.set("20110329120030100", conditionBean);
 *
 *  // 取得
 *  ConditionBean bean = holder.get("20110329120030100", ConditionBean.class);
 *  }
 * </pre>
 */
public class ConditionBeanHolder {

    private Map<String, Object> conditionBeanMap = new HashMap<String, Object>();

    private static final ConditionBeanHolder instance = new ConditionBeanHolder();

    private ConditionBeanHolder(){
    }

    public static ConditionBeanHolder getInstance(){
        return instance;
    }
    synchronized public void set(String sRequestId,  Object oPojo){

        this.conditionBeanMap.put(sRequestId, oPojo);
    }
    @SuppressWarnings("unchecked")
    synchronized public <T> T get(String sRequestId,  Class<T> clBeanClass){
        try {
            T bean = (T) this.conditionBeanMap.get(sRequestId);
            return bean;
        } finally {
            this.conditionBeanMap.remove(sRequestId);
        }
    }
    synchronized public Object get(String sRequestId){
        try {
            return this.conditionBeanMap.get(sRequestId);
        } finally {
            this.conditionBeanMap.remove(sRequestId);
        }
    }
    synchronized public Class<?> getConditionBeanClass(String sRequestId){
        return this.conditionBeanMap.get(sRequestId).getClass();
    }

}
