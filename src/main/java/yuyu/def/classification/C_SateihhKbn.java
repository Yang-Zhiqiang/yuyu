
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 査定方法区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_SateihhKbn</td><td colspan="3">査定方法区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="2">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #HANDSATEI}</td><td>&quot;0&quot;</td><td>ハンド査定</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JIDOUSATEI}</td><td>&quot;1&quot;</td><td>自動査定</td></tr>
 * </table>
 */
public class C_SateihhKbn extends Classification<C_SateihhKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_SateihhKbn HANDSATEI = new C_SateihhKbn("0");

    public static final C_SateihhKbn JIDOUSATEI = new C_SateihhKbn("1");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, HANDSATEI, "HANDSATEI", true);
        addPattern(PATTERN_DEFAULT, JIDOUSATEI, "JIDOUSATEI", false);


        lock(C_SateihhKbn.class);
    }

    private C_SateihhKbn(String value) {
        super(value);
    }

    public static C_SateihhKbn valueOf(String value) {
        return valueOf(C_SateihhKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_SateihhKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_SateihhKbn.class, patternId, value);
    }
}
