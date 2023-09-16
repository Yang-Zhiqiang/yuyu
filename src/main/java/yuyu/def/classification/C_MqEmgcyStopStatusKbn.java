
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＱ緊急停止状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MqEmgcyStopStatusKbn</td><td colspan="3">ＭＱ緊急停止状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MQEMGCYSTOP_START}</td><td>&quot;0&quot;</td><td>ＭＱ緊急停止状態－開始</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MQEMGCYSTOP_END}</td><td>&quot;1&quot;</td><td>ＭＱ緊急停止状態－終了</td></tr>
 * </table>
 */
public class C_MqEmgcyStopStatusKbn extends Classification<C_MqEmgcyStopStatusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MqEmgcyStopStatusKbn MQEMGCYSTOP_START = new C_MqEmgcyStopStatusKbn("0");

    public static final C_MqEmgcyStopStatusKbn MQEMGCYSTOP_END = new C_MqEmgcyStopStatusKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MQEMGCYSTOP_START, "MQEMGCYSTOP_START", true);
        addPattern(PATTERN_DEFAULT, MQEMGCYSTOP_END, "MQEMGCYSTOP_END", false);


        lock(C_MqEmgcyStopStatusKbn.class);
    }

    private C_MqEmgcyStopStatusKbn(String value) {
        super(value);
    }

    public static C_MqEmgcyStopStatusKbn valueOf(String value) {
        return valueOf(C_MqEmgcyStopStatusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MqEmgcyStopStatusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MqEmgcyStopStatusKbn.class, patternId, value);
    }
}
