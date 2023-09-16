
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料支払確定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsryshrkktKbn</td><td colspan="3">手数料支払確定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MIKAKUTEI}</td><td>&quot;0&quot;</td><td>未確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUTEI}</td><td>&quot;1&quot;</td><td>確定</td></tr>
 * </table>
 */
public class C_TsryshrkktKbn extends Classification<C_TsryshrkktKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsryshrkktKbn MIKAKUTEI = new C_TsryshrkktKbn("0");

    public static final C_TsryshrkktKbn KAKUTEI = new C_TsryshrkktKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MIKAKUTEI, "MIKAKUTEI", true);
        addPattern(PATTERN_DEFAULT, KAKUTEI, "KAKUTEI", false);


        lock(C_TsryshrkktKbn.class);
    }

    private C_TsryshrkktKbn(String value) {
        super(value);
    }

    public static C_TsryshrkktKbn valueOf(String value) {
        return valueOf(C_TsryshrkktKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsryshrkktKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsryshrkktKbn.class, patternId, value);
    }
}
