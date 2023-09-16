
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 選択情報区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SntkinfoKbn</td><td colspan="3">選択情報区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="7">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MIKAKUNIN}</td><td>&quot;10&quot;</td><td>未確認</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SEIRITU}</td><td>&quot;20&quot;</td><td>成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUSEIRITU}</td><td>&quot;30&quot;</td><td>不成立</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUJOUZAN}</td><td>&quot;40&quot;</td><td>報状残</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KYOUKAIMR}</td><td>&quot;50&quot;</td><td>協会ＭＲ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SONOTA}</td><td>&quot;99&quot;</td><td>その他</td></tr>
 * </table>
 */
public class C_SntkinfoKbn extends Classification<C_SntkinfoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SntkinfoKbn BLNK = new C_SntkinfoKbn("0");

    public static final C_SntkinfoKbn MIKAKUNIN = new C_SntkinfoKbn("10");

    public static final C_SntkinfoKbn SEIRITU = new C_SntkinfoKbn("20");

    public static final C_SntkinfoKbn HUSEIRITU = new C_SntkinfoKbn("30");

    public static final C_SntkinfoKbn HOUJOUZAN = new C_SntkinfoKbn("40");

    public static final C_SntkinfoKbn KYOUKAIMR = new C_SntkinfoKbn("50");

    public static final C_SntkinfoKbn SONOTA = new C_SntkinfoKbn("99");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MIKAKUNIN, "MIKAKUNIN", false);
        addPattern(PATTERN_DEFAULT, SEIRITU, "SEIRITU", false);
        addPattern(PATTERN_DEFAULT, HUSEIRITU, "HUSEIRITU", false);
        addPattern(PATTERN_DEFAULT, HOUJOUZAN, "HOUJOUZAN", false);
        addPattern(PATTERN_DEFAULT, KYOUKAIMR, "KYOUKAIMR", false);
        addPattern(PATTERN_DEFAULT, SONOTA, "SONOTA", false);


        lock(C_SntkinfoKbn.class);
    }

    private C_SntkinfoKbn(String value) {
        super(value);
    }

    public static C_SntkinfoKbn valueOf(String value) {
        return valueOf(C_SntkinfoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SntkinfoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SntkinfoKbn.class, patternId, value);
    }
}
