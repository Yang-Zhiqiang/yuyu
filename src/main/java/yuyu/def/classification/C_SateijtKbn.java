
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 査定状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SateijtKbn</td><td colspan="3">査定状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;99&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_TYUU}</td><td>&quot;0&quot;</td><td>査定中</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SATEI_SUMI}</td><td>&quot;1&quot;</td><td>査定済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TKJYSYDK_MATI}</td><td>&quot;2&quot;</td><td>特条承諾書待ち</td></tr>
 * </table>
 */
public class C_SateijtKbn extends Classification<C_SateijtKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SateijtKbn BLNK = new C_SateijtKbn("99");

    public static final C_SateijtKbn SATEI_TYUU = new C_SateijtKbn("0");

    public static final C_SateijtKbn SATEI_SUMI = new C_SateijtKbn("1");

    public static final C_SateijtKbn TKJYSYDK_MATI = new C_SateijtKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SATEI_TYUU, "SATEI_TYUU", false);
        addPattern(PATTERN_DEFAULT, SATEI_SUMI, "SATEI_SUMI", false);
        addPattern(PATTERN_DEFAULT, TKJYSYDK_MATI, "TKJYSYDK_MATI", false);


        lock(C_SateijtKbn.class);
    }

    private C_SateijtKbn(String value) {
        super(value);
    }

    public static C_SateijtKbn valueOf(String value) {
        return valueOf(C_SateijtKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SateijtKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SateijtKbn.class, patternId, value);
    }
}
