
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 履歴区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_RirekiKbn</td><td colspan="3">履歴区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #SYSTEM}</td><td>&quot;0&quot;</td><td>システム履歴</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #GYOUMU}</td><td>&quot;1&quot;</td><td>業務履歴</td></tr>
 * </table>
 */
public class C_RirekiKbn extends Classification<C_RirekiKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_RirekiKbn SYSTEM = new C_RirekiKbn("0");

    public static final C_RirekiKbn GYOUMU = new C_RirekiKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, SYSTEM, "SYSTEM", true);
        addPattern(PATTERN_DEFAULT, GYOUMU, "GYOUMU", false);


        lock(C_RirekiKbn.class);
    }

    private C_RirekiKbn(String value) {
        super(value);
    }

    public static C_RirekiKbn valueOf(String value) {
        return valueOf(C_RirekiKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_RirekiKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_RirekiKbn.class, patternId, value);
    }
}
