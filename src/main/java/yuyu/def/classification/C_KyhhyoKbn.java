
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 給付事例表示区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KyhhyoKbn</td><td colspan="3">給付事例表示区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NYIN}</td><td>&quot;11&quot;</td><td>入院保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TYONYIN}</td><td>&quot;12&quot;</td><td>長期入院保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #IRYOSYUSIN}</td><td>&quot;13&quot;</td><td>医療終身保険</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GNTIKKTGTIRYOSYUSIN}</td><td>&quot;14&quot;</td><td>限定告知型医療終身保険</td></tr>
 * </table>
 */
public class C_KyhhyoKbn extends Classification<C_KyhhyoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KyhhyoKbn NYIN = new C_KyhhyoKbn("11");

    public static final C_KyhhyoKbn TYONYIN = new C_KyhhyoKbn("12");

    public static final C_KyhhyoKbn IRYOSYUSIN = new C_KyhhyoKbn("13");

    public static final C_KyhhyoKbn GNTIKKTGTIRYOSYUSIN = new C_KyhhyoKbn("14");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NYIN, "NYIN", true);
        addPattern(PATTERN_DEFAULT, TYONYIN, "TYONYIN", false);
        addPattern(PATTERN_DEFAULT, IRYOSYUSIN, "IRYOSYUSIN", false);
        addPattern(PATTERN_DEFAULT, GNTIKKTGTIRYOSYUSIN, "GNTIKKTGTIRYOSYUSIN", false);


        lock(C_KyhhyoKbn.class);
    }

    private C_KyhhyoKbn(String value) {
        super(value);
    }

    public static C_KyhhyoKbn valueOf(String value) {
        return valueOf(C_KyhhyoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KyhhyoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KyhhyoKbn.class, patternId, value);
    }
}
