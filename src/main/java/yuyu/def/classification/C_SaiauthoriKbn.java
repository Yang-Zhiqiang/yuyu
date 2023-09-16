
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 再オーソリ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SaiauthoriKbn</td><td colspan="3">再オーソリ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NOSAIAUTHORI}</td><td>&quot;0&quot;</td><td>再オーソリなし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIGENGIRE}</td><td>&quot;1&quot;</td><td>期限切れ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #AFTSAIAUTHORI}</td><td>&quot;2&quot;</td><td>再オーソリ後</td></tr>
 * </table>
 */
public class C_SaiauthoriKbn extends Classification<C_SaiauthoriKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SaiauthoriKbn NOSAIAUTHORI = new C_SaiauthoriKbn("0");

    public static final C_SaiauthoriKbn KIGENGIRE = new C_SaiauthoriKbn("1");

    public static final C_SaiauthoriKbn AFTSAIAUTHORI = new C_SaiauthoriKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NOSAIAUTHORI, "NOSAIAUTHORI", true);
        addPattern(PATTERN_DEFAULT, KIGENGIRE, "KIGENGIRE", false);
        addPattern(PATTERN_DEFAULT, AFTSAIAUTHORI, "AFTSAIAUTHORI", false);


        lock(C_SaiauthoriKbn.class);
    }

    private C_SaiauthoriKbn(String value) {
        super(value);
    }

    public static C_SaiauthoriKbn valueOf(String value) {
        return valueOf(C_SaiauthoriKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SaiauthoriKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SaiauthoriKbn.class, patternId, value);
    }
}
