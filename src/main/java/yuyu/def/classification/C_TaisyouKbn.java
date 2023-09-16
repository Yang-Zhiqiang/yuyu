
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TaisyouKbn</td><td colspan="3">対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HITAISYOU}</td><td>&quot;0&quot;</td><td>非対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOU}</td><td>&quot;1&quot;</td><td>対象</td></tr>
 * </table>
 */
public class C_TaisyouKbn extends Classification<C_TaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TaisyouKbn HITAISYOU = new C_TaisyouKbn("0");

    public static final C_TaisyouKbn TAISYOU = new C_TaisyouKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HITAISYOU, "HITAISYOU", true);
        addPattern(PATTERN_DEFAULT, TAISYOU, "TAISYOU", false);


        lock(C_TaisyouKbn.class);
    }

    private C_TaisyouKbn(String value) {
        super(value);
    }

    public static C_TaisyouKbn valueOf(String value) {
        return valueOf(C_TaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TaisyouKbn.class, patternId, value);
    }
}
