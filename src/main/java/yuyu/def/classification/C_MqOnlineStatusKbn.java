
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＱオンライン状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MqOnlineStatusKbn</td><td colspan="3">ＭＱオンライン状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MQONLINE_HUKA}</td><td>&quot;0&quot;</td><td>ＭＱオンライン停止中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MQONLINE_KA}</td><td>&quot;1&quot;</td><td>ＭＱオンライン開始中</td></tr>
 * </table>
 */
public class C_MqOnlineStatusKbn extends Classification<C_MqOnlineStatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MqOnlineStatusKbn MQONLINE_HUKA = new C_MqOnlineStatusKbn("0");

    public static final C_MqOnlineStatusKbn MQONLINE_KA = new C_MqOnlineStatusKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MQONLINE_HUKA, "MQONLINE_HUKA", true);
        addPattern(PATTERN_DEFAULT, MQONLINE_KA, "MQONLINE_KA", false);


        lock(C_MqOnlineStatusKbn.class);
    }

    private C_MqOnlineStatusKbn(String value) {
        super(value);
    }

    public static C_MqOnlineStatusKbn valueOf(String value) {
        return valueOf(C_MqOnlineStatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MqOnlineStatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MqOnlineStatusKbn.class, patternId, value);
    }
}
