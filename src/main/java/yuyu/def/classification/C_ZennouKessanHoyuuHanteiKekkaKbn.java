
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 前納決算保有判定結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZennouKessanHoyuuHanteiKekkaKbn</td><td colspan="3">前納決算保有判定結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HOYUUTAISYOU}</td><td>&quot;1&quot;</td><td>保有対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BIKINTAISYOU}</td><td>&quot;2&quot;</td><td>備金対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOUMETUTAISYOU}</td><td>&quot;3&quot;</td><td>消滅対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOYUUTAISYOUGAI}</td><td>&quot;4&quot;</td><td>保有対象外</td></tr>
 * </table>
 */
public class C_ZennouKessanHoyuuHanteiKekkaKbn extends Classification<C_ZennouKessanHoyuuHanteiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZennouKessanHoyuuHanteiKekkaKbn HOYUUTAISYOU = new C_ZennouKessanHoyuuHanteiKekkaKbn("1");

    public static final C_ZennouKessanHoyuuHanteiKekkaKbn BIKINTAISYOU = new C_ZennouKessanHoyuuHanteiKekkaKbn("2");

    public static final C_ZennouKessanHoyuuHanteiKekkaKbn SYOUMETUTAISYOU = new C_ZennouKessanHoyuuHanteiKekkaKbn("3");

    public static final C_ZennouKessanHoyuuHanteiKekkaKbn HOYUUTAISYOUGAI = new C_ZennouKessanHoyuuHanteiKekkaKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HOYUUTAISYOU, "HOYUUTAISYOU", true);
        addPattern(PATTERN_DEFAULT, BIKINTAISYOU, "BIKINTAISYOU", false);
        addPattern(PATTERN_DEFAULT, SYOUMETUTAISYOU, "SYOUMETUTAISYOU", false);
        addPattern(PATTERN_DEFAULT, HOYUUTAISYOUGAI, "HOYUUTAISYOUGAI", false);


        lock(C_ZennouKessanHoyuuHanteiKekkaKbn.class);
    }

    private C_ZennouKessanHoyuuHanteiKekkaKbn(String value) {
        super(value);
    }

    public static C_ZennouKessanHoyuuHanteiKekkaKbn valueOf(String value) {
        return valueOf(C_ZennouKessanHoyuuHanteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZennouKessanHoyuuHanteiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZennouKessanHoyuuHanteiKekkaKbn.class, patternId, value);
    }
}
