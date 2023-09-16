
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 給付限度型区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyhgndkataKbn</td><td colspan="3">給付限度型区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE60}</td><td>&quot;1&quot;</td><td>60日型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE120}</td><td>&quot;2&quot;</td><td>120日型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE180}</td><td>&quot;3&quot;</td><td>180日型</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE120}</td><td>&quot;2&quot;</td><td>120日型</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NO180 NO180}<br />(180日型なし)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE60}</td><td>&quot;1&quot;</td><td>60日型</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE120}</td><td>&quot;2&quot;</td><td>120日型</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NISSUU NISSUU}<br />(日数)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE60}</td><td>&quot;1&quot;</td><td>60</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE120}</td><td>&quot;2&quot;</td><td>120</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYPE180}</td><td>&quot;3&quot;</td><td>180</td></tr>
 * </table>
 */
public class C_KyhgndkataKbn extends Classification<C_KyhgndkataKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyhgndkataKbn BLNK = new C_KyhgndkataKbn("0");

    public static final C_KyhgndkataKbn TYPE60 = new C_KyhgndkataKbn("1");

    public static final C_KyhgndkataKbn TYPE120 = new C_KyhgndkataKbn("2");

    public static final C_KyhgndkataKbn TYPE180 = new C_KyhgndkataKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_NO180 = "3";

    public static final String PATTERN_NISSUU = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, TYPE60, "TYPE60", false);
        addPattern(PATTERN_DEFAULT, TYPE120, "TYPE120", false);
        addPattern(PATTERN_DEFAULT, TYPE180, "TYPE180", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", false);
        addPattern(PATTERN_SELECT, TYPE120, "TYPE120", false);


        addPattern(PATTERN_NO180, BLNK, "BLNK", false);
        addPattern(PATTERN_NO180, TYPE60, "TYPE60", false);
        addPattern(PATTERN_NO180, TYPE120, "TYPE120", false);


        addPattern(PATTERN_NISSUU, BLNK, "BLNK", false);
        addPattern(PATTERN_NISSUU, TYPE60, "TYPE60", false);
        addPattern(PATTERN_NISSUU, TYPE120, "TYPE120", false);
        addPattern(PATTERN_NISSUU, TYPE180, "TYPE180", false);


        lock(C_KyhgndkataKbn.class);
    }

    private C_KyhgndkataKbn(String value) {
        super(value);
    }

    public static C_KyhgndkataKbn valueOf(String value) {
        return valueOf(C_KyhgndkataKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyhgndkataKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyhgndkataKbn.class, patternId, value);
    }
}
