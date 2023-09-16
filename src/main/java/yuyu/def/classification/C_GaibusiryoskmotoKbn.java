
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 外部資料請求元区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GaibusiryoskmotoKbn</td><td colspan="3">外部資料請求元区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SUMISEI}</td><td>&quot;1&quot;</td><td>住生資料請求</td></tr>
 * </table>
 */
public class C_GaibusiryoskmotoKbn extends Classification<C_GaibusiryoskmotoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GaibusiryoskmotoKbn BLNK = new C_GaibusiryoskmotoKbn("0");

    public static final C_GaibusiryoskmotoKbn SUMISEI = new C_GaibusiryoskmotoKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SUMISEI, "SUMISEI", false);


        lock(C_GaibusiryoskmotoKbn.class);
    }

    private C_GaibusiryoskmotoKbn(String value) {
        super(value);
    }

    public static C_GaibusiryoskmotoKbn valueOf(String value) {
        return valueOf(C_GaibusiryoskmotoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GaibusiryoskmotoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GaibusiryoskmotoKbn.class, patternId, value);
    }
}
