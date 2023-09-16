
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ボーナス調整区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BonustyouseiKbn</td><td colspan="3">ボーナス調整区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SIHARAI}</td><td>&quot;1&quot;</td><td>支払</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #REINYU}</td><td>&quot;2&quot;</td><td>戻入</td></tr>
 * </table>
 */
public class C_BonustyouseiKbn extends Classification<C_BonustyouseiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BonustyouseiKbn BLNK = new C_BonustyouseiKbn("0");

    public static final C_BonustyouseiKbn SIHARAI = new C_BonustyouseiKbn("1");

    public static final C_BonustyouseiKbn REINYU = new C_BonustyouseiKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SIHARAI, "SIHARAI", false);
        addPattern(PATTERN_DEFAULT, REINYU, "REINYU", false);


        lock(C_BonustyouseiKbn.class);
    }

    private C_BonustyouseiKbn(String value) {
        super(value);
    }

    public static C_BonustyouseiKbn valueOf(String value) {
        return valueOf(C_BonustyouseiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BonustyouseiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BonustyouseiKbn.class, patternId, value);
    }
}
