
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 特条区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TkjyKbn</td><td colspan="3">特条区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKTIBIHTNP}</td><td>&quot;1&quot;</td><td>特定部位不担保</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HKKSKGN}</td><td>&quot;2&quot;</td><td>保険金削減支払</td></tr>
 * </table>
 */
public class C_TkjyKbn extends Classification<C_TkjyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TkjyKbn BLNK = new C_TkjyKbn("0");

    public static final C_TkjyKbn TKTIBIHTNP = new C_TkjyKbn("1");

    public static final C_TkjyKbn HKKSKGN = new C_TkjyKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TKTIBIHTNP, "TKTIBIHTNP", false);
        addPattern(PATTERN_DEFAULT, HKKSKGN, "HKKSKGN", false);


        lock(C_TkjyKbn.class);
    }

    private C_TkjyKbn(String value) {
        super(value);
    }

    public static C_TkjyKbn valueOf(String value) {
        return valueOf(C_TkjyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TkjyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TkjyKbn.class, patternId, value);
    }
}
