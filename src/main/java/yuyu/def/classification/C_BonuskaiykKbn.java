
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * ボーナス解約区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_BonuskaiykKbn</td><td colspan="3">ボーナス解約区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ITIBU_REINYU}</td><td>&quot;1&quot;</td><td>一部戻入</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #ZENGAKU_REINYU}</td><td>&quot;2&quot;</td><td>全額戻入</td></tr>
 * </table>
 */
public class C_BonuskaiykKbn extends Classification<C_BonuskaiykKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_BonuskaiykKbn BLNK = new C_BonuskaiykKbn("0");

    public static final C_BonuskaiykKbn ITIBU_REINYU = new C_BonuskaiykKbn("1");

    public static final C_BonuskaiykKbn ZENGAKU_REINYU = new C_BonuskaiykKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, ITIBU_REINYU, "ITIBU_REINYU", false);
        addPattern(PATTERN_DEFAULT, ZENGAKU_REINYU, "ZENGAKU_REINYU", false);


        lock(C_BonuskaiykKbn.class);
    }

    private C_BonuskaiykKbn(String value) {
        super(value);
    }

    public static C_BonuskaiykKbn valueOf(String value) {
        return valueOf(C_BonuskaiykKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_BonuskaiykKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_BonuskaiykKbn.class, patternId, value);
    }
}
