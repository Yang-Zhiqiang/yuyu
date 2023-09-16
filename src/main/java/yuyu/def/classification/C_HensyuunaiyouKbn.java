
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 編集内容状態区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_HensyuunaiyouKbn</td><td colspan="3">編集内容状態区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #ADD}</td><td>&quot;1&quot;</td><td>追加</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #MOD}</td><td>&quot;2&quot;</td><td>変更</td></tr>
 * </table>
 */
public class C_HensyuunaiyouKbn extends Classification<C_HensyuunaiyouKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_HensyuunaiyouKbn ADD = new C_HensyuunaiyouKbn("1");

    public static final C_HensyuunaiyouKbn MOD = new C_HensyuunaiyouKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, ADD, "ADD", true);
        addPattern(PATTERN_DEFAULT, MOD, "MOD", false);


        lock(C_HensyuunaiyouKbn.class);
    }

    private C_HensyuunaiyouKbn(String value) {
        super(value);
    }

    public static C_HensyuunaiyouKbn valueOf(String value) {
        return valueOf(C_HensyuunaiyouKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_HensyuunaiyouKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_HensyuunaiyouKbn.class, patternId, value);
    }
}
