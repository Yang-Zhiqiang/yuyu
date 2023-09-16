
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ＬＩＮＣ用被保険者性別区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_LinchhknseiKbn</td><td colspan="3">ＬＩＮＣ用被保険者性別区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MALE}</td><td>&quot;1&quot;</td><td>男</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #FEMALE}</td><td>&quot;2&quot;</td><td>女</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUSSEIMAE}</td><td>&quot;3&quot;</td><td>出生前加入</td></tr>
 * </table>
 */
public class C_LinchhknseiKbn extends Classification<C_LinchhknseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_LinchhknseiKbn BLNK = new C_LinchhknseiKbn("0");

    public static final C_LinchhknseiKbn MALE = new C_LinchhknseiKbn("1");

    public static final C_LinchhknseiKbn FEMALE = new C_LinchhknseiKbn("2");

    public static final C_LinchhknseiKbn SYUSSEIMAE = new C_LinchhknseiKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, MALE, "MALE", false);
        addPattern(PATTERN_DEFAULT, FEMALE, "FEMALE", false);
        addPattern(PATTERN_DEFAULT, SYUSSEIMAE, "SYUSSEIMAE", false);


        lock(C_LinchhknseiKbn.class);
    }

    private C_LinchhknseiKbn(String value) {
        super(value);
    }

    public static C_LinchhknseiKbn valueOf(String value) {
        return valueOf(C_LinchhknseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_LinchhknseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_LinchhknseiKbn.class, patternId, value);
    }
}
