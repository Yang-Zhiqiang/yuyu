
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 入金内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyknaiyouKbn</td><td colspan="3">入金内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="10">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUP}</td><td>&quot;1&quot;</td><td>継続Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUP}</td><td>&quot;2&quot;</td><td>前納Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HENKOUGOP}</td><td>&quot;3&quot;</td><td>変更後Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATUYOUP}</td><td>&quot;4&quot;</td><td>復活要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAIP}</td><td>&quot;7&quot;</td><td>初回Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENHENKOUYOUP}</td><td>&quot;10&quot;</td><td>保全変更要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIHENYOUP}</td><td>&quot;11&quot;</td><td>払方変更要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENYOUP}</td><td>&quot;12&quot;</td><td>Ｐ免要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;99&quot;</td><td>その他入金</td></tr>
 *  <tr><td rowspan="8">{@link #PATTERN_SELECT SELECT}<br />(案内収納利用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYOKAIP}</td><td>&quot;7&quot;</td><td>初回Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUP}</td><td>&quot;1&quot;</td><td>継続Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKKATUYOUP}</td><td>&quot;4&quot;</td><td>復活要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENHENKOUYOUP}</td><td>&quot;10&quot;</td><td>保全変更要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIHENYOUP}</td><td>&quot;11&quot;</td><td>払方変更要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #PMENYOUP}</td><td>&quot;12&quot;</td><td>Ｐ免要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;99&quot;</td><td>その他入金</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_ONLINE ONLINE}<br />(オンライン入金用)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUP}</td><td>&quot;1&quot;</td><td>継続Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENHENKOUYOUP}</td><td>&quot;10&quot;</td><td>保全変更要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIHENYOUP}</td><td>&quot;11&quot;</td><td>払方変更要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUP}</td><td>&quot;2&quot;</td><td>前納Ｐ</td></tr>
 *  <tr><td rowspan="6">{@link #PATTERN_ONLINE2 ONLINE2}<br />(オンライン入金用２)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KEIZOKUP}</td><td>&quot;1&quot;</td><td>継続Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOZENHENKOUYOUP}</td><td>&quot;10&quot;</td><td>保全変更要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HARAIHENYOUP}</td><td>&quot;11&quot;</td><td>払方変更要Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENNOUP}</td><td>&quot;2&quot;</td><td>前納Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #OTHER}</td><td>&quot;99&quot;</td><td>その他入金</td></tr>
 *  <tr><td rowspan="1">{@link #PATTERN_ONLINE3 ONLINE3}<br />(臨時売上請求受付用)</td><td align="center">○</td><td>{@link #OTHER}</td><td>&quot;99&quot;</td><td>その他入金</td></tr>
 * </table>
 */
public class C_NyknaiyouKbn extends Classification<C_NyknaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyknaiyouKbn BLNK = new C_NyknaiyouKbn("0");

    public static final C_NyknaiyouKbn KEIZOKUP = new C_NyknaiyouKbn("1");

    public static final C_NyknaiyouKbn ZENNOUP = new C_NyknaiyouKbn("2");

    public static final C_NyknaiyouKbn HENKOUGOP = new C_NyknaiyouKbn("3");

    public static final C_NyknaiyouKbn HUKKATUYOUP = new C_NyknaiyouKbn("4");

    public static final C_NyknaiyouKbn SYOKAIP = new C_NyknaiyouKbn("7");

    public static final C_NyknaiyouKbn HOZENHENKOUYOUP = new C_NyknaiyouKbn("10");

    public static final C_NyknaiyouKbn HARAIHENYOUP = new C_NyknaiyouKbn("11");

    public static final C_NyknaiyouKbn PMENYOUP = new C_NyknaiyouKbn("12");

    public static final C_NyknaiyouKbn OTHER = new C_NyknaiyouKbn("99");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_ONLINE = "3";

    public static final String PATTERN_ONLINE2 = "4";

    public static final String PATTERN_ONLINE3 = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KEIZOKUP, "KEIZOKUP", false);
        addPattern(PATTERN_DEFAULT, ZENNOUP, "ZENNOUP", false);
        addPattern(PATTERN_DEFAULT, HENKOUGOP, "HENKOUGOP", false);
        addPattern(PATTERN_DEFAULT, HUKKATUYOUP, "HUKKATUYOUP", false);
        addPattern(PATTERN_DEFAULT, SYOKAIP, "SYOKAIP", false);
        addPattern(PATTERN_DEFAULT, HOZENHENKOUYOUP, "HOZENHENKOUYOUP", false);
        addPattern(PATTERN_DEFAULT, HARAIHENYOUP, "HARAIHENYOUP", false);
        addPattern(PATTERN_DEFAULT, PMENYOUP, "PMENYOUP", false);
        addPattern(PATTERN_DEFAULT, OTHER, "OTHER", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, SYOKAIP, "SYOKAIP", false);
        addPattern(PATTERN_SELECT, KEIZOKUP, "KEIZOKUP", false);
        addPattern(PATTERN_SELECT, HUKKATUYOUP, "HUKKATUYOUP", false);
        addPattern(PATTERN_SELECT, HOZENHENKOUYOUP, "HOZENHENKOUYOUP", false);
        addPattern(PATTERN_SELECT, HARAIHENYOUP, "HARAIHENYOUP", false);
        addPattern(PATTERN_SELECT, PMENYOUP, "PMENYOUP", false);
        addPattern(PATTERN_SELECT, OTHER, "OTHER", false);


        addPattern(PATTERN_ONLINE, BLNK, "BLNK", true);
        addPattern(PATTERN_ONLINE, KEIZOKUP, "KEIZOKUP", false);
        addPattern(PATTERN_ONLINE, HOZENHENKOUYOUP, "HOZENHENKOUYOUP", false);
        addPattern(PATTERN_ONLINE, HARAIHENYOUP, "HARAIHENYOUP", false);
        addPattern(PATTERN_ONLINE, ZENNOUP, "ZENNOUP", false);


        addPattern(PATTERN_ONLINE2, BLNK, "BLNK", true);
        addPattern(PATTERN_ONLINE2, KEIZOKUP, "KEIZOKUP", false);
        addPattern(PATTERN_ONLINE2, HOZENHENKOUYOUP, "HOZENHENKOUYOUP", false);
        addPattern(PATTERN_ONLINE2, HARAIHENYOUP, "HARAIHENYOUP", false);
        addPattern(PATTERN_ONLINE2, ZENNOUP, "ZENNOUP", false);
        addPattern(PATTERN_ONLINE2, OTHER, "OTHER", false);


        addPattern(PATTERN_ONLINE3, OTHER, "OTHER", true);


        lock(C_NyknaiyouKbn.class);
    }

    private C_NyknaiyouKbn(String value) {
        super(value);
    }

    public static C_NyknaiyouKbn valueOf(String value) {
        return valueOf(C_NyknaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyknaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyknaiyouKbn.class, patternId, value);
    }
}
