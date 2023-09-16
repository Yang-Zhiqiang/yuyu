
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保有判定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HoyuuCheckKekkaKbn</td><td colspan="3">保有判定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HOYUUTAISYOU}</td><td>&quot;1&quot;</td><td>保有対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOYUUTAISYOUGAI}</td><td>&quot;2&quot;</td><td>保有対象外</td></tr>
 * </table>
 */
public class C_HoyuuCheckKekkaKbn extends Classification<C_HoyuuCheckKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HoyuuCheckKekkaKbn HOYUUTAISYOU = new C_HoyuuCheckKekkaKbn("1");

    public static final C_HoyuuCheckKekkaKbn HOYUUTAISYOUGAI = new C_HoyuuCheckKekkaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HOYUUTAISYOU, "HOYUUTAISYOU", true);
        addPattern(PATTERN_DEFAULT, HOYUUTAISYOUGAI, "HOYUUTAISYOUGAI", false);


        lock(C_HoyuuCheckKekkaKbn.class);
    }

    private C_HoyuuCheckKekkaKbn(String value) {
        super(value);
    }

    public static C_HoyuuCheckKekkaKbn valueOf(String value) {
        return valueOf(C_HoyuuCheckKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HoyuuCheckKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HoyuuCheckKekkaKbn.class, patternId, value);
    }
}
