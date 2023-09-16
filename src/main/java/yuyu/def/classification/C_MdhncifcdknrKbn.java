
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 窓販ＣＩＦコード管理区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MdhncifcdknrKbn</td><td colspan="3">窓販ＣＩＦコード管理区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="3">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #NONE}</td><td>&quot;0&quot;</td><td>管理なし</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #BANK}</td><td>&quot;1&quot;</td><td>銀行単位</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SITEN}</td><td>&quot;2&quot;</td><td>支店単位</td></tr>
 * </table>
 */
public class C_MdhncifcdknrKbn extends Classification<C_MdhncifcdknrKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MdhncifcdknrKbn NONE = new C_MdhncifcdknrKbn("0");

    public static final C_MdhncifcdknrKbn BANK = new C_MdhncifcdknrKbn("1");

    public static final C_MdhncifcdknrKbn SITEN = new C_MdhncifcdknrKbn("2");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, NONE, "NONE", true);
        addPattern(PATTERN_DEFAULT, BANK, "BANK", false);
        addPattern(PATTERN_DEFAULT, SITEN, "SITEN", false);


        lock(C_MdhncifcdknrKbn.class);
    }

    private C_MdhncifcdknrKbn(String value) {
        super(value);
    }

    public static C_MdhncifcdknrKbn valueOf(String value) {
        return valueOf(C_MdhncifcdknrKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MdhncifcdknrKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MdhncifcdknrKbn.class, patternId, value);
    }
}
