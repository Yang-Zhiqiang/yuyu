
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険料割引適用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PWaribikitekiyouKbn</td><td colspan="3">保険料割引適用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0000&quot;</td><td>保険料割引適用対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO_NONE}</td><td>&quot;0100&quot;</td><td>保険料割引制度－割引なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO_RANK01}</td><td>&quot;0101&quot;</td><td>保険料割引制度－ランク１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO_RANK02}</td><td>&quot;0102&quot;</td><td>保険料割引制度－ランク２</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_SKMOSSYOUKAI SKMOSSYOUKAI}<br />(申込状況照会)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0000&quot;</td><td>未判定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO_NONE}</td><td>&quot;0100&quot;</td><td>割引対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO_RANK01}</td><td>&quot;0101&quot;</td><td>高額割引対象（月払Ｐ１．５万円以上）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PWARISEIDO_RANK02}</td><td>&quot;0102&quot;</td><td>高額割引対象（月払Ｐ３．０万円以上）</td></tr>
 * </table>
 */
public class C_PWaribikitekiyouKbn extends Classification<C_PWaribikitekiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PWaribikitekiyouKbn NONE = new C_PWaribikitekiyouKbn("0000");

    public static final C_PWaribikitekiyouKbn PWARISEIDO_NONE = new C_PWaribikitekiyouKbn("0100");

    public static final C_PWaribikitekiyouKbn PWARISEIDO_RANK01 = new C_PWaribikitekiyouKbn("0101");

    public static final C_PWaribikitekiyouKbn PWARISEIDO_RANK02 = new C_PWaribikitekiyouKbn("0102");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SKMOSSYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, PWARISEIDO_NONE, "PWARISEIDO_NONE", false);
        addPattern(PATTERN_DEFAULT, PWARISEIDO_RANK01, "PWARISEIDO_RANK01", false);
        addPattern(PATTERN_DEFAULT, PWARISEIDO_RANK02, "PWARISEIDO_RANK02", false);


        addPattern(PATTERN_SKMOSSYOUKAI, NONE, "NONE", false);
        addPattern(PATTERN_SKMOSSYOUKAI, PWARISEIDO_NONE, "PWARISEIDO_NONE", false);
        addPattern(PATTERN_SKMOSSYOUKAI, PWARISEIDO_RANK01, "PWARISEIDO_RANK01", false);
        addPattern(PATTERN_SKMOSSYOUKAI, PWARISEIDO_RANK02, "PWARISEIDO_RANK02", false);


        lock(C_PWaribikitekiyouKbn.class);
    }

    private C_PWaribikitekiyouKbn(String value) {
        super(value);
    }

    public static C_PWaribikitekiyouKbn valueOf(String value) {
        return valueOf(C_PWaribikitekiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PWaribikitekiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PWaribikitekiyouKbn.class, patternId, value);
    }
}
