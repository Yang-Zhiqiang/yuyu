
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * データ取込区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DatatorikomiKbn</td><td colspan="3">データ取込区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MITORIKOMI}</td><td>&quot;0&quot;</td><td>未取込</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TORIKOMIZUMI}</td><td>&quot;1&quot;</td><td>取込済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YOUSYUUSEI}</td><td>&quot;8&quot;</td><td>要修正</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TAISYOUGAI}</td><td>&quot;9&quot;</td><td>対象外</td></tr>
 * </table>
 */
public class C_DatatorikomiKbn extends Classification<C_DatatorikomiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DatatorikomiKbn MITORIKOMI = new C_DatatorikomiKbn("0");

    public static final C_DatatorikomiKbn TORIKOMIZUMI = new C_DatatorikomiKbn("1");

    public static final C_DatatorikomiKbn YOUSYUUSEI = new C_DatatorikomiKbn("8");

    public static final C_DatatorikomiKbn TAISYOUGAI = new C_DatatorikomiKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MITORIKOMI, "MITORIKOMI", true);
        addPattern(PATTERN_DEFAULT, TORIKOMIZUMI, "TORIKOMIZUMI", false);
        addPattern(PATTERN_DEFAULT, YOUSYUUSEI, "YOUSYUUSEI", false);
        addPattern(PATTERN_DEFAULT, TAISYOUGAI, "TAISYOUGAI", false);


        lock(C_DatatorikomiKbn.class);
    }

    private C_DatatorikomiKbn(String value) {
        super(value);
    }

    public static C_DatatorikomiKbn valueOf(String value) {
        return valueOf(C_DatatorikomiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DatatorikomiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DatatorikomiKbn.class, patternId, value);
    }
}
