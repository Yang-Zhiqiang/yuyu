
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料支払期間区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsryshrkknKbn</td><td colspan="3">手数料支払期間区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YUGEN}</td><td>&quot;1&quot;</td><td>有限</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MUGEN}</td><td>&quot;2&quot;</td><td>無限</td></tr>
 * </table>
 */
public class C_TsryshrkknKbn extends Classification<C_TsryshrkknKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsryshrkknKbn BLNK = new C_TsryshrkknKbn("0");

    public static final C_TsryshrkknKbn YUGEN = new C_TsryshrkknKbn("1");

    public static final C_TsryshrkknKbn MUGEN = new C_TsryshrkknKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YUGEN, "YUGEN", false);
        addPattern(PATTERN_DEFAULT, MUGEN, "MUGEN", false);


        lock(C_TsryshrkknKbn.class);
    }

    private C_TsryshrkknKbn(String value) {
        super(value);
    }

    public static C_TsryshrkknKbn valueOf(String value) {
        return valueOf(C_TsryshrkknKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsryshrkknKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsryshrkknKbn.class, patternId, value);
    }
}
