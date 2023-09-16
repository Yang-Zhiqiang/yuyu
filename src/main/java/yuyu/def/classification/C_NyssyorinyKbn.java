
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 名寄せ確定処理内容区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_NyssyorinyKbn</td><td colspan="3">名寄せ確定処理内容区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #KAKUTEI}</td><td>&quot;1&quot;</td><td>確定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SENTEI}</td><td>&quot;2&quot;</td><td>選定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SINKI}</td><td>&quot;3&quot;</td><td>新規</td></tr>
 * </table>
 */
public class C_NyssyorinyKbn extends Classification<C_NyssyorinyKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_NyssyorinyKbn KAKUTEI = new C_NyssyorinyKbn("1");

    public static final C_NyssyorinyKbn SENTEI = new C_NyssyorinyKbn("2");

    public static final C_NyssyorinyKbn SINKI = new C_NyssyorinyKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, KAKUTEI, "KAKUTEI", true);
        addPattern(PATTERN_DEFAULT, SENTEI, "SENTEI", false);
        addPattern(PATTERN_DEFAULT, SINKI, "SINKI", false);


        lock(C_NyssyorinyKbn.class);
    }

    private C_NyssyorinyKbn(String value) {
        super(value);
    }

    public static C_NyssyorinyKbn valueOf(String value) {
        return valueOf(C_NyssyorinyKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_NyssyorinyKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_NyssyorinyKbn.class, patternId, value);
    }
}
