
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＡＬＭ用ソフト名称区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ALMSoftKbn</td><td colspan="3">ＡＬＭ用ソフト名称区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYSN}</td><td>&quot;12&quot;</td><td>終身保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIBRSYSN}</td><td>&quot;13&quot;</td><td>一時払終身保険（リッチを含む）</td></tr>
 * </table>
 */
public class C_ALMSoftKbn extends Classification<C_ALMSoftKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ALMSoftKbn BLNK = new C_ALMSoftKbn("0");

    public static final C_ALMSoftKbn SYSN = new C_ALMSoftKbn("12");

    public static final C_ALMSoftKbn ITIJIBRSYSN = new C_ALMSoftKbn("13");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYSN, "SYSN", false);
        addPattern(PATTERN_DEFAULT, ITIJIBRSYSN, "ITIJIBRSYSN", false);


        lock(C_ALMSoftKbn.class);
    }

    private C_ALMSoftKbn(String value) {
        super(value);
    }

    public static C_ALMSoftKbn valueOf(String value) {
        return valueOf(C_ALMSoftKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ALMSoftKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ALMSoftKbn.class, patternId, value);
    }
}
