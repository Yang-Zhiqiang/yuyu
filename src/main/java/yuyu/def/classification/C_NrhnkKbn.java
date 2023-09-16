
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年齢変更区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NrhnkKbn</td><td colspan="3">年齢変更区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNKNONE}</td><td>&quot;1&quot;</td><td>変更なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AGARI}</td><td>&quot;2&quot;</td><td>あがり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAGARI}</td><td>&quot;3&quot;</td><td>さがり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HNKARI}</td><td>&quot;4&quot;</td><td>変更あり</td></tr>
 * </table>
 */
public class C_NrhnkKbn extends Classification<C_NrhnkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NrhnkKbn BLNK = new C_NrhnkKbn("0");

    public static final C_NrhnkKbn HNKNONE = new C_NrhnkKbn("1");

    public static final C_NrhnkKbn AGARI = new C_NrhnkKbn("2");

    public static final C_NrhnkKbn SAGARI = new C_NrhnkKbn("3");

    public static final C_NrhnkKbn HNKARI = new C_NrhnkKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HNKNONE, "HNKNONE", false);
        addPattern(PATTERN_DEFAULT, AGARI, "AGARI", false);
        addPattern(PATTERN_DEFAULT, SAGARI, "SAGARI", false);
        addPattern(PATTERN_DEFAULT, HNKARI, "HNKARI", false);


        lock(C_NrhnkKbn.class);
    }

    private C_NrhnkKbn(String value) {
        super(value);
    }

    public static C_NrhnkKbn valueOf(String value) {
        return valueOf(C_NrhnkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NrhnkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NrhnkKbn.class, patternId, value);
    }
}
