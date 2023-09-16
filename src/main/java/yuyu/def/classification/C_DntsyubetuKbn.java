
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 団体種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DntsyubetuKbn</td><td colspan="3">団体種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DANTAI}</td><td>&quot;1&quot;</td><td>団体</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUBETUDANTAI}</td><td>&quot;2&quot;</td><td>特別団体</td></tr>
 * </table>
 */
public class C_DntsyubetuKbn extends Classification<C_DntsyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DntsyubetuKbn BLNK = new C_DntsyubetuKbn("0");

    public static final C_DntsyubetuKbn DANTAI = new C_DntsyubetuKbn("1");

    public static final C_DntsyubetuKbn TOKUBETUDANTAI = new C_DntsyubetuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DANTAI, "DANTAI", false);
        addPattern(PATTERN_DEFAULT, TOKUBETUDANTAI, "TOKUBETUDANTAI", false);


        lock(C_DntsyubetuKbn.class);
    }

    private C_DntsyubetuKbn(String value) {
        super(value);
    }

    public static C_DntsyubetuKbn valueOf(String value) {
        return valueOf(C_DntsyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DntsyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DntsyubetuKbn.class, patternId, value);
    }
}
