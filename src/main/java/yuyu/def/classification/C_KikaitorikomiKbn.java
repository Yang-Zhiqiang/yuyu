
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 機械取込区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KikaitorikomiKbn</td><td colspan="3">機械取込区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KIKAITORIKOMI_SINAI}</td><td>&quot;0&quot;</td><td>機械取込しない</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIKAITORIKOMI_SURU}</td><td>&quot;1&quot;</td><td>機械取込する</td></tr>
 * </table>
 */
public class C_KikaitorikomiKbn extends Classification<C_KikaitorikomiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KikaitorikomiKbn KIKAITORIKOMI_SINAI = new C_KikaitorikomiKbn("0");

    public static final C_KikaitorikomiKbn KIKAITORIKOMI_SURU = new C_KikaitorikomiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KIKAITORIKOMI_SINAI, "KIKAITORIKOMI_SINAI", true);
        addPattern(PATTERN_DEFAULT, KIKAITORIKOMI_SURU, "KIKAITORIKOMI_SURU", false);


        lock(C_KikaitorikomiKbn.class);
    }

    private C_KikaitorikomiKbn(String value) {
        super(value);
    }

    public static C_KikaitorikomiKbn valueOf(String value) {
        return valueOf(C_KikaitorikomiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KikaitorikomiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KikaitorikomiKbn.class, patternId, value);
    }
}
