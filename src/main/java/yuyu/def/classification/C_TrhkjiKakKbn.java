
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 取引時確認区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TrhkjiKakKbn</td><td colspan="3">取引時確認区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINZUMI}</td><td>&quot;1&quot;</td><td>取引時確認済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KAKUNINZUMI_KAKUNINZUMI}</td><td>&quot;2&quot;</td><td>取引時確認済の確認済</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NONE}</td><td>&quot;9&quot;</td><td>なし</td></tr>
 * </table>
 */
public class C_TrhkjiKakKbn extends Classification<C_TrhkjiKakKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TrhkjiKakKbn BLNK = new C_TrhkjiKakKbn("0");

    public static final C_TrhkjiKakKbn KAKUNINZUMI = new C_TrhkjiKakKbn("1");

    public static final C_TrhkjiKakKbn KAKUNINZUMI_KAKUNINZUMI = new C_TrhkjiKakKbn("2");

    public static final C_TrhkjiKakKbn NONE = new C_TrhkjiKakKbn("9");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KAKUNINZUMI, "KAKUNINZUMI", false);
        addPattern(PATTERN_DEFAULT, KAKUNINZUMI_KAKUNINZUMI, "KAKUNINZUMI_KAKUNINZUMI", false);
        addPattern(PATTERN_DEFAULT, NONE, "NONE", false);


        lock(C_TrhkjiKakKbn.class);
    }

    private C_TrhkjiKakKbn(String value) {
        super(value);
    }

    public static C_TrhkjiKakKbn valueOf(String value) {
        return valueOf(C_TrhkjiKakKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TrhkjiKakKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TrhkjiKakKbn.class, patternId, value);
    }
}
