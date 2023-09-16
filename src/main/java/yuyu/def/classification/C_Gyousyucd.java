
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 業種コード クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Gyousyucd</td><td colspan="3">業種コード</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;00000&quot;</td><td>設定なし</td></tr>
 * </table>
 */
public class C_Gyousyucd extends Classification<C_Gyousyucd> {

    private static final long serialVersionUID = 1L;


    public static final C_Gyousyucd NONE = new C_Gyousyucd("00000");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);


        lock(C_Gyousyucd.class);
    }

    private C_Gyousyucd(String value) {
        super(value);
    }

    public static C_Gyousyucd valueOf(String value) {
        return valueOf(C_Gyousyucd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Gyousyucd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Gyousyucd.class, patternId, value);
    }
}
