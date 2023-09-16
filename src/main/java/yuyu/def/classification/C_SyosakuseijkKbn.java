
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 証券作成状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SyosakuseijkKbn</td><td colspan="3">証券作成状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #MISAKUSEI}</td><td>&quot;0&quot;</td><td>未作成</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SAKUSEIZUMI}</td><td>&quot;1&quot;</td><td>作成済</td></tr>
 * </table>
 */
public class C_SyosakuseijkKbn extends Classification<C_SyosakuseijkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SyosakuseijkKbn MISAKUSEI = new C_SyosakuseijkKbn("0");

    public static final C_SyosakuseijkKbn SAKUSEIZUMI = new C_SyosakuseijkKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, MISAKUSEI, "MISAKUSEI", true);
        addPattern(PATTERN_DEFAULT, SAKUSEIZUMI, "SAKUSEIZUMI", false);


        lock(C_SyosakuseijkKbn.class);
    }

    private C_SyosakuseijkKbn(String value) {
        super(value);
    }

    public static C_SyosakuseijkKbn valueOf(String value) {
        return valueOf(C_SyosakuseijkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SyosakuseijkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SyosakuseijkKbn.class, patternId, value);
    }
}
