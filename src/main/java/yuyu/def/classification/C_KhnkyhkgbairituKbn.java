
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 基本給付金額倍率区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KhnkyhkgbairituKbn</td><td colspan="3">基本給付金額倍率区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBAI}</td><td>&quot;1&quot;</td><td>１倍</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NIBAI}</td><td>&quot;2&quot;</td><td>２倍</td></tr>
 * </table>
 */
public class C_KhnkyhkgbairituKbn extends Classification<C_KhnkyhkgbairituKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KhnkyhkgbairituKbn BLNK = new C_KhnkyhkgbairituKbn("0");

    public static final C_KhnkyhkgbairituKbn ITIBAI = new C_KhnkyhkgbairituKbn("1");

    public static final C_KhnkyhkgbairituKbn NIBAI = new C_KhnkyhkgbairituKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITIBAI, "ITIBAI", false);
        addPattern(PATTERN_DEFAULT, NIBAI, "NIBAI", false);


        lock(C_KhnkyhkgbairituKbn.class);
    }

    private C_KhnkyhkgbairituKbn(String value) {
        super(value);
    }

    public static C_KhnkyhkgbairituKbn valueOf(String value) {
        return valueOf(C_KhnkyhkgbairituKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KhnkyhkgbairituKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KhnkyhkgbairituKbn.class, patternId, value);
    }
}
