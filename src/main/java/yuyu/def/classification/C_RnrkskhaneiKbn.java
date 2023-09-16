
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 連絡先反映区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RnrkskhaneiKbn</td><td colspan="3">連絡先反映区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOK}</td><td>&quot;1&quot;</td><td>顧客</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRTEN}</td><td>&quot;2&quot;</td><td>代理店</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SKSELECT SKSELECT}<br />(選択)</td><td align="center">○</td><td>{@link #KOK}</td><td>&quot;1&quot;</td><td>顧客</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRTEN}</td><td>&quot;2&quot;</td><td>代理店</td></tr>
 * </table>
 */
public class C_RnrkskhaneiKbn extends Classification<C_RnrkskhaneiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RnrkskhaneiKbn BLNK = new C_RnrkskhaneiKbn("0");

    public static final C_RnrkskhaneiKbn KOK = new C_RnrkskhaneiKbn("1");

    public static final C_RnrkskhaneiKbn DRTEN = new C_RnrkskhaneiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SKSELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KOK, "KOK", false);
        addPattern(PATTERN_DEFAULT, DRTEN, "DRTEN", false);


        addPattern(PATTERN_SKSELECT, KOK, "KOK", true);
        addPattern(PATTERN_SKSELECT, DRTEN, "DRTEN", false);


        lock(C_RnrkskhaneiKbn.class);
    }

    private C_RnrkskhaneiKbn(String value) {
        super(value);
    }

    public static C_RnrkskhaneiKbn valueOf(String value) {
        return valueOf(C_RnrkskhaneiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RnrkskhaneiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RnrkskhaneiKbn.class, patternId, value);
    }
}
