
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 新契約請求書作成書類区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SksakuseisyoruiKbn</td><td colspan="3">新契約請求書作成書類区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_HENKINIRAISYO}</td><td>&quot;1&quot;</td><td>返金依頼書</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SK_TRKSSEIKYU}</td><td>&quot;2&quot;</td><td>取消請求書</td></tr>
 * </table>
 */
public class C_SksakuseisyoruiKbn extends Classification<C_SksakuseisyoruiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SksakuseisyoruiKbn BLNK = new C_SksakuseisyoruiKbn("0");

    public static final C_SksakuseisyoruiKbn SK_HENKINIRAISYO = new C_SksakuseisyoruiKbn("1");

    public static final C_SksakuseisyoruiKbn SK_TRKSSEIKYU = new C_SksakuseisyoruiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SK_HENKINIRAISYO, "SK_HENKINIRAISYO", false);
        addPattern(PATTERN_DEFAULT, SK_TRKSSEIKYU, "SK_TRKSSEIKYU", false);


        lock(C_SksakuseisyoruiKbn.class);
    }

    private C_SksakuseisyoruiKbn(String value) {
        super(value);
    }

    public static C_SksakuseisyoruiKbn valueOf(String value) {
        return valueOf(C_SksakuseisyoruiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SksakuseisyoruiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SksakuseisyoruiKbn.class, patternId, value);
    }
}
