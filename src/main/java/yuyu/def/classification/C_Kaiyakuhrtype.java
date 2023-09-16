
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 解約返戻金支払タイプ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Kaiyakuhrtype</td><td colspan="3">解約返戻金支払タイプ</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIMANGOARI}</td><td>&quot;1&quot;</td><td>払満後あり</td></tr>
 * </table>
 */
public class C_Kaiyakuhrtype extends Classification<C_Kaiyakuhrtype> {

    private static final long serialVersionUID = 1L;


    public static final C_Kaiyakuhrtype NONE = new C_Kaiyakuhrtype("0");

    public static final C_Kaiyakuhrtype HARAIMANGOARI = new C_Kaiyakuhrtype("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, HARAIMANGOARI, "HARAIMANGOARI", false);


        lock(C_Kaiyakuhrtype.class);
    }

    private C_Kaiyakuhrtype(String value) {
        super(value);
    }

    public static C_Kaiyakuhrtype valueOf(String value) {
        return valueOf(C_Kaiyakuhrtype.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Kaiyakuhrtype.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Kaiyakuhrtype.class, patternId, value);
    }
}
