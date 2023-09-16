
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 暗号化方式区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AngoukaHousikiKbn</td><td colspan="3">暗号化方式区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #PACKAGE}</td><td>&quot;0&quot;</td><td>パッケージ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CUSTOMIZE}</td><td>&quot;1&quot;</td><td>カスタマイズ</td></tr>
 * </table>
 */
public class C_AngoukaHousikiKbn extends Classification<C_AngoukaHousikiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AngoukaHousikiKbn PACKAGE = new C_AngoukaHousikiKbn("0");

    public static final C_AngoukaHousikiKbn CUSTOMIZE = new C_AngoukaHousikiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, PACKAGE, "PACKAGE", true);
        addPattern(PATTERN_DEFAULT, CUSTOMIZE, "CUSTOMIZE", false);


        lock(C_AngoukaHousikiKbn.class);
    }

    private C_AngoukaHousikiKbn(String value) {
        super(value);
    }

    public static C_AngoukaHousikiKbn valueOf(String value) {
        return valueOf(C_AngoukaHousikiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AngoukaHousikiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AngoukaHousikiKbn.class, patternId, value);
    }
}
