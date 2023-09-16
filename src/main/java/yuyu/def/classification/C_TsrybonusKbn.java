
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 手数料・ボーナス区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_TsrybonusKbn</td><td colspan="3">手数料・ボーナス区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #TESURYO}</td><td>&quot;1&quot;</td><td>手数料</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BONUS}</td><td>&quot;2&quot;</td><td>ボーナス</td></tr>
 * </table>
 */
public class C_TsrybonusKbn extends Classification<C_TsrybonusKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_TsrybonusKbn TESURYO = new C_TsrybonusKbn("1");

    public static final C_TsrybonusKbn BONUS = new C_TsrybonusKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, TESURYO, "TESURYO", true);
        addPattern(PATTERN_DEFAULT, BONUS, "BONUS", false);


        lock(C_TsrybonusKbn.class);
    }

    private C_TsrybonusKbn(String value) {
        super(value);
    }

    public static C_TsrybonusKbn valueOf(String value) {
        return valueOf(C_TsrybonusKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_TsrybonusKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_TsrybonusKbn.class, patternId, value);
    }
}
