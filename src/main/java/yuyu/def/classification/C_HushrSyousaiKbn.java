
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 不支払詳細区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HushrSyousaiKbn</td><td colspan="3">不支払詳細区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HTNPKKN}</td><td>&quot;1&quot;</td><td>不担保期間</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITINYUINGNDTYOUKA}</td><td>&quot;2&quot;</td><td>１入院限度超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TSNGNDTYOUKA}</td><td>&quot;3&quot;</td><td>通算限度超過</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;4&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_HushrSyousaiKbn extends Classification<C_HushrSyousaiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HushrSyousaiKbn BLNK = new C_HushrSyousaiKbn("0");

    public static final C_HushrSyousaiKbn HTNPKKN = new C_HushrSyousaiKbn("1");

    public static final C_HushrSyousaiKbn ITINYUINGNDTYOUKA = new C_HushrSyousaiKbn("2");

    public static final C_HushrSyousaiKbn TSNGNDTYOUKA = new C_HushrSyousaiKbn("3");

    public static final C_HushrSyousaiKbn SONOTA = new C_HushrSyousaiKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HTNPKKN, "HTNPKKN", false);
        addPattern(PATTERN_DEFAULT, ITINYUINGNDTYOUKA, "ITINYUINGNDTYOUKA", false);
        addPattern(PATTERN_DEFAULT, TSNGNDTYOUKA, "TSNGNDTYOUKA", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_HushrSyousaiKbn.class);
    }

    private C_HushrSyousaiKbn(String value) {
        super(value);
    }

    public static C_HushrSyousaiKbn valueOf(String value) {
        return valueOf(C_HushrSyousaiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HushrSyousaiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HushrSyousaiKbn.class, patternId, value);
    }
}
