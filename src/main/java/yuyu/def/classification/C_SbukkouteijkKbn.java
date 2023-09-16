
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受付工程状況区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SbukkouteijkKbn</td><td colspan="3">受付工程状況区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SBMOSUKE_NASI}</td><td>&quot;0&quot;</td><td>申出受付なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MITORIKESIKOUTEI_ARI}</td><td>&quot;1&quot;</td><td>未取消工程あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENKOUTEI_TORIKESIZUMI}</td><td>&quot;2&quot;</td><td>全工程取消済み</td></tr>
 * </table>
 */
public class C_SbukkouteijkKbn extends Classification<C_SbukkouteijkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SbukkouteijkKbn SBMOSUKE_NASI = new C_SbukkouteijkKbn("0");

    public static final C_SbukkouteijkKbn MITORIKESIKOUTEI_ARI = new C_SbukkouteijkKbn("1");

    public static final C_SbukkouteijkKbn ZENKOUTEI_TORIKESIZUMI = new C_SbukkouteijkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SBMOSUKE_NASI, "SBMOSUKE_NASI", true);
        addPattern(PATTERN_DEFAULT, MITORIKESIKOUTEI_ARI, "MITORIKESIKOUTEI_ARI", false);
        addPattern(PATTERN_DEFAULT, ZENKOUTEI_TORIKESIZUMI, "ZENKOUTEI_TORIKESIZUMI", false);


        lock(C_SbukkouteijkKbn.class);
    }

    private C_SbukkouteijkKbn(String value) {
        super(value);
    }

    public static C_SbukkouteijkKbn valueOf(String value) {
        return valueOf(C_SbukkouteijkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SbukkouteijkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SbukkouteijkKbn.class, patternId, value);
    }
}
