
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 更新パターン区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KosptnKbn</td><td colspan="3">更新パターン区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KYKSHNK_BETUJIN}</td><td>&quot;1&quot;</td><td>契約者変更(別人へ)</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSHNK_DOUITU}</td><td>&quot;2&quot;</td><td>契約者変更(契被同一へ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKS_TEISEI}</td><td>&quot;3&quot;</td><td>契約者情報訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HHKS_TEISEI}</td><td>&quot;4&quot;</td><td>被保険者情報訂正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYKSHNK_KEIHIBETU}</td><td>&quot;5&quot;</td><td>契約者変更(契被別へ）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KHDI_TEISEI}</td><td>&quot;6&quot;</td><td>契被同一者情報訂正</td></tr>
 * </table>
 */
public class C_KosptnKbn extends Classification<C_KosptnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KosptnKbn KYKSHNK_BETUJIN = new C_KosptnKbn("1");

    public static final C_KosptnKbn KYKSHNK_DOUITU = new C_KosptnKbn("2");

    public static final C_KosptnKbn KYKS_TEISEI = new C_KosptnKbn("3");

    public static final C_KosptnKbn HHKS_TEISEI = new C_KosptnKbn("4");

    public static final C_KosptnKbn KYKSHNK_KEIHIBETU = new C_KosptnKbn("5");

    public static final C_KosptnKbn KHDI_TEISEI = new C_KosptnKbn("6");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KYKSHNK_BETUJIN, "KYKSHNK_BETUJIN", true);
        addPattern(PATTERN_DEFAULT, KYKSHNK_DOUITU, "KYKSHNK_DOUITU", false);
        addPattern(PATTERN_DEFAULT, KYKS_TEISEI, "KYKS_TEISEI", false);
        addPattern(PATTERN_DEFAULT, HHKS_TEISEI, "HHKS_TEISEI", false);
        addPattern(PATTERN_DEFAULT, KYKSHNK_KEIHIBETU, "KYKSHNK_KEIHIBETU", false);
        addPattern(PATTERN_DEFAULT, KHDI_TEISEI, "KHDI_TEISEI", false);


        lock(C_KosptnKbn.class);
    }

    private C_KosptnKbn(String value) {
        super(value);
    }

    public static C_KosptnKbn valueOf(String value) {
        return valueOf(C_KosptnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KosptnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KosptnKbn.class, patternId, value);
    }
}
