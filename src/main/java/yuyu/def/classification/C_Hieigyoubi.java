
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 非営業日区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hieigyoubi</td><td colspan="3">非営業日区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #YOKU}</td><td>&quot;1&quot;</td><td>翌営業日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MAE}</td><td>&quot;2&quot;</td><td>前営業日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENSAIYOKU}</td><td>&quot;3&quot;</td><td>返済日のみ翌営業日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENSAIMAE}</td><td>&quot;4&quot;</td><td>返済日のみ前営業日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;9&quot;</td><td>営業日判定なし</td></tr>
 * </table>
 */
public class C_Hieigyoubi extends Classification<C_Hieigyoubi> {

    private static final long serialVersionUID = 1L;


    public static final C_Hieigyoubi YOKU = new C_Hieigyoubi("1");

    public static final C_Hieigyoubi MAE = new C_Hieigyoubi("2");

    public static final C_Hieigyoubi HENSAIYOKU = new C_Hieigyoubi("3");

    public static final C_Hieigyoubi HENSAIMAE = new C_Hieigyoubi("4");

    public static final C_Hieigyoubi NONE = new C_Hieigyoubi("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, YOKU, "YOKU", true);
        addPattern(PATTERN_DEFAULT, MAE, "MAE", false);
        addPattern(PATTERN_DEFAULT, HENSAIYOKU, "HENSAIYOKU", false);
        addPattern(PATTERN_DEFAULT, HENSAIMAE, "HENSAIMAE", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_Hieigyoubi.class);
    }

    private C_Hieigyoubi(String value) {
        super(value);
    }

    public static C_Hieigyoubi valueOf(String value) {
        return valueOf(C_Hieigyoubi.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hieigyoubi.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hieigyoubi.class, patternId, value);
    }
}
