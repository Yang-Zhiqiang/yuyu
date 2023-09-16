
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 査定区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SateiKbn</td><td colspan="3">査定区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KARISATEI}</td><td>&quot;0&quot;</td><td>仮査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HONSATEI}</td><td>&quot;1&quot;</td><td>本査定</td></tr>
 * </table>
 */
public class C_SateiKbn extends Classification<C_SateiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SateiKbn KARISATEI = new C_SateiKbn("0");

    public static final C_SateiKbn HONSATEI = new C_SateiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KARISATEI, "KARISATEI", true);
        addPattern(PATTERN_DEFAULT, HONSATEI, "HONSATEI", false);


        lock(C_SateiKbn.class);
    }

    private C_SateiKbn(String value) {
        super(value);
    }

    public static C_SateiKbn valueOf(String value) {
        return valueOf(C_SateiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SateiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SateiKbn.class, patternId, value);
    }
}
