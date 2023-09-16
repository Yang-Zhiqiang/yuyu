
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 削除不可区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_DelhukaKbn</td><td colspan="3">削除不可区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #DELKA}</td><td>&quot;0&quot;</td><td>削除可</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #DELHUKA}</td><td>&quot;1&quot;</td><td>削除不可</td></tr>
 * </table>
 */
public class C_DelhukaKbn extends Classification<C_DelhukaKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_DelhukaKbn DELKA = new C_DelhukaKbn("0");

    public static final C_DelhukaKbn DELHUKA = new C_DelhukaKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, DELKA, "DELKA", true);
        addPattern(PATTERN_DEFAULT, DELHUKA, "DELHUKA", false);


        lock(C_DelhukaKbn.class);
    }

    private C_DelhukaKbn(String value) {
        super(value);
    }

    public static C_DelhukaKbn valueOf(String value) {
        return valueOf(C_DelhukaKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_DelhukaKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_DelhukaKbn.class, patternId, value);
    }
}
