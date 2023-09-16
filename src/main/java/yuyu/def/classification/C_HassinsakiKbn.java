
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 発信先区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HassinsakiKbn</td><td colspan="3">発信先区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYA}</td><td>&quot;1&quot;</td><td>社内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOK}</td><td>&quot;2&quot;</td><td>顧客</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DRTEN}</td><td>&quot;3&quot;</td><td>代理店</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYA}</td><td>&quot;4&quot;</td><td>支社</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_RADIO RADIO}<br />(ラジオボタン用)</td><td align="center">&nbsp;</td><td>{@link #SYA}</td><td>&quot;1&quot;</td><td>社内</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOK}</td><td>&quot;2&quot;</td><td>顧客</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_SKSELECT SKSELECT}<br />(新契約)</td><td align="center">○</td><td>{@link #DRTEN}</td><td>&quot;3&quot;</td><td>代理店</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(新契約以外)</td><td align="center">○</td><td>{@link #KOK}</td><td>&quot;2&quot;</td><td>顧客</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYA}</td><td>&quot;1&quot;</td><td>本社事務部門</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SISELECT SISELECT}<br />(保険金)</td><td align="center">○</td><td>{@link #KOK}</td><td>&quot;2&quot;</td><td>顧客</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SISYA}</td><td>&quot;4&quot;</td><td>支社</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYA}</td><td>&quot;1&quot;</td><td>本社事務部門</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_KHSELECT KHSELECT}<br />(保全)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOK}</td><td>&quot;2&quot;</td><td>顧客</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYA}</td><td>&quot;1&quot;</td><td>本社事務部門</td></tr>
 * </table>
 */
public class C_HassinsakiKbn extends Classification<C_HassinsakiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HassinsakiKbn BLNK = new C_HassinsakiKbn("0");

    public static final C_HassinsakiKbn SYA = new C_HassinsakiKbn("1");

    public static final C_HassinsakiKbn KOK = new C_HassinsakiKbn("2");

    public static final C_HassinsakiKbn DRTEN = new C_HassinsakiKbn("3");

    public static final C_HassinsakiKbn SISYA = new C_HassinsakiKbn("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_RADIO = "2";

    public static final String PATTERN_SKSELECT = "3";

    public static final String PATTERN_SELECT = "4";

    public static final String PATTERN_SISELECT = "5";

    public static final String PATTERN_KHSELECT = "6";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYA, "SYA", false);
        addPattern(PATTERN_DEFAULT, KOK, "KOK", false);
        addPattern(PATTERN_DEFAULT, DRTEN, "DRTEN", false);
        addPattern(PATTERN_DEFAULT, SISYA, "SISYA", false);


        addPattern(PATTERN_RADIO, SYA, "SYA", false);
        addPattern(PATTERN_RADIO, KOK, "KOK", false);


        addPattern(PATTERN_SKSELECT, DRTEN, "DRTEN", true);


        addPattern(PATTERN_SELECT, KOK, "KOK", true);
        addPattern(PATTERN_SELECT, SYA, "SYA", false);


        addPattern(PATTERN_SISELECT, KOK, "KOK", true);
        addPattern(PATTERN_SISELECT, SISYA, "SISYA", false);
        addPattern(PATTERN_SISELECT, SYA, "SYA", false);


        addPattern(PATTERN_KHSELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_KHSELECT, KOK, "KOK", false);
        addPattern(PATTERN_KHSELECT, SYA, "SYA", false);


        lock(C_HassinsakiKbn.class);
    }

    private C_HassinsakiKbn(String value) {
        super(value);
    }

    public static C_HassinsakiKbn valueOf(String value) {
        return valueOf(C_HassinsakiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HassinsakiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HassinsakiKbn.class, patternId, value);
    }
}
