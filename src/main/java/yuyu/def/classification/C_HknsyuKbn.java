
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 保険種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HknsyuKbn</td><td colspan="3">保険種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="12">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HANYOU}</td><td>&quot;AA&quot;</td><td>汎用</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRSSS}</td><td>&quot;CA&quot;</td><td>医療終身保険S</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRSSL}</td><td>&quot;CB&quot;</td><td>医療終身保険L</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETNYINNYIN}</td><td>&quot;CC&quot;</td><td>入院保険＋入院保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SETNYINTYONYIN}</td><td>&quot;CD&quot;</td><td>入院保険＋長期入院保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIGANIRSS}</td><td>&quot;CE&quot;</td><td>一時払がん医療終身保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRSSA}</td><td>&quot;CF&quot;</td><td>医療終身保険A</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HEIJYUNIRYO}</td><td>&quot;CG&quot;</td><td>平準払医療保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRSSA_MDHN}</td><td>&quot;CH&quot;</td><td>医療終身保険A（窓販）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRSSB}</td><td>&quot;CI&quot;</td><td>医療終身保険B</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GNTKKTIRYOSYUSIN_SMBC}</td><td>&quot;CJ&quot;</td><td>限定告知型医療終身保険（SMBC）</td></tr>
 * </table>
 */
public class C_HknsyuKbn extends Classification<C_HknsyuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HknsyuKbn BLNK = new C_HknsyuKbn("0");

    public static final C_HknsyuKbn HANYOU = new C_HknsyuKbn("AA");

    public static final C_HknsyuKbn IRSSS = new C_HknsyuKbn("CA");

    public static final C_HknsyuKbn IRSSL = new C_HknsyuKbn("CB");

    public static final C_HknsyuKbn SETNYINNYIN = new C_HknsyuKbn("CC");

    public static final C_HknsyuKbn SETNYINTYONYIN = new C_HknsyuKbn("CD");

    public static final C_HknsyuKbn ITIJIGANIRSS = new C_HknsyuKbn("CE");

    public static final C_HknsyuKbn IRSSA = new C_HknsyuKbn("CF");

    public static final C_HknsyuKbn HEIJYUNIRYO = new C_HknsyuKbn("CG");

    public static final C_HknsyuKbn IRSSA_MDHN = new C_HknsyuKbn("CH");

    public static final C_HknsyuKbn IRSSB = new C_HknsyuKbn("CI");

    public static final C_HknsyuKbn GNTKKTIRYOSYUSIN_SMBC = new C_HknsyuKbn("CJ");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HANYOU, "HANYOU", false);
        addPattern(PATTERN_DEFAULT, IRSSS, "IRSSS", false);
        addPattern(PATTERN_DEFAULT, IRSSL, "IRSSL", false);
        addPattern(PATTERN_DEFAULT, SETNYINNYIN, "SETNYINNYIN", false);
        addPattern(PATTERN_DEFAULT, SETNYINTYONYIN, "SETNYINTYONYIN", false);
        addPattern(PATTERN_DEFAULT, ITIJIGANIRSS, "ITIJIGANIRSS", false);
        addPattern(PATTERN_DEFAULT, IRSSA, "IRSSA", false);
        addPattern(PATTERN_DEFAULT, HEIJYUNIRYO, "HEIJYUNIRYO", false);
        addPattern(PATTERN_DEFAULT, IRSSA_MDHN, "IRSSA_MDHN", false);
        addPattern(PATTERN_DEFAULT, IRSSB, "IRSSB", false);
        addPattern(PATTERN_DEFAULT, GNTKKTIRYOSYUSIN_SMBC, "GNTKKTIRYOSYUSIN_SMBC", false);


        lock(C_HknsyuKbn.class);
    }

    private C_HknsyuKbn(String value) {
        super(value);
    }

    public static C_HknsyuKbn valueOf(String value) {
        return valueOf(C_HknsyuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HknsyuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HknsyuKbn.class, patternId, value);
    }
}
