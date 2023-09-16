
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_CalcKbn</td><td colspan="3">計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEK}</td><td>&quot;1&quot;</td><td>設計書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS}</td><td>&quot;2&quot;</td><td>申込書</td></tr>
 * </table>
 */
public class C_CalcKbn extends Classification<C_CalcKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_CalcKbn SEK = new C_CalcKbn("1");

    public static final C_CalcKbn MOS = new C_CalcKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEK, "SEK", true);
        addPattern(PATTERN_DEFAULT, MOS, "MOS", false);


        lock(C_CalcKbn.class);
    }

    private C_CalcKbn(String value) {
        super(value);
    }

    public static C_CalcKbn valueOf(String value) {
        return valueOf(C_CalcKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_CalcKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_CalcKbn.class, patternId, value);
    }
}
