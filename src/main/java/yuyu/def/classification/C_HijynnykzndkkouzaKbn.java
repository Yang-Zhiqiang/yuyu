
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 平準払入金額残高口座区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HijynnykzndkkouzaKbn</td><td colspan="3">平準払入金額残高口座区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENHONKZ}</td><td>&quot;10&quot;</td><td>円本口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GKHONKZ}</td><td>&quot;20&quot;</td><td>外貨本口座</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;99&quot;</td><td>対象外</td></tr>
 * </table>
 */
public class C_HijynnykzndkkouzaKbn extends Classification<C_HijynnykzndkkouzaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HijynnykzndkkouzaKbn BLNK = new C_HijynnykzndkkouzaKbn("0");

    public static final C_HijynnykzndkkouzaKbn YENHONKZ = new C_HijynnykzndkkouzaKbn("10");

    public static final C_HijynnykzndkkouzaKbn GKHONKZ = new C_HijynnykzndkkouzaKbn("20");

    public static final C_HijynnykzndkkouzaKbn NONE = new C_HijynnykzndkkouzaKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, YENHONKZ, "YENHONKZ", false);
        addPattern(PATTERN_DEFAULT, GKHONKZ, "GKHONKZ", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_HijynnykzndkkouzaKbn.class);
    }

    private C_HijynnykzndkkouzaKbn(String value) {
        super(value);
    }

    public static C_HijynnykzndkkouzaKbn valueOf(String value) {
        return valueOf(C_HijynnykzndkkouzaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HijynnykzndkkouzaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HijynnykzndkkouzaKbn.class, patternId, value);
    }
}
