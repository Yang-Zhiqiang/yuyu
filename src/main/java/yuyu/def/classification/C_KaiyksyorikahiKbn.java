
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 解約処理可否区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_KaiyksyorikahiKbn</td><td colspan="3">解約処理可否区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #KA}</td><td>&quot;1&quot;</td><td>処理可能</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUKA}</td><td>&quot;2&quot;</td><td>処理不可</td></tr>
 * </table>
 */
public class C_KaiyksyorikahiKbn extends Classification<C_KaiyksyorikahiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_KaiyksyorikahiKbn BLNK = new C_KaiyksyorikahiKbn("0");

    public static final C_KaiyksyorikahiKbn KA = new C_KaiyksyorikahiKbn("1");

    public static final C_KaiyksyorikahiKbn HUKA = new C_KaiyksyorikahiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, KA, "KA", false);
        addPattern(PATTERN_DEFAULT, HUKA, "HUKA", false);


        lock(C_KaiyksyorikahiKbn.class);
    }

    private C_KaiyksyorikahiKbn(String value) {
        super(value);
    }

    public static C_KaiyksyorikahiKbn valueOf(String value) {
        return valueOf(C_KaiyksyorikahiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_KaiyksyorikahiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_KaiyksyorikahiKbn.class, patternId, value);
    }
}
