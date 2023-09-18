package yuyu.common.workflowcore.iwfcommon.check;


/**
 * チェッカーインタフェースです。<br/>
 * 何らかのチェックを行いチェックの結果を{@link Boolean}で返却するメソッド（{@link Checker#check(Object...)}）を持ちます。
 */
public interface Checker<T> {

    public Boolean check(T...conditions);

}
