
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料計算方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsrkeisanhouKbn</td><td colspan="3">手数料計算方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIKYUBASE}</td><td>&quot;1&quot;</td><td>請求ベース</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HURIKAEBASE}</td><td>&quot;2&quot;</td><td>振替ベース</td></tr>
 * </table>
 */
public class C_TsrkeisanhouKbn extends Classification<C_TsrkeisanhouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsrkeisanhouKbn BLNK = new C_TsrkeisanhouKbn("0");

    public static final C_TsrkeisanhouKbn SEIKYUBASE = new C_TsrkeisanhouKbn("1");

    public static final C_TsrkeisanhouKbn HURIKAEBASE = new C_TsrkeisanhouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SEIKYUBASE, "SEIKYUBASE", false);
        addPattern(PATTERN_DEFAULT, HURIKAEBASE, "HURIKAEBASE", false);


        lock(C_TsrkeisanhouKbn.class);
    }

    private C_TsrkeisanhouKbn(String value) {
        super(value);
    }

    public static C_TsrkeisanhouKbn valueOf(String value) {
        return valueOf(C_TsrkeisanhouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsrkeisanhouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsrkeisanhouKbn.class, patternId, value);
    }
}
