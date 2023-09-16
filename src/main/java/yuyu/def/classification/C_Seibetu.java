
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 性別 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Seibetu</td><td colspan="3">性別</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="5">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJN}</td><td>&quot;3&quot;</td><td>法人</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI}</td><td>&quot;4&quot;</td><td>不明</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOBLNK NOBLNK}<br />(ブランクなし)</td><td align="center">○</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI}</td><td>&quot;4&quot;</td><td>不明</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_NOHUMBLNK NOHUMBLNK}<br />(不明、ブランクなし)</td><td align="center">○</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_NOHJN NOHJN}<br />(法人なし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HUMEI}</td><td>&quot;4&quot;</td><td>不明</td></tr>
 * </table>
 */
public class C_Seibetu extends Classification<C_Seibetu> {

    private static final long serialVersionUID = 1L;


    public static final C_Seibetu BLNK = new C_Seibetu("0");

    public static final C_Seibetu MALE = new C_Seibetu("1");

    public static final C_Seibetu FEMALE = new C_Seibetu("2");

    public static final C_Seibetu HJN = new C_Seibetu("3");

    public static final C_Seibetu HUMEI = new C_Seibetu("4");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_NOBLNK = "2";

    public static final String PATTERN_NOHUMBLNK = "3";

    public static final String PATTERN_SELECT = "4";

    public static final String PATTERN_NOHJN = "5";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MALE, "MALE", false);
        addPattern(PATTERN_DEFAULT, FEMALE, "FEMALE", false);
        addPattern(PATTERN_DEFAULT, HJN, "HJN", false);
        addPattern(PATTERN_DEFAULT, HUMEI, "HUMEI", false);


        addPattern(PATTERN_NOBLNK, MALE, "MALE", true);
        addPattern(PATTERN_NOBLNK, FEMALE, "FEMALE", false);
        addPattern(PATTERN_NOBLNK, HUMEI, "HUMEI", false);


        addPattern(PATTERN_NOHUMBLNK, MALE, "MALE", true);
        addPattern(PATTERN_NOHUMBLNK, FEMALE, "FEMALE", false);


        addPattern(PATTERN_SELECT, BLNK, "BLNK", true);
        addPattern(PATTERN_SELECT, MALE, "MALE", false);
        addPattern(PATTERN_SELECT, FEMALE, "FEMALE", false);


        addPattern(PATTERN_NOHJN, BLNK, "BLNK", true);
        addPattern(PATTERN_NOHJN, MALE, "MALE", false);
        addPattern(PATTERN_NOHJN, FEMALE, "FEMALE", false);
        addPattern(PATTERN_NOHJN, HUMEI, "HUMEI", false);


        lock(C_Seibetu.class);
    }

    private C_Seibetu(String value) {
        super(value);
    }

    public static C_Seibetu valueOf(String value) {
        return valueOf(C_Seibetu.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Seibetu.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Seibetu.class, patternId, value);
    }
}
