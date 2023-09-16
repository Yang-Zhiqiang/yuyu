
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * バッチ予約状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_OrderStatusuKbn</td><td colspan="3">バッチ予約状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #APPOINTMENT}</td><td>&quot;0&quot;</td><td>予約中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #EXECUTE}</td><td>&quot;1&quot;</td><td>実行中</td></tr>
 * </table>
 */
public class C_OrderStatusuKbn extends Classification<C_OrderStatusuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_OrderStatusuKbn APPOINTMENT = new C_OrderStatusuKbn("0");

    public static final C_OrderStatusuKbn EXECUTE = new C_OrderStatusuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, APPOINTMENT, "APPOINTMENT", true);
        addPattern(PATTERN_DEFAULT, EXECUTE, "EXECUTE", false);


        lock(C_OrderStatusuKbn.class);
    }

    private C_OrderStatusuKbn(String value) {
        super(value);
    }

    public static C_OrderStatusuKbn valueOf(String value) {
        return valueOf(C_OrderStatusuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_OrderStatusuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_OrderStatusuKbn.class, patternId, value);
    }
}
