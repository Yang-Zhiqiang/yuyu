
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 年齢計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NenreiCalcKbn</td><td colspan="3">年齢計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MANNEN}</td><td>&quot;1&quot;</td><td>満年齢</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENNEN}</td><td>&quot;2&quot;</td><td>保険年齢</td></tr>
 * </table>
 */
public class C_NenreiCalcKbn extends Classification<C_NenreiCalcKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NenreiCalcKbn BLNK = new C_NenreiCalcKbn("0");

    public static final C_NenreiCalcKbn MANNEN = new C_NenreiCalcKbn("1");

    public static final C_NenreiCalcKbn HOKENNEN = new C_NenreiCalcKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MANNEN, "MANNEN", false);
        addPattern(PATTERN_DEFAULT, HOKENNEN, "HOKENNEN", false);


        lock(C_NenreiCalcKbn.class);
    }

    private C_NenreiCalcKbn(String value) {
        super(value);
    }

    public static C_NenreiCalcKbn valueOf(String value) {
        return valueOf(C_NenreiCalcKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NenreiCalcKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NenreiCalcKbn.class, patternId, value);
    }
}
