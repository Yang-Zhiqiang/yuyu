
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 業務区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GyoumuKbn</td><td colspan="3">業務区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKEIYAKU}</td><td>&quot;1&quot;</td><td>新契約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;2&quot;</td><td>年金支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUEOKI}</td><td>&quot;3&quot;</td><td>保険金据置</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;4&quot;</td><td>保険金給付金支払</td></tr>
 * </table>
 */
public class C_GyoumuKbn extends Classification<C_GyoumuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GyoumuKbn BLNK = new C_GyoumuKbn("0");

    public static final C_GyoumuKbn SINKEIYAKU = new C_GyoumuKbn("1");

    public static final C_GyoumuKbn NENKIN = new C_GyoumuKbn("2");

    public static final C_GyoumuKbn SUEOKI = new C_GyoumuKbn("3");

    public static final C_GyoumuKbn SIHARAI = new C_GyoumuKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SINKEIYAKU, "SINKEIYAKU", false);
        addPattern(PATTERN_DEFAULT, NENKIN, "NENKIN", false);
        addPattern(PATTERN_DEFAULT, SUEOKI, "SUEOKI", false);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);


        lock(C_GyoumuKbn.class);
    }

    private C_GyoumuKbn(String value) {
        super(value);
    }

    public static C_GyoumuKbn valueOf(String value) {
        return valueOf(C_GyoumuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GyoumuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GyoumuKbn.class, patternId, value);
    }
}
