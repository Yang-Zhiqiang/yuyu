
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＰＡＬあて照会実施有無区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_PalSyoukaiJissiumuKbn</td><td colspan="3">ＰＡＬあて照会実施有無区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ARI}</td><td>&quot;0&quot;</td><td>実施あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;1&quot;</td><td>実施なし</td></tr>
 * </table>
 */
public class C_PalSyoukaiJissiumuKbn extends Classification<C_PalSyoukaiJissiumuKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_PalSyoukaiJissiumuKbn ARI = new C_PalSyoukaiJissiumuKbn("0");

    public static final C_PalSyoukaiJissiumuKbn NONE = new C_PalSyoukaiJissiumuKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ARI, "ARI", true);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_PalSyoukaiJissiumuKbn.class);
    }

    private C_PalSyoukaiJissiumuKbn(String value) {
        super(value);
    }

    public static C_PalSyoukaiJissiumuKbn valueOf(String value) {
        return valueOf(C_PalSyoukaiJissiumuKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_PalSyoukaiJissiumuKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_PalSyoukaiJissiumuKbn.class, patternId, value);
    }
}
