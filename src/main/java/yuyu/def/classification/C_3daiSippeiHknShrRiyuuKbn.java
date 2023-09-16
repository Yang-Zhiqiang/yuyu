
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ３大疾病保険金支払理由区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_3daiSippeiHknShrRiyuuKbn</td><td colspan="3">３大疾病保険金支払理由区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR_HGAITOU}</td><td>&quot;1&quot;</td><td>不支払(非該当)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HSHR_60DAYSMIKEIKA}</td><td>&quot;2&quot;</td><td>不支払(６０日未経過)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GANSNDNKKTIYMD}</td><td>&quot;3&quot;</td><td>がん診断確定日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSS_NOUST_SS60}</td><td>&quot;4&quot;</td><td>急性心筋梗塞、脳卒中による初診日から６０日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSS_NOUST_SJ}</td><td>&quot;5&quot;</td><td>急性心筋梗塞、脳卒中による手術日</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KSS_NOUST_SB}</td><td>&quot;6&quot;</td><td>急性心筋梗塞、脳卒中による死亡日</td></tr>
 * </table>
 */
public class C_3daiSippeiHknShrRiyuuKbn extends Classification<C_3daiSippeiHknShrRiyuuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_3daiSippeiHknShrRiyuuKbn BLNK = new C_3daiSippeiHknShrRiyuuKbn("0");

    public static final C_3daiSippeiHknShrRiyuuKbn HSHR_HGAITOU = new C_3daiSippeiHknShrRiyuuKbn("1");

    public static final C_3daiSippeiHknShrRiyuuKbn HSHR_60DAYSMIKEIKA = new C_3daiSippeiHknShrRiyuuKbn("2");

    public static final C_3daiSippeiHknShrRiyuuKbn GANSNDNKKTIYMD = new C_3daiSippeiHknShrRiyuuKbn("3");

    public static final C_3daiSippeiHknShrRiyuuKbn KSS_NOUST_SS60 = new C_3daiSippeiHknShrRiyuuKbn("4");

    public static final C_3daiSippeiHknShrRiyuuKbn KSS_NOUST_SJ = new C_3daiSippeiHknShrRiyuuKbn("5");

    public static final C_3daiSippeiHknShrRiyuuKbn KSS_NOUST_SB = new C_3daiSippeiHknShrRiyuuKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HSHR_HGAITOU, "HSHR_HGAITOU", false);
        addPattern(PATTERN_DEFAULT, HSHR_60DAYSMIKEIKA, "HSHR_60DAYSMIKEIKA", false);
        addPattern(PATTERN_DEFAULT, GANSNDNKKTIYMD, "GANSNDNKKTIYMD", false);
        addPattern(PATTERN_DEFAULT, KSS_NOUST_SS60, "KSS_NOUST_SS60", false);
        addPattern(PATTERN_DEFAULT, KSS_NOUST_SJ, "KSS_NOUST_SJ", false);
        addPattern(PATTERN_DEFAULT, KSS_NOUST_SB, "KSS_NOUST_SB", false);


        lock(C_3daiSippeiHknShrRiyuuKbn.class);
    }

    private C_3daiSippeiHknShrRiyuuKbn(String value) {
        super(value);
    }

    public static C_3daiSippeiHknShrRiyuuKbn valueOf(String value) {
        return valueOf(C_3daiSippeiHknShrRiyuuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_3daiSippeiHknShrRiyuuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_3daiSippeiHknShrRiyuuKbn.class, patternId, value);
    }
}
