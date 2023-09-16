
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 税務通知種類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_ZeimuTuutiSyuruiKbn</td><td colspan="3">税務通知種類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZIMTT}</td><td>&quot;1&quot;</td><td>税務通知</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZIMTT_NIJYUUKAZEI}</td><td>&quot;2&quot;</td><td>税務通知（二重課税）</td></tr>
 * </table>
 */
public class C_ZeimuTuutiSyuruiKbn extends Classification<C_ZeimuTuutiSyuruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_ZeimuTuutiSyuruiKbn BLNK = new C_ZeimuTuutiSyuruiKbn("0");

    public static final C_ZeimuTuutiSyuruiKbn ZIMTT = new C_ZeimuTuutiSyuruiKbn("1");

    public static final C_ZeimuTuutiSyuruiKbn ZIMTT_NIJYUUKAZEI = new C_ZeimuTuutiSyuruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ZIMTT, "ZIMTT", false);
        addPattern(PATTERN_DEFAULT, ZIMTT_NIJYUUKAZEI, "ZIMTT_NIJYUUKAZEI", false);


        lock(C_ZeimuTuutiSyuruiKbn.class);
    }

    private C_ZeimuTuutiSyuruiKbn(String value) {
        super(value);
    }

    public static C_ZeimuTuutiSyuruiKbn valueOf(String value) {
        return valueOf(C_ZeimuTuutiSyuruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_ZeimuTuutiSyuruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_ZeimuTuutiSyuruiKbn.class, patternId, value);
    }
}
