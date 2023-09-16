
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 募集年月翌月指定 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Bsyymyokusitei</td><td colspan="3">募集年月翌月指定</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>あり</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SYOUKAI SYOUKAI}<br />(照会)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>翌月指定あり</td></tr>
 * </table>
 */
public class C_Bsyymyokusitei extends Classification<C_Bsyymyokusitei> {

    private static final long serialVersionUID = 1L;


    public static final C_Bsyymyokusitei NONE = new C_Bsyymyokusitei("0");

    public static final C_Bsyymyokusitei ARI = new C_Bsyymyokusitei("1");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SYOUKAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);


        addPattern(PATTERN_SYOUKAI, NONE, "NONE", true);
        addPattern(PATTERN_SYOUKAI, ARI, "ARI", false);


        lock(C_Bsyymyokusitei.class);
    }

    private C_Bsyymyokusitei(String value) {
        super(value);
    }

    public static C_Bsyymyokusitei valueOf(String value) {
        return valueOf(C_Bsyymyokusitei.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Bsyymyokusitei.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Bsyymyokusitei.class, patternId, value);
    }
}
