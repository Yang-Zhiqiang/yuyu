
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 配当所要額計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HaitouSyoyougakuKeisanKbn</td><td colspan="3">配当所要額計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NPLUSZERO}</td><td>&quot;1&quot;</td><td>N+0</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NPLUSONE}</td><td>&quot;2&quot;</td><td>N+1</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NPLUSTWO}</td><td>&quot;3&quot;</td><td>N+2</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NMINUSZERO}</td><td>&quot;8&quot;</td><td>N+Q</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NPLUSQUART}</td><td>&quot;9&quot;</td><td>N-0</td></tr>
 * </table>
 */
public class C_HaitouSyoyougakuKeisanKbn extends Classification<C_HaitouSyoyougakuKeisanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HaitouSyoyougakuKeisanKbn NPLUSZERO = new C_HaitouSyoyougakuKeisanKbn("1");

    public static final C_HaitouSyoyougakuKeisanKbn NPLUSONE = new C_HaitouSyoyougakuKeisanKbn("2");

    public static final C_HaitouSyoyougakuKeisanKbn NPLUSTWO = new C_HaitouSyoyougakuKeisanKbn("3");

    public static final C_HaitouSyoyougakuKeisanKbn NMINUSZERO = new C_HaitouSyoyougakuKeisanKbn("8");

    public static final C_HaitouSyoyougakuKeisanKbn NPLUSQUART = new C_HaitouSyoyougakuKeisanKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NPLUSZERO, "NPLUSZERO", true);
        addPattern(PATTERN_DEFAULT, NPLUSONE, "NPLUSONE", false);
        addPattern(PATTERN_DEFAULT, NPLUSTWO, "NPLUSTWO", false);
        addPattern(PATTERN_DEFAULT, NMINUSZERO, "NMINUSZERO", false);
        addPattern(PATTERN_DEFAULT, NPLUSQUART, "NPLUSQUART", false);


        lock(C_HaitouSyoyougakuKeisanKbn.class);
    }

    private C_HaitouSyoyougakuKeisanKbn(String value) {
        super(value);
    }

    public static C_HaitouSyoyougakuKeisanKbn valueOf(String value) {
        return valueOf(C_HaitouSyoyougakuKeisanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HaitouSyoyougakuKeisanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HaitouSyoyougakuKeisanKbn.class, patternId, value);
    }
}
