
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受付番号区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_UkenoKbn</td><td colspan="3">受付番号区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONE}</td><td>&quot;1&quot;</td><td>１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWO}</td><td>&quot;2&quot;</td><td>２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THREE}</td><td>&quot;3&quot;</td><td>３</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #ONE}</td><td>&quot;1&quot;</td><td>１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWO}</td><td>&quot;2&quot;</td><td>２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THREE}</td><td>&quot;3&quot;</td><td>３</td></tr>
 * </table>
 */
public class C_UkenoKbn extends Classification<C_UkenoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_UkenoKbn BLNK = new C_UkenoKbn("0");

    public static final C_UkenoKbn ONE = new C_UkenoKbn("1");

    public static final C_UkenoKbn TWO = new C_UkenoKbn("2");

    public static final C_UkenoKbn THREE = new C_UkenoKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ONE, "ONE", false);
        addPattern(PATTERN_DEFAULT, TWO, "TWO", false);
        addPattern(PATTERN_DEFAULT, THREE, "THREE", false);


        addPattern(PATTERN_SELECT, ONE, "ONE", true);
        addPattern(PATTERN_SELECT, TWO, "TWO", false);
        addPattern(PATTERN_SELECT, THREE, "THREE", false);


        lock(C_UkenoKbn.class);
    }

    private C_UkenoKbn(String value) {
        super(value);
    }

    public static C_UkenoKbn valueOf(String value) {
        return valueOf(C_UkenoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_UkenoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_UkenoKbn.class, patternId, value);
    }
}
