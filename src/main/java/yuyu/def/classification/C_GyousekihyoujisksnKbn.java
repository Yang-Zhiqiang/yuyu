
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 業績表示Ｓ計算区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_GyousekihyoujisksnKbn</td><td colspan="3">業績表示Ｓ計算区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SBHSYNASI}</td><td>&quot;0&quot;</td><td>死亡保障なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIJIP_RIGENV_5ZILL_MAX}</td><td>&quot;1&quot;</td><td>一時払Ｐと利源Ｖ・５チルの最大値</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KIHONS}</td><td>&quot;2&quot;</td><td>基本S</td></tr>
 * </table>
 */
public class C_GyousekihyoujisksnKbn extends Classification<C_GyousekihyoujisksnKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_GyousekihyoujisksnKbn SBHSYNASI = new C_GyousekihyoujisksnKbn("0");

    public static final C_GyousekihyoujisksnKbn ITIJIP_RIGENV_5ZILL_MAX = new C_GyousekihyoujisksnKbn("1");

    public static final C_GyousekihyoujisksnKbn KIHONS = new C_GyousekihyoujisksnKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SBHSYNASI, "SBHSYNASI", true);
        addPattern(PATTERN_DEFAULT, ITIJIP_RIGENV_5ZILL_MAX, "ITIJIP_RIGENV_5ZILL_MAX", false);
        addPattern(PATTERN_DEFAULT, KIHONS, "KIHONS", false);


        lock(C_GyousekihyoujisksnKbn.class);
    }

    private C_GyousekihyoujisksnKbn(String value) {
        super(value);
    }

    public static C_GyousekihyoujisksnKbn valueOf(String value) {
        return valueOf(C_GyousekihyoujisksnKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_GyousekihyoujisksnKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_GyousekihyoujisksnKbn.class, patternId, value);
    }
}
