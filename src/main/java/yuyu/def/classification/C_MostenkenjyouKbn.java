
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 申込点検状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MostenkenjyouKbn</td><td colspan="3">申込点検状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>未実施</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKENMATI_1}</td><td>&quot;1&quot;</td><td>点検待ち（１次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKENMATI_2}</td><td>&quot;2&quot;</td><td>点検待ち（２次）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOSTENKEN_ZUMI}</td><td>&quot;4&quot;</td><td>申込点検済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TENKENMATI_HUBI}</td><td>&quot;5&quot;</td><td>点検待ち（点検後不備）</td></tr>
 * </table>
 */
public class C_MostenkenjyouKbn extends Classification<C_MostenkenjyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MostenkenjyouKbn NONE = new C_MostenkenjyouKbn("0");

    public static final C_MostenkenjyouKbn TENKENMATI_1 = new C_MostenkenjyouKbn("1");

    public static final C_MostenkenjyouKbn TENKENMATI_2 = new C_MostenkenjyouKbn("2");

    public static final C_MostenkenjyouKbn MOSTENKEN_ZUMI = new C_MostenkenjyouKbn("4");

    public static final C_MostenkenjyouKbn TENKENMATI_HUBI = new C_MostenkenjyouKbn("5");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, TENKENMATI_1, "TENKENMATI_1", false);
        addPattern(PATTERN_DEFAULT, TENKENMATI_2, "TENKENMATI_2", false);
        addPattern(PATTERN_DEFAULT, MOSTENKEN_ZUMI, "MOSTENKEN_ZUMI", false);
        addPattern(PATTERN_DEFAULT, TENKENMATI_HUBI, "TENKENMATI_HUBI", false);


        lock(C_MostenkenjyouKbn.class);
    }

    private C_MostenkenjyouKbn(String value) {
        super(value);
    }

    public static C_MostenkenjyouKbn valueOf(String value) {
        return valueOf(C_MostenkenjyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MostenkenjyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MostenkenjyouKbn.class, patternId, value);
    }
}
