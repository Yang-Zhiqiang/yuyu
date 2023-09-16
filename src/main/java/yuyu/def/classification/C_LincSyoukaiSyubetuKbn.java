
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＩＮＣ照会種別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LincSyoukaiSyubetuKbn</td><td colspan="3">ＬＩＮＣ照会種別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOKENKIN}</td><td>&quot;1&quot;</td><td>保険金</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TOKUYAKU}</td><td>&quot;2&quot;</td><td>特約</td></tr>
 * </table>
 */
public class C_LincSyoukaiSyubetuKbn extends Classification<C_LincSyoukaiSyubetuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LincSyoukaiSyubetuKbn BLNK = new C_LincSyoukaiSyubetuKbn("0");

    public static final C_LincSyoukaiSyubetuKbn HOKENKIN = new C_LincSyoukaiSyubetuKbn("1");

    public static final C_LincSyoukaiSyubetuKbn TOKUYAKU = new C_LincSyoukaiSyubetuKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HOKENKIN, "HOKENKIN", false);
        addPattern(PATTERN_DEFAULT, TOKUYAKU, "TOKUYAKU", false);


        lock(C_LincSyoukaiSyubetuKbn.class);
    }

    private C_LincSyoukaiSyubetuKbn(String value) {
        super(value);
    }

    public static C_LincSyoukaiSyubetuKbn valueOf(String value) {
        return valueOf(C_LincSyoukaiSyubetuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LincSyoukaiSyubetuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LincSyoukaiSyubetuKbn.class, patternId, value);
    }
}
