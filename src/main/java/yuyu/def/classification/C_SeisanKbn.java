
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 精算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SeisanKbn</td><td colspan="3">精算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISEISAN}</td><td>&quot;0&quot;</td><td>未精算</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEISANZUMI}</td><td>&quot;1&quot;</td><td>精算済</td></tr>
 * </table>
 */
public class C_SeisanKbn extends Classification<C_SeisanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SeisanKbn MISEISAN = new C_SeisanKbn("0");

    public static final C_SeisanKbn SEISANZUMI = new C_SeisanKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISEISAN, "MISEISAN", true);
        addPattern(PATTERN_DEFAULT, SEISANZUMI, "SEISANZUMI", false);


        lock(C_SeisanKbn.class);
    }

    private C_SeisanKbn(String value) {
        super(value);
    }

    public static C_SeisanKbn valueOf(String value) {
        return valueOf(C_SeisanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SeisanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SeisanKbn.class, patternId, value);
    }
}
