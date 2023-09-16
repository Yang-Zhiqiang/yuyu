
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 変更可否 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Henkoukahi</td><td colspan="3">変更可否</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KA}</td><td>&quot;0&quot;</td><td>可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA_HYOUJI}</td><td>&quot;1&quot;</td><td>不可（表示）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA_HIHYOUJI}</td><td>&quot;2&quot;</td><td>不可（非表示／指定不可）</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_HYOUJI HYOUJI}<br />(表示)</td><td align="center">○</td><td>{@link #KA}</td><td>&quot;0&quot;</td><td>可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA_HYOUJI}</td><td>&quot;1&quot;</td><td>不可（表示）</td></tr>
 * </table>
 */
public class C_Henkoukahi extends Classification<C_Henkoukahi> {

    private static final long serialVersionUID = 1L;


    public static final C_Henkoukahi KA = new C_Henkoukahi("0");

    public static final C_Henkoukahi HUKA_HYOUJI = new C_Henkoukahi("1");

    public static final C_Henkoukahi HUKA_HIHYOUJI = new C_Henkoukahi("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_HYOUJI = "2";


    static {

        addPattern(PATTERN_DEFAULT, KA, "KA", true);
        addPattern(PATTERN_DEFAULT, HUKA_HYOUJI, "HUKA_HYOUJI", false);
        addPattern(PATTERN_DEFAULT, HUKA_HIHYOUJI, "HUKA_HIHYOUJI", false);


        addPattern(PATTERN_HYOUJI, KA, "KA", true);
        addPattern(PATTERN_HYOUJI, HUKA_HYOUJI, "HUKA_HYOUJI", false);


        lock(C_Henkoukahi.class);
    }

    private C_Henkoukahi(String value) {
        super(value);
    }

    public static C_Henkoukahi valueOf(String value) {
        return valueOf(C_Henkoukahi.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Henkoukahi.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Henkoukahi.class, patternId, value);
    }
}
