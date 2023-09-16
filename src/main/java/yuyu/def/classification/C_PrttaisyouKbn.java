
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 印刷対象区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PrttaisyouKbn</td><td colspan="3">印刷対象区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SEK}</td><td>&quot;1&quot;</td><td>設計書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOS}</td><td>&quot;2&quot;</td><td>申込書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEKMOS}</td><td>&quot;3&quot;</td><td>設計書申込書</td></tr>
 * </table>
 */
public class C_PrttaisyouKbn extends Classification<C_PrttaisyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PrttaisyouKbn SEK = new C_PrttaisyouKbn("1");

    public static final C_PrttaisyouKbn MOS = new C_PrttaisyouKbn("2");

    public static final C_PrttaisyouKbn SEKMOS = new C_PrttaisyouKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SEK, "SEK", true);
        addPattern(PATTERN_DEFAULT, MOS, "MOS", false);
        addPattern(PATTERN_DEFAULT, SEKMOS, "SEKMOS", false);


        lock(C_PrttaisyouKbn.class);
    }

    private C_PrttaisyouKbn(String value) {
        super(value);
    }

    public static C_PrttaisyouKbn valueOf(String value) {
        return valueOf(C_PrttaisyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PrttaisyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PrttaisyouKbn.class, patternId, value);
    }
}
