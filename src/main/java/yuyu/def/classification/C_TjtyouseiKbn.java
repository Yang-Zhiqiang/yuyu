
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 通常調整区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TjtyouseiKbn</td><td colspan="3">通常調整区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYOUSEI}</td><td>&quot;2&quot;</td><td>調整</td></tr>
 * </table>
 */
public class C_TjtyouseiKbn extends Classification<C_TjtyouseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TjtyouseiKbn BLNK = new C_TjtyouseiKbn("0");

    public static final C_TjtyouseiKbn TUUJYOU = new C_TjtyouseiKbn("1");

    public static final C_TjtyouseiKbn TYOUSEI = new C_TjtyouseiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", false);
        addPattern(PATTERN_DEFAULT, TYOUSEI, "TYOUSEI", false);


        lock(C_TjtyouseiKbn.class);
    }

    private C_TjtyouseiKbn(String value) {
        super(value);
    }

    public static C_TjtyouseiKbn valueOf(String value) {
        return valueOf(C_TjtyouseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TjtyouseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TjtyouseiKbn.class, patternId, value);
    }
}
