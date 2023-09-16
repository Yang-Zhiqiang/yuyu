
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＭＱコネクション制御区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MqConnectionControlKbn</td><td colspan="3">ＭＱコネクション制御区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #END}</td><td>&quot;0&quot;</td><td>ＭＱ終了</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #START}</td><td>&quot;1&quot;</td><td>ＭＱ開始</td></tr>
 * </table>
 */
public class C_MqConnectionControlKbn extends Classification<C_MqConnectionControlKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MqConnectionControlKbn END = new C_MqConnectionControlKbn("0");

    public static final C_MqConnectionControlKbn START = new C_MqConnectionControlKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, END, "END", true);
        addPattern(PATTERN_DEFAULT, START, "START", false);


        lock(C_MqConnectionControlKbn.class);
    }

    private C_MqConnectionControlKbn(String value) {
        super(value);
    }

    public static C_MqConnectionControlKbn valueOf(String value) {
        return valueOf(C_MqConnectionControlKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MqConnectionControlKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MqConnectionControlKbn.class, patternId, value);
    }
}
