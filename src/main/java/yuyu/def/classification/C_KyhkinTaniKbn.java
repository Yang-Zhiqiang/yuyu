
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 給付金単位区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyhkinTaniKbn</td><td colspan="3">給付金単位区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NITI}</td><td>&quot;1&quot;</td><td>日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BAI}</td><td>&quot;2&quot;</td><td>倍</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PER}</td><td>&quot;3&quot;</td><td>％</td></tr>
 * </table>
 */
public class C_KyhkinTaniKbn extends Classification<C_KyhkinTaniKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyhkinTaniKbn BLNK = new C_KyhkinTaniKbn("0");

    public static final C_KyhkinTaniKbn NITI = new C_KyhkinTaniKbn("1");

    public static final C_KyhkinTaniKbn BAI = new C_KyhkinTaniKbn("2");

    public static final C_KyhkinTaniKbn PER = new C_KyhkinTaniKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, NITI, "NITI", false);
        addPattern(PATTERN_DEFAULT, BAI, "BAI", false);
        addPattern(PATTERN_DEFAULT, PER, "PER", false);


        lock(C_KyhkinTaniKbn.class);
    }

    private C_KyhkinTaniKbn(String value) {
        super(value);
    }

    public static C_KyhkinTaniKbn valueOf(String value) {
        return valueOf(C_KyhkinTaniKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyhkinTaniKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyhkinTaniKbn.class, patternId, value);
    }
}
