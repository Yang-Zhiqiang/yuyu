
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 控除証明メッセージ区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KoujyosyoumeimsgKbn</td><td colspan="3">控除証明メッセージ区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLANK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #YENHNDSNKKYTGKKSNHK}</td><td>&quot;1&quot;</td><td>円貨変動商品申告予定額計算不可</td></tr>
 * </table>
 */
public class C_KoujyosyoumeimsgKbn extends Classification<C_KoujyosyoumeimsgKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KoujyosyoumeimsgKbn BLANK = new C_KoujyosyoumeimsgKbn("0");

    public static final C_KoujyosyoumeimsgKbn YENHNDSNKKYTGKKSNHK = new C_KoujyosyoumeimsgKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLANK, "BLANK", true);
        addPattern(PATTERN_DEFAULT, YENHNDSNKKYTGKKSNHK, "YENHNDSNKKYTGKKSNHK", false);


        lock(C_KoujyosyoumeimsgKbn.class);
    }

    private C_KoujyosyoumeimsgKbn(String value) {
        super(value);
    }

    public static C_KoujyosyoumeimsgKbn valueOf(String value) {
        return valueOf(C_KoujyosyoumeimsgKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KoujyosyoumeimsgKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KoujyosyoumeimsgKbn.class, patternId, value);
    }
}
