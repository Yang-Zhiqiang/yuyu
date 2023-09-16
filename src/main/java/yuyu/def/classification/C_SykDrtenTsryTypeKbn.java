
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 紹介代理店手数料タイプ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SykDrtenTsryTypeKbn</td><td colspan="3">紹介代理店手数料タイプ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FIFTY}</td><td>&quot;1&quot;</td><td>50%</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FORTY}</td><td>&quot;2&quot;</td><td>40%</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #THIRTY}</td><td>&quot;3&quot;</td><td>30%</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TWENTY}</td><td>&quot;4&quot;</td><td>20%</td></tr>
 * </table>
 */
public class C_SykDrtenTsryTypeKbn extends Classification<C_SykDrtenTsryTypeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SykDrtenTsryTypeKbn BLNK = new C_SykDrtenTsryTypeKbn("0");

    public static final C_SykDrtenTsryTypeKbn FIFTY = new C_SykDrtenTsryTypeKbn("1");

    public static final C_SykDrtenTsryTypeKbn FORTY = new C_SykDrtenTsryTypeKbn("2");

    public static final C_SykDrtenTsryTypeKbn THIRTY = new C_SykDrtenTsryTypeKbn("3");

    public static final C_SykDrtenTsryTypeKbn TWENTY = new C_SykDrtenTsryTypeKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, FIFTY, "FIFTY", false);
        addPattern(PATTERN_DEFAULT, FORTY, "FORTY", false);
        addPattern(PATTERN_DEFAULT, THIRTY, "THIRTY", false);
        addPattern(PATTERN_DEFAULT, TWENTY, "TWENTY", false);


        lock(C_SykDrtenTsryTypeKbn.class);
    }

    private C_SykDrtenTsryTypeKbn(String value) {
        super(value);
    }

    public static C_SykDrtenTsryTypeKbn valueOf(String value) {
        return valueOf(C_SykDrtenTsryTypeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SykDrtenTsryTypeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SykDrtenTsryTypeKbn.class, patternId, value);
    }
}
