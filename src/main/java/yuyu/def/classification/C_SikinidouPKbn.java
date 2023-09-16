
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 資金移動用保険料区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SikinidouPKbn</td><td colspan="3">資金移動用保険料区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FSTP}</td><td>&quot;1&quot;</td><td>初回保険料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUP}</td><td>&quot;2&quot;</td><td>継続保険料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TUITYOUKIN}</td><td>&quot;3&quot;</td><td>追徴金</td></tr>
 * </table>
 */
public class C_SikinidouPKbn extends Classification<C_SikinidouPKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SikinidouPKbn BLNK = new C_SikinidouPKbn("0");

    public static final C_SikinidouPKbn FSTP = new C_SikinidouPKbn("1");

    public static final C_SikinidouPKbn KEIZOKUP = new C_SikinidouPKbn("2");

    public static final C_SikinidouPKbn TUITYOUKIN = new C_SikinidouPKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FSTP, "FSTP", false);
        addPattern(PATTERN_DEFAULT, KEIZOKUP, "KEIZOKUP", false);
        addPattern(PATTERN_DEFAULT, TUITYOUKIN, "TUITYOUKIN", false);


        lock(C_SikinidouPKbn.class);
    }

    private C_SikinidouPKbn(String value) {
        super(value);
    }

    public static C_SikinidouPKbn valueOf(String value) {
        return valueOf(C_SikinidouPKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SikinidouPKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SikinidouPKbn.class, patternId, value);
    }
}
