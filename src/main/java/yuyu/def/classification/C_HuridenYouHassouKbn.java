
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 振替伝票用発送区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HuridenYouHassouKbn</td><td colspan="3">振替伝票用発送区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="9">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSOUSAKI1}</td><td>&quot;01&quot;</td><td>発送先１</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSOUSAKI2}</td><td>&quot;02&quot;</td><td>発送先２</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSOUSAKI3}</td><td>&quot;03&quot;</td><td>発送先３</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSOUSAKI4}</td><td>&quot;04&quot;</td><td>発送先４</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSOUSAKI5}</td><td>&quot;05&quot;</td><td>発送先５</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSOUSAKI6}</td><td>&quot;06&quot;</td><td>発送先６</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSOUSAKI7}</td><td>&quot;07&quot;</td><td>発送先７</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSOUSAKI8}</td><td>&quot;08&quot;</td><td>発送先８</td></tr>
 * </table>
 */
public class C_HuridenYouHassouKbn extends Classification<C_HuridenYouHassouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HuridenYouHassouKbn BLNK = new C_HuridenYouHassouKbn("0");

    public static final C_HuridenYouHassouKbn HASSOUSAKI1 = new C_HuridenYouHassouKbn("01");

    public static final C_HuridenYouHassouKbn HASSOUSAKI2 = new C_HuridenYouHassouKbn("02");

    public static final C_HuridenYouHassouKbn HASSOUSAKI3 = new C_HuridenYouHassouKbn("03");

    public static final C_HuridenYouHassouKbn HASSOUSAKI4 = new C_HuridenYouHassouKbn("04");

    public static final C_HuridenYouHassouKbn HASSOUSAKI5 = new C_HuridenYouHassouKbn("05");

    public static final C_HuridenYouHassouKbn HASSOUSAKI6 = new C_HuridenYouHassouKbn("06");

    public static final C_HuridenYouHassouKbn HASSOUSAKI7 = new C_HuridenYouHassouKbn("07");

    public static final C_HuridenYouHassouKbn HASSOUSAKI8 = new C_HuridenYouHassouKbn("08");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HASSOUSAKI1, "HASSOUSAKI1", false);
        addPattern(PATTERN_DEFAULT, HASSOUSAKI2, "HASSOUSAKI2", false);
        addPattern(PATTERN_DEFAULT, HASSOUSAKI3, "HASSOUSAKI3", false);
        addPattern(PATTERN_DEFAULT, HASSOUSAKI4, "HASSOUSAKI4", false);
        addPattern(PATTERN_DEFAULT, HASSOUSAKI5, "HASSOUSAKI5", false);
        addPattern(PATTERN_DEFAULT, HASSOUSAKI6, "HASSOUSAKI6", false);
        addPattern(PATTERN_DEFAULT, HASSOUSAKI7, "HASSOUSAKI7", false);
        addPattern(PATTERN_DEFAULT, HASSOUSAKI8, "HASSOUSAKI8", false);


        lock(C_HuridenYouHassouKbn.class);
    }

    private C_HuridenYouHassouKbn(String value) {
        super(value);
    }

    public static C_HuridenYouHassouKbn valueOf(String value) {
        return valueOf(C_HuridenYouHassouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HuridenYouHassouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HuridenYouHassouKbn.class, patternId, value);
    }
}
