
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 被保険者性別 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_Hhknsei</td><td colspan="3">被保険者性別</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_SELECT SELECT}<br />(選択)</td><td align="center">○</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男性</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女性</td></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_RYAKU RYAKU}<br />(略称)</td><td align="center">&nbsp;</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>不明</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女</td></tr>
 * </table>
 */
public class C_Hhknsei extends Classification<C_Hhknsei> {

    private static final long serialVersionUID = 1L;


    public static final C_Hhknsei BLNK = new C_Hhknsei("0");

    public static final C_Hhknsei MALE = new C_Hhknsei("1");

    public static final C_Hhknsei FEMALE = new C_Hhknsei("2");


    public static final String PATTERN_DEFAULT = "1";

    public static final String PATTERN_SELECT = "2";

    public static final String PATTERN_RYAKU = "3";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MALE, "MALE", false);
        addPattern(PATTERN_DEFAULT, FEMALE, "FEMALE", false);


        addPattern(PATTERN_SELECT, MALE, "MALE", true);
        addPattern(PATTERN_SELECT, FEMALE, "FEMALE", false);


        addPattern(PATTERN_RYAKU, BLNK, "BLNK", false);
        addPattern(PATTERN_RYAKU, MALE, "MALE", false);
        addPattern(PATTERN_RYAKU, FEMALE, "FEMALE", false);


        lock(C_Hhknsei.class);
    }

    private C_Hhknsei(String value) {
        super(value);
    }

    public static C_Hhknsei valueOf(String value) {
        return valueOf(C_Hhknsei.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_Hhknsei.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_Hhknsei.class, patternId, value);
    }
}
