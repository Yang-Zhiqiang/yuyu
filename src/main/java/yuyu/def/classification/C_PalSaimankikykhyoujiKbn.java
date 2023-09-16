
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＰＡＬ才満期契約表示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PalSaimankikykhyoujiKbn</td><td colspan="3">ＰＡＬ才満期契約表示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;1&quot;</td><td>年満期</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SAI}</td><td>&quot;2&quot;</td><td>歳満期</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">&nbsp;</td><td>{@link #NEN}</td><td>&quot;1&quot;</td><td>０：年満期</td></tr>
 *  <tr><td align="center">○</td><td>{@link #SAI}</td><td>&quot;2&quot;</td><td>１：歳満期</td></tr>
 * </table>
 */
public class C_PalSaimankikykhyoujiKbn extends Classification<C_PalSaimankikykhyoujiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PalSaimankikykhyoujiKbn NEN = new C_PalSaimankikykhyoujiKbn("1");

    public static final C_PalSaimankikykhyoujiKbn SAI = new C_PalSaimankikykhyoujiKbn("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, NEN, "NEN", false);
        addPattern(PATTERN_DEFAULT, SAI, "SAI", true);


        addPattern(PATTERN_SELECT, NEN, "NEN", false);
        addPattern(PATTERN_SELECT, SAI, "SAI", true);


        lock(C_PalSaimankikykhyoujiKbn.class);
    }

    private C_PalSaimankikykhyoujiKbn(String value) {
        super(value);
    }

    public static C_PalSaimankikykhyoujiKbn valueOf(String value) {
        return valueOf(C_PalSaimankikykhyoujiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PalSaimankikykhyoujiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PalSaimankikykhyoujiKbn.class, patternId, value);
    }
}
