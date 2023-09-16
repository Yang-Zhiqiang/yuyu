
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 帳票ソート区分３ クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TyhysortKbn3</td><td colspan="3">帳票ソート区分３</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #THSORT1}</td><td>&quot;1&quot;</td><td>帳票ソート区分１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THSORT2}</td><td>&quot;2&quot;</td><td>帳票ソート区分２</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_TyhysortKbn3 extends Classification<C_TyhysortKbn3> {

    private static final long serialVersionUID = 1L;


    public static final C_TyhysortKbn3 THSORT1 = new C_TyhysortKbn3("1");

    public static final C_TyhysortKbn3 THSORT2 = new C_TyhysortKbn3("2");

    public static final C_TyhysortKbn3 BLNK = new C_TyhysortKbn3("0");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, THSORT1, "THSORT1", false);
        addPattern(PATTERN_DEFAULT, THSORT2, "THSORT2", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_TyhysortKbn3.class);
    }

    private C_TyhysortKbn3(String value) {
        super(value);
    }

    public static C_TyhysortKbn3 valueOf(String value) {
        return valueOf(C_TyhysortKbn3.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TyhysortKbn3.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TyhysortKbn3.class, patternId, value);
    }
}
