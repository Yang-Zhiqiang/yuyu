
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 通常簡易区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TuujyoukaniKbn</td><td colspan="3">通常簡易区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TUUJYOU}</td><td>&quot;1&quot;</td><td>通常</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANI}</td><td>&quot;2&quot;</td><td>簡易</td></tr>
 * </table>
 */
public class C_TuujyoukaniKbn extends Classification<C_TuujyoukaniKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TuujyoukaniKbn TUUJYOU = new C_TuujyoukaniKbn("1");

    public static final C_TuujyoukaniKbn KANI = new C_TuujyoukaniKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TUUJYOU, "TUUJYOU", true);
        addPattern(PATTERN_DEFAULT, KANI, "KANI", false);


        lock(C_TuujyoukaniKbn.class);
    }

    private C_TuujyoukaniKbn(String value) {
        super(value);
    }

    public static C_TuujyoukaniKbn valueOf(String value) {
        return valueOf(C_TuujyoukaniKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TuujyoukaniKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TuujyoukaniKbn.class, patternId, value);
    }
}
