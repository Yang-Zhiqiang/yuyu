
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択情報登録システム区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkInfoTourokuSysKbn</td><td colspan="3">選択情報登録システム区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #HOZEN}</td><td>&quot;1&quot;</td><td>契約保全</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;2&quot;</td><td>保険金給付金支払</td></tr>
 * </table>
 */
public class C_SntkInfoTourokuSysKbn extends Classification<C_SntkInfoTourokuSysKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkInfoTourokuSysKbn HOZEN = new C_SntkInfoTourokuSysKbn("1");

    public static final C_SntkInfoTourokuSysKbn SIHARAI = new C_SntkInfoTourokuSysKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HOZEN, "HOZEN", false);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);


        lock(C_SntkInfoTourokuSysKbn.class);
    }

    private C_SntkInfoTourokuSysKbn(String value) {
        super(value);
    }

    public static C_SntkInfoTourokuSysKbn valueOf(String value) {
        return valueOf(C_SntkInfoTourokuSysKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkInfoTourokuSysKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkInfoTourokuSysKbn.class, patternId, value);
    }
}
