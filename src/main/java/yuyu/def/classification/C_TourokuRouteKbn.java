
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 登録ルート区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TourokuRouteKbn</td><td colspan="3">登録ルート区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS}</td><td>&quot;01&quot;</td><td>ダイレクトサービス</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEL}</td><td>&quot;02&quot;</td><td>電話</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;03&quot;</td><td>オンライン</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BATCH}</td><td>&quot;04&quot;</td><td>バッチ</td></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_YUUKOUJYOTAI YUUKOUJYOTAI}<br />(有効状態チェック用)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DS}</td><td>&quot;01&quot;</td><td>ＤＳ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #TEL}</td><td>&quot;02&quot;</td><td>電話</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ONLINE}</td><td>&quot;03&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BATCH}</td><td>&quot;04&quot;</td><td>ブランク</td></tr>
 * </table>
 */
public class C_TourokuRouteKbn extends Classification<C_TourokuRouteKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TourokuRouteKbn BLNK = new C_TourokuRouteKbn("0");

    public static final C_TourokuRouteKbn DS = new C_TourokuRouteKbn("01");

    public static final C_TourokuRouteKbn TEL = new C_TourokuRouteKbn("02");

    public static final C_TourokuRouteKbn ONLINE = new C_TourokuRouteKbn("03");

    public static final C_TourokuRouteKbn BATCH = new C_TourokuRouteKbn("04");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_YUUKOUJYOTAI = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, DS, "DS", false);
        addPattern(PATTERN_DEFAULT, TEL, "TEL", false);
        addPattern(PATTERN_DEFAULT, ONLINE, "ONLINE", false);
        addPattern(PATTERN_DEFAULT, BATCH, "BATCH", false);


        addPattern(PATTERN_YUUKOUJYOTAI, BLNK, "BLNK", false);
        addPattern(PATTERN_YUUKOUJYOTAI, DS, "DS", false);
        addPattern(PATTERN_YUUKOUJYOTAI, TEL, "TEL", false);
        addPattern(PATTERN_YUUKOUJYOTAI, ONLINE, "ONLINE", false);
        addPattern(PATTERN_YUUKOUJYOTAI, BATCH, "BATCH", false);


        lock(C_TourokuRouteKbn.class);
    }

    private C_TourokuRouteKbn(String value) {
        super(value);
    }

    public static C_TourokuRouteKbn valueOf(String value) {
        return valueOf(C_TourokuRouteKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TourokuRouteKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TourokuRouteKbn.class, patternId, value);
    }
}
