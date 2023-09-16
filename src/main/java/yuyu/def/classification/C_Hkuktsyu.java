
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 給付金受取人種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hkuktsyu</td><td colspan="3">給付金受取人種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYFKUKT}</td><td>&quot;1&quot;</td><td>給付金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBHKKUKT}</td><td>&quot;2&quot;</td><td>死亡保険金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KDSGHKUKT}</td><td>&quot;3&quot;</td><td>高度障害保険金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #LNHKKUKT}</td><td>&quot;4&quot;</td><td>ＬＮ保険金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SBKYFKUKT}</td><td>&quot;5&quot;</td><td>死亡給付金受取人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_Hkuktsyu extends Classification<C_Hkuktsyu> {

    private static final long serialVersionUID = 1L;


    public static final C_Hkuktsyu BLNK = new C_Hkuktsyu("0");

    public static final C_Hkuktsyu KYFKUKT = new C_Hkuktsyu("1");

    public static final C_Hkuktsyu SBHKKUKT = new C_Hkuktsyu("2");

    public static final C_Hkuktsyu KDSGHKUKT = new C_Hkuktsyu("3");

    public static final C_Hkuktsyu LNHKKUKT = new C_Hkuktsyu("4");

    public static final C_Hkuktsyu SBKYFKUKT = new C_Hkuktsyu("5");

    public static final C_Hkuktsyu SONOTA = new C_Hkuktsyu("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KYFKUKT, "KYFKUKT", false);
        addPattern(PATTERN_DEFAULT, SBHKKUKT, "SBHKKUKT", false);
        addPattern(PATTERN_DEFAULT, KDSGHKUKT, "KDSGHKUKT", false);
        addPattern(PATTERN_DEFAULT, LNHKKUKT, "LNHKKUKT", false);
        addPattern(PATTERN_DEFAULT, SBKYFKUKT, "SBKYFKUKT", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_Hkuktsyu.class);
    }

    private C_Hkuktsyu(String value) {
        super(value);
    }

    public static C_Hkuktsyu valueOf(String value) {
        return valueOf(C_Hkuktsyu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hkuktsyu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hkuktsyu.class, patternId, value);
    }
}
