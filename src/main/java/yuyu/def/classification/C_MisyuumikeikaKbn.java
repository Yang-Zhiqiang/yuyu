
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 未収未経過区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MisyuumikeikaKbn</td><td colspan="3">未収未経過区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MISYUUP}</td><td>&quot;1&quot;</td><td>未収保険料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKEIKAP}</td><td>&quot;2&quot;</td><td>未経過保険料</td></tr>
 * </table>
 */
public class C_MisyuumikeikaKbn extends Classification<C_MisyuumikeikaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MisyuumikeikaKbn BLNK = new C_MisyuumikeikaKbn("0");

    public static final C_MisyuumikeikaKbn MISYUUP = new C_MisyuumikeikaKbn("1");

    public static final C_MisyuumikeikaKbn MIKEIKAP = new C_MisyuumikeikaKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MISYUUP, "MISYUUP", false);
        addPattern(PATTERN_DEFAULT, MIKEIKAP, "MIKEIKAP", false);


        lock(C_MisyuumikeikaKbn.class);
    }

    private C_MisyuumikeikaKbn(String value) {
        super(value);
    }

    public static C_MisyuumikeikaKbn valueOf(String value) {
        return valueOf(C_MisyuumikeikaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MisyuumikeikaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MisyuumikeikaKbn.class, patternId, value);
    }
}
