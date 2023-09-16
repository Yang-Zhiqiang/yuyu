
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 表示形式区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HyoujtypeKbn</td><td colspan="3">表示形式区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TEXT}</td><td>&quot;0&quot;</td><td>テキスト</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YMD}</td><td>&quot;1&quot;</td><td>年月日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #CODECNV}</td><td>&quot;2&quot;</td><td>コード変換</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENCALC}</td><td>&quot;3&quot;</td><td>年齢計算</td></tr>
 * </table>
 */
public class C_HyoujtypeKbn extends Classification<C_HyoujtypeKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HyoujtypeKbn TEXT = new C_HyoujtypeKbn("0");

    public static final C_HyoujtypeKbn YMD = new C_HyoujtypeKbn("1");

    public static final C_HyoujtypeKbn CODECNV = new C_HyoujtypeKbn("2");

    public static final C_HyoujtypeKbn NENCALC = new C_HyoujtypeKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TEXT, "TEXT", true);
        addPattern(PATTERN_DEFAULT, YMD, "YMD", false);
        addPattern(PATTERN_DEFAULT, CODECNV, "CODECNV", false);
        addPattern(PATTERN_DEFAULT, NENCALC, "NENCALC", false);


        lock(C_HyoujtypeKbn.class);
    }

    private C_HyoujtypeKbn(String value) {
        super(value);
    }

    public static C_HyoujtypeKbn valueOf(String value) {
        return valueOf(C_HyoujtypeKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HyoujtypeKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HyoujtypeKbn.class, patternId, value);
    }
}
