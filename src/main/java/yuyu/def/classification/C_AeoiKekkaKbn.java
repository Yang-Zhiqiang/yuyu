
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＡＥＯＩ結果区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_AeoiKekkaKbn</td><td colspan="3">ＡＥＯＩ結果区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUKOKUTAISYOUGAI}</td><td>&quot;1&quot;</td><td>ＡＥＯＩ報告対象外</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUKOKUTAISYOUGAIMIHENSOU}</td><td>&quot;2&quot;</td><td>ＡＥＯＩ報告対象外（未返送）</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUKOKUTAISYOU}</td><td>&quot;3&quot;</td><td>ＡＥＯＩ報告対象</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SKSELECT SKSELECT}<br />(新契約選択肢)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUKOKUTAISYOU}</td><td>&quot;3&quot;</td><td>報告対象</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HOUKOKUTAISYOUGAI}</td><td>&quot;1&quot;</td><td>報告対象外</td></tr>
 * </table>
 */
public class C_AeoiKekkaKbn extends Classification<C_AeoiKekkaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_AeoiKekkaKbn BLNK = new C_AeoiKekkaKbn("0");

    public static final C_AeoiKekkaKbn HOUKOKUTAISYOUGAI = new C_AeoiKekkaKbn("1");

    public static final C_AeoiKekkaKbn HOUKOKUTAISYOUGAIMIHENSOU = new C_AeoiKekkaKbn("2");

    public static final C_AeoiKekkaKbn HOUKOKUTAISYOU = new C_AeoiKekkaKbn("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SKSELECT = "2";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, HOUKOKUTAISYOUGAI, "HOUKOKUTAISYOUGAI", false);
        addPattern(PATTERN_DEFAULT, HOUKOKUTAISYOUGAIMIHENSOU, "HOUKOKUTAISYOUGAIMIHENSOU", false);
        addPattern(PATTERN_DEFAULT, HOUKOKUTAISYOU, "HOUKOKUTAISYOU", false);


        addPattern(PATTERN_SKSELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SKSELECT, HOUKOKUTAISYOU, "HOUKOKUTAISYOU", false);
        addPattern(PATTERN_SKSELECT, HOUKOKUTAISYOUGAI, "HOUKOKUTAISYOUGAI", false);


        lock(C_AeoiKekkaKbn.class);
    }

    private C_AeoiKekkaKbn(String value) {
        super(value);
    }

    public static C_AeoiKekkaKbn valueOf(String value) {
        return valueOf(C_AeoiKekkaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_AeoiKekkaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_AeoiKekkaKbn.class, patternId, value);
    }
}
