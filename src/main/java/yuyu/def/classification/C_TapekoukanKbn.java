
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * テープ交換区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TapekoukanKbn</td><td colspan="3">テープ交換区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TYOUHYOU}</td><td>&quot;0&quot;</td><td>帳票</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKAN_1}</td><td>&quot;1&quot;</td><td>交換１本</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KOUKAN_2}</td><td>&quot;2&quot;</td><td>交換２本</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FILEDENSOU}</td><td>&quot;3&quot;</td><td>ファイル伝送</td></tr>
 * </table>
 */
public class C_TapekoukanKbn extends Classification<C_TapekoukanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TapekoukanKbn TYOUHYOU = new C_TapekoukanKbn("0");

    public static final C_TapekoukanKbn KOUKAN_1 = new C_TapekoukanKbn("1");

    public static final C_TapekoukanKbn KOUKAN_2 = new C_TapekoukanKbn("2");

    public static final C_TapekoukanKbn FILEDENSOU = new C_TapekoukanKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TYOUHYOU, "TYOUHYOU", true);
        addPattern(PATTERN_DEFAULT, KOUKAN_1, "KOUKAN_1", false);
        addPattern(PATTERN_DEFAULT, KOUKAN_2, "KOUKAN_2", false);
        addPattern(PATTERN_DEFAULT, FILEDENSOU, "FILEDENSOU", false);


        lock(C_TapekoukanKbn.class);
    }

    private C_TapekoukanKbn(String value) {
        super(value);
    }

    public static C_TapekoukanKbn valueOf(String value) {
        return valueOf(C_TapekoukanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TapekoukanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TapekoukanKbn.class, patternId, value);
    }
}
