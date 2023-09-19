package yuyu.common.workflowcore.core.webservice.provide.kouteikanri.getsometask;

import java.util.LinkedList;

import org.apache.commons.collections.CollectionUtils;

/**
 * 業務キー採番履歴を保持・管理するクラスです。
 * <p>
 *  {@link GyoumukeyHistory#getInstance()}を使用し、当クラスのインスタンスを取得します。<br/>
 *  {@link GyoumukeyHistory#set(String, Object)}を使用し、コンディションBeanを設定します。<br/>
 *  {@link GyoumukeyHistory#get(String, Class)}を使用し、コンディションBeanを取得します。<br/>
 *
 * 【使用例】
 * <pre>
 *  {@code
 *  // ホルダー取得
 *  GyoumukeyHistory history = GyoumukeyHistory.getInstance();
 *
 *  // 設定
 *  history.add("20110329120001");
 *
 *  // 取得
 *  history.getFirst();
 *  }
 * </pre>
 * </p>
 */
public class GyoumukeyHistory {

    private LinkedList<String> deque = new LinkedList<String>();

    private static final Integer iMAX_SIZE = 10;

    private static GyoumukeyHistory instance = new GyoumukeyHistory();

    private GyoumukeyHistory(){
    }

    public static GyoumukeyHistory getInstance(){
        return instance;
    }

    public void add(String gyoumukey){
        LinkedList<String> deq = this.deque;

        deq.addFirst(gyoumukey);

        if(deq.size() > iMAX_SIZE){
            deq.peekLast();
        }
    }

    public String getFirst(){
        return this.deque.peekFirst();
    }

    public String get(int idx){
        LinkedList<String> deq = this.deque;

        if(deq.size()<=idx){
            return "";
        }

        return (String)CollectionUtils.get(deq, idx);
    }
}
