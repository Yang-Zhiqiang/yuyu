
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 自動取消用ＰＡＬ取消残区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_JdTrksPalTrksZanKbn</td><td colspan="3">自動取消用ＰＡＬ取消残区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>取消残なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ARI}</td><td>&quot;1&quot;</td><td>取消残あり</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KANOUSEIARI}</td><td>&quot;2&quot;</td><td>取消残の可能性あり</td></tr>
 *  <tr><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;9&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_JdTrksPalTrksZanKbn extends Classification<C_JdTrksPalTrksZanKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_JdTrksPalTrksZanKbn NONE = new C_JdTrksPalTrksZanKbn("0");

    public static final C_JdTrksPalTrksZanKbn ARI = new C_JdTrksPalTrksZanKbn("1");

    public static final C_JdTrksPalTrksZanKbn KANOUSEIARI = new C_JdTrksPalTrksZanKbn("2");

    public static final C_JdTrksPalTrksZanKbn BLNK = new C_JdTrksPalTrksZanKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);
        addPattern(PATTERN_DEFAULT, ARI, "ARI", false);
        addPattern(PATTERN_DEFAULT, KANOUSEIARI, "KANOUSEIARI", false);
        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);


        lock(C_JdTrksPalTrksZanKbn.class);
    }

    private C_JdTrksPalTrksZanKbn(String value) {
        super(value);
    }

    public static C_JdTrksPalTrksZanKbn valueOf(String value) {
        return valueOf(C_JdTrksPalTrksZanKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_JdTrksPalTrksZanKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_JdTrksPalTrksZanKbn.class, patternId, value);
    }
}
