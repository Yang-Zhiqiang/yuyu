
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＧＷ利用区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GwriyouKbn</td><td colspan="3">ＧＷ利用区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>利用なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI_GWTRAYNASI}</td><td>&quot;1&quot;</td><td>利用あり(GWトレイなし）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI_GWTRAYARI}</td><td>&quot;2&quot;</td><td>利用あり(GWトレイあり)</td></tr>
 * </table>
 */
public class C_GwriyouKbn extends Classification<C_GwriyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GwriyouKbn NONE = new C_GwriyouKbn("0");

    public static final C_GwriyouKbn ARI_GWTRAYNASI = new C_GwriyouKbn("1");

    public static final C_GwriyouKbn ARI_GWTRAYARI = new C_GwriyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, ARI_GWTRAYNASI, "ARI_GWTRAYNASI", false);
        addPattern(PATTERN_DEFAULT, ARI_GWTRAYARI, "ARI_GWTRAYARI", false);


        lock(C_GwriyouKbn.class);
    }

    private C_GwriyouKbn(String value) {
        super(value);
    }

    public static C_GwriyouKbn valueOf(String value) {
        return valueOf(C_GwriyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GwriyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GwriyouKbn.class, patternId, value);
    }
}
