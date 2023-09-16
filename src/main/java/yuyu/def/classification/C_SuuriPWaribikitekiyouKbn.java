
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 数理保険料割引適用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SuuriPWaribikitekiyouKbn</td><td colspan="3">数理保険料割引適用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #PWARISEIDO_NONE}</td><td>&quot;0&quot;</td><td>割引対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO_RANK01}</td><td>&quot;1&quot;</td><td>高額割引対象（月払Ｐ１．５万円以上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO_RANK02}</td><td>&quot;2&quot;</td><td>高額割引対象（月払Ｐ３．０万円以上）</td></tr>
 * </table>
 */
public class C_SuuriPWaribikitekiyouKbn extends Classification<C_SuuriPWaribikitekiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SuuriPWaribikitekiyouKbn PWARISEIDO_NONE = new C_SuuriPWaribikitekiyouKbn("0");

    public static final C_SuuriPWaribikitekiyouKbn PWARISEIDO_RANK01 = new C_SuuriPWaribikitekiyouKbn("1");

    public static final C_SuuriPWaribikitekiyouKbn PWARISEIDO_RANK02 = new C_SuuriPWaribikitekiyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, PWARISEIDO_NONE, "PWARISEIDO_NONE", true);
        addPattern(PATTERN_DEFAULT, PWARISEIDO_RANK01, "PWARISEIDO_RANK01", false);
        addPattern(PATTERN_DEFAULT, PWARISEIDO_RANK02, "PWARISEIDO_RANK02", false);


        lock(C_SuuriPWaribikitekiyouKbn.class);
    }

    private C_SuuriPWaribikitekiyouKbn(String value) {
        super(value);
    }

    public static C_SuuriPWaribikitekiyouKbn valueOf(String value) {
        return valueOf(C_SuuriPWaribikitekiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SuuriPWaribikitekiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SuuriPWaribikitekiyouKbn.class, patternId, value);
    }
}
