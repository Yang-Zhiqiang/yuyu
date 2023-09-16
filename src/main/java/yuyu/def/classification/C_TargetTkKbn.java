
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ターゲット特約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TargetTkKbn</td><td colspan="3">ターゲット特約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYUUSIN}</td><td>&quot;1&quot;</td><td>目標到達時円建終身保険変更特約</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #NENKIN}</td><td>&quot;2&quot;</td><td>目標到達時円建年金保険変更特約</td></tr>
 * </table>
 */
public class C_TargetTkKbn extends Classification<C_TargetTkKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TargetTkKbn BLNK = new C_TargetTkKbn("0");

    public static final C_TargetTkKbn SYUUSIN = new C_TargetTkKbn("1");

    public static final C_TargetTkKbn NENKIN = new C_TargetTkKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYUUSIN, "SYUUSIN", false);
        addPattern(PATTERN_DEFAULT, NENKIN, "NENKIN", false);


        lock(C_TargetTkKbn.class);
    }

    private C_TargetTkKbn(String value) {
        super(value);
    }

    public static C_TargetTkKbn valueOf(String value) {
        return valueOf(C_TargetTkKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TargetTkKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TargetTkKbn.class, patternId, value);
    }
}
