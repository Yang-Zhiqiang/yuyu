
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 受取人性別 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Uktsei</td><td colspan="3">受取人性別</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJN}</td><td>&quot;3&quot;</td><td>法人</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_SELCT SELCT}<br />(画面用)</td><td align="center">○</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #HJN}</td><td>&quot;3&quot;</td><td>法人</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_NOHJN NOHJN}<br />(法人なし)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 * </table>
 */
public class C_Uktsei extends Classification<C_Uktsei> {

    private static final long serialVersionUID = 1L;


    public static final C_Uktsei BLNK = new C_Uktsei("0");

    public static final C_Uktsei MALE = new C_Uktsei("1");

    public static final C_Uktsei FEMALE = new C_Uktsei("2");

    public static final C_Uktsei HJN = new C_Uktsei("3");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELCT = "2";

    public static final String PATTERN_NOHJN = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MALE, "MALE", false);
        addPattern(PATTERN_DEFAULT, FEMALE, "FEMALE", false);
        addPattern(PATTERN_DEFAULT, HJN, "HJN", false);


        addPattern(PATTERN_SELCT, MALE, "MALE", true);
        addPattern(PATTERN_SELCT, FEMALE, "FEMALE", false);
        addPattern(PATTERN_SELCT, HJN, "HJN", false);


        addPattern(PATTERN_NOHJN, BLNK, "BLNK", true);
        addPattern(PATTERN_NOHJN, MALE, "MALE", false);
        addPattern(PATTERN_NOHJN, FEMALE, "FEMALE", false);


        lock(C_Uktsei.class);
    }

    private C_Uktsei(String value) {
        super(value);
    }

    public static C_Uktsei valueOf(String value) {
        return valueOf(C_Uktsei.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Uktsei.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Uktsei.class, patternId, value);
    }
}
