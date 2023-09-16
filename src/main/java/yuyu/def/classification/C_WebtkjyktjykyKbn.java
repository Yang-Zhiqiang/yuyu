
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * Ｗｅｂ特条回答状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_WebtkjyktjykyKbn</td><td colspan="3">Ｗｅｂ特条回答状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HASSINMATI}</td><td>&quot;1&quot;</td><td>発信待ち</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUTYUU}</td><td>&quot;2&quot;</td><td>回答中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUZUMI_SYOU}</td><td>&quot;3&quot;</td><td>回答済（承諾）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAITOUZUMI_HUSYOU}</td><td>&quot;4&quot;</td><td>回答済（不承諾）</td></tr>
 * </table>
 */
public class C_WebtkjyktjykyKbn extends Classification<C_WebtkjyktjykyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_WebtkjyktjykyKbn BLNK = new C_WebtkjyktjykyKbn("0");

    public static final C_WebtkjyktjykyKbn HASSINMATI = new C_WebtkjyktjykyKbn("1");

    public static final C_WebtkjyktjykyKbn KAITOUTYUU = new C_WebtkjyktjykyKbn("2");

    public static final C_WebtkjyktjykyKbn KAITOUZUMI_SYOU = new C_WebtkjyktjykyKbn("3");

    public static final C_WebtkjyktjykyKbn KAITOUZUMI_HUSYOU = new C_WebtkjyktjykyKbn("4");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HASSINMATI, "HASSINMATI", false);
        addPattern(PATTERN_DEFAULT, KAITOUTYUU, "KAITOUTYUU", false);
        addPattern(PATTERN_DEFAULT, KAITOUZUMI_SYOU, "KAITOUZUMI_SYOU", false);
        addPattern(PATTERN_DEFAULT, KAITOUZUMI_HUSYOU, "KAITOUZUMI_HUSYOU", false);


        lock(C_WebtkjyktjykyKbn.class);
    }

    private C_WebtkjyktjykyKbn(String value) {
        super(value);
    }

    public static C_WebtkjyktjykyKbn valueOf(String value) {
        return valueOf(C_WebtkjyktjykyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_WebtkjyktjykyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_WebtkjyktjykyKbn.class, patternId, value);
    }
}
