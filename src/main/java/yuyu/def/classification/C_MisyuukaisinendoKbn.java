
package yuyu.def.classification;

import jp.co.slcs.swak.core.classification.Classification;

/**
 * 未収開始年度区分 クラスです。
 * <table border="1" cellspacing="0" cellpadding="0">
 *  <tr bgcolor="whitesmoke"><th colspan="2">区分ID</th><th colspan="3">名称</th></tr>
 *  <tr><td colspan="2">C_MisyuukaisinendoKbn</td><td colspan="3">未収開始年度区分</td></tr>
 *  <tr bgcolor="whitesmoke"><th>パターンID(名称)</th><th>初期値</th><th>区分値ID</th><th>区分値</th><th>内容</th></tr>
 *  <tr><td rowspan="4">{@link #PATTERN_DEFAULT DEFAULT}<br />(デフォルト)</td><td align="center">○</td><td>{@link #BLNK}</td><td>&quot;0&quot;</td><td>ブランク</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDO2NDP}</td><td>&quot;1&quot;</td><td>初年度２回目Ｐ</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #SYONENDO}</td><td>&quot;2&quot;</td><td>初年度</td></tr>
 *  <tr><td align="center">&nbsp;</td><td>{@link #JINENDO}</td><td>&quot;3&quot;</td><td>次年度</td></tr>
 * </table>
 */
public class C_MisyuukaisinendoKbn extends Classification<C_MisyuukaisinendoKbn> {

    private static final long serialVersionUID = 1L;


    public static final C_MisyuukaisinendoKbn BLNK = new C_MisyuukaisinendoKbn("0");

    public static final C_MisyuukaisinendoKbn SYONENDO2NDP = new C_MisyuukaisinendoKbn("1");

    public static final C_MisyuukaisinendoKbn SYONENDO = new C_MisyuukaisinendoKbn("2");

    public static final C_MisyuukaisinendoKbn JINENDO = new C_MisyuukaisinendoKbn("3");


    public static final String PATTERN_DEFAULT = "1";


    static {

        addPattern(PATTERN_DEFAULT, BLNK, "BLNK", true);
        addPattern(PATTERN_DEFAULT, SYONENDO2NDP, "SYONENDO2NDP", false);
        addPattern(PATTERN_DEFAULT, SYONENDO, "SYONENDO", false);
        addPattern(PATTERN_DEFAULT, JINENDO, "JINENDO", false);


        lock(C_MisyuukaisinendoKbn.class);
    }

    private C_MisyuukaisinendoKbn(String value) {
        super(value);
    }

    public static C_MisyuukaisinendoKbn valueOf(String value) {
        return valueOf(C_MisyuukaisinendoKbn.class, value);
    }

    public static String getContentByValue(String value) {
        return getContentByValue(C_MisyuukaisinendoKbn.class, value);
    }

    public static String getContentByValue(String patternId, String value) {
        return getContentByValue(C_MisyuukaisinendoKbn.class, patternId, value);
    }
}
