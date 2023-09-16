
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * S建P建区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Sdpd</td><td colspan="3">S建P建区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SD}</td><td>&quot;1&quot;</td><td>Ｓ建</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PD}</td><td>&quot;2&quot;</td><td>Ｐ建</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GIJIPD}</td><td>&quot;3&quot;</td><td>擬似Ｐ建</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #SD}</td><td>&quot;1&quot;</td><td>Ｓ建</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PD}</td><td>&quot;2&quot;</td><td>Ｐ建</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GIJIPD}</td><td>&quot;3&quot;</td><td>擬似Ｐ建</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SD}</td><td>&quot;1&quot;</td><td>Ｓ建</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PD}</td><td>&quot;2&quot;</td><td>Ｐ建</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_REPORT REPORT}<br />(帳票用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SD}</td><td>&quot;1&quot;</td><td>保険金額建</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PD}</td><td>&quot;2&quot;</td><td>保険料建</td></tr>
 * </table>
 */
public class C_Sdpd extends Classification<C_Sdpd> {

    private static final long serialVersionUID = 1L;


    public static final C_Sdpd BLNK = new C_Sdpd("0");

    public static final C_Sdpd SD = new C_Sdpd("1");

    public static final C_Sdpd PD = new C_Sdpd("2");

    public static final C_Sdpd GIJIPD = new C_Sdpd("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_SELECT = "3";

    public static final String PATTERN_REPORT = "4";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SD, "SD", false);
        addPattern(PATTERN_DEFAULT, PD, "PD", false);
        addPattern(PATTERN_DEFAULT, GIJIPD, "GIJIPD", false);


        addPattern(PATTERN_NOBLNK, SD, "SD", true);
        addPattern(PATTERN_NOBLNK, PD, "PD", false);
        addPattern(PATTERN_NOBLNK, GIJIPD, "GIJIPD", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, SD, "SD", false);
        addPattern(PATTERN_SELECT, PD, "PD", false);


        addPattern(PATTERN_REPORT, BLNK, "BLNK", true);
        addPattern(PATTERN_REPORT, SD, "SD", false);
        addPattern(PATTERN_REPORT, PD, "PD", false);


        lock(C_Sdpd.class);
    }

    private C_Sdpd(String value) {
        super(value);
    }

    public static C_Sdpd valueOf(String value) {
        return valueOf(C_Sdpd.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Sdpd.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Sdpd.class, patternId, value);
    }
}
